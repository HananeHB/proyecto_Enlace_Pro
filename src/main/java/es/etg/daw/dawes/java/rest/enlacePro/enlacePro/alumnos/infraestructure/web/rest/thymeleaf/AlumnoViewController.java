package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.rest.thymeleaf;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.alumno.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.alumno.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.alumno.CreateAlumnoService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.alumno.DeleteAlumnoService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.alumno.EditarAlumnoService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.alumno.FindAlumnoService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma.FindIdiomaService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.AlumnoId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.constants.WebRoutes;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.enums.FragmentoContenido;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.enums.ModelAttribute;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.enums.ThymView;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AlumnoViewController {

    private static final String PDF_CONTENT_TYPE = "application/pdf";
    private static final String PDF_FILE_NAME = "alumnos.pdf";

    private final FindAlumnoService findAlumnoService;
    private final FindIdiomaService findIdiomaService;

    private final CreateAlumnoService createAlumnoService;
    private final DeleteAlumnoService deleteAlumnoService;

    private final EditarAlumnoService editAlumnoService;


    private final TemplateEngine templateEngine;

    @GetMapping(WebRoutes.ADMIN_BASE)
    public String escritorio(Model model) {
        //para saber donde va el active en el sidebar al hacer fragmentos
        model.addAttribute("activePage", "escritorio");


        List<Alumno> alumnos = findAlumnoService.findAll();
        List<Idioma> idiomas = findIdiomaService.findAll();

        model.addAttribute(ModelAttribute.FRAGMENTO_CONTENIDO.getName(), FragmentoContenido.ESCRITORIO.getPath());
        model.addAttribute("alumnos", alumnos.stream()
                .map(a -> Map.of(
                        "id", a.getId().getValue(),
                        "idiomaId", a.getIdiomaId().getValue()))
                .toList());
        model.addAttribute("idiomas", idiomas.stream()
                .map(i -> Map.of(
                        "id", i.getId().getValue(),
                        "nombre", i.getNombre()))
                .toList());
        model.addAttribute("totalTareas", 2);

        return ThymView.ENLACEPRO_MAIN.getPath();
    }

    @GetMapping(WebRoutes.ADMIN_CALENDARIO)
    public String mostrarCalendario(Model model) {

        //para saber donde va el active en el sidebar al hacer fragmentos
        model.addAttribute("activePage", "calendario");

        model.addAttribute(ModelAttribute.FRAGMENTO_CONTENIDO.getName(), FragmentoContenido.CALENDARIO.getPath());
        return ThymView.ENLACEPRO_MAIN.getPath();
    }

    @GetMapping(WebRoutes.ADMIN_ALUMNOS_BASE)
    public String listar(Model model) {
        //para saber donde va el active en el sidebar al hacer fragmentos
        model.addAttribute("activePage", "alumnos-lista");

        List<Alumno> alumnos = findAlumnoService.findAll();
        List<Idioma> idiomas = findIdiomaService.findAll();

        Map<Integer, String> idiomasMap = idiomas.stream()
                .collect(Collectors.toMap(i -> i.getId().getValue(), Idioma::getNombre));

        model.addAttribute(ModelAttribute.FRAGMENTO_CONTENIDO.getName(), FragmentoContenido.ALUMNO_LISTA.getPath());
        model.addAttribute(ModelAttribute.ALUM_LIST.getName(), alumnos);
        model.addAttribute(ModelAttribute.IDIOM_MAP.getName(), idiomasMap);
        model.addAttribute("idiomas", idiomas);
        return ThymView.ENLACEPRO_MAIN.getPath();
    }

    @GetMapping(WebRoutes.ADMIN_ALUMNOS_NUEVO)
    public String formulario(Model model) {
        //para saber donde va el active en el sidebar al hacer fragmentos
        model.addAttribute("activePage", "alumnos-formulario");

        model.addAttribute(ModelAttribute.FRAGMENTO_CONTENIDO.getName(), FragmentoContenido.ALUMNO_FORMUMALIO.getPath());
        model.addAttribute(ModelAttribute.SINGLE_ALUM.getName(), new Alumno());
        model.addAttribute("idiomas", findIdiomaService.findAll());
        return ThymView.ENLACEPRO_MAIN.getPath();
    }

    @PostMapping(WebRoutes.ADMIN_ALUMNOS_NUEVO)
    public String crearAlumno(@org.springframework.web.bind.annotation.ModelAttribute("alumno") Alumno alumno,
            // Captura el ID del idioma seleccionado en el <select> del HTML
            @RequestParam("idiomaSeleccionadoId") Integer idIdioma,
            RedirectAttributes redirectAttributes) {

        IdiomaId idiomaVo = new IdiomaId(idIdioma);
        alumno.setFechaCreacion(java.time.LocalDateTime.now());
        createAlumnoService.createAlumno(new CreateAlumnoCommand(alumno.getNombre(), alumno.getApellidos(), alumno.getEmail(), alumno.getNumeroTelefono(), idiomaVo));
        String nombreCompleto = alumno.getNombre() + " " + alumno.getApellidos();
        redirectAttributes.addFlashAttribute("alumnoGuardado", nombreCompleto);
        return "redirect:" + WebRoutes.ADMIN_ALUMNOS_NUEVO;
    }
    

    // @GetMapping(WebRoutes.ADMIN_ALUMNOS_CREADO)
    // public String vistaExito() {
    //     return ThymView.ALUM_CREATED.getPath();
    // }


    @PostMapping(WebRoutes.ADMIN_ALUMNOS_BORRADO)
    public String eliminarAlumno(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {

        try {
            deleteAlumnoService.delete(new AlumnoId(id));
            redirectAttributes.addFlashAttribute("successDelete", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "No se pudo eliminar al alumno");
        }

        return "redirect:" + WebRoutes.ADMIN_ALUMNOS_BASE;
    }

    @PostMapping(WebRoutes.ADMIN_ALUMNOS_EDITADO)
    public String actualizarAlumno(
            @RequestParam("id") Integer id,
            @RequestParam("nombre") String nombre,
            @RequestParam("apellidos") String apellidos,
            @RequestParam("email") String email,
            @RequestParam("numeroTelefono") String telefono, 
            @RequestParam("idiomaSeleccionadoId") Integer idIdioma,
            RedirectAttributes ra) {
    
        editAlumnoService.update(new EditAlumnoCommand(
            new AlumnoId(id), // <--- Pasamos el ID para que sepa a quién editar
            nombre,
            apellidos,
            email,
            telefono,
            new IdiomaId(idIdioma)));

        ra.addFlashAttribute("mensaje", "Alumno actualizado con éxito");
        return "redirect:/web/enlacePro/admin/alumnos";
    }

    @GetMapping(WebRoutes.ADMIN_ALUMNOS_PDF)
    public void exportarPDF(HttpServletResponse response) throws Exception {

        List<Alumno> alumnos = findAlumnoService.findAll();
        List<Idioma> idiomas = findIdiomaService.findAll();
        Map<Integer, String> idiomasMap = idiomas.stream()
                .collect(Collectors.toMap(i -> i.getId().getValue(), Idioma::getNombre));

        Context context = new Context();
        context.setVariable("alumnos", alumnos);
        context.setVariable("idiomasMap", idiomasMap);

        String htmlContent = templateEngine.process(ThymView.ALUM_LIST_PDF.getPath(), context);

        response.setContentType(PDF_CONTENT_TYPE);
        response.setHeader("Content-Disposition", "attachment; filename=" + PDF_FILE_NAME);

        // Código OpenHTML to PDF - CAMBIOS
        // ******************************
        OutputStream outputStream = response.getOutputStream();
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.withHtmlContent(htmlContent, null); // El 'null' es la base URL
        builder.toStream(outputStream);

        builder.run();

    }
}
package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.rest.thymeleaf;

import java.io.OutputStream;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.idioma.EditIdiomaCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma.CreateIdiomaService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma.DeleteIdiomaService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma.EditIdiomaService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma.FindIdiomaService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.mapper.IdiomaMapper;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.constants.WebRoutes;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.idioma.IdiomaRequest;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.enums.FragmentoContenido;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.enums.ModelAttribute;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.enums.ThymView;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IdiomaViewController {

    private final FindIdiomaService findIdiomaService;
    private final CreateIdiomaService createIdiomaService;
    private final DeleteIdiomaService deleteIdiomaService;
    private final EditIdiomaService editIdiomaService;
    private final TemplateEngine templateEngine;

    @GetMapping(WebRoutes.ADMIN_IDIOMA_BASE)
    public String listar(Model model) {

        //para saber donde va el active en el sidebar al hacer fragmentos
        model.addAttribute("activePage", "idioma-lista");

        model.addAttribute(ModelAttribute.FRAGMENTO_CONTENIDO.getName(), FragmentoContenido.IDIOMA_LISTA.getPath());
        model.addAttribute(ModelAttribute.IDIOM_LIST.getName(), findIdiomaService.findAll());
        return ThymView.ENLACEPRO_MAIN.getPath();
    }

    @GetMapping(WebRoutes.ADMIN_IDIOMA_NUEVO)
    public String formulario(Model model) {

        //para saber donde va el active en el sidebar al hacer fragmentos
        model.addAttribute("activePage", "idioma-formulario");

        model.addAttribute(ModelAttribute.FRAGMENTO_CONTENIDO.getName(), FragmentoContenido.IDIOMA_FORMUMALIO.getPath());
        model.addAttribute(ModelAttribute.SINGLE_IDIOM.getName(), new Idioma());
        return ThymView.ENLACEPRO_MAIN.getPath();
    }

    @GetMapping(WebRoutes.ADMIN_IDIOMA_PDF)
    public void exportarPDF(HttpServletResponse response) throws Exception {

        List<Idioma> idiomas = findIdiomaService.findAll();

        Context context = new Context();
        context.setVariable("idiomas", idiomas);

        String htmlContent = templateEngine.process(ThymView.IDIOM_LIST_PDF.getPath(), context);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=idiomas.pdf");

        // Código OpenHTML to PDF - CAMBIOS
        // ******************************
        OutputStream outputStream = response.getOutputStream();
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.withHtmlContent(htmlContent, null); // El 'null' es la base URL
        builder.toStream(outputStream);

        builder.run();
    }

    @PostMapping(WebRoutes.ADMIN_IDIOMA_NUEVO)
    public String crearIdioma(@org.springframework.web.bind.annotation.ModelAttribute IdiomaRequest requestNombre,
            RedirectAttributes redirectAttributes) {

        try {
            createIdiomaService.createIdioma(IdiomaMapper.toCommand(requestNombre));

            redirectAttributes.addFlashAttribute("successNombre", requestNombre.nombre());

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(
                    "error",
                    "El idioma \"" + requestNombre + "\" ya está registrado");
        }

        return "redirect:" + WebRoutes.ADMIN_IDIOMA_NUEVO;
    }

    @PostMapping(WebRoutes.ADMIN_IDIOMA_BORRADO)
    public String eliminarIdioma(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes){
        try {
            deleteIdiomaService.deleteIdioma(new IdiomaId(id));
            redirectAttributes.addFlashAttribute(ModelAttribute.SUCCESS_DELETE.getName(), true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(ModelAttribute.ERROR_MESSAGE.getName(),"No se pudo eliminar el idioma");
        }
        return "redirect:"+WebRoutes.ADMIN_IDIOMA_BASE;
    }
    
    @PostMapping(WebRoutes.ADMIN_IDIOMA_EDITADO)
    public  String actualizarIdioma(
                            @RequestParam("idiomaId") Integer id,
                            @RequestParam("nombre") String nombre, 
                            RedirectAttributes redirectAttributes){
      
    editIdiomaService.update(new EditIdiomaCommand(
                    new IdiomaId(id), //para saber que idioma actualizar
                    nombre));
    redirectAttributes.addFlashAttribute(ModelAttribute.SUCCESS_MESSAGE.getName(),"Idioma actualizado con éxito");
    return "redirect:" + WebRoutes.ADMIN_IDIOMA_BASE;
    }
}

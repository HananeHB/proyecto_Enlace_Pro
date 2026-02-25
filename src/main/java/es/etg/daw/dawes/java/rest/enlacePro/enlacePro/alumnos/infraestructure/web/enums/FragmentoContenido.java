package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.enums;

public enum FragmentoContenido {
    
    ALUMNO_LISTA("fragments/content/alumnos-lista"),
    ALUMNO_FORMUMALIO("fragments/content/alumno-formulario"),
    IDIOMA_LISTA("fragments/content/idiomas-lista"),
    IDIOMA_FORMUMALIO("fragments/content/idioma-formulario"),
    CALENDARIO("fragments/content/calendario"),
    ESCRITORIO("fragments/content/escritorio");

    private final String path;

    FragmentoContenido(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    } 
}

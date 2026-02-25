package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.enums;

public enum ThymView {
    ENLACEPRO_MAIN("enlacePro-main"),

    ALUM_LIST("fragments/content/alumnos-lista"),
    ALUM_LIST_PDF("pdf/alumnos-lista"),
    ALUM_FORM("fragments/content/alumno-formulario"),
    ALUM_CREATED("fragments/content/alumno-creado"),
    ALUM_DELETED("fragments/content/alumno-borrado"),

    IDIOM_LIST("fragments/content/idiomas-lista"),
    IDIOM_LIST_PDF("pdf/idiomas-lista"),
    IDIOM_FORM("fragments/content/idioma-formulario"),
    IDIOM_CREATED("fragments/content/idioma-creado"),

    ADMIN_DASHBOARD("fragments/content/escritorio"),
    ADMIN_CALENDAR("fragments/content/calendario"),


    ERROR_GENERIC("error/error-general");

    private final String path;

    ThymView(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}

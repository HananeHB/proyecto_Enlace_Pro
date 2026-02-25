package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.enums;

public enum ModelAttribute {
    
    ALUM_LIST("alumnos"),
    SINGLE_ALUM("alumno"),

    IDIOM_LIST("idiomas"),
    IDIOM_MAP("idiomasMap"),
    SINGLE_IDIOM("idioma"),
    
    SUCCESS_DELETE("successDelete"),
    ERROR_MESSAGE("errorMsg"),
    SUCCESS_MESSAGE("successMsg"),
    
    FRAGMENTO_CONTENIDO("content"),;

    private final String name;

    ModelAttribute(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

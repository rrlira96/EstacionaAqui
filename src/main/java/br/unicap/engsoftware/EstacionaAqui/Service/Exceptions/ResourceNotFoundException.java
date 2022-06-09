package br.unicap.engsoftware.EstacionaAqui.Service.Exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String id){
        super("Resource not found - id: "+id);
    }
}

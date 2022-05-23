package br.unicap.engsoftware.EstacionaAqui.Service.Exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String id) {
        super("Resource already exists - id: " + id);
    }
}

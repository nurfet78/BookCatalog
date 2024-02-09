package org.nurfet.bookcatalog.exception;

public class NotFoundException extends RuntimeException{
    public <T> NotFoundException(Class<T> cls, Long id) {
        super(cls.getSimpleName() + String.format("With id %s does not exist!", id));
    }
}

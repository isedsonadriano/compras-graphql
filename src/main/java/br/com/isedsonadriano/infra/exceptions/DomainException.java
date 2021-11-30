package br.com.isedsonadriano.infra.exceptions;

public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }

}

package com.tms.exception_resolver;

public class NoAccessByIdException extends RuntimeException {
    private Long id;
    private String login;
    public NoAccessByIdException(Long id, String login) {
        this.id = id;
        this.login = login;
    }

    @Override
    public String toString() {
        return "NoAccessException{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
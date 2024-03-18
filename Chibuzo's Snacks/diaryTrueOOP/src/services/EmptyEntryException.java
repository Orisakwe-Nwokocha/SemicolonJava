package services;

import exceptions.DiaryAppException;

public class EmptyEntryException extends DiaryAppException {
    public EmptyEntryException(String message) {
        super(message);
    }
}

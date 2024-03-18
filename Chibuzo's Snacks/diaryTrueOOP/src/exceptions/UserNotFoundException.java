package exceptions;

import exceptions.DiaryAppException;

public class UserNotFoundException extends DiaryAppException {
    public UserNotFoundException(String message) {
        super(message);
    }
}

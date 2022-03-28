package ch.learnbees.salarycalculate.persistency.exception;

import java.text.MessageFormat;

public class WorkingHoursNotFoundException extends RuntimeException{

    public WorkingHoursNotFoundException(final Long id ) {
        super(MessageFormat.format("Could not find working hours with id: {0}", id));
    }
}

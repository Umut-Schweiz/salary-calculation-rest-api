package ch.learnbees.salarycalculate.persistency.exception;

import java.text.MessageFormat;

public class WorkerNotFoundException extends RuntimeException{
    public WorkerNotFoundException(final Long id ) {
        super(MessageFormat.format("Could not find worker with id: {0}", id));
    }
}

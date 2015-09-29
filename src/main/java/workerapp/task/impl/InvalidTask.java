package workerapp.task.impl;

import workerapp.task.Task;
import workerapp.task.WorkResult;
import workerapp.task.exceptions.InvalidTaskException;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
public class InvalidTask extends Task {
    @Override
    public WorkResult process() throws InvalidTaskException {
        throw new InvalidTaskException(this);
    }
}

package workerapp.task.exceptions;

import workerapp.task.Task;
import workerapp.task.WorkResult;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
public class InvalidTaskException extends TaskException {
    public InvalidTaskException(Task task) {
        super(task);
    }

    @Override
    public WorkResult buildWorkResult() {
        return new WorkResult(task.getMessage()); //TODO: Implement real exception handling
    }
}

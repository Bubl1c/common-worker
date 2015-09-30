package workerapp.task;

import workerapp.message.TaskMessage;
import workerapp.task.exceptions.TaskException;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public abstract class Task {
    protected TaskMessage message;

    public Task() {
    }

    public Task(TaskMessage message) {
        this.message = message;
    }

    public abstract WorkResult process();

    public TaskMessage getMessage() {
        return message;
    }

    public void setMessage(TaskMessage message) {
        this.message = message;
    }

    public enum Type {
        INSERT, FIND, LOGIN, STOP, INVALID
    }
}

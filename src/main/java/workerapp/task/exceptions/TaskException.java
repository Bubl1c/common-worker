package workerapp.task.exceptions;

import workerapp.task.Task;
import workerapp.task.WorkResult;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
public abstract class TaskException extends Exception {
    protected Task task;

    public TaskException(Task task) {
        this.task = task;
    }

    public abstract WorkResult buildWorkResult();

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}

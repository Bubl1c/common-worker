package workerapp.task;

import workerapp.message.TaskMessage;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public class WorkResult {
    private TaskMessage taskMessage;

    public WorkResult(TaskMessage taskMessage) {
        this.taskMessage = taskMessage;
    }

    public TaskMessage getTaskMessage() {
        return taskMessage;
    }

    public void setTaskMessage(TaskMessage taskMessage) {
        this.taskMessage = taskMessage;
    }
}

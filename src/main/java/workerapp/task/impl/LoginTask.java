package workerapp.task.impl;

import workerapp.message.TaskMessage;
import workerapp.task.Task;
import workerapp.task.WorkResult;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public class LoginTask extends Task {

    public LoginTask() {
    }

    public LoginTask(TaskMessage taskMessage) {
        super(taskMessage);
    }

    @Override
    public WorkResult process() {
        System.out.println("+++  LOGIN");
        return new WorkResult(message);
    }
}

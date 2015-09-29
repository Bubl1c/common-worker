package workerapp.task.impl;

import workerapp.message.TaskMessage;
import workerapp.task.Task;
import workerapp.task.WorkResult;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public class InsertTask extends Task {

    public InsertTask() {
    }

    public InsertTask(TaskMessage taskMessage) {
        super(taskMessage);
    }

    @Override
    public WorkResult process() {
        System.out.println("INSERT task");
        return new WorkResult(message);
    }
}

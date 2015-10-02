package workerapp.task.impl;

import workerapp.message.HttpTaskMessage;
import workerapp.message.TaskMessage;
import workerapp.task.Task;
import workerapp.task.WorkResult;

/**
 * Created by Andrii Mozharovskyi on 02.10.2015.
 */
public class FailedTask extends Task {

    @Override
    public WorkResult process() {
        System.out.println("FAILED");
        return new WorkResult(new HttpTaskMessage(null, Type.FAILED, null));
    }
}

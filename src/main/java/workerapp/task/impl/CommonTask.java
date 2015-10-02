package workerapp.task.impl;

import workerapp.message.HttpTaskMessage;
import workerapp.task.Task;
import workerapp.task.WorkResult;

/**
 * Created by Andrii Mozharovskyi on 02.10.2015.
 */
public class CommonTask extends Task {
    @Override
    public WorkResult process() {
        return new WorkResult(new HttpTaskMessage(null, Type.COMMON, null));
    }
}

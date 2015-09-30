package workerapp.task.impl;

import workerapp.message.HttpTaskMessage;
import workerapp.task.Task;
import workerapp.task.WorkResult;
import workerapp.task.exceptions.InvalidTaskException;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
public class InvalidTask extends Task {
    @Override
    public WorkResult process() {
        return new WorkResult(new HttpTaskMessage()); //TODO: implement real work result for invalid task
    }
}

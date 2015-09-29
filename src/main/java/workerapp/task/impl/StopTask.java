package workerapp.task.impl;

import workerapp.task.exceptions.StopTaskException;
import workerapp.task.Task;
import workerapp.task.WorkResult;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
public class StopTask extends Task {
    @Override
    public WorkResult process() throws StopTaskException {
        System.out.println("Stop task");
        throw new StopTaskException(this);
    }
}

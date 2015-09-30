package workerapp.task.impl;

import org.springframework.beans.factory.annotation.Autowired;
import workerapp.ApplicationManager;
import workerapp.message.HttpTaskMessage;
import workerapp.task.Task;
import workerapp.task.WorkResult;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
public class StopTask extends Task {
    @Autowired
    ApplicationManager applicationManager;

    @Override
    public WorkResult process() {
        System.out.println("Stop task");
        applicationManager.interrupt();
        return new WorkResult(new HttpTaskMessage()); //TODO: implement real work result for stop task
    }
}

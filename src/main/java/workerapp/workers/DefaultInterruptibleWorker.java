package workerapp.workers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import workerapp.Shit;
import workerapp.task.Task;
import workerapp.task.WorkResult;
import workerapp.task.TaskOperator;
import workerapp.task.exceptions.TaskException;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
@Component
@Scope("prototype")
public class DefaultInterruptibleWorker extends InterruptibleWorker {
    @Autowired
    TaskOperator taskOperator;

    @Autowired
    Shit shit;

    @Override
    public void start() {
        while(!isInterrupted()) {
            Task task = taskOperator.getTask();
            WorkResult workResult = null;
            try {
                workResult = task.process();
            } catch (TaskException e) {
                workResult = e.buildWorkResult();
                shit.interrupt();
            }
            taskOperator.sendResult(workResult);
        }
    }
}

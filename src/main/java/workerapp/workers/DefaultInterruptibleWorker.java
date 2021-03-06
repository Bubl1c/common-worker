package workerapp.workers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import workerapp.task.Task;
import workerapp.task.WorkResult;
import workerapp.task.TaskProvider;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
@Component
@Scope("prototype")
public class DefaultInterruptibleWorker extends InterruptibleWorker {
    @Autowired
    TaskProvider taskProvider;

    @Override
    public void start() {
        while(!isInterrupted()) {
            try {
                Task task = taskProvider.getTask();
                WorkResult workResult = task.process();
                taskProvider.sendResult(workResult);
            } catch (InterruptedException e) {
                e.printStackTrace();
                continue;
            } catch (ExecutionException e) {
                e.printStackTrace();
                continue;
            } catch (TimeoutException e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}

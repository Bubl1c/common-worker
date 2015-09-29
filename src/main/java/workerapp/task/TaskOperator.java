package workerapp.task;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
public interface TaskOperator {
    Task getTask();
    boolean sendResult(WorkResult result);
}

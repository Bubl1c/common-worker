package workerapp.task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
public interface TaskOperator {
    long GET_TASK_TIMEOUT_MILLIS = 60000; //1 min
    long SEND_RESULT_TIMEOUT_MILLIS = 60000; //1 min

    Task getTask() throws ExecutionException, InterruptedException, TimeoutException;
    boolean sendResult(WorkResult result) throws ExecutionException, InterruptedException;
}


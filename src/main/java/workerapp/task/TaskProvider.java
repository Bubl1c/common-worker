package workerapp.task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
public interface TaskProvider {
    long GET_TASK_TIMEOUT_MILLIS = 6000000; //100 min
    long SEND_RESULT_TIMEOUT_MILLIS = 6000000; //100 min

    Task getTask() throws ExecutionException, InterruptedException, TimeoutException;
    boolean sendResult(WorkResult result) throws ExecutionException, InterruptedException;
}


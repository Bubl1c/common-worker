package workerapp.task;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import workerapp.message.HttpClient;
import workerapp.message.HttpTaskMessage;
import workerapp.message.TaskMessage;
import org.springframework.beans.factory.annotation.Autowired;
import workerapp.task.converter.MessageToTaskConverter;

import java.util.concurrent.*;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
@Component
@Scope("prototype")
public class HttpTaskProvider implements TaskProvider {
    @Autowired
    HttpClient httpClient;

    @Autowired
    MessageToTaskConverter messageToTaskConverter;

    @Override
    public Task getTask() throws ExecutionException, InterruptedException, TimeoutException {
        Future<HttpTaskMessage> futureMessage = httpClient.get("tasks/get");
        TaskMessage taskMessage  = futureMessage.get(GET_TASK_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        return messageToTaskConverter.convert(taskMessage);
    }

    @Override
    public boolean sendResult(WorkResult result) throws ExecutionException, InterruptedException {
        boolean isSent = false;
        int repeatsCounter = 0;
        do {
            repeatsCounter++;
            try {
                isSent = httpClient.post("tasks/result", result.getTaskMessage()).get(SEND_RESULT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                continue;
            }

        } while(!isSent && repeatsCounter < 5);

        //TODO: Discuss handling situation when failed to send back results
        if(!isSent) {
            throw new RuntimeException("Failed to send back results!");
        }
        return isSent;
    }
}




package workerapp.task;

import workerapp.message.HttpClient;
import workerapp.message.TaskMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
@Service
public class HttpTaskOperator implements TaskOperator {
    @Autowired
    HttpClient httpClient;

    @Autowired
    MessageToTaskConverter messageToTaskConverter;

    @Override
    public Task getTask() {
        TaskMessage taskMessage = httpClient.get("");
        return messageToTaskConverter.convert(taskMessage);
    }

    @Override
    public boolean sendResult(WorkResult result) {
        boolean isSent;
        int repeatsCounter = 0;
        do {
            isSent = httpClient.post("", result.getTaskMessage());
            repeatsCounter++;
        } while(!isSent && repeatsCounter < 5);

        //TODO: Discuss handling situation when failed to send back results
        if(!isSent) {
            throw new RuntimeException("Failed to send back results!");
        }
        return isSent;
    }
}

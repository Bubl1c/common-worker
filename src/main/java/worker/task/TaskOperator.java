package worker.task;

import worker.message.Message;
import worker.message.MessageBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
@Service
public class TaskOperator/*<T extends Task>*/ {
    @Autowired
    MessageBroker messageBroker;

    public void doProcess() {
        int counter = 0;
        while(counter < 1) {
            Message message = messageBroker.get();
            Task task = message.getTaskType().toTask(message);
            sendResult(task.process());
            counter++;
        }
    }

    private void sendResult(WorkResult result) {
        boolean isSent = false;
        int repeatsCounter = 0;
        do {
            isSent = messageBroker.send(result.getMessage());
            repeatsCounter++;
        } while(!isSent && repeatsCounter < 5);

        if(!isSent) {
            throw new RuntimeException("Failed to send back results!");
        }
    }
}

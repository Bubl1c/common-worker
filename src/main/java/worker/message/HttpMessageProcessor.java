package worker.message;

import worker.task.Task;
import org.springframework.stereotype.Service;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
@Service
public class HttpMessageProcessor<T extends Task> implements MessageProcessor<T, HttpMessage> {
    @Override
    public T toTask(HttpMessage message) {
        return message.getTaskType().toTask(message);
    }
}

package worker;

import org.springframework.stereotype.Service;
import worker.message.Message;
import worker.task.Task;
import worker.task.TypeTaskFactory;

/**
 * Created by Andrii Mozharovskyi on 28.09.2015.
 */
@Service
public class DefaultMessageToTaskConverter implements MessageToTaskConverter<Task, Message> {
    @Override
    public Task convert(Message message) {
        Task task = new TypeTaskFactory(message.getTaskType()).getTask();
        task.setMessage(message);
        return task;
    }
}

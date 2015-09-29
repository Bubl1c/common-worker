package worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import worker.message.Message;
import worker.task.Task;

/**
 * Created by Andrii Mozharovskyi on 28.09.2015.
 */
@Service
public class DefaultMessageToTaskConverter implements MessageToTaskConverter<Task, Message> {

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public Task convert(Message message) {
        Task task = (Task) applicationContext.getBean(message.getTaskType().getTaskClass());
        task.setMessage(message);
        return task;
    }
}

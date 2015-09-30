package workerapp.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import workerapp.message.TaskMessage;
import workerapp.task.impl.*;

/**
 * Created by Andrii Mozharovskyi on 29/09/15.
 */
@Configuration
public class MessageToTaskConverterConfiguration {

    @Bean
    public MessageToTaskConverter defaultMessageToTaskConverter(){
        return message -> task(message);
    }

    @Bean
    @Scope("prototype")
    public Task task(TaskMessage message){
        Task task;
        switch (message.getTaskType()) {
            case LOGIN: task = new LoginTask(); break;
            case INSERT: task = new InsertTask(); break;
            case STOP: task = new StopTask(); break;
            case FIND: task = new FindTask(); break;
            default: task = new InvalidTask();
        }
        task.setMessage(message);
        return task;
    }
}

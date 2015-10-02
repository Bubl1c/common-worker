package workerapp.task.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import workerapp.message.TaskMessage;
import workerapp.task.Task;

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
        Task task = message.getTaskType().getTaskInstance();
        task.setMessage(message);
        return task;
    }
}

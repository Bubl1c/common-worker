package workerapp.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import workerapp.task.impl.InsertTask;
import workerapp.task.impl.InvalidTask;
import workerapp.task.impl.LoginTask;
import workerapp.task.impl.StopTask;

/**
 * Created by Andrii Mozharovskyi on 29/09/15.
 */
@Configuration
public class MessageToTaskConverterConfiguration {

    @Bean
    public MessageToTaskConverter defaultMessageToTaskConverter(){
        return message -> task(message.getTaskType());
    }

    @Bean
    @Scope("prototype")
    public Task task(Task.Type type){
        switch (type) {
            case LOGIN: return new LoginTask();
            case INSERT: return new InsertTask();
            case STOP: return new StopTask();
            case INVALID: return new InvalidTask();
            default: return new InvalidTask();
        }
    }
}

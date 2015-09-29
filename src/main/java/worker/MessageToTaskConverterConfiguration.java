package worker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import worker.task.InsertTask;
import worker.task.LoginTask;
import worker.task.Task;

/**
 * Created by Serhii Hychka, OT on 29/09/15.
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
            default: return new InsertTask();
        }
    }
}

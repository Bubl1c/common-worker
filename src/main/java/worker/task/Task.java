package worker.task;

import worker.message.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
@Configuration
public abstract class Task {
    protected Message message;

    public Task() {
    }

    public Task(Message message) {
        this.message = message;
    }

    public enum Type {
        INSERT {

            @Override
            @Bean
            public InsertTask toTask(Message message) {
                return new InsertTask(message);
            }
        }, LOGIN {

            @Override
            @Bean
            public LoginTask toTask(Message message) {
                return new LoginTask(message);
            }
        };

        public abstract <T extends Task, M extends Message> T toTask(M message);

//        private <T extends Task> T getBean() {
//            JavaConfigApplicationContext context = new JavaConfigApplicationContext();
//            Map matchingBeans = context.getBeansOfType(Service.class);
//        }
    }

    public abstract WorkResult process();
}

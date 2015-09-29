package worker.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import worker.message.Message;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public abstract class Task {
    protected Message message;

    public Task() {
    }

    public Task(Message message) {
        this.message = message;
    }

    public abstract WorkResult process();

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public static enum Type {
        INSERT {
            @Override
            public Class getTaskClass() {
                return InsertTask.class;
            }
        }, LOGIN {
            @Override
            public Class getTaskClass() {
                return LoginTask.class;
            }
        };

        public abstract Class getTaskClass();
    }
}

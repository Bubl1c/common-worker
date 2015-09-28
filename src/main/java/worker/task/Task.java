package worker.task;

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

    public enum Type {
        INSERT {
            @Override
            public InsertTask getTask() {
                return new InsertTask();
            }
        }, LOGIN {
            @Override
            public LoginTask getTask() {
                return new LoginTask();
            }
        };

        public abstract <T extends Task> T getTask();
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}

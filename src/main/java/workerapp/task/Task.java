package workerapp.task;

import workerapp.message.TaskMessage;
import workerapp.task.exceptions.TaskException;
import workerapp.task.impl.*;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public abstract class Task {
    protected TaskMessage message;

    public Task() {
    }

    public Task(TaskMessage message) {
        this.message = message;
    }

    public abstract WorkResult process();

    public TaskMessage getMessage() {
        return message;
    }

    public void setMessage(TaskMessage message) {
        this.message = message;
    }

    public enum Type {
        DELIVERED {
            @Override
            public DeliveredTask getTaskInstance() {
                return new DeliveredTask();
            }
        }, FAILED {
            @Override
            public FailedTask getTaskInstance() {
                return new FailedTask();
            }
        },
        STOP {
            @Override
            public StopTask getTaskInstance() {
                return new StopTask();
            }
        }, RESULT, COMMON;

        public Task getTaskInstance() {
            return new CommonTask();
        }
    }
}

package worker.message;

import worker.task.Task;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public interface MessageProcessor<T extends Task, M extends Message> {
    T toTask(M message);
}

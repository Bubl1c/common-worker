package worker;

import worker.message.Message;
import worker.task.Task;

/**
 * Created by Andrii Mozharovskyi on 28.09.2015.
 */
public interface MessageToTaskConverter<T extends Task, M extends Message> {
    T convert(M message);
}

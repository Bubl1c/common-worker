package workerapp.task.converter;

import workerapp.message.TaskMessage;
import workerapp.task.Task;

/**
 * Created by Andrii Mozharovskyi on 28.09.2015.
 */
public interface MessageToTaskConverter<T extends Task, M extends TaskMessage> {
    T convert(M message);
}

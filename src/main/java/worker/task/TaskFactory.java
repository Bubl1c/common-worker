package worker.task;

/**
 * Created by Andrii Mozharovskyi on 28.09.2015.
 */
public interface TaskFactory<T extends Task> {
    T getTask();
}

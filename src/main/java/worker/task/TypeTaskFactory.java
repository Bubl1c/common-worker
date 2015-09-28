package worker.task;

/**
 * Created by Andrii Mozharovskyi on 28.09.2015.
 */
public class TypeTaskFactory implements TaskFactory<Task> {
    Task.Type taskType;

    public TypeTaskFactory(Task.Type type) {
        this.taskType = type;
    }

    @Override
    public Task getTask() {
        return taskType.getTask();
    }
}

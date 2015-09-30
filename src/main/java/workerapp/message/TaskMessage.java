package workerapp.message;

import workerapp.task.Task;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public abstract class TaskMessage<T extends TaskMessage.Content> {
    protected String id;
    protected Task.Type taskType;
    protected T content;

    public TaskMessage() {
    }

    public TaskMessage(String id, Task.Type taskType, T content) {
        this.id = id;
        this.taskType = taskType;
        this.content = content;
    }

    public static class Content {
        private Object data;

        public Content(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Task.Type getTaskType() {
        return taskType;
    }

    public void setTaskType(Task.Type taskType) {
        this.taskType = taskType;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}

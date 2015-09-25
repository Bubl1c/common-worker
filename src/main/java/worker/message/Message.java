package worker.message;

import worker.task.Task;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public abstract class Message<T extends Message.Content> {
    protected String id;
    protected Task.Type taskType;
    protected T content;

    public Message() {
    }

    public Message(String id, Task.Type taskType, T content) {
        this.id = id;
        this.taskType = taskType;
        this.content = content;
    }

    public static abstract class Content {
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

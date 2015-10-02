package workerapp.message;

import workerapp.task.Task;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public abstract class TaskMessage {
    protected String id;
    protected Task.Type taskType;
    protected Object content;

    public TaskMessage() {
    }

    public TaskMessage(String id, Task.Type taskType, Object content) {
        this.id = id;
        this.taskType = taskType;
        this.content = content;
    }

    public static class Content {
        private java.lang.Object data;

        public Content() {
        }

        public Content(java.lang.Object data) {
            this.data = data;
        }

        public java.lang.Object getData() {
            return data;
        }

        public void setData(java.lang.Object data) {
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

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}

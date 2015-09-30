package workerapp.message;

import workerapp.task.Task;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public class HttpTaskMessage extends TaskMessage<HttpTaskMessage.Content> {

    public HttpTaskMessage() {
    }

    public HttpTaskMessage(String id, Task.Type taskType, Content content) {
        super(id, taskType, content);
    }

    public static class Content extends TaskMessage.Content {

        public Content(Object data) {
            super(data);
        }
    }

}

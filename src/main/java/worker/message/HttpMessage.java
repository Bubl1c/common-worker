package worker.message;

import worker.task.Task;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public class HttpMessage extends Message<HttpMessage.Content> {

    public HttpMessage() {
    }

    public HttpMessage(String id, Task.Type taskType, Content content) {
        super(id, taskType, content);
    }

    public static class Content extends Message.Content {
        protected String data;

        public Content() {
        }

        public Content(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

}

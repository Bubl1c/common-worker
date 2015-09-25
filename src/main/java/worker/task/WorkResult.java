package worker.task;

import worker.message.Message;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public class WorkResult {
    private Message message;

    public WorkResult(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}

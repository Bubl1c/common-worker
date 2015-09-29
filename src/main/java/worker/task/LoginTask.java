package worker.task;

import worker.message.Message;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public class LoginTask extends Task {

    public LoginTask() {
    }

    public LoginTask(Message message) {
        super(message);
    }

    @Override

    public WorkResult process() {
        System.out.println("Do Login!");
        return new WorkResult(message);
    }
}

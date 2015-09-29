package worker.task;

import worker.Dummy;
import worker.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public class InsertTask extends Task {
    @Autowired
    Dummy dc;

    public InsertTask() {
    }

    public InsertTask(Message message) {
        super(message);
    }

    @Override
    public WorkResult process() {
        dc.doSmth();
        return new WorkResult(message);
    }
}

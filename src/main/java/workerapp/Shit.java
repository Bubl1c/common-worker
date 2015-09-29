package workerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import workerapp.managers.InterruptibleWorkersManager;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
@Service
public class Shit {
    @Autowired
    InterruptibleWorkersManager workersManager;

    private boolean isInterrupted;

    private final Lock lock = new ReentrantLock();

    public void process() {
        workersManager.addWorkers(3);
        while(!isInterrupted) {
            lock.lock();
        }
        workersManager.stopWorkers(5);
    }

    public void interrupt(){
        isInterrupted = true;
    }

}

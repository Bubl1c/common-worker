package workerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import workerapp.managers.InterruptibleWorkersManager;
import workerapp.managers.WorkersManager;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
@Service
public class ApplicationManager {
    @Autowired
    InterruptibleWorkersManager workersManager;

    private boolean isInterrupted;

    private final Lock lock = new ReentrantLock();

    public void startApp(int workersToStart) {
        workersManager.addWorkers(workersToStart);
        while(!isInterrupted) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        workersManager.stopWorkers(WorkersManager.WORKERS_LIMIT);
    }

    public void interrupt(){
        isInterrupted = true;
    }

}

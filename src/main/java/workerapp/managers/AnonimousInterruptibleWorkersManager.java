package workerapp.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workerapp.workers.InterruptibleWorker;
import workerapp.workers.Worker;
import workerapp.workers.WorkersFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
@Service
public class AnonimousInterruptibleWorkersManager extends InterruptibleWorkersManager {

    @Autowired
    WorkersFactory workersFactory;

    private List<Worker> workers;

    public AnonimousInterruptibleWorkersManager() {
        workers = new ArrayList<>();
    }

    @Override
    public void addWorkers(int amount) {
        amount = activeWorkers() + amount > WORKERS_LIMIT ? WORKERS_LIMIT - activeWorkers() : amount;
        for (int i = 0; i < amount; i++) {
            Worker worker = workersFactory.getWorkerInstance();
            worker.start();
            this.workers.add(worker);
            System.out.println("Started  " + i);
        }
    }

    @Override
    public void stopWorkers(int amount) {
        amount = amount > activeWorkers() ? activeWorkers() : amount;
        try {
            for (int i = 0; i < amount; i++) {
                InterruptibleWorker worker = getTargetObject(this.workers.get(0), InterruptibleWorker.class);
                worker.interrupt();
                this.workers.remove(0);
                System.out.println("Stopped " + i);
            }
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Workers cannot be stopped!");
        }
    }

    @Override
    public int activeWorkers() {
        return this.workers.size();
    }
}

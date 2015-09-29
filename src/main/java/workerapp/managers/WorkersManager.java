package workerapp.managers;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
public interface WorkersManager {
    int WORKERS_LIMIT = 100;

    void addWorkers(int amount);
    int activeWorkers();
}

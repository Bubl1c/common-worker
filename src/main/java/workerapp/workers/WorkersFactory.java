package workerapp.workers;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
public interface WorkersFactory {
    Worker getWorkerInstance();
}

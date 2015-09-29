package workerapp.workers;

import org.springframework.scheduling.annotation.Async;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
public interface Worker {
    @Async
    void start();
}

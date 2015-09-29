package workerapp.workers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import workerapp.workers.DefaultInterruptibleWorker;
import workerapp.workers.Worker;
import workerapp.workers.WorkersFactory;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
@Configuration
public class ConfigurationWorkersFactory implements WorkersFactory {
    @Bean
    public Worker getWorkerInstance() {
        return new DefaultInterruptibleWorker();
    }
}

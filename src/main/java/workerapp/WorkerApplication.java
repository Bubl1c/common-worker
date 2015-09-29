package workerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import workerapp.managers.InterruptibleWorkersManager;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
@EnableAsync
public class WorkerApplication implements CommandLineRunner {
    @Autowired
    InterruptibleWorkersManager workersManager;

    @Autowired
    Shit shit;

    private final Lock lock = new ReentrantLock();

    @Override
    public void run(String... strings) throws Exception {
       shit.process();
    }

    public static void main(String[] args) {
        SpringApplication.run(WorkerApplication.class, args);
    }
}

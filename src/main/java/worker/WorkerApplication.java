package worker;

import worker.task.InsertTask;
import worker.task.TaskOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class WorkerApplication implements CommandLineRunner {
    @Autowired
    TaskOperator operator;

    @Autowired
    InsertTask task;

    @Override
    public void run(String... strings) throws Exception {
        operator.doProcess();
    }

    public static void main(String[] args) {
        SpringApplication.run(WorkerApplication.class, args);
    }
}

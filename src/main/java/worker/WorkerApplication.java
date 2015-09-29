package worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import worker.task.TaskOperator;

@SpringBootApplication
public class WorkerApplication implements CommandLineRunner {
    @Autowired
    TaskOperator operator;

    @Override
    public void run(String... strings) throws Exception {
        operator.doProcess();
    }

    public static void main(String[] args) {
        SpringApplication.run(WorkerApplication.class, args);
    }
}

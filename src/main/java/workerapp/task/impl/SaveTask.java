package workerapp.task.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import workerapp.entity.Record;
import workerapp.message.HttpTaskMessage;
import workerapp.message.TaskMessage;
import workerapp.repository.RecordRepository;
import workerapp.task.Task;
import workerapp.task.WorkResult;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public class SaveTask extends Task {
    @Autowired
    private ObjectMapper jacksonObjectMapper;
    @Autowired
    RecordRepository recordRepository;

    public SaveTask() {
    }

    public SaveTask(TaskMessage taskMessage) {
        super(taskMessage);
    }

    @Override
    public WorkResult process() {
        Record record = jacksonObjectMapper.convertValue(message.getContent(), Record.class);
        recordRepository.save(record);
        message.setContent(new TaskMessage.Content("Successful"));
        System.out.println("--- INSERTed : " + record);
        return new WorkResult(message);
    }
}

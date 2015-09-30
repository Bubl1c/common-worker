package workerapp.task.impl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import workerapp.entity.Record;
import workerapp.message.HttpTaskMessage;
import workerapp.message.TaskMessage;
import workerapp.repository.RecordRepository;
import workerapp.task.Task;
import workerapp.task.WorkResult;

import java.util.List;

/**
 * Created by Andrii Mozharovskyi on 30.09.2015.
 */

public class FindTask extends Task{
    @Autowired
    private ObjectMapper jacksonObjectMapper;
    @Autowired
    RecordRepository recordRepository;

    public FindTask() {
    }

    public FindTask(TaskMessage message) {
        super(message);
    }

    @Override
    public WorkResult process() {
        String ip = (String) message.getContent().getData();
        List<Record> records = recordRepository.findByIp(ip);
        message.setContent(new TaskMessage.Content(records));
        System.out.println("--- Find by IP: " + ip + " found " + records);
        return new WorkResult(message);
    }
}

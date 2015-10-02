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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrii Mozharovskyi on 30.09.2015.
 */

public class FindByIpTask extends Task{
    @Autowired
    private ObjectMapper jacksonObjectMapper;
    @Autowired
    RecordRepository recordRepository;

    public FindByIpTask() {
    }

    public FindByIpTask(TaskMessage message) {
        super(message);
    }

    @Override
    public WorkResult process() {
        Object ip = message.getContent();
        List<Record> records = recordRepository.findByIp(ip.toString());
        message.setContent(new TaskMessage.Content(records));
        System.out.println("--- Find by IP: " + ip + " found " + records);
        return new WorkResult(message);
    }
}

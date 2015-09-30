package workerapp.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import workerapp.entity.Record;
import workerapp.message.HttpTaskMessage;
import workerapp.message.TaskMessage;
import workerapp.task.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Future;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
@Service
public class HttpClient {
    private static volatile long counter;
    private static final String BASE_URL = "http://gturnquist-quoters.cfapps.io/api/random";

    @Autowired
    private ObjectMapper jacksonObjectMapper;

    @Async
     public Future<HttpTaskMessage> get(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String response = ""/*restTemplate.getForObject(BASE_URL + url, String.class)*/;

        HttpTaskMessage message = new HttpTaskMessage(""+response.length(), Task.Type.INSERT, new HttpTaskMessage.Content(response));
        Record rec = new Record();
        rec.setIp("ip address");
        HttpTaskMessage.Content c = new HttpTaskMessage.Content(rec);
        message.setContent(c);

        if(counter == 1) {
            message = new HttpTaskMessage(""+response.length(), Task.Type.FIND, new HttpTaskMessage.Content("ip address"));
        }
        if(counter == 2) {
            message = new HttpTaskMessage(""+response.length(), Task.Type.STOP, new HttpTaskMessage.Content(response));
        }
        counter++;
        return new AsyncResult<>(message);
    }

    @Async
    public Future<Boolean> post(String url, TaskMessage taskMessage) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();
        params.put("Accept", MediaType.APPLICATION_JSON.toString());

        HttpEntity<TaskMessage> entity = new HttpEntity<>(taskMessage);

//        ResponseEntity<String> result = restTemplate.exchange(BASE_URL + url, HttpMethod.POST, entity, String.class, params);
//        return result.getStatusCode().equals(HttpStatus.ACCEPTED);
        return new AsyncResult<>(true);
    }
}

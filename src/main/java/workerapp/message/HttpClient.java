package workerapp.message;

import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import workerapp.task.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
@Service
public class HttpClient {
    private static final String BASE_URL = "http://localhost:8080/";

    @Async
     public Future<HttpTaskMessage> get(String url) {
        RestTemplate restTemplate = new RestTemplate();
        HttpTaskMessage response = restTemplate.getForObject(BASE_URL + url, HttpTaskMessage.class);
        return new AsyncResult<>(response);
    }

    @Async
    public Future<Boolean> post(String url, TaskMessage taskMessage) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        params.put("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<TaskMessage> entity = new HttpEntity<>(taskMessage);

        ResponseEntity<HttpTaskMessage> result = restTemplate.exchange(BASE_URL + url, HttpMethod.POST, entity, HttpTaskMessage.class, params);
        return new AsyncResult<>(result.getBody().getTaskType().equals(Task.Type.DELIVERED));
    }
}

package workerapp.message;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import workerapp.message.HttpTaskMessage;
import workerapp.message.TaskMessage;
import workerapp.task.Task;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
@Service
public class HttpClient {
    private static long counter;
    private static final String BASE_URL = "http://gturnquist-quoters.cfapps.io/api/random";

    public HttpTaskMessage get(String url) {
        counter++;
        System.out.println("Message " + counter);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(BASE_URL + url, String.class);
        HttpTaskMessage message = new HttpTaskMessage(""+response.length(), Task.Type.INSERT, new HttpTaskMessage.Content(response));
        if(counter == 10) {
            message = new HttpTaskMessage(""+response.length(), Task.Type.STOP, new HttpTaskMessage.Content(response));
        }
        return message;
    }

    public boolean post(String url, TaskMessage taskMessage) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();
        params.put("Accept", MediaType.APPLICATION_JSON.toString());

        HttpEntity<TaskMessage> entity = new HttpEntity<>(taskMessage);

//        ResponseEntity<String> result = restTemplate.exchange(BASE_URL + url, HttpMethod.POST, entity, String.class, params);
//        return result.getStatusCode().equals(HttpStatus.ACCEPTED);
        return true;
    }
}

package worker.message;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import worker.task.Task;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
@Service("messageBroker")
public class HttpMessageBroker implements MessageBroker<HttpMessage> {
    private static final String TASKS_SOURCE_URI = "http://gturnquist-quoters.cfapps.io/api/random";

    @Override
    public HttpMessage get() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(TASKS_SOURCE_URI, String.class);
        HttpMessage message = new HttpMessage(""+response.length(), Task.Type.INSERT, new HttpMessage.Content(response));
        return message;
    }

    @Override
    public boolean send(HttpMessage message) {
        return true;
    }
}

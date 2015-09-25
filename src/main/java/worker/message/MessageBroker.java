package worker.message;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
public interface MessageBroker<T extends Message> {
    T get();
    boolean send(T message);
}

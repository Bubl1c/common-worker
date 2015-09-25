package worker;

import org.springframework.stereotype.Service;

/**
 * Created by Andrii Mozharovskyi on 25.09.2015.
 */
@Service
public class DummyComponent implements Dummy {
    @Override
    public void doSmth() {
        System.out.println("Hello From Dummy");
    }
}

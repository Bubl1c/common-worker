package workerapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import workerapp.entity.Record;

import java.util.List;

/**
 * Created by Andrii Mozharovskyi on 30.09.2015.
 */
@Repository
public interface RecordRepository extends CrudRepository<Record, Long> {
    List<Record> findByIp(String ip);
}

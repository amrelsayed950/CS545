package edu.miu.waa.lab5.repository;

import edu.miu.waa.lab5.domain.Logger;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface LoggerRepository extends CrudRepository<Logger, Long> {
    public List<Logger> findAll();
}

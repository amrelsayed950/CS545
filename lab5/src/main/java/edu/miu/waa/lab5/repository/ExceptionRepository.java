package edu.miu.waa.lab5.repository;

import org.springframework.data.repository.CrudRepository;
import edu.miu.waa.lab5.domain.Exception;
import java.util.List;

public interface ExceptionRepository extends CrudRepository<Exception, Long> {

    public List<Exception> findAll();

}

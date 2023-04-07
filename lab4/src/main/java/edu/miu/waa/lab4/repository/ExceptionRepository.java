package edu.miu.waa.lab4.repository;

import org.springframework.data.repository.CrudRepository;
import edu.miu.waa.lab4.domain.Exception;
import java.util.List;

public interface ExceptionRepository extends CrudRepository<Exception, Long> {

    public List<Exception> findAll();

}

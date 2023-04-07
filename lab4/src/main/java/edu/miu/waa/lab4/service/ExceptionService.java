package edu.miu.waa.lab4.service;

import java.util.List;
import edu.miu.waa.lab4.domain.Exception;
public interface ExceptionService {
    public List<Exception> findAll();
    public void save(Exception e);
}

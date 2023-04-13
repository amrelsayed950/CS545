package edu.miu.waa.lab5.service;

import java.util.List;
import edu.miu.waa.lab5.domain.Exception;
public interface ExceptionService {
    public List<Exception> findAll();
    public void save(Exception e);
}

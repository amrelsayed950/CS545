package edu.miu.waa.lab5.service;

import edu.miu.waa.lab5.domain.Logger;

import java.util.List;

public interface LoggerService {
    public List<Logger> findAll();
    public void save(Logger l);
}

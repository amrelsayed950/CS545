package edu.miu.waa.lab4.service;

import edu.miu.waa.lab4.domain.Logger;

import java.util.List;

public interface LoggerService {
    public List<Logger> findAll();
    public void save(Logger l);
}

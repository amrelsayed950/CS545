package edu.miu.waa.lab5.service.impl;

import edu.miu.waa.lab5.domain.Logger;
import edu.miu.waa.lab5.repository.LoggerRepository;
import edu.miu.waa.lab5.service.LoggerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LoggerServiceImpl implements LoggerService {
    @Autowired
    LoggerRepository loggerRepository;

    @Override
    public List<Logger> findAll() {
        return loggerRepository.findAll();
    }

    @Override
    public void save(Logger l) {
        loggerRepository.save(l);
        System.out.println("=============================================");
        System.out.println("**** Logger Service Saved ****");
        System.out.println("=============================================");
    }
}

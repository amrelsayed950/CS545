package edu.miu.waa.lab4.service;

import edu.miu.waa.lab4.domain.Logger;
import edu.miu.waa.lab4.repository.LoggerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LoggerServiceImpl implements LoggerService{
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

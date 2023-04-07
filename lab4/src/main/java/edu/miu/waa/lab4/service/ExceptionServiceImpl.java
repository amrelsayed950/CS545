package edu.miu.waa.lab4.service;

import edu.miu.waa.lab4.repository.ExceptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.miu.waa.lab4.domain.Exception;
import java.util.List;

@Service
@Transactional
public class ExceptionServiceImpl implements ExceptionService{
    @Autowired
    ExceptionRepository exceptionRepository;

    @Override
    public List<Exception> findAll() {
        return exceptionRepository.findAll();
    }

    @Override
    public void save(Exception e) {
        exceptionRepository.save(e);
        System.out.println("=============================================");
        System.out.println("**** Exception Service Saved ****");
        System.out.println("=============================================");
    }
}

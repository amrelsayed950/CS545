package edu.miu.waa.lab5.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
    private LocalDateTime date;
    private String principle;
    private String operation;


    public Logger(LocalDateTime date, String principle, String operation) {

        this.date = date;
        this.principle = principle;
        this.operation = operation;
    }
}

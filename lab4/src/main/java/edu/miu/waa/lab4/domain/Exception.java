package edu.miu.waa.lab4.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
    private LocalDateTime date;
    private String principle;
    private String operation;
    private String exceptionType;

    public Exception(LocalDateTime date, String principle, String operation, String exceptionType) {

        this.date = date;
        this.principle = principle;
        this.operation = operation;
        this.exceptionType = exceptionType;
    }
}

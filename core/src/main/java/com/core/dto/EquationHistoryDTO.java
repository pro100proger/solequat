package com.core.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EquationHistoryDTO {

    private String id;
    private LocalDateTime startCalculation;
    private LocalDateTime endCalculation;
    private long duration;

}

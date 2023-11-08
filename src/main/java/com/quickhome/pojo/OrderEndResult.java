package com.quickhome.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Tim-h
 * @description
 * @creatDate 2023/11/8 15:03
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEndResult {
    private boolean success;
    private String message;
    private Double refundedAmount;
    private Double chargedAmount;
    private LocalDateTime endTime;
    private String orderState;
}

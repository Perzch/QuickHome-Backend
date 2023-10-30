package com.quickhome.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/28 21:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PojoPaymentPassword {
    private Long userID;
    private String EncryptedPassword;
}

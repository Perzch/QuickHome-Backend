package com.quickhome.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PJIdCard {
    private Long userId;
    private Long IDCardRecordID;
    private String IDCardName;
    private String IDCardNumber;
    private String IDCardPhoneNumber;
    private String newIDCardName;
    private String newIDCardNumber;
    private String newIDCardPhoneNumber;
    private String oldIDCardName;
    private String oldIDCardNumber;
    private String oldIDCardPhoneNumber;
    private Long orderId;
}

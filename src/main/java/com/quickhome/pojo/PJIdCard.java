package com.quickhome.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("IDCardRecordID")
    private Long IDCardRecordID;
    @JsonProperty("IDCardName")
    private String IDCardName;
    @JsonProperty("IDCardNumber")
    private String IDCardNumber;
    @JsonProperty("IDCardPhoneNumber")
    private String IDCardPhoneNumber;
    private String newIDCardName;
    private String newIDCardNumber;
    private String newIDCardPhoneNumber;
    private String oldIDCardName;
    private String oldIDCardNumber;
    private String oldIDCardPhoneNumber;
    private Long orderId;

}

package com.quickhome.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Tim-h
 * @description 用于获取预订信息的pojo类
 * @creatDate 2023/6/29 15:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PJOrder {
    List<PJUserTenant> userTenantList;
    String checkInDate;
    String checkOutDate;
    Long orderId;
    Long homeId;
    Long userId;
    Long UACID;
    Double maintenanceCost;

}

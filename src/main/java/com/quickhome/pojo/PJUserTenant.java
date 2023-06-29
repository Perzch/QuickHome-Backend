package com.quickhome.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tim-h
 * @description 用于保存单独租客生活信息的UserTenant
 * @creatDate 2023/6/29 15:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PJUserTenant {
    String name;
    String phone;
    String cardIdNumber;
}

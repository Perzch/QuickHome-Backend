package com.quickhome.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tim-h
 * @description 用于分类查询的中间类PJH
 * @creatDate 2023/6/27 16:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PJHselect {
    Long page;
    Long size;
    String homeType;
    double area;
    String beginDate;
    String endDate;
    int maxPeople;

}

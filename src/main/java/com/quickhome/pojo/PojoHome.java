package com.quickhome.pojo;

import com.quickhome.domain.Home;
import com.quickhome.domain.HomeDevice;
import com.quickhome.domain.HomeImage;
import com.quickhome.domain.HomeInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tim-h
 * @description 记录房屋信息的pojo类
 * @creatDate 2023/6/21 15:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PojoHome {
    private Long homeId_zch_hwz_gjc;
    private Home home;
    private HomeInformation homeInformation;
    private List<HomeDevice> homeDeviceList;
    private List<HomeImage> homeImageList;
    private Integer collectionCount; // 收藏数
}

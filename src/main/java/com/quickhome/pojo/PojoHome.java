package com.quickhome.pojo;

import com.quickhome.domain.Home;
import com.quickhome.domain.HomeDevice;
import com.quickhome.domain.HomeImage;
import com.quickhome.domain.HomeInformation;
import lombok.AllArgsConstructor;
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
public class PojoHome {
    private Home home;
    private HomeInformation homeInformation;
    private List<HomeDevice> homeDeviceList;
    private List<HomeImage> homeImageList;

    //获取房屋中的智能设备信息
    public List<HomeDevice> getSmartDeviceList(){
        List<HomeDevice> homeDevices=this.homeDeviceList;
        List<HomeDevice> smartDevices = new ArrayList<HomeDevice>();
        homeDevices.forEach((homeDevice -> {
            if(homeDevice.getDeviceType_zch_hwz_gjc().equals("智能设备"))
                smartDevices.add(homeDevice);
        }));
        return smartDevices;
    }
}
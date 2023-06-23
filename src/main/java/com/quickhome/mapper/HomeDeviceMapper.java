package com.quickhome.mapper;

import com.quickhome.domain.HomeDevice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_homedevice_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-21 09:47:16
* @Entity .domain.HomeDevice
*/
public interface HomeDeviceMapper extends BaseMapper<HomeDevice> {
    public List<HomeDevice> getAllById(Long homeId_zch_hwz_gjc);
}





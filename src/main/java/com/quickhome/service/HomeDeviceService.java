package com.quickhome.service;

import com.quickhome.domain.HomeDevice;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_homedevice_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:47:16
*/
@Transactional
public interface HomeDeviceService extends IService<HomeDevice> {
    public List<HomeDevice> getAllByHomeId(Long id);
}

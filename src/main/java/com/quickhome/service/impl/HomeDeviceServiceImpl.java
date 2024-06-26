package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.HomeDevice;
import com.quickhome.service.HomeDeviceService;
import com.quickhome.mapper.HomeDeviceMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_homedevice_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:47:16
*/
@Transactional
@Service
public class HomeDeviceServiceImpl extends ServiceImpl<HomeDeviceMapper, HomeDevice>
    implements HomeDeviceService{

    @Override
    public List<HomeDevice> getAllByHomeId(Long id) {
        return baseMapper.getAllById(id);
    }
}





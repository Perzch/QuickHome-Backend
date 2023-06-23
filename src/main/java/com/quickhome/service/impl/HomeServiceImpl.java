package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.Home;
import com.quickhome.domain.HomeDevice;
import com.quickhome.domain.HomeImage;
import com.quickhome.domain.HomeInformation;
import com.quickhome.pojo.PojoHome;
import com.quickhome.pojo.PojoPageHome;
import com.quickhome.service.HomeDeviceService;
import com.quickhome.service.HomeImageService;
import com.quickhome.service.HomeInformationService;
import com.quickhome.service.HomeService;
import com.quickhome.mapper.HomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_home_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:47:09
*/
@Service
public class HomeServiceImpl extends ServiceImpl<HomeMapper, Home>
    implements HomeService{
    @Override
    public List<Home> getHomesByPage(Long page, Long size) {
        return baseMapper.selectHomeByPage(page, size);
    }
}





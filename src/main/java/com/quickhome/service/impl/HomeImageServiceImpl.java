package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.HomeImage;
import com.quickhome.service.HomeImageService;
import com.quickhome.mapper.HomeImageMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_homeimage_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:47:24
*/
@Service
public class HomeImageServiceImpl extends ServiceImpl<HomeImageMapper, HomeImage>
    implements HomeImageService{


    @Override
    public List<HomeImage> getAllByHomeId(Long homeId_zch_hwz_gjc) {
        return baseMapper.getAllById(homeId_zch_hwz_gjc);
    }
}





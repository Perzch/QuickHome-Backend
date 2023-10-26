package com.quickhome.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.AttractionImage;
import com.quickhome.domain.HomeImage;
import com.quickhome.service.HomeImageService;
import com.quickhome.mapper.HomeImageMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_homeimage_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:47:24
*/
@Transactional
@Service
public class HomeImageServiceImpl extends ServiceImpl<HomeImageMapper, HomeImage>
    implements HomeImageService{

    @Override
    public HomeImage saveHomeImg(Long homeId, String imagePath) {
        HomeImage Image = new HomeImage();
        Image.setImagePath_zch_hwz_gjc(imagePath);
        Image.setInDateTime_zch_hwz_gjc(DateTime.now());
        Image.setHomeId_zch_hwz_gjc(homeId);
        baseMapper.insert(Image);
        return Image;
    }


    @Override
    public List<HomeImage> getAllByHomeId(Long homeId_zch_hwz_gjc) {
        return baseMapper.getAllById(homeId_zch_hwz_gjc);
    }
}





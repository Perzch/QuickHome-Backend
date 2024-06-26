package com.quickhome.service;

import com.quickhome.domain.HomeImage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_homeimage_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:47:24
*/
@Transactional
public interface HomeImageService extends IService<HomeImage> {

    public HomeImage saveHomeImg(Long homeId, String imagePath);
    public List<HomeImage> getAllByHomeId(Long homeId_zch_hwz_gjc);
}

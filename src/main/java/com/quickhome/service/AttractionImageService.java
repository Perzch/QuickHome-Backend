package com.quickhome.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.quickhome.domain.AttractionImage;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_attractionimage_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-24 11:29:22
*/
@Transactional
public interface AttractionImageService extends IService<AttractionImage> {

    public AttractionImage saveAttractionImg(Long attractionId, String imagePath);
    public List<AttractionImage> getAttractionImageListById(Long attractionId_zch_hwz_gjc);
}

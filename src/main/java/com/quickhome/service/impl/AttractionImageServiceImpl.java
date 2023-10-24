package com.quickhome.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.AttractionImage;
import com.quickhome.domain.UserHeadImage;
import com.quickhome.mapper.AttractionImageMapper;
import com.quickhome.service.AttractionImageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tim-h
 * @description 针对表【tab_attractionimage_zch_hwz_gjc】的数据库操作Service实现
 * @createDate 2023-06-24 11:29:22
 */
@Service
public class AttractionImageServiceImpl extends ServiceImpl<AttractionImageMapper, AttractionImage>
        implements AttractionImageService {

    @Override
    public AttractionImage saveOrUpdateUserHeadImage(Long attractionId, String imagePath) {
        AttractionImage Image = new AttractionImage();
        Image.setImagePath_zch_hwz_gjc(imagePath);
        Image.setInDateTime_zch_hwz_gjc(DateTime.now());
        Image.setAttractionId_zch_hwz_gjc(attractionId);
        baseMapper.insert(Image);
        return Image;
    }

    @Override
    public List<AttractionImage> getAttractionImageListById(Long attractionId_zch_hwz_gjc) {
        return baseMapper.getAttractionImageListById(attractionId_zch_hwz_gjc);
    }
}





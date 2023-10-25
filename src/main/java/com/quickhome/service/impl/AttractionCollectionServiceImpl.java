package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.AttractionCollection;
import com.quickhome.service.AttractionCollectionService;
import com.quickhome.mapper.AttractionCollectionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_attractioncollection_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:44:58
*/
@Transactional
@Service
public class AttractionCollectionServiceImpl extends ServiceImpl<AttractionCollectionMapper, AttractionCollection>
    implements AttractionCollectionService {

}





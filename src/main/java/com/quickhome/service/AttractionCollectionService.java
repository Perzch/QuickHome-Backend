package com.quickhome.service;

import com.quickhome.domain.AttractionCollection;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_attractioncollection_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:44:58
*/
@Transactional
public interface AttractionCollectionService extends IService<AttractionCollection> {

}

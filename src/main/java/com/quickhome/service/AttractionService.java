package com.quickhome.service;

import com.quickhome.domain.Attraction;
import com.baomidou.mybatisplus.extension.service.IService;
import com.quickhome.pojo.PojoAttraction;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_attractions_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:45:15
*/
@Transactional
public interface AttractionService extends IService<Attraction> {
    List<PojoAttraction> getAttractionListOrderByCollectionCount();
}

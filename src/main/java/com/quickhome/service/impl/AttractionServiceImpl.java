package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.Attraction;
import com.quickhome.pojo.PojoAttraction;
import com.quickhome.service.AttractionService;
import com.quickhome.mapper.AttractionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_attractions_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:45:15
*/
@Transactional
@Service
public class AttractionServiceImpl extends ServiceImpl<AttractionMapper, Attraction>
    implements AttractionService {

    @Override
    public List<PojoAttraction> getAttractionListOrderByCollectionCount() {
        return baseMapper.getAttractionListOrderByCollectionCount();
    }
}





package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.HouseCollection;
import com.quickhome.service.HouseCollectionService;
import com.quickhome.mapper.HouseCollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_housecollection_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:47:41
*/
@Transactional
@Service
public class HouseCollectionServiceImpl extends ServiceImpl<HouseCollectionMapper, HouseCollection>
    implements HouseCollectionService{
    @Autowired
    private HouseCollectionMapper houseCollectionMapper;
    public int getCollectionCountByHomeId(Long homeId) {

        return houseCollectionMapper.getCollectionCountByHomeId(homeId);
    }
}





package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.HouseCollection;
import com.quickhome.pojo.PJUserHome;
import com.quickhome.service.HouseCollectionService;
import com.quickhome.mapper.HouseCollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

    public Page<HouseCollection> getUserHomeCollections(Long userId, int pageNo, int pageSize) {
        Page<HouseCollection> page = new Page<>(pageNo, pageSize);
        QueryWrapper<HouseCollection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId_zch_hwz_gjc", userId)
                .eq("deleted_zch_hwz_gjc", 0);  // 只查询未被删除的收藏

        return houseCollectionMapper.selectPage(page, queryWrapper);
    }

    public boolean addHouseCollection(PJUserHome userHome) {
        QueryWrapper<HouseCollection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId_zch_hwz_gjc", userHome.getUserId())
                .eq("homeId_zch_hwz_gjc", userHome.getHomeId());
        Long count = houseCollectionMapper.selectCount(queryWrapper);
        if (count > 0) {
            return false; // 已收藏
        }

        HouseCollection collection = new HouseCollection();
        collection.setUserId_zch_hwz_gjc(userHome.getUserId());
        collection.setHomeId_zch_hwz_gjc(userHome.getHomeId());
        collection.setCollectionTime_zch_hwz_gjc(new Date()); // 使用java.util.Date

        return houseCollectionMapper.insert(collection) > 0;
    }
}





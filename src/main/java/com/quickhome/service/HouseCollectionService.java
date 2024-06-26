package com.quickhome.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quickhome.domain.HouseCollection;
import com.baomidou.mybatisplus.extension.service.IService;
import com.quickhome.pojo.PJUserHome;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_housecollection_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:47:41
*/
@Transactional
public interface HouseCollectionService extends IService<HouseCollection> {
    public int getCollectionCountByHomeId(Long homeId);
    public Page<HouseCollection> getUserHomeCollections(Long userId, int pageNo, int pageSize);
    public boolean addHouseCollection(PJUserHome userHome);
}

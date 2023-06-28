package com.quickhome.service;

import com.quickhome.domain.Home;
import com.baomidou.mybatisplus.extension.service.IService;
import com.quickhome.pojo.PJHselect;
import com.quickhome.pojo.PojoHome;
import com.quickhome.pojo.PojoPageHome;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_home_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:47:09
*/
public interface HomeService extends IService<Home> {
    public List<Home> getHomesByPage(Long page, Long size);
    public List<PojoHome> getHomeListOrderByCollectionCount();
    public List<Home> selectHomeTypeCate(PJHselect pjh);
    public List<Home> selectHomeCate(PJHselect pjh);

}

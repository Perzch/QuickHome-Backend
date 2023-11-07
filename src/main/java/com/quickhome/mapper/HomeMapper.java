package com.quickhome.mapper;

import com.quickhome.domain.Home;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quickhome.pojo.PojoHome;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Tim-h
 * @description 针对表【tab_home_zch_hwz_gjc】的数据库操作Mapper
 * @createDate 2023-06-21 09:47:09
 * @Entity .domain.Home
 */
@Repository
@Mapper
public interface HomeMapper extends BaseMapper<Home> {
    public List<Home> selectHomeByPage(@Param("page") Long page, @Param("size") Long size);

    public List<PojoHome> getHomeListOrderByCollectionCount(String endDate);

    public Double getHomeDayRentByHomeId(Long homeId_zch_hwz_gjc);

    List<Home> selectHomesByCriteriaWithDevices(Date beginDate, Date endDate, String address, double minRent, double maxRent, List<String> deviceNames, int deviceCount,int maxPeople ,String homeType, int page, int size);

    List<Home> selectHomesWithoutDevicesCriteria(Date beginDate, Date endDate, String address, double minRent, double maxRent,int maxPeople ,String homeType, int page, int size);
}





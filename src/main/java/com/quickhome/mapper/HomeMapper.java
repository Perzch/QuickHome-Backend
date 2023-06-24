package com.quickhome.mapper;

import com.quickhome.domain.Home;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quickhome.pojo.PojoHome;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Tim-h
 * @description 针对表【tab_home_zch_hwz_gjc】的数据库操作Mapper
 * @createDate 2023-06-21 09:47:09
 * @Entity .domain.Home
 */
@Repository
public interface HomeMapper extends BaseMapper<Home> {
    public List<Home> selectHomeByPage(@Param("page") Long page, @Param("size") Long size);

    public List<PojoHome> getHomeListOrderByCollectionCount();

}





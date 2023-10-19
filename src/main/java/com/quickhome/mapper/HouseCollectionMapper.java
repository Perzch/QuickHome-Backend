package com.quickhome.mapper;

import com.quickhome.domain.HouseCollection;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
* @author Tim-h
* @description 针对表【tab_housecollection_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-21 09:47:41
* @Entity .domain.HouseCollection
*/
@Mapper
public interface HouseCollectionMapper extends BaseMapper<HouseCollection> {
    @Select("SELECT COUNT(*) FROM tab_houseCollection_zch_hwz_gjc WHERE homeId_zch_hwz_gjc = #{homeId} AND deleted_zch_hwz_gjc = 0")
    int getCollectionCountByHomeId(Long homeId);

}





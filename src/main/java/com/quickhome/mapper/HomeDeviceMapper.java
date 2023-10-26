package com.quickhome.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.quickhome.domain.HomeDevice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_homedevice_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-21 09:47:16
* @Entity .domain.HomeDevice
*/
@Mapper
public interface HomeDeviceMapper extends BaseMapper<HomeDevice> {
    @Select("SELECT * FROM tab_homeDevice_zch_hwz_gjc WHERE homeId_zch_hwz_gjc = #{homeId} AND deleted_zch_hwz_gjc = 0")
    IPage<HomeDevice> getDevicesByHomeId(IPage<HomeDevice> page, @Param("homeId") Long homeId);
    public List<HomeDevice> getAllById(Long homeId_zch_hwz_gjc);
}





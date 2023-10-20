package com.quickhome.mapper;

import com.quickhome.domain.UserInformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Tim-h
* @description 针对表【tab_userinformation_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-21 09:49:11
* @Entity .domain.UserInformation
*/
@Mapper
public interface UserInformationMapper extends BaseMapper<UserInformation> {
    public String getUserImagePath(Long userId);
}





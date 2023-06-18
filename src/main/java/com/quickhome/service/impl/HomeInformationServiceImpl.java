package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.HomeInformation;
import com.quickhome.mapper.HomeInformationMapper;
import com.quickhome.service.HomeInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Perzch
* @description 针对表【tab_homeInformation_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-17 19:42:29
*/
@Service
public class HomeInformationServiceImpl extends ServiceImpl<HomeInformationMapper, HomeInformation>
    implements HomeInformationService {
}





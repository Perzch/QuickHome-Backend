package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.Home;
import com.quickhome.service.HomeService;
import com.quickhome.mapper.HomeMapper;
import org.springframework.stereotype.Service;

/**
* @author Tim-h
* @description 针对表【tab_home_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:47:09
*/
@Service
public class HomeServiceImpl extends ServiceImpl<HomeMapper, Home>
    implements HomeService{

}





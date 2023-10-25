package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.SuperManager;
import com.quickhome.service.SuperManagerService;
import com.quickhome.mapper.SuperManagerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_supermanager_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:48:39
*/
@Transactional
@Service
public class SuperManagerServiceImpl extends ServiceImpl<SuperManagerMapper, SuperManager>
    implements SuperManagerService{

}





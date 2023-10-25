package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.RCAMI;
import com.quickhome.service.RCAMIService;
import com.quickhome.mapper.RCAMIMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_rcami_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:48:33
*/
@Transactional
@Service
public class RCAMIServiceImpl extends ServiceImpl<RCAMIMapper, RCAMI>
    implements RCAMIService{

}





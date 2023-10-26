package com.quickhome.service;

import com.quickhome.domain.RCAMI;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_rcami_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:48:33
*/
@Transactional
public interface RCAMIService extends IService<RCAMI> {

}

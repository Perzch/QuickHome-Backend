package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.Log;
import com.quickhome.service.LogService;
import com.quickhome.mapper.LogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_log_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:47:54
*/
@Transactional
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log>
    implements LogService{

}





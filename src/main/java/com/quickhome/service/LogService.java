package com.quickhome.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.quickhome.domain.Log;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_log_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:47:54
*/
@Transactional
public interface LogService extends IService<Log> {

    public IPage<Log> getAllLogs(int page, int size);
    public boolean insertLog(Log log);

    public IPage<Log> getLogsByUserId(Long userId, int page, int size);
}

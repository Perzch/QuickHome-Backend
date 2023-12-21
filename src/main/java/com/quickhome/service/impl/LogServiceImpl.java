package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    @Override
    public boolean insertLog(Log log) {
        return baseMapper.insert(log) > 0;
    }

    @Override
    public IPage<Log> getLogsByUserId(Long userId, int page, int size) {
        Page<Log> pageParam = new Page<>(page, size);
        QueryWrapper<Log> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userPerformingId_zch_hwz_gjc", userId)
                .orderByDesc("executionTime_zch_hwz_gjc");
        return baseMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    public IPage<Log> getAllLogs(int page, int size) {
        Page<Log> pageParam = new Page<>(page, size);
        QueryWrapper<Log> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("executionTime_zch_hwz_gjc");
        return baseMapper.selectPage(pageParam, queryWrapper);
    }
}





package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.Manager;
import com.quickhome.service.ManagerService;
import com.quickhome.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
* @author Tim-h
* @description 针对表【tab_manager_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:47:58
*/
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager>
    implements ManagerService{
    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public Manager getRandomOnlineManager() {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("online_status_zch_hwz_gjc", "在线")
            .eq("managerCategory_zch_hwz_gjc", "客服")
            .orderBy(true, false, "rand()");
        List<Manager> onlineManagers = managerMapper.selectList(queryWrapper);
        if (onlineManagers.isEmpty()) {  // 检查列表是否为空
            return null;  // 或者你可以选择抛出一个自定义的异常
        }
        Random random = new Random();
        return onlineManagers.get(random.nextInt(onlineManagers.size()));
    }
    @Override
    public void setManagerOnline(Long managerId) {
        UpdateWrapper<Manager> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("managerId_zch_hwz_gjc", managerId)
                .set("online_status_zch_hwz_gjc", "在线");
        managerMapper.update(null, updateWrapper);
    }
    @Override
    public void setManagerOffline(Long managerId) {
        UpdateWrapper<Manager> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("managerId_zch_hwz_gjc", managerId)
                .set("online_status_zch_hwz_gjc", "离线");
        managerMapper.update(null, updateWrapper);
    }
}





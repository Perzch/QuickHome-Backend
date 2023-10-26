package com.quickhome.service;

import com.quickhome.domain.Manager;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_manager_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:47:58
*/
@Transactional
public interface ManagerService extends IService<Manager> {
    public Manager getRandomOnlineManager();

    public void setManagerOnline(Long managerId);

    public void setManagerOffline(Long managerId);

}

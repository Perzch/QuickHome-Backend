package com.quickhome.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quickhome.domain.Home;
import com.quickhome.domain.Manager;
import com.quickhome.domain.ManagerHomeBinding;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_managerhomebinding_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:48:08
*/
@Transactional
public interface ManagerHomeBindingService extends IService<ManagerHomeBinding> {

    public IPage<Home> getHomesByManagerId(Long managerId, Page<Home> page);
    public IPage<Manager> getManagersByHomeId(Long homeId, Page<Manager> page);

}

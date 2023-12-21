package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.Home;
import com.quickhome.domain.Manager;
import com.quickhome.domain.ManagerHomeBinding;
import com.quickhome.mapper.HomeMapper;
import com.quickhome.mapper.ManagerMapper;
import com.quickhome.service.ManagerHomeBindingService;
import com.quickhome.mapper.ManagerHomeBindingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author Tim-h
* @description 针对表【tab_managerhomebinding_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:48:08
*/
@Transactional
@Service
public class ManagerHomeBindingServiceImpl extends ServiceImpl<ManagerHomeBindingMapper, ManagerHomeBinding>
    implements ManagerHomeBindingService{

    @Autowired
    private HomeMapper homeMapper;

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public IPage<Manager> getManagersByHomeId(Long homeId, Page<Manager> page) {
        QueryWrapper<ManagerHomeBinding> bindingQueryWrapper = new QueryWrapper<>();
        bindingQueryWrapper.eq("homeID_zch_hwz_gjc", homeId);
        List<Long> managerIds = baseMapper.selectList(bindingQueryWrapper)
                .stream()
                .map(ManagerHomeBinding::getManagerID_zch_hwz_gjc)
                .collect(Collectors.toList());

        if (managerIds.isEmpty()) {
            return page;
        }

        QueryWrapper<Manager> managerQueryWrapper = new QueryWrapper<>();
        managerQueryWrapper.in("managerId_zch_hwz_gjc", managerIds);
        return managerMapper.selectPage(page, managerQueryWrapper);
    }

    @Override
    public IPage<Home> getHomesByManagerId(Long managerId, Page<Home> page) {
        QueryWrapper<ManagerHomeBinding> bindingQueryWrapper = new QueryWrapper<>();
        bindingQueryWrapper.eq("managerID_zch_hwz_gjc", managerId);
        List<Long> homeIds = baseMapper.selectList(bindingQueryWrapper)
                .stream()
                .map(ManagerHomeBinding::getHomeID_zch_hwz_gjc)
                .collect(Collectors.toList());

        if (homeIds.isEmpty()) {
            return page;
        }

        QueryWrapper<Home> homeQueryWrapper = new QueryWrapper<>();
        homeQueryWrapper.in("homeId_zch_hwz_gjc", homeIds);
        return homeMapper.selectPage(page, homeQueryWrapper);
    }

    @Override
    public IPage<ManagerHomeBinding> getAllBindingInfo(Page<?> page) {
        // 示例：假设有一个 BindingInfoMapper 用于操作数据库
        IPage<ManagerHomeBinding> bindingInfoPage = new Page<>(page.getCurrent(), page.getSize());

        // 查询所有绑定信息并填充分页对象
        baseMapper.selectPage(bindingInfoPage, null);

        return bindingInfoPage;
    }

}





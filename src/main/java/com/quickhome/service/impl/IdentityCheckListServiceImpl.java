package com.quickhome.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.IdentityCheckList;
import com.quickhome.mapper.IdentityCheckListMapper;
import com.quickhome.service.IdentityCheckListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_identitychecklist_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-29 15:20:58
*/
@Transactional
@Service
public class IdentityCheckListServiceImpl extends ServiceImpl<IdentityCheckListMapper, IdentityCheckList>
    implements IdentityCheckListService {

}





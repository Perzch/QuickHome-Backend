package com.quickhome.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.quickhome.domain.IdentityCheckList;
import com.quickhome.pojo.PJIdCard;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_identitychecklist_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-29 15:20:58
*/
@Transactional
public interface IdentityCheckListService extends IService<IdentityCheckList> {
    public IdentityCheckList createIdentityChecklist(PJIdCard idCard);

}

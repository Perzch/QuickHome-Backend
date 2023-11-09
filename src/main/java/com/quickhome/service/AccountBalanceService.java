package com.quickhome.service;

import com.quickhome.domain.AccountBalance;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_accountbalance_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:43:54
*/
@Transactional
public interface AccountBalanceService extends IService<AccountBalance> {
    public boolean refundUserBalance(Long userId, Double amount);
}

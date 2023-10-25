package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.mapper.AccountBalanceMapper;
import com.quickhome.domain.AccountBalance;
import com.quickhome.service.AccountBalanceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_accountbalance_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:43:54
*/
@Transactional
@Service
public class AccountBalanceServiceImpl extends ServiceImpl<AccountBalanceMapper, AccountBalance>
    implements AccountBalanceService{

}





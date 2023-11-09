package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.mapper.AccountBalanceMapper;
import com.quickhome.domain.AccountBalance;
import com.quickhome.service.AccountBalanceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
* @author Tim-h
* @description 针对表【tab_accountbalance_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:43:54
*/
@Transactional
@Service
public class AccountBalanceServiceImpl extends ServiceImpl<AccountBalanceMapper, AccountBalance>
    implements AccountBalanceService{
    /**
     * 退款到用户账户余额
     *
     * @param userId 用户ID
     * @param amount 退款金额
     * @return 是否成功
     */
    @Override
    public boolean refundUserBalance(Long userId, Double amount) {
        // 查询用户当前的账户余额
        // 构建查询条件
        QueryWrapper<AccountBalance> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId_zch_hwz_gjc", userId);

        // 查询用户当前的账户余额
        AccountBalance accountBalance = baseMapper.selectOne(queryWrapper);
        if (accountBalance == null) {
            // 用户账户不存在，无法退款
            return false;
        }

        // 计算新的余额
        Double newBalance = accountBalance.getUserBalance_zch_hwz_gjc() + amount;

        // 更新账户余额
        AccountBalance updatedAccountBalance = new AccountBalance();
        updatedAccountBalance.setBid_zch_hwz_gjc(accountBalance.getBid_zch_hwz_gjc()); // 设置主键ID
        updatedAccountBalance.setUserBalance_zch_hwz_gjc(newBalance); // 设置新的余额
        updatedAccountBalance.setLastModifiedDate_zch_hwz_gjc(new Date()); // 设置最后修改时间

        // 使用乐观锁更新余额，确保并发安全
        int result = baseMapper.updateById(updatedAccountBalance);
        return result > 0;
    }
}





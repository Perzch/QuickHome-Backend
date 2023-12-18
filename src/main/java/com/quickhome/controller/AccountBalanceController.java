package com.quickhome.controller;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.quickhome.domain.AccountBalance;
import com.quickhome.mapper.AccountBalanceMapper;
import com.quickhome.request.ResponseResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/20 16:13
 */

@Transactional
@Controller("BalanceCon")
@RequestMapping("/balance")
public class AccountBalanceController {

    @Autowired
    private AccountBalanceMapper accountBalanceMapper;

    /**
     * 新建用户钱包
     * @param accountBalance 用户钱包类
     * @param req
     * @return
     */

    @ResponseBody
    @PostMapping
    public ResponseEntity<ResponseResult<?>> insertMoney(
            @RequestBody AccountBalance accountBalance,
            HttpServletRequest req) {
        if (accountBalance == null){
            return ResponseEntity.ok(ResponseResult.of(400,"参数错误"));
        }
        if (accountBalance.getUserBalance_zch_hwz_gjc() == null){
            accountBalance.setUserBalance_zch_hwz_gjc(0.0);
        }
        if (accountBalance.getLastModifiedDate_zch_hwz_gjc() == null){
            accountBalance.setLastModifiedDate_zch_hwz_gjc(DateTime.now());
        }
        QueryWrapper<AccountBalance> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId_zch_hwz_gjc", accountBalance.getUserId_zch_hwz_gjc());
        AccountBalance select = accountBalanceMapper.selectOne(queryWrapper);
        if (select == null) {
            accountBalance.setOpenTime_zch_hwz_gjc(DateTime.now());
            accountBalanceMapper.insert(accountBalance);
            return ResponseEntity.ok(ResponseResult.ok(accountBalance));
        }else {
            return ResponseEntity.ok(ResponseResult.of(400,"该用户已存在"));
        }
    }

    /**
     * 充值/提现
     * @param req
     * @return
     */


    @ResponseBody
    @PutMapping
    public ResponseEntity<ResponseResult<?>> updateMoney(
            @RequestBody AccountBalance accountBalanceParams,
            HttpServletRequest req) {

        QueryWrapper<AccountBalance> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId_zch_hwz_gjc", accountBalanceParams.getUserId_zch_hwz_gjc());
        AccountBalance accountBalance = accountBalanceMapper.selectOne(queryWrapper);
        if (accountBalance == null) {
            return ResponseEntity.badRequest().body(ResponseResult.error("用户不存在"));
        }

        // 检查提现金额是否超过余额
        if (accountBalanceParams.getUserBalance_zch_hwz_gjc() < 0 && Math.abs(accountBalanceParams.getUserBalance_zch_hwz_gjc()) > accountBalance.getUserBalance_zch_hwz_gjc()) {
            return ResponseEntity.badRequest().body(ResponseResult.error("余额不足"));
        }

        // 更新余额
        accountBalance.setUserBalance_zch_hwz_gjc(accountBalance.getUserBalance_zch_hwz_gjc() + accountBalanceParams.getUserBalance_zch_hwz_gjc());
        // 设置最后修改时间为当前时间
        accountBalance.setLastModifiedDate_zch_hwz_gjc(DateTime.now());

        // 使用MyBatisPlus的更新方法
        accountBalanceMapper.update(accountBalance, queryWrapper);

        return ResponseEntity.ok(ResponseResult.ok(accountBalance));
    }

    /**
     * 查询用户钱包
     * @param userId 用户id
     * @param req
     * @return
     */

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<ResponseResult<?>> selectAccountBalance(
            @PathVariable("id") Long userId,
            HttpServletRequest req) {
        QueryWrapper<AccountBalance> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId_zch_hwz_gjc", userId);
        AccountBalance accountBalance = accountBalanceMapper.selectOne(queryWrapper);
        if (accountBalance == null) {
            return ResponseEntity.ok(ResponseResult.error("用户不存在"));
        }

        return ResponseEntity.ok(ResponseResult.ok(accountBalance));
    }
}



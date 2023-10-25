package com.quickhome.mapper;

import com.quickhome.domain.AccountBalance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_accountbalance_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-21 09:43:54
* @Entity .domain.AccountBalance
*/

@Transactional
@Mapper
public interface AccountBalanceMapper extends BaseMapper<AccountBalance> {

}





package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.PaymentPassword;
import com.quickhome.service.PaymentPasswordService;
import com.quickhome.mapper.PaymentPasswordMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_paymentpassword_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:48:24
*/
@Transactional
@Service
public class PaymentPasswordServiceImpl extends ServiceImpl<PaymentPasswordMapper, PaymentPassword>
    implements PaymentPasswordService{

}





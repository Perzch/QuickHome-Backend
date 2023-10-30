package com.quickhome.service;

import com.quickhome.domain.PaymentPassword;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tim-h
 * @description 针对表【tab_paymentpassword_zch_hwz_gjc】的数据库操作Service
 * @createDate 2023-06-21 09:48:24
 */
@Transactional
public interface PaymentPasswordService extends IService<PaymentPassword> {
    public boolean setPaymentPassword(Long userId, String paymentPassword);
    public boolean verifyPaymentPassword(Long userId, String encryptedPassword);
    public boolean getPaymentPasswordStatus(Long userId);

}

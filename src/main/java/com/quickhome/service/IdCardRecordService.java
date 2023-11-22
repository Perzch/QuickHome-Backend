package com.quickhome.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.quickhome.domain.IdCardRecord;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Tim-h
 * @description 针对表【tab_idcardrecord_zch_hwz_gjc】的数据库操作Service
 * @createDate 2023-06-29 15:58:06
 */
@Transactional
public interface IdCardRecordService extends IService<IdCardRecord> {
    public IdCardRecord uploadIdCardInfo(String IDCardName, String IDCardNumber, String IDCardPhoneNumber, Long userId);

    public IPage<IdCardRecord> getIdCardInfo(Long userId, int current, int size);

    public boolean updateIdCardInfo(Long userId, String newName, String newNumber, String newPhoneNumber,
                                    String oldName, String oldNumber, String oldPhoneNumber);
    public boolean deleteIdCardInfo(String IDCardName, String IDCardNumber, String IDCardPhoneNumber,Long userId);
    List<IdCardRecord> getOrderIdentityInfo(Long orderID);;
}

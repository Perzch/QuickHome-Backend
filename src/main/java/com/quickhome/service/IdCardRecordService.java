package com.quickhome.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.quickhome.domain.IdCardRecord;
import com.quickhome.pojo.PJIdCard;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Tim-h
 * @description 针对表【tab_idcardrecord_zch_hwz_gjc】的数据库操作Service
 * @createDate 2023-06-29 15:58:06
 */
@Transactional
public interface IdCardRecordService extends IService<IdCardRecord> {
    public IdCardRecord uploadIdCardInfo(IdCardRecord cardRecord);

    public IPage<IdCardRecord> getIdCardInfo(Long userId, int current, int size);

    public boolean updateIdCardInfo(PJIdCard idCard);
    public boolean deleteIdCardInfo(PJIdCard idCard);
    List<IdCardRecord> getOrderIdentityInfo(Long orderID);;
}

package com.quickhome.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.IdCardRecord;
import com.quickhome.domain.IdentityCheckList;
import com.quickhome.mapper.IdCardRecordMapper;
import com.quickhome.mapper.IdentityCheckListMapper;
import com.quickhome.pojo.PJIdCard;
import com.quickhome.service.IdCardRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Tim-h
 * @description 针对表【tab_IdCardRecord_zch_hwz_gjc】的数据库操作Service实现
 * @createDate 2023-06-29 15:58:06
 */
@Transactional
@Service
public class IdCardRecordServiceImpl extends ServiceImpl<IdCardRecordMapper, IdCardRecord>
        implements IdCardRecordService {

    @Autowired
    private IdentityCheckListMapper identityCheckListMapper;

    @Override
    public IdCardRecord uploadIdCardInfo(IdCardRecord cardRecord) {
        // 假设你已经创建了一个IdCardRecord对象并保存到了数据库
        cardRecord.setInDateTime_zch_hwz_gjc(new Date());
        baseMapper.insert(cardRecord);
        return cardRecord;
    }

    @Override
    public IPage<IdCardRecord> getIdCardInfo(Long userId, int current, int size) {
        // 定义身份证和手机号的正则表达式
        String idCardRegex = "^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        String phoneRegex = "^1(3\\d|4[5-9]|5[0-35-9]|6[2567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$";

        QueryWrapper<IdCardRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("DISTINCT IDCardName_zch_hwz_gjc, IDCardNumber_zch_hwz_gjc, IDCardPhoneNumber_zch_hwz_gjc")
                .eq("userId_zch_hwz_gjc", userId)
                // 使用正则表达式匹配身份证号和手机号
                .apply("IDCardNumber_zch_hwz_gjc REGEXP {0}", idCardRegex)
                .apply("IDCardPhoneNumber_zch_hwz_gjc REGEXP {0}", phoneRegex);

        Page<IdCardRecord> page = new Page<>(current, size);
        return baseMapper.selectPage(page, queryWrapper);
    }

    @Override
    public boolean deleteIdCardInfo(PJIdCard idCard) {
        QueryWrapper<IdCardRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("IDCardName_zch_hwz_gjc", idCard.getIDCardName())
                .eq("IDCardNumber_zch_hwz_gjc", idCard.getIDCardNumber())
                .eq("IDCardPhoneNumber_zch_hwz_gjc", idCard.getIDCardPhoneNumber())
                .eq("userId_zch_hwz_gjc", idCard.getUserId());
        return remove(queryWrapper);
    }

    @Override
    public boolean updateIdCardInfo(PJIdCard idCard) {
        UpdateWrapper<IdCardRecord> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("userId_zch_hwz_gjc", idCard.getUserId())
                .eq(idCard.getOldIDCardName() != null, "IDCardName_zch_hwz_gjc", idCard.getOldIDCardName())
                .eq(idCard.getOldIDCardNumber() != null, "IDCardNumber_zch_hwz_gjc", idCard.getOldIDCardNumber())
                .eq(idCard.getOldIDCardPhoneNumber() != null, "IDCardPhoneNumber_zch_hwz_gjc", idCard.getOldIDCardPhoneNumber());

        IdCardRecord idCardRecord = new IdCardRecord();
        if (idCard.getNewIDCardName() != null) idCardRecord.setIDCardName_zch_hwz_gjc(idCard.getNewIDCardName());
        if (idCard.getNewIDCardNumber() != null) idCardRecord.setIDCardNumber_zch_hwz_gjc(idCard.getNewIDCardNumber());
        if (idCard.getNewIDCardPhoneNumber() != null) idCardRecord.setIDCardPhoneNumber_zch_hwz_gjc(idCard.getNewIDCardPhoneNumber());

        int update = baseMapper.update(idCardRecord, updateWrapper);
        return update > 0;
    }

    @Override
    public List<IdCardRecord> getOrderIdentityInfo(Long orderID) {
        QueryWrapper<IdentityCheckList> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("orderID_zch_hwz_gjc", orderID)
                .eq("deleted_zch_hwz_gjc", 0);

        List<IdentityCheckList> IdentityCheckLists = identityCheckListMapper.selectList(queryWrapper);
        if (IdentityCheckLists == null || IdentityCheckLists.isEmpty()) {
            return Collections.emptyList();
        }

        List<Long> idCardRecordIds = IdentityCheckLists.stream()
                .map(IdentityCheckList::getIDCardRecordID_zch_hwz_gjc)
                .collect(Collectors.toList());

        QueryWrapper<IdCardRecord> idCardRecordQueryWrapper = new QueryWrapper<>();
        idCardRecordQueryWrapper.in("IDCardRecordID_zch_hwz_gjc", idCardRecordIds)
                .eq("deleted_zch_hwz_gjc", 0);

        return baseMapper.selectList(idCardRecordQueryWrapper);
    }
}





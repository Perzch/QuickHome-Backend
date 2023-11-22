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
    public IdCardRecord uploadIdCardInfo(String IDCardName, String IDCardNumber, String IDCardPhoneNumber, Long userId) {
        // 假设你已经创建了一个IdCardRecord对象并保存到了数据库
        IdCardRecord IdCardRecord = new IdCardRecord();
        IdCardRecord.setIDCardName_zch_hwz_gjc(IDCardName);
        IdCardRecord.setIDCardNumber_zch_hwz_gjc(IDCardNumber);
        IdCardRecord.setIDCardPhoneNumber_zch_hwz_gjc(IDCardPhoneNumber);
        IdCardRecord.setUserId_zch_hwz_gjc(userId);
        IdCardRecord.setInDateTime_zch_hwz_gjc(new Date());
        baseMapper.insert(IdCardRecord);

        return IdCardRecord;
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
    public boolean deleteIdCardInfo(String IDCardName, String IDCardNumber, String IDCardPhoneNumber, Long userId) {
        QueryWrapper<IdCardRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("IDCardName_zch_hwz_gjc", IDCardName)
                .eq("IDCardNumber_zch_hwz_gjc", IDCardNumber)
                .eq("IDCardPhoneNumber_zch_hwz_gjc", IDCardPhoneNumber)
                .eq("userId_zch_hwz_gjc", userId);
        return remove(queryWrapper);
    }

    @Override
    public boolean updateIdCardInfo(Long userId, String newName, String newNumber, String newPhoneNumber,
                                    String oldName, String oldNumber, String oldPhoneNumber) {
        UpdateWrapper<IdCardRecord> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("userId_zch_hwz_gjc", userId)
                .eq(oldName != null, "IDCardName_zch_hwz_gjc", oldName)
                .eq(oldNumber != null, "IDCardNumber_zch_hwz_gjc", oldNumber)
                .eq(oldPhoneNumber != null, "IDCardPhoneNumber_zch_hwz_gjc", oldPhoneNumber);

        IdCardRecord idCardRecord = new IdCardRecord();
        if (newName != null) idCardRecord.setIDCardName_zch_hwz_gjc(newName);
        if (newNumber != null) idCardRecord.setIDCardNumber_zch_hwz_gjc(newNumber);
        if (newPhoneNumber != null) idCardRecord.setIDCardPhoneNumber_zch_hwz_gjc(newPhoneNumber);

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





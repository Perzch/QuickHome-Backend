package com.quickhome.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.IdCardRecord;
import com.quickhome.mapper.IdCardRecordMapper;
import com.quickhome.service.IdCardRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_idcardrecord_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-29 15:58:06
*/
@Transactional
@Service
public class IdCardRecordServiceImpl extends ServiceImpl<IdCardRecordMapper, IdCardRecord>
    implements IdCardRecordService {

}





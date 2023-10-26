package com.quickhome.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.quickhome.domain.IdCardRecord;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tim-h
 * @description 针对表【tab_idcardrecord_zch_hwz_gjc】的数据库操作Service
 * @createDate 2023-06-29 15:58:06
 */
@Transactional
public interface IdCardRecordService extends IService<IdCardRecord> {

}

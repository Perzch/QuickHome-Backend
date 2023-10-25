package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.HousingReview;
import com.quickhome.service.HousingReviewService;
import com.quickhome.mapper.HousingReviewMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_housingreview_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:47:50
*/
@Transactional
@Service
public class HousingReviewServiceImpl extends ServiceImpl<HousingReviewMapper, HousingReview>
    implements HousingReviewService{

}





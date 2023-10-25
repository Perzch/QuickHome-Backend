package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.AttractionReview;
import com.quickhome.service.AttractionReviewService;
import com.quickhome.mapper.AttractionReviewMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_attractionreview_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:45:06
*/
@Transactional
@Service
public class AttractionReviewServiceImpl extends ServiceImpl<AttractionReviewMapper, AttractionReview>
    implements AttractionReviewService{

}





package com.quickhome.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.quickhome.domain.AttractionReview;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_attractionreview_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:45:06
*/
@Transactional
public interface AttractionReviewService extends IService<AttractionReview> {
    boolean insertAttractionReview(AttractionReview attractionReview);
    boolean likeAttractionComment(Long attractionReviewId);
    boolean deleteCommentAndChildren(Long attractionReviewId);
    IPage<AttractionReview> getCommentsByAttractionId(Long attractionId, int pageNum, int pageSize);

}

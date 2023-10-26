package com.quickhome.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.quickhome.domain.HousingReview;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Tim-h
* @description 针对表【tab_housingreview_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:47:50
*/
public interface HousingReviewService extends IService<HousingReview> {
    public boolean insertHomeReview(HousingReview housingReview);

    public boolean likeComment(Long housingReviewId);
    public boolean deleteCommentAndChildren(Long housingReviewId);
    public IPage<HousingReview> getCommentsByHomeId(Long homeId, int pageNum, int pageSize);
}

package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.AttractionReview;
import com.quickhome.service.AttractionReviewService;
import com.quickhome.mapper.AttractionReviewMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
* @author Tim-h
* @description 针对表【tab_attractionreview_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:45:06
*/
@Transactional
@Service
public class AttractionReviewServiceImpl extends ServiceImpl<AttractionReviewMapper, AttractionReview>
    implements AttractionReviewService{
    @Override
    public boolean insertAttractionReview(AttractionReview attractionReview) {
        boolean result = save(attractionReview);
        if (result && attractionReview.getSecondAttractionReviewId_zch_hwz_gjc() == null) {
            attractionReview.setSecondAttractionReviewId_zch_hwz_gjc(attractionReview.getAttractionReviewId_zch_hwz_gjc());
            result = updateById(attractionReview);
        }
        return result;
    }

    @Override
    public boolean likeAttractionComment(Long attractionReviewId) {
        AttractionReview attractionReview = getById(attractionReviewId);
        if (attractionReview != null) {
            attractionReview.setAttractionLikeCount_zch_hwz_gjc(attractionReview.getAttractionLikeCount_zch_hwz_gjc() + 1);
            return updateById(attractionReview);
        }
        return false;
    }

    @Override
    public boolean deleteCommentAndChildren(Long attractionReviewId) {
        AttractionReview attractionReview = getById(attractionReviewId);
        if (attractionReview == null) {
            return false;
        }

        Queue<Long> queue = new LinkedList<>();
        queue.add(attractionReviewId);

        while (!queue.isEmpty()) {
            Long currentId = queue.poll();
            // 查找所有直接子评论
            List<AttractionReview> childrenComments = list(new QueryWrapper<AttractionReview>().eq("secondAttractionReviewId_zch_hwz_gjc", currentId));
            // 将所有直接子评论的 ID 加入队列
            for (AttractionReview childComment : childrenComments) {
                queue.add(childComment.getAttractionReviewId_zch_hwz_gjc());
            }
            // 删除当前评论
            removeById(currentId);
        }

        return true;
    }

    @Override
    public IPage<AttractionReview> getCommentsByAttractionId(Long attractionId, int pageNum, int pageSize) {
        Page<AttractionReview> page = new Page<>(pageNum, pageSize);
        QueryWrapper<AttractionReview> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("attractionsId_zch_hwz_gjc", attractionId);
        return page(page, queryWrapper);
    }

}





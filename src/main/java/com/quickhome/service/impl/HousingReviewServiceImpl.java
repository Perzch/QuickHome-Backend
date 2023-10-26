package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.HousingReview;
import com.quickhome.service.HousingReviewService;
import com.quickhome.mapper.HousingReviewMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
* @author Tim-h
* @description 针对表【tab_housingreview_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:47:50
*/
@Transactional
@Service
public class HousingReviewServiceImpl extends ServiceImpl<HousingReviewMapper, HousingReview>
    implements HousingReviewService{

    @Override
    public boolean insertHomeReview(HousingReview housingReview) {
        return save(housingReview);
    }

    @Override
    public boolean likeComment(Long housingReviewId) {
        HousingReview housingReview = getById(housingReviewId);
        if (housingReview != null) {
            housingReview.setHomeLikeCount_zch_hwz_gjc(housingReview.getHomeLikeCount_zch_hwz_gjc() + 1);
            return updateById(housingReview);
        }
        return false;
    }

    @Override
    public boolean deleteCommentAndChildren(Long housingReviewId) {
        HousingReview housingReview = getById(housingReviewId);
        if (housingReview == null) {
            return false;
        }

        Queue<Long> queue = new LinkedList<>();
        queue.add(housingReviewId);

        while (!queue.isEmpty()) {
            Long currentId = queue.poll();
            // 查找所有直接子评论
            List<HousingReview> childrenComments = list(new QueryWrapper<HousingReview>().eq("secondHousingReviewId_zch_hwz_gjc", currentId));
            // 将所有直接子评论的 ID 加入队列
            for (HousingReview childComment : childrenComments) {
                queue.add(childComment.getHousingReviewId_zch_hwz_gjc());
            }
            // 删除当前评论
            removeById(currentId);
        }

        return true;
    }



    @Override
    public IPage<HousingReview> getCommentsByHomeId(Long homeId, int pageNum, int pageSize) {
        // 创建分页对象
        Page<HousingReview> page = new Page<>(pageNum, pageSize);

        // 创建查询条件
        QueryWrapper<HousingReview> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("homeId_zch_hwz_gjc", homeId);

        // 执行查询
        return page(page, queryWrapper);
    }

}





package com.quickhome.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.quickhome.domain.AttractionReview;
import com.quickhome.domain.HousingReview;
import com.quickhome.mapper.AttractionReviewMapper;
import com.quickhome.mapper.HousingReviewMapper;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.AttractionReviewService;
import com.quickhome.service.HousingReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/26 19:56
 */
@Transactional
@Controller("ReviewCon")
@RequestMapping("/Review")
public class ReviewController {
    @Autowired
    private HousingReviewService housingReviewService;

    @Autowired
    private HousingReviewMapper housingReviewMapper;
    @Autowired
    private AttractionReviewService attractionReviewService;
    @Autowired
    private AttractionReviewMapper attractionReviewMapper;

    @PostMapping("/insertHomeReview")
    public ResponseEntity<ResponseResult<?>> insertHomeReview(@RequestBody HousingReview housingReview) {
        housingReview.setReviewTime_zch_hwz_gjc(new Date());  // 设置当前时间为评论时间
        boolean result = housingReviewService.insertHomeReview(housingReview);

        if (housingReview.getSecondHousingReviewId_zch_hwz_gjc() != null) {
            if (housingReviewMapper.selectById(housingReview.getSecondHousingReviewId_zch_hwz_gjc()) == null && housingReview.getSecondHousingReviewId_zch_hwz_gjc() != null) {
                housingReviewMapper.deleteById(housingReview.getHousingReviewId_zch_hwz_gjc());
                return ResponseEntity.badRequest().body(ResponseResult.error("该条评论已被删除"));
            }
        }
        if (result && housingReview.getSecondHousingReviewId_zch_hwz_gjc() == null) {
            try {
                housingReview.setSecondHousingReviewId_zch_hwz_gjc(housingReview.getHousingReviewId_zch_hwz_gjc());
                housingReviewService.updateById(housingReview);  // 更新记录，将 secondHousingReviewId 设置为 housingReviewId_zch_hwz_gjc 的值
                return ResponseEntity.ok(ResponseResult.ok());
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(ResponseResult.error("评论失败"));
            }
        } else if (result) {
            return ResponseEntity.ok(ResponseResult.ok("插入成功"));
        } else {
            return ResponseEntity.badRequest().body(ResponseResult.error("插入评论失败"));
        }
    }

    @PutMapping("/likeHomeComment")
    public ResponseEntity<ResponseResult<?>> likeComment(@RequestParam Long housingReviewId) {
        boolean result = housingReviewService.likeComment(housingReviewId);
        if (result) {
            return ResponseEntity.ok(ResponseResult.ok());
        } else {
            return ResponseEntity.badRequest().body(ResponseResult.error("点赞失败"));
        }
    }

    @DeleteMapping("/deleteHomeComment")
    public ResponseEntity<ResponseResult> deleteComment(@RequestParam Long housingReviewId) {
        boolean result = housingReviewService.deleteCommentAndChildren(housingReviewId);
        if (result) {
            return ResponseEntity.ok(ResponseResult.ok());
        } else {
            return ResponseEntity.badRequest().body(ResponseResult.error("删除评论失败"));
        }
    }

    @GetMapping("/getHomeAllReview")
    public ResponseEntity<ResponseResult<IPage<HousingReview>>> getCommentsByHomeId(@RequestParam Long homeId,
                                                                                    @RequestParam(defaultValue = "1") int pageNum,
                                                                                    @RequestParam(defaultValue = "10") int pageSize) {
        IPage<HousingReview> comments = housingReviewService.getCommentsByHomeId(homeId, pageNum, pageSize);
        return ResponseEntity.ok(ResponseResult.ok(comments));
    }


    @PostMapping("/insertAttractionReview")
    public ResponseEntity<ResponseResult<?>> insertAttractionReview(@RequestBody AttractionReview attractionReview) {
        attractionReview.setReviewTime_zch_hwz_gjc(new Date());  // 设置当前时间为评论时间
        boolean result = attractionReviewService.insertAttractionReview(attractionReview);
        if (attractionReview.getSecondAttractionReviewId_zch_hwz_gjc() != null) {
            if (attractionReviewMapper.selectById(attractionReview.getSecondAttractionReviewId_zch_hwz_gjc()) == null && attractionReview.getSecondAttractionReviewId_zch_hwz_gjc() != null) {

                attractionReviewMapper.deleteById(attractionReview.getAttractionReviewId_zch_hwz_gjc());
                return ResponseEntity.badRequest().body(ResponseResult.error("该条评论已被删除"));
            }
        }

        if (result && attractionReview.getSecondAttractionReviewId_zch_hwz_gjc() == null) {
            attractionReview.setSecondAttractionReviewId_zch_hwz_gjc(attractionReview.getAttractionReviewId_zch_hwz_gjc());
            if (attractionReviewService.updateById(attractionReview)) {
                return ResponseEntity.ok(ResponseResult.ok("插入成功"));
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("插入失败"));
            }
        } else if (result) {
            return ResponseEntity.ok(ResponseResult.ok("插入成功"));
        } else {
            return ResponseEntity.badRequest().body(ResponseResult.error("插入失败"));
        }
    }

    @PutMapping("/likeAttractionComment")
    public ResponseEntity<ResponseResult<?>> likeAttractionComment(@RequestParam Long attractionReviewId) {
        boolean result = attractionReviewService.likeAttractionComment(attractionReviewId);
        if (result) {
            return ResponseEntity.ok(ResponseResult.ok("点赞成功"));
        } else {
            return ResponseEntity.badRequest().body(ResponseResult.error("点赞失败"));
        }
    }

    @DeleteMapping("/deleteAttractionComment")
    public ResponseEntity<ResponseResult<?>> deleteAttractionComment(@RequestParam Long attractionReviewId) {
        boolean result = attractionReviewService.deleteCommentAndChildren(attractionReviewId);
        if (result) {
            return ResponseEntity.ok(ResponseResult.ok("删除成功"));
        } else {
            return ResponseEntity.badRequest().body(ResponseResult.error("删除失败"));
        }
    }

    @GetMapping("/getAttractionAllReview")
    public ResponseEntity<ResponseResult<IPage<AttractionReview>>> getCommentsByAttractionId(@RequestParam Long attractionId,
                                                                                             @RequestParam(defaultValue = "1") int pageNum,
                                                                                             @RequestParam(defaultValue = "10") int pageSize) {
        IPage<AttractionReview> comments = attractionReviewService.getCommentsByAttractionId(attractionId, pageNum, pageSize);
        return ResponseEntity.ok(ResponseResult.ok(comments));
    }

}

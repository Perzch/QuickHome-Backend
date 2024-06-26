package com.quickhome.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quickhome.domain.Coupon;
import com.quickhome.domain.UsersAndCoupons;
import com.quickhome.mapper.CouponMapper;
import com.quickhome.mapper.UsersAndCouponsMapper;
import com.quickhome.pojo.PJReleaseCoupon;
import com.quickhome.pojo.PojoCoupon;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.CouponService;
import com.quickhome.service.UsersAndCouponsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/21 22:37
 */
@Transactional
@Controller("CouponCon")
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private UsersAndCouponsMapper usersAndCouponsMapper;

    @Autowired
    private CouponService couponService;

    @Autowired
    private UsersAndCouponsService usersAndCouponsService;


    /**
     * 添加优惠券
     * @param coupon 优惠券
     * @param req
     * @return
     */
    @ResponseBody
    @PostMapping
    public ResponseEntity<ResponseResult<?>> addCoupon(
            @RequestBody Coupon coupon,
            HttpServletRequest req) {

        boolean success = couponService.addCoupon(coupon);
        if (success) {
            return ResponseEntity.ok(ResponseResult.ok("添加成功"));
        } else {
            return ResponseEntity.status(500).body(ResponseResult.error("插入失败"));
        }
    }

    @ResponseBody
    @PutMapping
    public ResponseEntity<ResponseResult<?>> updateCoupon(@RequestBody Coupon coupon) {
        if(Objects.isNull(coupon.getCouponId_zch_hwz_gjc())) {
            return ResponseEntity.ok(ResponseResult.error("优惠券ID不能为空"));
        }
        boolean result = couponService.updateCoupon(coupon);
        if(result) {
            return ResponseEntity.ok(ResponseResult.ok(coupon));
        } else {
            return ResponseEntity.ok(ResponseResult.error("更新失败"));
        }
    }

    /**
     *  发放优惠券
     * @param req
     * @return
     */
    @ResponseBody
    @PostMapping("/release")
    public ResponseEntity<ResponseResult<?>> releaseCoupons(@RequestBody PJReleaseCoupon releaseCoupon, // 用户ID字符串
                                                            HttpServletRequest req) {

        List<Long> userIdList = null;
        if (releaseCoupon.getUserIds() != null && !releaseCoupon.getUserIds().isEmpty()) {
            userIdList = Arrays.stream(releaseCoupon.getUserIds().split(","))
                    .map(String::trim)
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
        }

        boolean success = couponService.releaseCouponsToUsers(releaseCoupon.getCouponId(), userIdList);
        if (success) {
            return ResponseEntity.ok(ResponseResult.ok());
        } else {
            return ResponseEntity.status(500).body(ResponseResult.error("发放失败"));
        }
    }

    /**
     * 用户使用优惠券
     * @param UACID 用户优惠券ID
     * @param req
     * @return
     */

    @ResponseBody
    @PutMapping("/use")
    public ResponseEntity<ResponseResult<?>> useCoupons(
            @RequestParam Long UACID,
            HttpServletRequest req) {

        boolean success = usersAndCouponsService.useCoupon(UACID);
        if (success) {
            return ResponseEntity.ok(ResponseResult.ok("使用成功"));
        } else {
            return ResponseEntity.status(500).body(ResponseResult.error("使用优惠券失败"));
        }
    }

    /**
     * 获取所有优惠券
     * @param current 页码
     * @param size 每页大小
     */
    @GetMapping("/coupon/list")
    public ResponseEntity<ResponseResult<?>> getAllCoupons(
            @RequestParam(required = false, defaultValue = "1", name = "page") long current,
            @RequestParam(required = false, defaultValue = "10", name = "size") long size) {
        try {
            QueryWrapper<Coupon> queryWrapper = new QueryWrapper<>();
            queryWrapper.orderByDesc("earliestUseTime_zch_hwz_gjc");

            IPage<Coupon> page = couponService.page(new Page<>(current, size), queryWrapper);

            return ResponseEntity.ok(ResponseResult.ok(page));
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error(e.getMessage()));
        }
    }

    /**
     * 获取用户所有优惠券
     * @param userId 用户ID
     * @param page 页码
     * @param size 每页大小
     * @param req
     * @return
     */

    @ResponseBody
    @GetMapping("/list")
    public ResponseEntity<ResponseResult<?>> getAllCoupons(
            @RequestParam Long userId,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            HttpServletRequest req) {

        try {
            QueryWrapper<UsersAndCoupons> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("userId_zch_hwz_gjc", userId)
                    .eq("condition_zch_hwz_gjc", "未使用")
                    .eq("deleted_zch_hwz_gjc", 0);

            // 获取所有的优惠券记录
            List<UsersAndCoupons> allUsersAndCoupons = usersAndCouponsMapper.selectList(queryWrapper);

            // 筛选出未过期的优惠券
            LocalDateTime now = LocalDateTime.now();
            List<PojoCoupon> validCoupons = allUsersAndCoupons.stream()
                    .map(usersAndCoupons -> {
                        Coupon coupon = couponMapper.selectById(usersAndCoupons.getCouponId_zch_hwz_gjc());
                        if (coupon != null) {
                            LocalDateTime latestUseTime = LocalDateTime.ofInstant(coupon.getLatestUseTime_zch_hwz_gjc().toInstant(), ZoneId.systemDefault());
                            if (!now.isAfter(latestUseTime)) {
                                PojoCoupon pojoCoupon = new PojoCoupon();
                                pojoCoupon.setCoupon(coupon);
                                pojoCoupon.setUsersAndCoupons(usersAndCoupons);
                                return pojoCoupon;
                            }
                        }
                        return null;
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            // 手动分页
            int start = (page - 1) * size;
            int end = Math.min((start + size), validCoupons.size());
            List<PojoCoupon> paginatedCoupons = validCoupons.subList(start, end);

            Page<PojoCoupon> pojoCouponPage = new Page<>(page, size);
            pojoCouponPage.setTotal(validCoupons.size());
            pojoCouponPage.setRecords(paginatedCoupons);

            return ResponseEntity.ok(ResponseResult.ok(pojoCouponPage));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(ResponseResult.error("查询失败：" + e.getMessage()));
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseResult<?>> handleException(Exception e) {
        return ResponseEntity.status(500).body(ResponseResult.error(e.getMessage()));
    }

    /**
     * 删除优惠券
     * @param couponId 优惠券ID
     * @param req
     * @return
     */
    @ResponseBody
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseResult<?>> delCoupon(
            @PathVariable("id") Long couponId,
            HttpServletRequest req) {

        try {
            // 更新 tab_coupon_zch_hwz_gjc 表中的逻辑删除字段
            UpdateWrapper<Coupon> couponUpdateWrapper = new UpdateWrapper<>();
            couponUpdateWrapper.eq("couponId_zch_hwz_gjc", couponId)
                    .set("deleted_zch_hwz_gjc", 1);
            int couponResult = couponMapper.update(null, couponUpdateWrapper);

            // 更新 tab_usersAndCoupons_zch_hwz_gjc 表中的逻辑删除字段
            UpdateWrapper<UsersAndCoupons> usersAndCouponsUpdateWrapper = new UpdateWrapper<>();
            usersAndCouponsUpdateWrapper.eq("couponId_zch_hwz_gjc", couponId)
                    .set("deleted_zch_hwz_gjc", 1);
            int usersAndCouponsResult = usersAndCouponsMapper.update(null, usersAndCouponsUpdateWrapper);

            if (couponResult > 0 && usersAndCouponsResult >= 0) {
                // 如果优惠券种类删除成功，并且用户的该种类优惠券也删除成功（或没有该种类的优惠券）
                return ResponseEntity.ok(ResponseResult.ok());
            } else {
                return ResponseEntity.status(500).body(ResponseResult.error("删除失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(ResponseResult.error("删除失败：" + e.getMessage()));
        }
    }

    /**
     * 获取优惠券的最晚使用时间
     * @param couponId 优惠券ID
     * @return
     */
    @ResponseBody
    @GetMapping("/getLatestUseTime")
    public ResponseEntity<ResponseResult<?>> getLatestUseTime(
            @RequestParam Long couponId) {

        try {
            Coupon coupon = couponMapper.selectById(couponId);
            if (coupon != null) {
                Date latestUseTime = coupon.getLatestUseTime_zch_hwz_gjc();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = formatter.format(latestUseTime);
                return ResponseEntity.ok(ResponseResult.ok(formattedDate));
            } else {
                return ResponseEntity.status(404).body(ResponseResult.error("优惠券不存在"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(ResponseResult.error("查询失败：" + e.getMessage()));
        }
    }

    /**
     * 获取优惠券的详细信息
     * @param couponId 优惠券ID
     * @return
     */

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<ResponseResult<?>> getCouponInfo(
            @PathVariable("id") Long couponId) {

        try {
            Coupon coupon = couponMapper.selectById(couponId);
            if (coupon != null) {
                return ResponseEntity.ok(ResponseResult.ok(coupon));
            } else {
                return ResponseEntity.status(404).body(ResponseResult.error("优惠券不存在"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(ResponseResult.error("查询失败：" + e.getMessage()));
        }
    }
}

package com.quickhome.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quickhome.domain.Coupon;
import com.quickhome.domain.UsersAndCoupons;
import com.quickhome.mapper.CouponMapper;
import com.quickhome.mapper.UsersAndCouponsMapper;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/21 22:37
 */
@Transactional
@Controller("CouponCon")
@RequestMapping("/Coupon")
public class CouponController {

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private UsersAndCouponsMapper usersAndCouponsMapper;

    @Autowired
    private CouponService couponService;

    @Autowired
    private UsersAndCouponsService usersAndCouponsService;

    @ResponseBody
    @PostMapping("/addCoupon")
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
    @PostMapping("/userAddCoupons")
    public ResponseEntity<ResponseResult<?>> userAddCoupons(
            @RequestBody UsersAndCoupons usersAndCoupons,
            HttpServletRequest req) {

        boolean success = usersAndCouponsService.addUserCoupon(usersAndCoupons);
        if (success) {
            return ResponseEntity.ok(ResponseResult.ok());
        } else {
            return ResponseEntity.status(500).body(ResponseResult.error("发放失败"));
        }
    }

    @ResponseBody
    @PutMapping("/useCoupons")
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

    @ResponseBody
    @GetMapping("/getAllCoupons")
    public ResponseEntity<ResponseResult<?>> getAllCoupons(
            @RequestParam Long userId,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            HttpServletRequest req) {

        try {
            QueryWrapper<UsersAndCoupons> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("userId_zch_hwz_gjc", userId)
                    .eq("condition_zch_hwz_gjc", "未使用")
                    .eq("deleted_zch_hwz_gjc", 0);

            Page<UsersAndCoupons> page = new Page<>(pageNum, pageSize);
            IPage<UsersAndCoupons> usersAndCouponsPage = usersAndCouponsMapper.selectPage(page, queryWrapper);

            List<PojoCoupon> pojoCoupons = new ArrayList<>();
            LocalDateTime now = LocalDateTime.now();
            for (UsersAndCoupons usersAndCoupons : usersAndCouponsPage.getRecords()) {
                Coupon coupon = couponMapper.selectById(usersAndCoupons.getCouponId_zch_hwz_gjc());
                if (coupon != null) {
                    LocalDateTime latestUseTime = LocalDateTime.ofInstant(coupon.getLatestUseTime_zch_hwz_gjc().toInstant(), ZoneId.systemDefault());
                    if (!now.isAfter(latestUseTime)) {
                        PojoCoupon pojoCoupon = new PojoCoupon();
                        pojoCoupon.setCoupon(coupon);
                        pojoCoupon.setUsersAndCoupons(usersAndCoupons);
                        pojoCoupons.add(pojoCoupon);
                    }
                }
            }

            Page<PojoCoupon> pojoCouponPage = new Page<>(pageNum, pageSize);
            pojoCouponPage.setTotal(usersAndCouponsPage.getTotal());
            pojoCouponPage.setRecords(pojoCoupons);

            return ResponseEntity.ok(ResponseResult.ok(pojoCouponPage));
        } catch (Exception e) {
            // Handle exception...
            return ResponseEntity.status(500).body(ResponseResult.error("查询失败：" + e.getMessage()));
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseResult<?>> handleException(Exception e) {
        return ResponseEntity.status(500).body(ResponseResult.error(e.getMessage()));
    }

    @ResponseBody
    @DeleteMapping("/delCoupon")
    public ResponseEntity<ResponseResult<?>> delCoupon(
            @RequestParam Long couponId,
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

    @ResponseBody
    @GetMapping("/getCouponInfo")
    public ResponseEntity<ResponseResult<?>> getCouponInfo(
            @RequestParam Long couponId) {

        try {
            Coupon coupon = couponMapper.selectById(couponId);
            if (coupon != null) {
                return ResponseEntity.ok(ResponseResult.ok(coupon));
            } else {
                return ResponseEntity.status(404).body(ResponseResult.error("优惠券不存在"));
            }
        } catch (Exception e) {
            // Handle exception...
            return ResponseEntity.status(500).body(ResponseResult.error("查询失败：" + e.getMessage()));
        }
    }
}

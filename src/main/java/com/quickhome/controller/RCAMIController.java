package com.quickhome.controller;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quickhome.domain.RCAMI;
import com.quickhome.mapper.RCAMIMapper;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.RCAMIService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/10 10:32
 */
@Transactional
@Controller("RCAMICon")
@RequestMapping("/RCAMI")
public class RCAMIController {
    @Autowired
    private RCAMIService rcamiService;

    @Autowired
    private RCAMIMapper rcamiMapper;
    /**
     * 上传房屋维修信息
     * @param rcami 维修信息
     * @return 维修信息
     */
    @PostMapping
    public ResponseEntity<?> addRCAMI(@RequestBody RCAMI rcami, HttpServletRequest req) {
        rcami.setInformationCreatTime_zch_hwz_gjc(DateTime.now());
        boolean flag = rcamiService.save(rcami);
        return ResponseEntity.ok(ResponseResult.ok(rcami));
    }

    /**
     * 完成维修信息
     * @param rcami 维修信息
     * @param req
     * @return
     */

    @ResponseBody
    @PutMapping("/finish")
    public ResponseEntity<ResponseResult<?>> finishRCAMI(
            @RequestBody RCAMI rcami,
            HttpServletRequest req) {

        // 检查维修信息是否存在
        RCAMI existingRCAMI = rcamiService.getById(rcami.getWorkItemId_zch_hwz_gjc());
        if (existingRCAMI == null) {
            return ResponseEntity.badRequest().body(ResponseResult.of(500,"维修信息不存在"));
        }

        // 设置完成处理时间、工作人员编号和完成情况
        if (rcami.getCompletion_zch_hwz_gjc() == null || rcami.getCompletion_zch_hwz_gjc().isEmpty()) {
            rcami.setCompletion_zch_hwz_gjc("已完成");
        }

        // 设置版本号
        rcami.setVersion_zch_hwz_gjc(existingRCAMI.getVersion_zch_hwz_gjc());

        boolean flag = rcamiService.updateById(rcami);

        if (flag) {
            return ResponseEntity.ok(ResponseResult.ok(rcamiMapper.selectById(rcami.getWorkItemId_zch_hwz_gjc())));
        } else {
            return ResponseEntity.badRequest().body(ResponseResult.of(500,"更新失败，数据可能已被其他用户修改"));
        }
    }

    /**
     * 根据订单id或房屋id获取维修信息
     * @param orderId 订单id
     * @param homeId 房屋id
     * @param current 当前页
     * @param size 每页大小
     * @param req
     * @return
     */

    @ResponseBody
    @GetMapping("/list")
    public ResponseEntity<ResponseResult<?>> getRCAMIByOrderOrHome(
            @RequestParam(required = false) Long orderId,
            @RequestParam(required = false) Long homeId,
            @RequestParam(defaultValue = "1", name = "page") int current,
            @RequestParam(defaultValue = "10", name = "size") int size,
            HttpServletRequest req) {

        LambdaQueryWrapper<RCAMI> queryWrapper = new LambdaQueryWrapper<>();

        if (orderId != null) {
            queryWrapper.eq(RCAMI::getOrderId_zch_hwz_gjc, orderId);
        } else if (homeId != null) {
            queryWrapper.eq(RCAMI::getHomeId_zch_hwz_gjc, homeId);
        }

        queryWrapper.orderByDesc(RCAMI::getInformationCreatTime_zch_hwz_gjc);

        IPage<RCAMI> page = new Page<>(current, size);
        IPage<RCAMI> resultPage = rcamiService.page(page, queryWrapper);

        return ResponseEntity.ok(ResponseResult.ok(resultPage));
    }

}

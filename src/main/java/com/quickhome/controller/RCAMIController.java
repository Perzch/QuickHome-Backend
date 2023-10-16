package com.quickhome.controller;

import cn.hutool.core.date.DateTime;
import com.quickhome.domain.RCAMI;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.RCAMIService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/10 10:32
 */
@Controller("RCAMICon")
@RequestMapping("/RCAMI")
public class RCAMIController {
    @Autowired
    private RCAMIService RCAMIService;

    /**
     * 上传房屋维修信息
     * @param rcami 维修信息
     * @return 维修信息
     */
    @PostMapping("/addRCAMI")
    public ResponseEntity<?> addRCAMI(@RequestBody RCAMI rcami, HttpServletRequest req) {
        rcami.setInformationCreatTime_zch_hwz_gjc(DateTime.now());
        boolean flag = RCAMIService.save(rcami);
        return ResponseEntity.ok(ResponseResult.ok(rcami));
    }
}

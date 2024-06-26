package com.quickhome.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.quickhome.domain.Log;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.LogService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/28 19:52
 */
@Transactional
@Controller("LogCon")
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    /**
     * 日志记录
     *
     * @param log 日志信息
     * @return
     */
    @PostMapping
    public ResponseEntity<ResponseResult<?>> insertLog(@RequestBody Log log, HttpServletRequest req) {
        try {
            log.setExecutionTime_zch_hwz_gjc(new Date());
            boolean result = logService.save(log);
            if (result) {
                return ResponseEntity.ok(ResponseResult.ok(log));
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("插入日志失败"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok().body(ResponseResult.error("错误内容: " + e.getMessage()));
        }
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseResult<?>> getLogs(
            @RequestParam(required = false) Long userId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            IPage<Log> logs;
            if (userId != null){
                logs = logService.getLogsByUserId(userId, page, size);
            }else {
                logs = logService.getAllLogs(page, size);
            }
            return ResponseEntity.ok(ResponseResult.ok(logs));
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error("错误内容: " + e.getMessage()));
        }
    }
}

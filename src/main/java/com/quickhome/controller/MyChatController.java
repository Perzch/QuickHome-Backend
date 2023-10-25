package com.quickhome.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.quickhome.domain.Manager;
import com.quickhome.domain.MyChat;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.ManagerService;
import com.quickhome.service.MyChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/24 13:34
 */
@Transactional
@Controller("ChatCon")
@RequestMapping("/Chat")
public class MyChatController {
    @Autowired
    private MyChatService chatService;

    @Autowired
    private ManagerService managerService;

    @PostMapping("/send")
    public ResponseEntity<ResponseResult<?>> sendMessage(@RequestBody MyChat myChat) {
        try {
            if (myChat.getMessageReceive_zch_hwz_gjc() == null || myChat.getMessageReceive_zch_hwz_gjc() == 0) {
                Manager onlineManager = managerService.getRandomOnlineManager();
                if (onlineManager == null) {
                    return ResponseEntity.badRequest().body(ResponseResult.error("没有客服在线"));
                }
                myChat.setMessageReceive_zch_hwz_gjc(onlineManager.getManagerId_zch_hwz_gjc());
            }
            LocalDateTime now = LocalDateTime.now();
            Date currentDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
            myChat.setSendingTime_zch_hwz_gjc(currentDate);  // 设置发送时间为当前时间
            chatService.save(myChat);
            return ResponseEntity.ok(ResponseResult.ok());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseResult.error("发送错误"));
        }
    }


    @GetMapping("/history")
    public ResponseEntity<ResponseResult<?>> getChatHistory(
            @RequestParam Long senderId,
            @RequestParam Long receiverId,
            @RequestParam(defaultValue = "1") Integer pageIndex,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        try {
            List<MyChat> chatHistory = chatService.getChatHistory(senderId, receiverId, pageIndex, pageSize);
            return ResponseEntity.ok(ResponseResult.ok(chatHistory));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseResult.error("获取聊天历史失败"));
        }
    }
}

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
@RequestMapping("/chat")
public class MyChatController {
    @Autowired
    private MyChatService chatService;

    @Autowired
    private ManagerService managerService;

    /**
     * 发送消息
     *
     * @param myChat 消息对象
     * @return
     */
    @PostMapping
    public ResponseEntity<ResponseResult<?>> sendMessage(@RequestBody MyChat myChat) {
        try {
            if (myChat.getMessageReceive_zch_hwz_gjc() == null || myChat.getMessageReceive_zch_hwz_gjc() == 0) {
                Manager onlineManager = managerService.getRandomOnlineManager();
                if (onlineManager == null) {
                    return ResponseEntity.ok().body(ResponseResult.error("没有客服在线"));
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
            return ResponseEntity.ok().body(ResponseResult.error("发送错误"));
        }
    }


    /**
     * 获取聊天历史
     *
     * @param senderId    发送者ID
     * @param receiverId  接收者ID
     * @param page   页码
     * @param size    每页条数
     * @return
     */
    @GetMapping("/history")
    public ResponseEntity<ResponseResult<?>> getChatHistory(
            @RequestParam Long senderId,
            @RequestParam Long receiverId,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        try {
            List<MyChat> chatHistory = chatService.getChatHistory(senderId, receiverId, page, size);
            return ResponseEntity.ok(ResponseResult.ok(chatHistory));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok().body(ResponseResult.error("获取聊天历史失败"));
        }
    }
}

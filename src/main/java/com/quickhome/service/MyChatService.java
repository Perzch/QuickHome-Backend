package com.quickhome.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.quickhome.domain.MyChat;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_mychat_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:48:14
*/
public interface MyChatService extends IService<MyChat> {
    public List<MyChat> getChatHistory(Long senderId, Long receiverId, Integer pageIndex, Integer pageSize);

}

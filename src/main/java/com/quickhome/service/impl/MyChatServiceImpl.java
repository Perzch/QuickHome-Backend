package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.MyChat;
import com.quickhome.service.MyChatService;
import com.quickhome.mapper.MyChatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_mychat_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:48:14
*/
@Service
public class MyChatServiceImpl extends ServiceImpl<MyChatMapper, MyChat>
    implements MyChatService{
    @Autowired
    private MyChatMapper myChatMapper;

    @Override
    public List<MyChat> getChatHistory(Long senderId, Long receiverId, Integer pageIndex, Integer pageSize) {
        QueryWrapper<MyChat> queryWrapper = new QueryWrapper<>();
        queryWrapper.nested(i -> i
                        .eq("messageSender_zch_hwz_gjc", senderId)
                        .eq("messageReceive_zch_hwz_gjc", receiverId)
                        .or()
                        .eq("messageSender_zch_hwz_gjc", receiverId)
                        .eq("messageReceive_zch_hwz_gjc", senderId))
                .eq("deleted_zch_hwz_gjc", 0)
                .orderByDesc("sendingTime_zch_hwz_gjc");

        // 使用 MyBatis-Plus 的分页插件
        Page<MyChat> page = new Page<>(pageIndex, pageSize);
        IPage<MyChat> chatPage = myChatMapper.selectPage(page, queryWrapper);
        return chatPage.getRecords();
    }

}





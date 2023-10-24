package com.quickhome;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/24 16:33
 */
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
@ServerEndpoint("/websocket/{username}") //暴露的ws应用的路径
public class WebSocket {

    /**
     * 客户端与服务端连接成功
     * @param session
     * @param username
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username){
        /*
            do something for onOpen
            与当前客户端连接成功时
         */
    }

    /**
     * 客户端与服务端连接关闭
     * @param session
     * @param username
     */
    @OnClose
    public void onClose(Session session,@PathParam("username") String username){
        /*
            do something for onClose
            与当前客户端连接关闭时
         */
    }

    /**
     * 客户端与服务端连接异常
     * @param error
     * @param session
     * @param username
     */
    @OnError
    public void onError(Throwable error,Session session,@PathParam("username") String username) {
    }

    /**
     * 客户端向服务端发送消息
     * @param message
     * @param username
     * @throws IOException
     */
    @OnMessage
    public void onMsg(Session session,String message,@PathParam("username") String username) throws IOException {
        /*
            do something for onMessage
            收到来自当前客户端的消息时
         */
    }
}
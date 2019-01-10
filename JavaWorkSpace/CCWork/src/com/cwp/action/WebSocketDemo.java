package com.cwp.action;


import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint("/webSocket")
public class WebSocketDemo {
    private  static final AtomicInteger onlineCount=new AtomicInteger(0);
    private static CopyOnWriteArraySet<WebSocketDemo> webSocketSet=new CopyOnWriteArraySet<WebSocketDemo>();
    private final String nickname;
    private Session session;
    private WebSocketDemo(){
        nickname="访客"+onlineCount.getAndIncrement();
    }

    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        webSocketSet.add(this);
        String message=String.format("[%s,%s]",nickname,"加入聊天室");
        broadcast(message);
        System.out.println("onOpen");
    }

    @OnMessage
    public void onMessage(String message,Session session){
         System.out.println(this.session==session);
         broadcast(String.format("%s:%s",nickname,message));
    }

    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        String message=String.format("[%s,%s]",nickname,"离开了聊天室");
        broadcast(message);
    }

    private void broadcast(String info){
        for (WebSocketDemo w:webSocketSet){
            try {
                synchronized (WebSocketDemo.class){
                    w.session.getBasicRemote().sendText(info);
                }
            }catch (IOException e){
                System.out.println("向客户端"+w.nickname+"发送请求失败");
                webSocketSet.remove(w);
                try{
                    w.session.close();
                }catch (IOException e1){
                    String message=String.format("[%s,%s]",w.nickname,"已断开连接");
                    broadcast(message);
                }
            }
        }
    }
}

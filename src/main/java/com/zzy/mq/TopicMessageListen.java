package com.zzy.mq;

import javax.jms.*;

public class TopicMessageListen implements MessageListener{

    public void onMessage(Message message) {
        System.out.println("监听==================监听");
        try {
            System.out.println(message);
            TextMessage tm = (TextMessage)(message);
            System.out.println(tm.getText());
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
/**************************************************************************
 * Copyright (c) 2016-2017 Zhejiang TaChao Network Technology Co.,Ltd.
 * All rights reserved.
 *
 * 项目名称：浙江踏潮-基础架构
 * 版权说明：本软件属浙江踏潮网络科技有限公司所有，在未获得浙江踏潮网络科技有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.zjtachao.rabbitmq.rabbitmqsender.rabbit.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author <a href="mailto:LYJ@zjtachao.com">LYJ</a>
 * @since 2.0
 */
@Configuration
public class TopicRabbitConfig {

     final static String message ="topic.message";

     final static String messages ="topic.messages";

     @Bean
     public Queue queueMessage(){
         return new Queue(TopicRabbitConfig.message);
     }

     @Bean
     public Queue queueMessages(){
          return new Queue(TopicRabbitConfig.messages);
     }

     @Bean
      TopicExchange exchange(){
             return new TopicExchange("exchange");
         }

     @Bean
     Binding bindingExchangeMessage(Queue queueMessage,TopicExchange exchange){
         return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
     }

     @Bean
    Binding bindingExchangeMessages(Queue queueMessages,TopicExchange exchange){
         return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
     }

}

/**************************************************************************
 * Copyright (c) 2016-2017 Zhejiang TaChao Network Technology Co.,Ltd.
 * All rights reserved.
 *
 * 项目名称：浙江踏潮-基础架构
 * 版权说明：本软件属浙江踏潮网络科技有限公司所有，在未获得浙江踏潮网络科技有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.zjtachao.rabbitmq.rabbitmqsender.rabbit.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author <a href="mailto:LYJ@zjtachao.com">LYJ</a>
 * @since 2.0
 */
@Configuration
public class FanoutRabbitConfig {


    @Bean
    public Queue AMessagge(){
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessagge(){
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessagge(){
        return new Queue("fanout.C");
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA(Queue AMessagge, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(AMessagge).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessagge, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(BMessagge).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessagge, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(CMessagge).to(fanoutExchange);
    }
}

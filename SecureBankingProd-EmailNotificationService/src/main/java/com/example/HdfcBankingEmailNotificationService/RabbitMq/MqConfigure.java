package com.example.HdfcBankingEmailNotificationService.RabbitMq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfigure {
    public static final String QUEUE1="hdfc-account-creation-trigger",QUEUE2="hdfc-account-pinchange-trigger",QUEUE3="hdfc-account-withdraw-notification",QUEUE4="hdfc-account-deposit-notification";
    public static final String EXCHANGE="hdfc-email-notification-service";
    public static final String ROUTING_KEY1="account-creation",ROUTING_KEY2="pin-change",ROUTING_KEY3="amount-withdraw",ROUTING_KEY4="amount-deposit";

    @Bean
    public Queue queue1(){ return new Queue(QUEUE1); }

    @Bean
    public Queue queue2(){ return new Queue(QUEUE2); }

    @Bean
    public Queue queue3(){ return new Queue(QUEUE3); }

    @Bean
    public Queue queue4(){ return new Queue(QUEUE4); }

    @Bean
    public TopicExchange topicExchange(){ return new TopicExchange(EXCHANGE); }

    @Bean
    public Binding binding1(Queue queue1, TopicExchange exchange){
        return BindingBuilder.bind(queue1())
                .to(exchange)
                .with(ROUTING_KEY1);
    }

    @Bean
    public Binding binding2(Queue queue2, TopicExchange exchange){
        return BindingBuilder.bind(queue2())
                .to(exchange)
                .with(ROUTING_KEY2);
    }

    @Bean
    public Binding binding3(Queue queue3, TopicExchange exchange){
        return BindingBuilder.bind(queue3())
                .to(exchange)
                .with(ROUTING_KEY3);
    }

    @Bean
    public Binding binding4(Queue queue4, TopicExchange exchange){
        return BindingBuilder.bind(queue4())
                .to(exchange)
                .with(ROUTING_KEY4);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}

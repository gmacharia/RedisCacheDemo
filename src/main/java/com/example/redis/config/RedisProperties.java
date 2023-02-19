/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.redis.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 *
 * @author kobe
 */
@ConfigurationProperties("redis.props")
public record RedisProperties(
        String hostName,
        int port)  { 

}

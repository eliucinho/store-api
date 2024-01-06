package com.eliud.store.api.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.eliud.store.api", "paquete.donde.esta.price.mapper"})
public class AppConfig {

}
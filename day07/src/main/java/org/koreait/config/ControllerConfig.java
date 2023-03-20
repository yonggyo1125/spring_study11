package org.koreait.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"org.koreait.controllers", "org.koreait.restcontrollers"})
public class ControllerConfig {

}
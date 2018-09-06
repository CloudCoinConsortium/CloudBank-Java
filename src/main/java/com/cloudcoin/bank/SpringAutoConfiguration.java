package com.cloudcoin.bank;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Main.class)
public class SpringAutoConfiguration {
}

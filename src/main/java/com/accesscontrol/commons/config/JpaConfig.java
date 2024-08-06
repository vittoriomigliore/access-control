package com.accesscontrol.commons.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.accesscontrol.usermanagement.repositories", "com.accesscontrol.gatelog.repositories"} )
public class JpaConfig {
}
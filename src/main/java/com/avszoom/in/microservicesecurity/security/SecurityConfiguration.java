package com.avszoom.in.microservicesecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.beans.BeanProperty;

/*
* So this configuration class extends WebSecurityConfigurerAdapter and spring security calls configure method and provide
* AuthenticationManagerBuilder which we can use to create our own AuthenticationManager.
*
* Annotation tell spring security that use this bean to handle web security
* */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("blah")
                .password("blah")
                .roles("USER")
                .and()
                .withUser("impw")
                .password("impw12")
                .roles("USERS");

    }

    /*
    * SO spring security looks for PasswordEncoder because it assumes that password provided by us is encoded so it need to decode it
    * to perform validation when client send its credentials.
    * */
    @Bean
    PasswordEncoder getEncoding(){
        return NoOpPasswordEncoder.getInstance();
    }

}

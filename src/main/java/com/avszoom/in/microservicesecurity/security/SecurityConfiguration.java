package com.avszoom.in.microservicesecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.beans.BeanProperty;

/*
* So this configuration class extends WebSecurityConfigurerAdapter and spring security calls configure method and provide
* AuthenticationManagerBuilder which we can use to create our own AuthenticationManager instance. This manager instance once
* configured invokes default providers present in spring boot based on what type of authentication it is default is form Login.
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
                .withUser("foo")
                .password("foo")
                .roles("ADMIN")
                .and()
                .withUser("any")
                .password("any")
                .roles("ANYONE");

    }

    /*
    * This method is used for authorizing urls with roles. SO only this roles are authorized to access these urls.
    * execution happen in order, so if we put least restrictive role at top it will match all
    * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin")
                .hasRole("ADMIN")
                .antMatchers("/user")
                .hasAnyRole("ADMIN","USER")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
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

package com.project.auth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.auth2.repositories.UserRepo;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private UserRepo repo;

	public WebSecurityConfig(UserRepo repo) {
		this.repo = repo;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(UserRepo repo) {
		this.repo = repo;
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.
        authorizeRequests()
            .antMatchers("/static/**", "/").permitAll()
            .antMatchers("/admin/**").access("hasRole('ADMIN')")
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/")
            .permitAll()
            .and()
        .logout()
            .permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(repo).passwordEncoder(bCryptPasswordEncoder(repo));
	}
}
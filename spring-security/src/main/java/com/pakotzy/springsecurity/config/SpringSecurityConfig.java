package com.pakotzy.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(users.username("b").password("b").roles("Employee", "Boss"));
		auth.inMemoryAuthentication().withUser(users.username("p").password("p").roles("Employee", "Pleb"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").hasRole("Employee")
								.antMatchers("/boss/**").hasRole("Boss")
				.and().formLogin().loginPage("/login").loginProcessingUrl("/authenticate").permitAll()
				.and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");
	}
}

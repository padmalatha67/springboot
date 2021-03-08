package com.zemoso.springboot.springbootassignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;



	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth
				.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
				//.httpBasic()
				//.and()
				.csrf()
				.disable()
				.authorizeRequests()
				.antMatchers("/").hasAnyRole("USER")
				.antMatchers("/claims/list/by/user").hasRole("INDIVIDUAL")
				.antMatchers("/claims/list/by/provider").hasRole("PROVIDER")
				.antMatchers("/claims/**").hasRole("ADMIN")
				//.antMatchers("/claims/**").hasAnyRole("ADMIN","PROVIDER","INDIVIDUAL")
				.antMatchers("/providers/**").hasAnyRole("ADMIN","INDIVIDUAL")
				.and()
				.formLogin().loginPage("/login/page").loginProcessingUrl("/authenticateTheUser")
				.permitAll()
				.and().logout().permitAll()
				//.and()
				//.authorizeRequests().anyRequest().authenticated()
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied")
		;
	}
		
}







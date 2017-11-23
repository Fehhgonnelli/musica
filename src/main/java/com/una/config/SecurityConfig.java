package com.una.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//import org.h2.server.web.WebServlet;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		//.csrf().disable()
		.authorizeRequests()
		.antMatchers("/css/**/*","/js/**/*","/themes/**/*").permitAll()
		//.antMatchers(HttpMethod.POST , "/").hasRole("ADMIN")
		//.antMatchers("/**").permitAll()
		//.antMatchers("/**").authenticated()
				.anyRequest().authenticated()
				.and().formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.permitAll().and().logout()
				.permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> manager = auth.inMemoryAuthentication();
		manager.withUser("user").password("123").roles("USER");
		manager.withUser("admin").password("321").roles("ADMIN");

	}
	
}

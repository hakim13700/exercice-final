package fr.treeptik.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
    private DataSource dataSource;

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/resources/*/**"
                , "/deveryware/*/**"
                , "*/js/*/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
  	  auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("USER");
  	  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
  	  auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

  	  http.csrf().disable().authorizeRequests()
  		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
  		.antMatchers("/**").access("hasRole('ROLE_ADMIN')")
  		.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
  		.and().formLogin()
  		.and().logout()
  			.logoutUrl("/logout");
    }
	
	
	
	
	
	/*
	@Autowired
    private DataSource dataSource;

	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
	  
	  
//	  auth.jdbcAuthentication().dataSource(dataSource);
//	  auth.jdbcAuthentication().usersByUsernameQuery("SELECT login, encrypted_password, enabled FROM person where login=?");
//	  auth.jdbcAuthentication().authoritiesByUsernameQuery("SELECT login, role FROM person where login=?");
	  
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.csrf().disable().authorizeRequests()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
		.and().formLogin()
		.and().logout()
			.logoutUrl("/logout");
		
	}*/
}
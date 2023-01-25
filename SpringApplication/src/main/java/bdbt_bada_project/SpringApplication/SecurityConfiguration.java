package bdbt_bada_project.SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()

                .withUser("3")
                .password("user")
                .roles("USER")
                .and()
                .withUser("4")
                .password("user")
                .roles("USER")
                .and()
                .withUser("8")
                .password("user")
                .roles("USER")
                .and()
                .withUser("user")
                .password("user")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }


    @Bean
    public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()


                .antMatchers("/", "/index").permitAll()
                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/main").authenticated()
                .antMatchers("/main_admin").access("hasRole('ADMIN')")
                .antMatchers("/user").access("hasRole('USER') or hasRole('ADMIN')")
                .antMatchers("/klienci").authenticated()
                .antMatchers("/klienci/edit/{userId}").access("@userSecurity.hasUserId(authentication, #userId) or hasRole('ADMIN')")
                .antMatchers("/klienci/update").permitAll()
                .antMatchers("/klienci/delete/**").access("hasRole('ADMIN')")
                .antMatchers("/klienci/new").access("hasRole('ADMIN')")
                .antMatchers("/klienci/save").access("hasRole('ADMIN') or hasRole ('USER')")
                .antMatchers("/user/user_edycja").access("hasRole('USER') or hasRole('ADMIN')")

                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/index")
                .logoutSuccessUrl("/index")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .permitAll();
    }
}


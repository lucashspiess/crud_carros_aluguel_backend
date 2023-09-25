package br.ueg.prog.webi.faculdade.crud.configuration;

import br.ueg.prog.webi.api.config.ApiSecurityConfig;
import br.ueg.prog.webi.api.config.ApiWebConfig;
import br.ueg.prog.webi.api.config.LogoutService;
import br.ueg.prog.webi.api.exception.FilterChainExceptionHandler;
import br.ueg.prog.webi.api.security.AuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig extends ApiSecurityConfig {

    @Value("${app.api.security.url-auth-controller:/api/v1/auth}")
    private String urlAuthController;

    @Autowired
    protected LogoutService logoutHandler;

    @Autowired
    protected AuthenticationProvider authenticationProvider;

    @Autowired
    private ApiWebConfig apiWebConfig;
    @Autowired
    private FilterChainExceptionHandler filterChainExceptionHandler;

    @Override
    protected void configureHttpSecurity(HttpSecurity http) {

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        List<String> freeAccessPaternsList = new ArrayList<>(
                Arrays.asList(urlAuthController.concat("/**"),
                        "/v2/api-docs",
                        "/v3/api-docs",
                        "/v3/api-docs/**",
                        "/swagger-resources",
                        "/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/swagger-ui/**",
                        "/webjars/**",
                        "/swagger-ui.html",
                        "/api/v1/usuario/singup",
                        "/api/v1/usuario/obterPorlogin"));
        freeAccessPaternsList.addAll(getCustomFreeAccessPaterns());
        String[] freeAccessPaterns = freeAccessPaternsList.toArray(new String[0]);
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(
                        freeAccessPaterns
                )
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(filterChainExceptionHandler, LogoutFilter.class)
                .logout()
                .logoutUrl("/api/v1/auth/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                .and()
                .cors().configurationSource(request -> {
                    return apiWebConfig.getCorsConfiguration();
                })
        ;
        configureHttpSecurity(http);

        return http.build();
    }

    protected List<String> getCustomFreeAccessPaterns() {
        return Arrays.asList();
    };
}
/*
 * SwaggerConfig.java
 * Copyright (c) UEG.
 *
 *
 *
 *
 */
package br.ueg.prog.webi.faculdade.crud.configuration;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import br.ueg.prog.webi.api.config.ApiSwaggerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Classe de configuração referente a geração de documentação automatida da API
 * REST.
 * 
 * @author UEG
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SwaggerConfig extends ApiSwaggerConfig {
}

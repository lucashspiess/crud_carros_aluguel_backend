/*
 * WebConfig.java
 * Copyright (c) UEG.
 *
 *
 *
 *
 */
package br.ueg.prog.webi.faculdade.crud.configuration;

import br.ueg.prog.webi.api.config.ApiWebConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * Classe de configuração referente aos recursos Web MVC da aplicação.
 * 
 * @author UEG
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class WebConfig extends ApiWebConfig {

	/**
	 * Retorna a instância {@link MethodValidationPostProcessor}.
	 * 
	 * @return
	 */
	/*@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}*/

}
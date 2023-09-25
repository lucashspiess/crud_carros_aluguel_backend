package br.ueg.prog.webi.faculdade.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.*;
@SpringBootApplication(scanBasePackages = {
		"br.ueg.prog.webi.faculdade.*",
		"br.ueg.prog.webi.*" //Para funcionamento da Arquitetura
})
@EntityScan(basePackageClasses = {Jsr310JpaConverters.class},
		basePackages = {
				"br.ueg.prog.webi.faculdade.*",
				"br.ueg.prog.webi.api.*" //Para funcionamento da Arquitetura
		})
@EnableWebSecurity
public class Application {

		public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
		}

}
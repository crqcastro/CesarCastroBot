package br.com.cesarcastro.telegram.bot.cesarcastrobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CesarCastroBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(CesarCastroBotApplication.class, args);
	}

}

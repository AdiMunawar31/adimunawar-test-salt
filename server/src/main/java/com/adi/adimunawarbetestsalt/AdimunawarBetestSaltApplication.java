package com.adi.adimunawarbetestsalt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "lib.i18n", "com.adi" })
public class AdimunawarBetestSaltApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdimunawarBetestSaltApplication.class, args);
	}

}

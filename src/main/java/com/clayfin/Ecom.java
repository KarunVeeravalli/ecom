package com.clayfin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.clayfin")
public class Ecom {

	public static void main(String[] args) {
		SpringApplication.run(Ecom.class, args);
		
		System.out.println(""
				+ "========================================================\n"
				+ "    ______          ______   ____   _    \n"
				+ "   / ___ /         / ___ / /  _  \\ / \\  /\\     \n"
				+ "  / /__   ___     / /     / /  / //   \\/  \\\n"
				+ " / ___/  |___|   / /     / /  / // /\\   /\\ \\\n"
				+ "/ /___          / /____ / /_ / // /  \\_/  \\ \\\n"
				+ "\\_____|         \\_____/ \\ ____/ \\/         \\/\n"
				+"\n"
				+ "========================================================\n");
	}
}

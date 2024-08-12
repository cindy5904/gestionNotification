package org.example.gestionnotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class GestionNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionNotificationApplication.class, args);
	}

}

package net.lanet.screenmatchfrases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import net.lanet.screenmatchfrases.utils.ApplicationProperties;

@SpringBootApplication
@ComponentScan(basePackages = "net.lanet.screenmatchfrases")
public class ScreenMatchFrasesApplication {

	@Autowired
	private ApplicationProperties ap; //Status

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchFrasesApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			// Status
			ap.status("console");
		};
	}

}

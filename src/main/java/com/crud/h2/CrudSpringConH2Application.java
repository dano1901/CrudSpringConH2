package com.crud.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CrudSpringConH2Application implements CommandLineRunner {
	
	@Autowired
	private JdbcTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringConH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.execute("DROP TABLE PERSONA IF EXISTS");
		template.execute("CREATE TABLE PERSONA (id INTEGER PRIMARY KEY AUTO_INCREMENT,name VARCHAR(255), ap VARCHAR(100), am VARCHAR(100), hobbie VARCHAR(500))");
	
		for(int i = 0; i < 3; i++) {
			template.update("insert into persona (name) values ('Persona 000 " + i +"')");
			
		}
	}
	

}

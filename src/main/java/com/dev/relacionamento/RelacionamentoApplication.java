package com.dev.relacionamento;

import com.dev.relacionamento.domain.User;
import com.dev.relacionamento.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class RelacionamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelacionamentoApplication.class, args);
	}

}

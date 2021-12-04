package br.com.bycoders.avaliacao.cnabpersister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.bycoders.avaliacao.cnabpersister"})
public class CnabPersisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnabPersisterApplication.class, args);
	}

}

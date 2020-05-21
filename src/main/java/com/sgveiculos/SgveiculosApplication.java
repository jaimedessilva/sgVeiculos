package com.sgveiculos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan (basePackages = {"com.sgveiculos.controller"})
//@EntityScan("com.*")
@EnableAutoConfiguration
public class SgveiculosApplication implements CommandLineRunner {
	
//	@Autowired
//	private VeiculoRepository vr;
//	@Autowired
//	private ProprietarioRepository pRep;
	
	public static void main(String[] args) {
		SpringApplication.run(SgveiculosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Executar Instanciação manual
//		Proprietario p = new Proprietario("Gustavo Pereira","gustavo@gmail.com","61-999-888",null); 
//		Veiculo v = new Veiculo("Ferrari","Spider360",2020,2020, 1550000.98,"EUE-000-Brasilia-DF",p);
//		
//		pRep.save(p);
//		vr.save(v);
			
	}
}

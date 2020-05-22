package com.sgveiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan (basePackages = {"com.sgveiculos.controller","com.sgveiculos.security"})
@EnableAutoConfiguration
public class SgveiculosApplication  {
	

	
	public static void main(String[] args) {
		SpringApplication.run(SgveiculosApplication.class, args);
	}
	
//	@Autowired
//	private VeiculoRepository vr;
//	@Autowired
//	private ProprietarioRepository pRep;
	
	/*
	 *   Classe implements CommandLineRunner
	 *   Comando utilizado p instanciar objetos e inserir 
	 *   no Banco toda vez que a aplicação for iniciada
	 */
//	@Override
//	public void run(String... args) throws Exception {
//		Executar Instanciação manual
//		Proprietario p = new Proprietario("Gustavo Pereira","gustavo@gmail.com","61-999-888",null); 
//		Veiculo v = new Veiculo("Ferrari","Spider360",2020,2020, 1550000.98,"EUE-000-Brasilia-DF",p);
//		
//		pRep.save(p);
//		vr.save(v);
//			
//	}

}

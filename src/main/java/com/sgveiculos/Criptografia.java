package com.sgveiculos;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sgveiculos.model.Veiculo;

public class Criptografia {

	public static void main(String[] args) {
		String senha ="123";
		BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
		crypt.encode(senha);
		//System.out.println(crypt.encode(senha));
		
		Veiculo car = new Veiculo("Ford","Ká",2018,2018,18540.99,"aaa-123", null);
		System.out.println(car);
		System.out.println("---------------------------------------------------");
		car = new Veiculo();
		car.setModelo("gol");
		car.setFabricante("Volkwagen");
		car.setPlaca("BBB-789");
		
		System.out.println(car.getModelo());
		System.out.println(car.getFabricante());
		System.out.println(car.getPlaca());
		
	}

}

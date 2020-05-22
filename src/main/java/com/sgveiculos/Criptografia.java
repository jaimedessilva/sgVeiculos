package com.sgveiculos;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Criptografia {

	public static void main(String[] args) {
		String senha ="123";
		BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
		crypt.encode(senha);
		System.out.println(crypt.encode(senha));
	}

}

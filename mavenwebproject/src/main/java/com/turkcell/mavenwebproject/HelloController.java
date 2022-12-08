package com.turkcell.mavenwebproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
maven ile bir springmvc uygulamasının yazılması ve tomatte çalıştırılması
maven web archetype kullanılabilir
http://localhost:8080/firstspring/hello
adresinden girince "hello world" yazması gerekiyor
 */

@RestController
public class HelloController {
	@GetMapping("/helloworld")
	public String helloworld() {//mapping:bir url(/helloworld) ile bir metot(helloworld()) eşleştirildi.
								//spring web mvc ile bunu spring otomatik yaptı.
								//eskiden servletler kullanılıyordu.
		//http://localhost:8080/mavenwebproject/helloworld
		return "hello spring maven project";
	}
}

package com.turkcell.TechnicalService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.TechnicalService.model.SaleLOG;
import com.turkcell.TechnicalService.service.SaleLogService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("buy")
@AllArgsConstructor
public class BuyController {
	private SaleLogService service;
	
	@PostMapping("save")
	public ResponseEntity<SaleLOG> save(@RequestBody SaleLOG log ){
		//localhost:8080/buy/save
		//{"kredikarti":"111222333","user":{"id":1},"sale":{"id":1}}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(log));
	}
}

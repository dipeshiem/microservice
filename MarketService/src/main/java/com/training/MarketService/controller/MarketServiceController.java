/**
 * 
 */
package com.training.MarketService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.MarketService.model.Trade;
import com.training.MarketService.repository.MarketRepository;


/**
 * @author dipgarg
 *
 */
@RestController
@RequestMapping("MarketService")
public class MarketServiceController {
	
	public MarketRepository getMarketRepository() {
		return marketRepository;
	}

	public void setMarketRepository(MarketRepository tradeRepository) {
		this.marketRepository = tradeRepository;
	}

	@Autowired
	MarketRepository marketRepository;
	
	@PostMapping(path = "/save")
	public ResponseEntity<Trade> add (@RequestBody final Trade trade){
		System.out.println("in market save");
		return new ResponseEntity<Trade>(marketRepository.add(trade), HttpStatus.OK) ;
		
	}
	
	@GetMapping(path = "/getTrade")
	public ResponseEntity<Trade> get (@RequestParam final Integer tradeid){
		return new ResponseEntity<Trade>(marketRepository.gettrade(tradeid), HttpStatus.OK) ;
		
	}
	
	@GetMapping(path = "/getAlltrades")
	public ResponseEntity<List<Trade>> get (){
		System.out.println("in market get");
		return new ResponseEntity<List<Trade>>(marketRepository.getAll(), HttpStatus.OK) ;
		
	}
	

}

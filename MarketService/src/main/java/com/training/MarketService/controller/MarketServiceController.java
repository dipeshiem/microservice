/**
 * 
 */
package com.training.MarketService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Trade> add (@RequestBody final Trade trade){
		System.out.println("in market save");
		return marketRepository.add(trade);	
		
	}
	
	@GetMapping(path = "/getTrade")
	public Trade get (@RequestParam final Integer tradeid){
		return marketRepository.gettrade(tradeid);
		
	}
	
	@GetMapping(path = "/getAlltrades")
	public List<Trade> get (){
		System.out.println("in market get");
		return marketRepository.getAll();
		
	}
	

}

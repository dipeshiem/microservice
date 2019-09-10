/**
 * 
 */
package com.training.TradeService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.TradeService.model.Trade;
import com.training.TradeService.repository.TradeRepository;


/**
 * @author dipgarg
 *
 */
@RestController
@RequestMapping("TradeService")
public class TradeServiceController {
	
	public TradeRepository getTradeRepository() {
		return tradeRepository;
	}

	public void setTradeRepository(TradeRepository tradeRepository) {
		this.tradeRepository = tradeRepository;
	}

	@Autowired
	TradeRepository tradeRepository;
	
	@PostMapping(path = "/save")
	public List<Trade> add (@RequestBody final Trade trade){
		return tradeRepository.add(trade);	
		
	}
	
	@GetMapping(path = "/getTrade")
	public Trade get (@RequestParam final Integer tradeid){
		return tradeRepository.gettrade(tradeid);
		
	}
	
	@GetMapping(path = "/getAlltrades")
	public List<Trade> get (){
		return tradeRepository.getAll();
		
	}
	

}

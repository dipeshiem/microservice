/**
 * 
 */
package com.training.TradeService.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.training.TradeService.jms.JmsQueueSender;
import com.training.TradeService.model.Trade;
import com.training.TradeService.proxy.MarketServiceProxy;
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
	
	@Autowired
	MarketServiceProxy MarketServiceProxy;
	
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
	
	
	@PostMapping(path = "/feignsave")
	public ResponseEntity<Object> addfeign (@RequestBody final Trade trade){

		Trade trade1 = MarketServiceProxy.add(trade);
		System.out.println(trade1.getTradeId());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(trade1.getTradeId()).toUri();
		//send trade id to activemq for notification service 
		sendNotification(trade1.getTradeId());
		return  ResponseEntity.created(location).build();
		
		
	}
	
	
	@GetMapping(path = "/feigngetTrade")
	public ResponseEntity<Trade> getfeign (@RequestParam final Integer tradeid){
		return new ResponseEntity<Trade>(MarketServiceProxy.get(tradeid),HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/feigngetAlltrades")
	public ResponseEntity<List<Trade>> getfeign (){
		return new ResponseEntity<List<Trade>>( MarketServiceProxy.get(),HttpStatus.OK);
		
	}
	
	
	private String sendNotification(Integer tradeId) {
		System.out.println("come in notification");
		JmsQueueSender jmsQueueSender = new JmsQueueSender();
		jmsQueueSender.simpleSend(tradeId);
		return "dipesh";
		
		
	}

	

}

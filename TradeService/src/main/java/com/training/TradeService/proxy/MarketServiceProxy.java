/**
 * 
 */
package com.training.TradeService.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.TradeService.model.Trade;

/**
 * @author dipesh Garg
 *
 */
//@FeignClient(name = "Currency-Exchange-Service", url = "localhost:8762/CurrencyExchange")
@FeignClient(name = "MarketService")
@RibbonClient(name = "MarketService")
public interface MarketServiceProxy {

	@PostMapping(path = "/MarketService/save")
	public Trade add(@RequestBody final Trade trade);

	@GetMapping(path = "/MarketService/getTrade")
	public Trade get(@RequestParam final Integer tradeid);

	@GetMapping(path = "/MarketService/getAlltrades")
	public List<Trade> get();

}

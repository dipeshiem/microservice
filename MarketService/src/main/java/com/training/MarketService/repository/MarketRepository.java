/**
 * 
 */
package com.training.MarketService.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.function.Consumer;

import org.springframework.stereotype.Repository;

import com.training.MarketService.model.Trade;

/**
 * @author dipgarg
 *
 */

@Repository
public class MarketRepository {
	
	private Map<Integer,Trade> trades = new HashMap<Integer,Trade>();
	
	public List<Trade>  add(Trade trade) {
		List<Trade> l = new ArrayList<Trade>();
		Random random = new Random();
		int randomNumber = random.nextInt();
		trade.setTradeId(randomNumber);
		trades.put(randomNumber, trade);
		trades.entrySet().stream().forEach(new Consumer<Entry<Integer, Trade>> () {

			@Override
			public void accept(Entry<Integer, Trade> arg0) {
			 l.add(arg0.getValue());
				
			}			
			
		});
		return l;
	}
	
	public Trade gettrade(int tradeId) {
		return trades.get(tradeId);
	}
	
	public List<Trade>  getAll() {
		List<Trade> l = new ArrayList<Trade>();
		trades.entrySet().stream().forEach(new Consumer<Entry<Integer, Trade>> () {

			@Override
			public void accept(Entry<Integer, Trade> arg0) {
			 l.add(arg0.getValue());
				
			}			
			
		});
		return l;
	}
	

}

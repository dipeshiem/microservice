/**
 * 
 */
package com.example.Notification.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @author dipgarg
 *
 */
public class NotificationListener {
	
	@JmsListener(destination = "tradequeue")
	private void sendNotification(Integer tradeId) {
		System.out.println("come in notification"+tradeId);
	//	return "dipesh";
		
		
	}

}

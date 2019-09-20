/**ms
 * 
 */
package com.training.TradeService.jms;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author dipgarg
 *
 */
@Component
public class JmsQueueSender {

	@Autowired
	private Queue queue;

	@Autowired
	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void simpleSend(Integer tradeId) {
		System.out.println("come here");
		try {
			System.out.println(jmsTemplate);
			jmsTemplate.convertAndSend(queue, "dipesh");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

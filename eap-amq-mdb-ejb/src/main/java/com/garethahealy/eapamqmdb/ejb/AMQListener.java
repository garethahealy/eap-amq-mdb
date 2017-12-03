package com.garethahealy.eapamqmdb.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//import javax.jms.TextMessage;

//import org.jboss.ejb3.annotation.ResourceAdapter;

/**
 * Message-Driven Bean implementation class for: AMQListener
 */
//@MessageDriven(
//		activationConfig = { @ActivationConfigProperty(
//				propertyName = "destination", propertyValue = "HELLOWORLDMDBQueue"), @ActivationConfigProperty(
//				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
//		}, 
//		mappedName = "HELLOWORLDMDBQueue")
//@TransactionManagement(TransactionManagementType.BEAN)
//@ResourceAdapter(value="activemq-rar.rar")
public class AMQListener { //implements MessageListener {

    /**
     * Default constructor. 
     */
    public AMQListener() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    //public void onMessage(Message inMessage) {
    	//	TextMessage message = (TextMessage)inMessage;
    //    try {
    //        System.out.println(String.format("Got: %s", message.getText()));
    //    } catch (JMSException e) {
    //        e.printStackTrace();
    //    }
    //}

}

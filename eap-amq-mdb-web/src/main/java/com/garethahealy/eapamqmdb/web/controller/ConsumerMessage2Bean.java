package com.garethahealy.eapamqmdb.web.controller;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.jboss.ejb3.annotation.ResourceAdapter;

@MessageDriven(
        mappedName = "HELLOWORLDMDBQueue2",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "HELLOWORLDMDBQueue2"),
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
        })
@TransactionManagement(TransactionManagementType.BEAN)
@ResourceAdapter("activemq-rar")
@org.jboss.ejb3.annotation.Pool(value="mdb-strict-max-pool")
public class ConsumerMessage2Bean implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            String text = ((TextMessage)message).getText();

            System.out.println(text);
        } catch (JMSException e) {
            throw new EJBException("Error in JMS operation", e);
        }
    }
}  

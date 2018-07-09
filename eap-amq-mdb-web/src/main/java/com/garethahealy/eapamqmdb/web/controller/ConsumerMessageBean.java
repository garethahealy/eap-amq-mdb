/*-
 * #%L
 * GarethHealy :: EAP AMQ MDB :: Web
 * %%
 * Copyright (C) 2013 - 2018 Gareth Healy
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
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
        mappedName = "HELLOWORLDMDBQueue",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "HELLOWORLDMDBQueue"),
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "maxSessions", propertyValue = "20"),
                @ActivationConfigProperty(propertyName = "maxMessagesPerSessions", propertyValue = "20")
        })
@TransactionManagement(TransactionManagementType.BEAN)
@ResourceAdapter("activemq-rar")
@org.jboss.ejb3.annotation.Pool(value = "mdb-strict-max-pool")
public class ConsumerMessageBean implements MessageListener {

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

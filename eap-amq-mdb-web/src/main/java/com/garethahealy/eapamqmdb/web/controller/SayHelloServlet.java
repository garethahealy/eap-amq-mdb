package com.garethahealy.eapamqmdb.web.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hellotest")
public class SayHelloServlet extends HttpServlet {

    @Resource(mappedName = "java:/ConnectionFactoryRar")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "java:/queue/HELLOWORLDMDBQueue") // Note the mapped name of the queue
    private Destination queue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name") != null ? req.getParameter("name") : "michael";
        sendMessage(name);
        res.getWriter().println(String.format("check your console (%s)", name));
    }

    private void sendMessage(String name) {
        Connection connection = null;

        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer publisher = session.createProducer(queue);

            connection.start();

            TextMessage message = session.createTextMessage(name);
            publisher.send(message);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

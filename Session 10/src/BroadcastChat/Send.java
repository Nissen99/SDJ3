package BroadcastChat;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Scanner;

public class Send {


    private String QUEUE_NAME;
    private static final String EXCHANGE_NAME = "logs";


    public void writeMsg() throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            Scanner scanner = new Scanner(System.in);

            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

          //  System.out.println("What Q do you wanna write to?");
            //this.QUEUE_NAME = scanner.nextLine();

            //channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            System.out.println("WHAT YOU WRITE");
            String message = scanner.nextLine();
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
            //channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }

    }
}

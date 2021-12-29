package PersonToPersonChat;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Send {

    private String QUEUE_NAME;

    public void writeMsg() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Who do you wanna write?");
            QUEUE_NAME = scanner.nextLine();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            System.out.println("What do you wanna tell them?");
            String message = scanner.nextLine();

            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");
        }
    }


}
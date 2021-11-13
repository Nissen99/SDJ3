package BroadcastOrQ2QChat;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Recv {




    private String QUEUE_NAME;

    private static final String EXCHANGE_NAME = "logs";

    public void listenToBroadcastMsg() throws Exception {

        Channel channel = getChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

        String queueName = channel.queueDeclare().getQueue();

        channel.queueBind(queueName, EXCHANGE_NAME,"");
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");


        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'" + " in Q: " + QUEUE_NAME);
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    }

    public void listenToPersonalMsg() throws Exception {
        Channel channel = getChannel();

        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want your Q to be called?");
        QUEUE_NAME = scanner.nextLine();


        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }

    private Channel getChannel() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        return connection.createChannel();
    }
}

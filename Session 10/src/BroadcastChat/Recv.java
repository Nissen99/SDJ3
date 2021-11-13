package BroadcastChat;

import com.rabbitmq.client.*;

import java.util.Scanner;

public class Recv {




    private String QUEUE_NAME;

    private static final String EXCHANGE_NAME = "logs";

    public void listenToMsg() throws Exception {
        Scanner scanner = new Scanner(System.in);
       // System.out.println("What Q name you want?");
      //  QUEUE_NAME = scanner.nextLine();

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

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
}

package client;

import server.IRMIServer;
import shared.FootballScore;
import shared.Stock;
import shared.TransferObject;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class RMIClient implements ICallBackClient, IRMIClient {

    private String typePreference;
    private IRMIServer server;

    @Override
    public void startClient() {
        try {
            UnicastRemoteObject.exportObject(this, 0);

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            server = (IRMIServer) registry.lookup("Server");
            System.out.println("What type you want");
            Scanner scanner = new Scanner(System.in);
            typePreference = scanner.nextLine();
            server.addCallback(this, typePreference);
            System.out.println("Client Started....");

            while (true){
                System.out.println("What you wanna send?");
                String type = scanner.nextLine();

                switch (type){
                    case "FootballScore":
                        System.out.println("Who is home team");
                        String homeTeam = scanner.nextLine();
                        System.out.println("How many goals they got");
                        int homeGoals = scanner.nextInt();
                        scanner.nextLine(); //Consumes leftover empty line
                        System.out.println("Who is away?");
                        String awayTeam = scanner.nextLine();
                        System.out.println("How many goals they got?");
                        int awayGoals = scanner.nextInt();
                        scanner.nextLine(); //Consumes leftover empty line
                        server.publish(new TransferObject("FootballScore", new FootballScore(homeTeam, awayTeam, new int[]{homeGoals, awayGoals})));
                        break;
                    case "Stock":
                        System.out.println("What stock do you wanna update");
                        String stockSymbol = scanner.nextLine();
                        System.out.println("What is the y stock at");
                        int stockPrice = scanner.nextInt();
                        scanner.nextLine(); //Consumes leftover empty line
                        server.publish(new TransferObject("Stock", new Stock(stockSymbol, stockPrice)));
                        break;
                }


            }

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(TransferObject transferObject) throws RemoteException {

        if ("FootballScore".equals(typePreference)) {
            FootballScore footballScore = (FootballScore) transferObject.getContents();
            System.out.println(footballScore.toString());

        } else if ("Stock".equals(typePreference)) {
            Stock stock = (Stock) transferObject.getContents();
            System.out.println(stock.toString());

        } else if (transferObject.getContents() instanceof FootballScore) {
            FootballScore footballScore = (FootballScore) transferObject.getContents();
            System.out.println(footballScore.toString());

        } else {
            Stock stock = (Stock) transferObject.getContents();
            System.out.println(stock.toString());

        }
    }

}


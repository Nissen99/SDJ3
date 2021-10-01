import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {



    public void startClient() throws IOException {
        Socket socket = new Socket("127.0.0.1", 5000);

        PrintWriter out = new PrintWriter(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scanner = new Scanner(System.in);


            System.out.println("Make car!");
            System.out.println("What does it weigh?");
            int weightOfCar = scanner.nextInt();
            System.out.println("How Many doors?");
            int amountOfDoors = scanner.nextInt();
            System.out.println("What Model number is it?");
            scanner.nextLine();
            String modelNumber = scanner.nextLine();

            Car car = new Car(weightOfCar, amountOfDoors, modelNumber);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            out.println(gson.toJson(car));
            out.flush();
            System.out.println("Send car: " + gson.toJson(car));
            System.out.println("-------RESPONSE------");
            String response = "";


            response = in.readLine();
            System.out.println("READ LINE FROM C#");


            System.out.println(response);
            Car careResponse = gson.fromJson(response, Car.class);
            System.out.println(gson.toJson(careResponse));


    }
}

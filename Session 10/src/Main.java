public class Main {
    public static void main(String[] args) throws Exception {

        Recv recv = new Recv();
        Send send = new Send();

        recv.listenToMsg();
        while (true){
            send.writeMsg();
        }


    }
}

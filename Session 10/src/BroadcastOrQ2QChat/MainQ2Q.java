package BroadcastOrQ2QChat;

public class MainQ2Q {
    public static void main(String[] args) throws Exception {

        Recv recv = new Recv();
        Send send = new Send();

        recv.listenToBroadcastMsg();
        recv.listenToPersonalMsg();
        while (true){
            send.writeMsg();
        }


    }
}

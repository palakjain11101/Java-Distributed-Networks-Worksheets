import java.io.*;
import java.net.*;

class TCPReceiverThreaded {
    public static void main(String [] args) {
        try {
            ServerSocket ss = new ServerSocket(4322);
            for (;;) {
                try {
                    final Socket client = ss.accept();
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                            PrintWriter out = new PrintWriter(client.getOutputStream());
                            String line;
                            while ((line = in.readLine()) != null) {
                                System.out.println(line + " received" + " from  " + client.getInetAddress() + "   Port  " + client.getPort());
                                //send acknowledgement
                                out.println("ACKNOWLEDGEMENT FROM SERVER");
                                out.flush();
                                System.out.println("Acknowledgement sent to      " + client.getInetAddress() + "   Port  " + client.getPort() + '\n');
                            }
                            client.close();
                            } catch (Exception e) {}
                        }
                    }).start();
                } catch (Exception e) {
                    System.out.println("error " + e);
                }
            }
        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }
}
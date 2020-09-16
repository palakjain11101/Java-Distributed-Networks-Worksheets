import java.io.*;
import java.net.*;

class TCPSender {
    public static void main(String [] args) {
        try {
            Socket socket = new Socket("Andreeas-MacBook-Pro.local", 4322);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            for (int i = 0; i < 10; i++) {
                String line;
                out.println("TCP message " + i);
                out.flush();
                System.out.println("TCP message " + i + " sent");
                Thread.sleep(1000);
                //wait for acknowledgement
               // while ((line = in.readLine()) != null) {}
                line = in.readLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }
}
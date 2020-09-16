import java.io.*;
import java.net.*;

public class UDPSender {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("Andreeas-MacBook-Pro.local");
            DatagramSocket socket = new DatagramSocket(5002);
            for (int i = 0; i < 10; i++) {
                byte[] buf = String.valueOf(i).getBytes();
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4321);
                socket.send(packet);
                System.out.println("send DatagramPacket "
                        + new String(packet.getData()) + " " + packet.getAddress() + ":"
                        + packet.getPort());
                Thread.sleep(2000);
                //wait for acknowledgement
                byte[] ackBuf = new byte[256];
                socket.receive(new DatagramPacket(ackBuf, ackBuf.length));
                System.out.println("Acknowledgement received");
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
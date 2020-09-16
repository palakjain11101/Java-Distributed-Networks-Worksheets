import java.io.*;
import java.net.*;

class UDPReceiver {
    public static void main(String [] args) {
        try {
            InetAddress address = InetAddress.getByName("Andreeas-MacBook-Pro.local");
            DatagramSocket socket = new DatagramSocket(4321);
            byte[] buf = new byte[256];
            for (int i = 0; i < 20; i++) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                System.out.println("receive DatagramPacket "
                        + (new String(packet.getData())).trim() + " " + packet.getAddress() + ":"
                        + packet.getPort());
                //send acknowledgement
                byte[] ackBuf = "ack".getBytes();
                socket.send(new DatagramPacket(ackBuf, ackBuf.length, address, 5002));
                System.out.println("Acknowledgement sent");
            }
        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }
}
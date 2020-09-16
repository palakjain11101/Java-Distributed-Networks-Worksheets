import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSenderSlow {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("Andreeas-MacBook-Pro.local");
            DatagramSocket socket = new DatagramSocket();
            for (int i = 0; i < 10; i++) {
                byte[] buf = String.valueOf(i).getBytes();
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4321);
                socket.send(packet);
                System.out.println("send DatagramPacket "
                        + new String(packet.getData()) + " " + packet.getAddress() + ":"
                        + packet.getPort());
                Thread.sleep(4500);
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
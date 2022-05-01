package studio.thamessia;

import studio.thamessia.packets.PacketManager;
import studio.thamessia.packets.handshake.HandshakePacket;
import studio.thamessia.packets.login.LoginPacket;
import studio.thamessia.utils.buffers.BufferTypeException;
import studio.thamessia.utils.buffers.VarInt;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Program {
    public static InputStreamReader input = new InputStreamReader(System.in);
    public static BufferedReader bufferedReader = new BufferedReader(input);

    public static void start() throws IOException, BufferTypeException {
        System.out.println("BaryonFramework");

        while (true) {
            System.out.print("> ");
            String cmd = bufferedReader.readLine();

            if (cmd.equalsIgnoreCase("join")) {
                System.out.print("Type IP: ");
                String IP = bufferedReader.readLine();

                System.out.print("Type port: ");
                int port = Integer.parseInt(bufferedReader.readLine());

                System.out.print("Insert protocol version: ");
                VarInt protocolVersionManager = new VarInt(Integer.parseInt(bufferedReader.readLine()));

                Socket socket = new Socket();
                InetSocketAddress inetSocketAddress = new InetSocketAddress(IP, port);

                socket.connect(inetSocketAddress);
                VarInt nextState = new VarInt(2);

                HandshakePacket handshakePacket = new HandshakePacket(protocolVersionManager, IP, port, nextState);
                PacketManager.sendPacket(socket, handshakePacket);

                LoginPacket loginPacket = new LoginPacket("BaryonBot");
                PacketManager.sendPacket(socket, loginPacket);

                System.out.println("Packet sent!");
                while (true);
            }
        }
    }
}

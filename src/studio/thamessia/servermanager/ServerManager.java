/*package studio.thamessia.servermanager;

import studio.thamessia.packets.PacketManager;
import studio.thamessia.packets.handshake.ServerHandshake;
import studio.thamessia.utils.buffers.BufferTypeException;
import studio.thamessia.utils.buffers.VarInt;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerManager {
    public static void startServer() throws BufferTypeException, IOException {
        ServerSocket serverSocket = new ServerSocket(25565);
        Socket socket = serverSocket.accept();

        InetSocketAddress inetSocketAddress = new InetSocketAddress(serverSocket.getInetAddress(), serverSocket.getLocalPort());

        socket

        ServerHandshake serverHandshake = new ServerHandshake(new VarInt(47), "127.0.0.1",
                25565, new VarInt(1));
        PacketManager.readPacketBuffer()
    }
}*/

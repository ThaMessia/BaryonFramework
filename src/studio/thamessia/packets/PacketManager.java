package studio.thamessia.packets;

import studio.thamessia.utils.buffers.BufferTypeException;
import studio.thamessia.utils.buffers.PacketBuffer;
import studio.thamessia.utils.buffers.VarInt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PacketManager {
    public static PacketBuffer readPacketBuffer(Socket connection) throws IOException, BufferTypeException {
        DataInputStream dataInputStream = new DataInputStream(connection.getInputStream());
        VarInt length = new VarInt(dataInputStream.readNBytes(5));

        return new PacketBuffer(dataInputStream.readNBytes(length.toInteger()));
    }

    public static void sendPacket(Socket connection, Packet packet) throws IOException, BufferTypeException {
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        PacketBuffer packetBuffer = new PacketBuffer();

        packet.writeData(packetBuffer);
        VarInt length = new VarInt(packetBuffer.getBufferBytes().length);

        dataOutputStream.write(length.buffer.getBufferBytes());
        dataOutputStream.write(packetBuffer.getBufferBytes());
    }
}

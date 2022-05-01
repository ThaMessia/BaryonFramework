package studio.thamessia.packets.handshake;

import studio.thamessia.packets.Packet;
import studio.thamessia.utils.buffers.BufferTypeException;
import studio.thamessia.utils.buffers.PacketBuffer;
import studio.thamessia.utils.buffers.VarInt;

public class ServerHandshake implements Packet {
    private VarInt protocolVersion;
    private String host;
    private int port;
    private VarInt nextState;

    public ServerHandshake(VarInt protocolVersion, String host, int port, VarInt nextState) {
        this.protocolVersion = protocolVersion;
        this.host = host;
        this.port = port;
        this.nextState = nextState;
    }

    @Override
    public void writeData(PacketBuffer buffer) throws BufferTypeException {

    }

    @Override
    public void readData(PacketBuffer buffer) throws BufferTypeException {
        buffer.readVarIntFromBuffer();
        protocolVersion = buffer.readVarIntFromBuffer();
        host = buffer.readUTF8String();
        port = buffer.readUnsignedShort();
        nextState = buffer.readVarIntFromBuffer();
    }
}

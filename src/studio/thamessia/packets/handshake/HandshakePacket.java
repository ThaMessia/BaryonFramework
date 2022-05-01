package studio.thamessia.packets.handshake;

import studio.thamessia.utils.buffers.BufferTypeException;
import studio.thamessia.utils.buffers.PacketBuffer;
import studio.thamessia.utils.buffers.VarInt;
import studio.thamessia.packets.Packet;

public class HandshakePacket implements Packet {
    private VarInt protocolVersion;
    private String host;
    private int port;
    private VarInt nextState;

    public HandshakePacket(VarInt protocolVersion, String host, int port, VarInt nextState) {
        this.protocolVersion = protocolVersion;
        this.host = host;
        this.port = port;
        this.nextState = nextState;
    }

    public HandshakePacket() {

    }

    @Override
    public void writeData(PacketBuffer buffer) throws BufferTypeException {
        buffer.writeVarIntToBuffer(new VarInt(0x00));
        buffer.writeVarIntToBuffer(protocolVersion);
        buffer.writeUTFString(host);
        buffer.writeUnsignedShort(port);
        buffer.writeVarIntToBuffer(nextState);
    }

    @Override
    public void readData(PacketBuffer buffer) throws BufferTypeException {
        /*buffer.readVarIntFromBuffer();
        protocolVersion = buffer.readInt();
        host = buffer.readUTF8String();
        port = buffer.readUnsignedShort();
        nextState = buffer.readInt();*/
    }
}

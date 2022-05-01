package studio.thamessia.packets.login;

import studio.thamessia.packets.Packet;
import studio.thamessia.utils.buffers.BufferTypeException;
import studio.thamessia.utils.buffers.PacketBuffer;
import studio.thamessia.utils.buffers.VarInt;

public class LoginPacket implements Packet {
    public String username;

    public LoginPacket(String username) {
        this.username = username;
    }

    @Override
    public void writeData(PacketBuffer buffer) throws BufferTypeException {
        buffer.writeVarIntToBuffer(new VarInt(0x00));
        buffer.writeUTFString(username);
    }

    @Override
    public void readData(PacketBuffer buffer) throws BufferTypeException {

    }
}

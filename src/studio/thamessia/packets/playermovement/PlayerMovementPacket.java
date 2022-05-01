package studio.thamessia.packets.playermovement;

import studio.thamessia.packets.Packet;
import studio.thamessia.utils.buffers.BufferTypeException;
import studio.thamessia.utils.buffers.PacketBuffer;
import studio.thamessia.utils.buffers.VarInt;

public class PlayerMovementPacket implements Packet {
    private boolean onGround;

    public PlayerMovementPacket(boolean onGround) {
        this.onGround = onGround;
    }

    @Override
    public void writeData(PacketBuffer buffer) throws BufferTypeException {
        buffer.writeVarIntToBuffer(new VarInt(0x03));
    }

    @Override
    public void readData(PacketBuffer buffer) throws BufferTypeException {

    }
}

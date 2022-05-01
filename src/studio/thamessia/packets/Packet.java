package studio.thamessia.packets;

import studio.thamessia.utils.buffers.BufferTypeException;
import studio.thamessia.utils.buffers.PacketBuffer;

public interface Packet {
    void writeData(PacketBuffer buffer) throws BufferTypeException;
    void readData(PacketBuffer buffer) throws BufferTypeException;
}

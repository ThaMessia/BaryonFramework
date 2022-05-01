package studio.thamessia.utils.buffers;

public class VarInt {
    public final PacketBuffer buffer = new PacketBuffer();

    public VarInt(int number) throws BufferTypeException {
        while ((number & -128) != 0) {
            buffer.writeByte((byte) (number & 127 | 128));
            number >>>= 7;
        }
        buffer.writeByte((byte) number);
    }

    public VarInt(byte[] bytes) throws BufferTypeException {
        buffer.writeBytes(bytes);
    }

    public int toInteger() {
        byte[] copiedBytes = this.buffer.getBufferBytes();
        int index = 0;

        int value = 0, length = 0;
        byte current;

        do {
            current = copiedBytes[index++];
            value |= (current & 127) << length++ * 7;

            if (length > 5) {
                throw new RuntimeException("VarInt too big");
            }
        }
        while ((current & 128) == 128);

        return value;
    }
}

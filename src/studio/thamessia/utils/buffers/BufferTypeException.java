package studio.thamessia.utils.buffers;

public class BufferTypeException extends Exception {

    public BufferTypeException(BufferType type) {
        super(type == BufferType.READ ? "Cannot execute a write function in a read buffer!" :
                "Cannot execute a read function in a write buffer!");
    }
}
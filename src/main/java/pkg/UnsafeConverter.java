package pkg;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public final class UnsafeConverter implements FloatToIntBitsConverter {
    private final Unsafe unsafe = getUnsafe();

    @Override
    public int convert(float value) {
        long address = unsafe.allocateMemory(Float.BYTES); // Float.BYTES == Integer.BYTES
        unsafe.putFloat(address, value);
        return unsafe.getInt(address);
    }

    private static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}

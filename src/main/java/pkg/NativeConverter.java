package pkg;

public final class NativeConverter implements FloatToIntBitsConverter {
    static {
        System.loadLibrary("converter");
    }

    @Override
    public native int convert(float value);
}

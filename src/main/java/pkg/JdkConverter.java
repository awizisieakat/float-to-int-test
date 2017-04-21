package pkg;

public final class JdkConverter implements FloatToIntBitsConverter {
    @Override
    public int convert(float value) {
        return Float.floatToRawIntBits(value);
    }
}

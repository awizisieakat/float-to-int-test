package pkg;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public final class Test {
    private final int numberOfTests;
    private final Random random;
    private final List<FloatToIntBitsConverter> converters;

    public Test(int numberOfTests) {
        this.numberOfTests = numberOfTests;
        random = new Random();
        converters = Arrays.asList(
                new JdkConverter(),
                new UnsafeConverter(),
                new NativeConverter());
    }

    public Map<FloatToIntBitsConverter, Long> test() {
        return converters.stream()
                .collect(Collectors.toMap(c -> c, this::test));

    }

    private long test(FloatToIntBitsConverter converter) {
        float value = random.nextFloat();
        Instant start = Instant.now();
        for (int i = 0; i < numberOfTests; i++) {
            converter.convert(value);
        }
        Instant end = Instant.now();
        return Duration.between(start, end).toMillis();
    }
}

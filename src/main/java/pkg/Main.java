package pkg;

import java.util.Map;

public final class Main {
    public static void main(String[] args) {
        Test test = new Test(1_000_000);
        Map<FloatToIntBitsConverter, Long> results = test.test();
        results.forEach((k, v) -> System.out.println(k.getClass().getName() + ": " + v + " ms"));
    }
}

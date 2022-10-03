import java.util.concurrent.atomic.AtomicInteger;

public class Utils {
    static void activateCounter(String text, AtomicInteger length3Counter, AtomicInteger length4Counter, AtomicInteger length5Counter) {
        switch (text.length()) {
            case 3: length3Counter.getAndIncrement();
                break;
            case 4: length4Counter.getAndIncrement();
                break;
            case 5: length5Counter.getAndIncrement();
        }
    }
}

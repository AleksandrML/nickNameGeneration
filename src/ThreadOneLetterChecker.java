import java.util.concurrent.atomic.AtomicInteger;

class ThreadOneLetterChecker extends Thread {
    AtomicInteger length3Counter;
    AtomicInteger length4Counter;
    AtomicInteger length5Counter;
    String[] texts;

    public ThreadOneLetterChecker(AtomicInteger length3Counter, AtomicInteger length4Counter, AtomicInteger length5Counter,
                                  String[] texts) {
        this.length3Counter = length3Counter;
        this.length4Counter = length4Counter;
        this.length5Counter = length5Counter;
        this.texts = texts;
    }

    @Override
    public void run() {
        for (String text : texts) {
            if (text.chars().allMatch(c -> c == text.charAt(0))) {
                Utils.activateCounter(text, length3Counter, length4Counter, length5Counter);
            }
        }
    }
}

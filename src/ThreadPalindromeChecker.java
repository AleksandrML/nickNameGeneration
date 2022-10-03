import java.util.concurrent.atomic.AtomicInteger;

class ThreadPalindromeChecker extends Thread {
    AtomicInteger length3Counter;
    AtomicInteger length4Counter;
    AtomicInteger length5Counter;
    String[] texts;

    public ThreadPalindromeChecker(AtomicInteger length3Counter, AtomicInteger length4Counter, AtomicInteger length5Counter,
                                   String[] texts) {
        this.length3Counter = length3Counter;
        this.length4Counter = length4Counter;
        this.length5Counter = length5Counter;
        this.texts = texts;
    }

    @Override
    public void run() {
        for (String text : texts) {
            int n = text.length();
            boolean notPalindromeDetected = false;
            for (int i = 0; i < (n/2); ++i) {
                if (text.charAt(i) != text.charAt(n - i - 1)) {
                    notPalindromeDetected = true;
                }
            }
            if (!notPalindromeDetected) {
                Utils.activateCounter(text, length3Counter, length4Counter, length5Counter);
            }
        }
    }
}

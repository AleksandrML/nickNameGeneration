import java.util.concurrent.atomic.AtomicInteger;

class ThreadOrderLettersChecker extends Thread {
    AtomicInteger length3Counter;
    AtomicInteger length4Counter;
    AtomicInteger length5Counter;
    String[] texts;

    public ThreadOrderLettersChecker(AtomicInteger length3Counter, AtomicInteger length4Counter, AtomicInteger length5Counter,
                                     String[] texts) {
        this.length3Counter = length3Counter;
        this.length4Counter = length4Counter;
        this.length5Counter = length5Counter;
        this.texts = texts;
    }

    @Override
    public void run() {
        for (String text : texts) {
            char[] arrayText = text.toCharArray();
            char previousChar = arrayText[0];
            boolean orderIsBroken = false;
            for (int i = 1; i < arrayText.length; i++) {
                if (arrayText[i] < previousChar)
                    orderIsBroken = true;
            }
            if (!orderIsBroken) {
                Utils.activateCounter(text, length3Counter, length4Counter, length5Counter);
            }
        }
    }

}

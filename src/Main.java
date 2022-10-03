import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }


        AtomicInteger length3Counter = new AtomicInteger(0);
        AtomicInteger length4Counter = new AtomicInteger(0);
        AtomicInteger length5Counter = new AtomicInteger(0);

        Thread thread1 = new ThreadOneLetterChecker(length3Counter, length4Counter, length5Counter, texts);
        Thread thread2 = new ThreadOrderLettersChecker(length3Counter, length4Counter, length5Counter, texts);
        Thread thread3 = new ThreadPalindromeChecker(length3Counter, length4Counter, length5Counter, texts);

        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("Красивых слов с длиной 3: " + length3Counter + " шт.");
        System.out.println("Красивых слов с длиной 4: " + length4Counter + " шт.");
        System.out.println("Красивых слов с длиной 5: " + length5Counter + " шт.");
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

}
package nextstep.fp;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Lambda {

    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");

        numbers.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        numbers.forEach(new Consumer<Integer>() {
            public void accept(Integer value) {
                System.out.println(value);
            }
        });
    }

    public static void runThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread");
            }
        }).start();
    }

    public static int sumAll(List<Integer> numbers) {
        return sumAll(numbers, (x) -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumAll(numbers, (x) -> x % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumAll(numbers, (x) -> x > 3);
    }

    public static int sumAll(List<Integer> numbers, SumCondition condition) {
        int total = 0;
        for (Integer number : numbers) {
            if (condition.sumStrategy(number)) {
                total += number;
            }
        }
        return total;
    }
}

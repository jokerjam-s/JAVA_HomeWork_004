/**
 * Пусть дан LinkedList с несколькими элементами.
 * Реализуйте метод, который вернет “перевернутый” список.
 *
 * Для переворота использеум LinkedList заполненный целочисленными значениями,
 * сгенерированными случайно. Количество генерерируемых значений спросим у пользователя.
 */

import java.util.*;
import java.util.logging.Logger;


public class Main {
    private static final int MAX_LIMIT_GENERATION = 100;

    public static void main(String[] args) {
        Random random = new Random();
        int countElement = inputIntConsole("Кол-во элементов в списке: ");
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < countElement; i++) {
            linkedList.add(random.nextInt(MAX_LIMIT_GENERATION));
        }

        Logger logger = Logger.getAnonymousLogger();
        // Вывод начального списка
        logger.info("Исходный:\t\t" + linkedList.toString());
        logger.info("Перевернутый:\t" + listReverse(linkedList).toString());
    }


    // запрос кол-ва элементов
    public static int inputIntConsole(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextInt();
    }

    // переворот списвка
    public static LinkedList<Integer> listReverse(List<Integer> list){
        LinkedList<Integer> reverseList = new LinkedList<Integer>(list);
        Collections.reverse(reverseList);

        return reverseList;
    }

}
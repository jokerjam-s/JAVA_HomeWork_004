/**
 * Пусть дан LinkedList с несколькими элементами.
 * Реализуйте метод, который вернет “перевернутый” список.
 *
 * Для переворота использеум LinkedList заполненный целочисленными значениями,
 * сгенерированными случайно
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        
    }


    public static List<Integer> listReverse(List<Integer> list){
        List<Integer> reverseList = new LinkedList<Integer>(list);
        Collections.reverse(reverseList);

        return reverseList;
    }

}
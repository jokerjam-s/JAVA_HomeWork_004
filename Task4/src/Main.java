/*
    Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.

    Пример:
    x ^ y / (5 * z) + 10  =>  x y ^ 5 z * / 10 +


    АЛГОРИТМ:
    Перебираем выражение слева на право.

    Если входящий элемент число, то добавляем его в очередь (QUEUE).
    Если входящий элемент оператор (+, -, *, /) то проверяем:

        Если стек пуст или содержит левую скобку в вершине, то добавляем входящий оператор в стек.
        Если входящий оператор имеет более высокий приоритет чем вершина, поместимего в стек.
        Если входящий оператор имеет более низкий или равный приоритет, чем вершине,
            выгружаем POP в очередь (QUEUE), пока не увидите оператор с меньшим приоритетом или левую скобку
            на вершине, затем добавьте (PUSH) входящий оператор в стек.

    Если входящий элемент является левой скобкой, поместите (PUSH) его в стек.
    Если входящий элемент является правой скобкой, выгружаем стек (POP) и добавляем его элементы
        в очередь (QUEUE), пока не увидите левую круглую скобку. Удалите найденную скобку из стека.
    В конце выражения выгрузить стек в очередь
 */

import java.util.*;
import java.util.logging.Logger;

public class Main {
    // операции и приоритеты
    private static final Map<String, Integer> prioritySign = new HashMap<>() {{
        put("^", 10);
        put("*", 9);
        put("/", 9);
        put("+", 8);
        put("-", 8);
    }};

    public static void main(String[] args) {
        // Массив инфиксных записей
        String[] infix = new String[]{
                "x ^ y / ( 5 * z ) + 10",
                "59 * 2 + 12 / 4",
                "48 - 28 * ( 12 - 10 ) + 5",
                "a + 24 * b - 9 / c",
                "d * 5 + e ^ 2"};

        Logger logger = Logger.getAnonymousLogger();

        for (String s : infix) {
            logger.info(s + " => " + infixToPostfix(s));
        }
    }

    // перевод выражения
    public static String infixToPostfix(String infixString) {
        String[] elements = infixString.split("\\s*(\\s)");
        Stack<String> stack = new Stack<>();
        LinkedList<String> queue = new LinkedList<>();

        for (String c : elements) {
            if (!prioritySign.containsKey(c) && !c.equals("(") && !c.equals(")")) {
                queue.addLast(c);
            } else if (prioritySign.containsKey(c)) {
                if (stack.empty()) {
                    stack.push(c);
                } else if (stack.peek().equals("(")) {
                    stack.push(c);
                } else if (prioritySign.get(c) > prioritySign.get(stack.peek())) {
                    stack.push(c);
                } else {
                    queue.addLast(stack.pop());
                    boolean checkStack = !stack.empty();
                    while (checkStack) {
                        if (prioritySign.get(stack.peek()).equals("(")
                                || prioritySign.get(stack.peek()) < prioritySign.get(c)) {
                            checkStack = false;
                        } else {
                            queue.addLast(stack.pop());
                            checkStack = !stack.empty();
                        }
                    }
                    stack.push(c);
                }
            } else if (c.equals("(")) {
                stack.push(c);
            } else if (c.equals(")")) {
                while (!stack.peek().equals("(")) {
                    queue.addLast(stack.pop());
                }
                stack.pop();
            }
        }

        while (!stack.empty()) {
            queue.addLast(stack.pop());
        }

        return String.join(" ", queue.toArray(new String[queue.size()]));
    }
}
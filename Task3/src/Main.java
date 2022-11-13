/*
  В калькулятор добавьте возможность отменить последнюю операцию

    Калькулятор из Задания 2, Задача 4.
    К калькулятору из предыдущего дз добавить логирование.

    На вход поолучаем строку с простыой операцией,
    между цифровыми значениями и знаком операции должен быть пробел.
    Считаем введенные данные валидными, проверку верности данных и
    математическое соответствие не проводим

  для управлениея используем:
    end - завершение работы
    del - удалить последнюю операцию
 */

import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        Stack<String> historyCalc = new Stack<>();
        boolean calcContinue = true;

        while (calcContinue) {
            String calcStr = readStrConsole("Операция: ");

            if (calcStr.equals("end")) {
                calcContinue = false;
            } else if (calcStr.equals("del")) {
                historyCalc.pop();
                logger.info(historyCalc.toString());
            } else {
                historyCalc.push(calculate(calcStr));
                logger.info(historyCalc.toString());
            }
        }
    }

    // получение строкового значения с консоли
    public static String readStrConsole(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }


    // расчет строкового выражения
    public static String calculate(String operation) {
        String[] calc = operation.split("\\s*(\\s)");

        float op1 = Float.parseFloat(calc[0]);
        float op2 = Float.parseFloat(calc[2]);
        float result = 0;

        switch (calc[1]) {
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case "*":
                result = op1 * op2;
                break;
            case "/":
                result = op1 / op2;
                break;
        }

        return operation + " = " + result;
    }
}
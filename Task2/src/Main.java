import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Реализуйте очередь с помощью LinkedList со следующими методами:
 *    enqueue() - помещает элемент в конец очереди,
 *    dequeue() - возвращает первый элемент из очереди и удаляет его,
 *    first() - возвращает первый элемент из очереди, не удаляя.
 *
 *    Список заполним произвольными строковыми значениями.
 *    Продемонстрируем работу методов обработки очереди.
 *    Если в очереди нет элементов, методы возврата значений ввернут "очердь пуста"
 */

public class Main {
  // список для организации очереди
  private static LinkedList<String> queue = new LinkedList<>();


  public static void main(String[] args) {
    Logger logger = Logger.getAnonymousLogger();

    logger.info("извлечь: " + dequeue(queue));

    // Заполнение списка
    enqueue(queue, "первый");
    enqueue(queue, "второй");
    enqueue(queue, "третий");

    logger.info("очередь: " + queue.toString());
    logger.info("извлечь: " + dequeue(queue));
    logger.info("очередь: " + queue.toString());
    logger.info("первый : " + first(queue));
    logger.info("очередь: " + queue.toString());
    logger.info("извлечь: " + dequeue(queue));
    logger.info("очередь: " + queue.toString());
  }

  // Добавлениеи элемента в очередь
  public static LinkedList<String> enqueue(LinkedList<String> list,  String value){
    list.addLast(value);
    return list;
  }

  // извлечение элемента из очереди,
  // если очередь пуста - возвращает null
  public static String dequeue(LinkedList<String> list){
    if(list.size() == 0){
      return "очердь пуста";
    }

    return list.removeFirst();
  }

  // отображение первого эдемента,
  // если список пуст - вернуть null
  public static String first(LinkedList<String> list){
    if(list.size() == 0){
      return "очердь пуста";
    }

    return list.getFirst();
  }

}
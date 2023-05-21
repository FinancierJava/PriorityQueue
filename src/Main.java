public class Main {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(); //Создание экземпляра класса PriorityQueue

        // Проверка, является ли очередь пустой
        boolean isEmpty = priorityQueue.isEmpty();
        System.out.println("Is queue empty? " + isEmpty);

        //Добавление элементов в очередь с приоритетом:
        priorityQueue.enqueue(3);
        priorityQueue.enqueue(8);
        priorityQueue.enqueue(2);

        // Проверка, является ли очередь пустой после добавления элементов
        boolean isEmpty1 = priorityQueue.isEmpty();
        System.out.println("Is queue empty? " + isEmpty1);

        //Извлечение элементов из очереди с приоритетом:
        while (!priorityQueue.isEmpty()) {
            int value = priorityQueue.dequeue();
            System.out.println("Dequeued: " + value);
        }

        // Попытка извлечь элемент из пустой очереди
        try {
            int value = priorityQueue.dequeue();
            System.out.println("Dequeued: " + value);
        } catch (IllegalStateException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

    }
}

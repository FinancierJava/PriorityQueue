
import java.util.ArrayList;
import java.util.List;
public class PriorityQueue {
    private List<Integer> elements;

    public PriorityQueue() {
        elements = new ArrayList<>();
    }

    public void enqueue(int value) {
        elements.add(value);
        int index = elements.size() - 1;

        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (elements.get(index) <= elements.get(parentIndex)) {
                break;
            }

            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        // Извлечение корневого элемента (с наивысшим приоритетом)
        int root = elements.get(0);
        int lastIndex = elements.size() - 1;
        elements.set(0, elements.get(lastIndex));
        elements.remove(lastIndex);

        int index = 0;
        while (true) {
            // Определение индексов левого и правого дочерних элементов
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            // Проверка, если левого дочернего элемента не существует, то прерываем цикл
            if (leftChildIndex >= elements.size()) {
                break;
            }

            int largestChildIndex = leftChildIndex;
            if (rightChildIndex < elements.size() && elements.get(rightChildIndex) > elements.get(leftChildIndex)) {
                largestChildIndex = rightChildIndex;
            }

            // Проверка, если текущий элемент имеет больший или равный приоритет, то прерываем цикл
            if (elements.get(index) >= elements.get(largestChildIndex)) {
                break;
            }

            // Обмен местами текущего элемента с дочерним элементом с наибольшим приоритетом
            swap(index, largestChildIndex);
            index = largestChildIndex;
        }

        return root;
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    private void swap(int i, int j) {
        int temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}

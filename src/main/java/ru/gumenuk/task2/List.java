package ru.gumenuk.task2;

public interface List<T> {


    /**
     * Метод добавления элемента в список
     * @param elem элемент типа T
     */
    void add(T elem);

    /**
     * Метод получения элемента по индексу
     * @param index индекс элемента
     * @return элемент, расположенный по указанному индексу
     * @throws IndexOutOfBoundsException если index < 0 или index >= size()
     */
    T get(int index);

    /**
     * Метод получения размера списка
     * @return количество элементов в списке
     */
    int size();

    /**
     * Метод удаления указанного элемента из списка
     * @param elem элемент, который необходимо удалить из списка
     * @return true, если элемент удаляемый был в списке
     */
    boolean remove(T elem);

    /**
     * Метод удаления элемента из списка по индексу
     * @param index индекс элемента, который необходимо удалить
     * @throws IndexOutOfBoundsException если index < 0 или index >= size()
     */
    void remove(int index);

    /**
     * Метод для проверки наличия элемента в списке
     * @param elem элемент, наличие которого нужно проверить
     * @return true, если элемент присутствует в списке, иначе false
     */
    boolean contains(T elem);

    /**
     * Метод для проверки списка на наличие элементов
     * @return true, если список пуст, иначе false
     */
    boolean isEmpty();

    /**
     * Метод для удаления всех элементов из списка
     */
    void clear();

    /**
     * Метод для получения индекса указанного элемента
     * @param elem элемент, индекс которого необходимо получить
     * @return индекс указанного элемента, или -1, если элемент не найден в списке
     */
    int indexOf(T elem);
}

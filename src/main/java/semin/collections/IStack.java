package semin.collections;

/**
 * Created by Vladkuz on 09.10.2017.
 */
/**
 * LIFO — Last In First Out
 */
public interface IStack<Item> extends Iterable<Item> {

    void push(Item item);

    Item pop();

    //Item peek();

    boolean isEmpty();

    int size();
}

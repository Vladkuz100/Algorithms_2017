package semin.iterator;

import java.util.Iterator;

/**
 * Итератор возвращающий последовательность из двух возрастающих итераторов в порядке возрастания
 * first = 1,3,4,5,7
 * second = 0,2,4,6,8
 * result = 0,1,2,3,4,4,5,6,7,8
 *
 * Time = O(k),
 *  k — суммарное количество элементов
 */
public class MergingIncreasingIterator implements Iterator<Integer> {

    private IncreasingIterator first;
    private IncreasingIterator second;

    private boolean hasOldFirst;
    private boolean hasOldSecond;
    private int oldFirst;
    private int oldSecond;

    public MergingIncreasingIterator(IncreasingIterator first, IncreasingIterator second) {
        this.first = first;
        this.second = second;

        // прочитать одно значение
        if (first.hasNext()) {
            oldFirst = first.next();
            hasOldFirst = true;
        } else if(second.hasNext()){
            oldSecond = second.next();
            hasOldSecond = true;
        }
    }

    @Override
    public boolean hasNext() {
        return hasOldFirst || hasOldSecond || first.hasNext() || second.hasNext();
    }

    @Override
    public Integer next() {

        if (hasOldFirst) {
            if (second.hasNext()) {
                hasOldSecond = true;
                oldSecond = second.next();
                if (oldSecond < oldFirst) {
                    hasOldSecond = false;
                    return oldSecond;
                } else {
                    hasOldFirst = false;
                    return oldFirst;
                }
            } else {
                hasOldFirst = false;
                return oldFirst;
            }
        }

        else { // hasOldSecond
            if (first.hasNext()) {
                hasOldFirst = true;
                oldFirst = first.next();
                if (oldFirst < oldSecond) {
                    hasOldFirst = false;
                    return oldFirst;
                } else {
                    hasOldSecond = false;
                    return oldSecond;
                }
            } else {
                hasOldSecond = false;
                return oldSecond;
            }
        }
    }
}


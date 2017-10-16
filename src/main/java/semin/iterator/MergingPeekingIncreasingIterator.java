package semin.iterator;

import java.util.Iterator;

import semin.collections.ArrayPriorityQueue;
import semin.collections.IPriorityQueue;

/**
 * Итератор возвращающий последовательность из N возрастающих итераторов в порядке возрастания
 * first = 1,3,4,5,7
 * second = 0,2,4,6,8
 * result = 0,1,2,3,4,4,5,6,7,8
 *
 * Time = O(n + k * log n),
 *  n — количество итераторов
 *  k — суммарное количество элементов
 */
public class MergingPeekingIncreasingIterator implements Iterator<Integer> {
    private final IPriorityQueue<IPeekingComparableIterator<Integer>> heap;

    @SafeVarargs
    public MergingPeekingIncreasingIterator(IPeekingComparableIterator<Integer> ... peekingIterators) {
        heap = new ArrayPriorityQueue<>(peekingIterators);
    }

    @Override
    public boolean hasNext() {
        return !heap.isEmpty();
    }

    @Override
    public Integer next() {
        final IPeekingComparableIterator<Integer> min = heap.extractMin();
        final Integer nextValue = min.next();
        if (min.hasNext()) {
            heap.add(min);
        }
        return nextValue;
    }
}


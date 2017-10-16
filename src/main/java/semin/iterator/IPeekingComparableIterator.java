package semin.iterator;

public interface IPeekingComparableIterator<E> extends IPeekingIterator<E>,
        Comparable<IPeekingComparableIterator<E>> {
}

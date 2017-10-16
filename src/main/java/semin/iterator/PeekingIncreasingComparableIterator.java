package semin.iterator;

import java.util.Random;

public class PeekingIncreasingComparableIterator extends IncreasingIterator implements IPeekingComparableIterator<Integer> {

    private boolean hasPeeked;
    private Integer peekedElement;

    public PeekingIncreasingComparableIterator(int start, int maxGrowth, int stepLimit) {
        super(start, maxGrowth, stepLimit);
    }

    public PeekingIncreasingComparableIterator(int start, int maxGrowth, int stepLimit, Random random) {
        super(start, maxGrowth, stepLimit, random);
    }

    @Override
    public boolean hasNext() {
        return hasPeeked || super.hasNext();
    }

    @Override
    public Integer next() {
        if (!hasPeeked) {
            return super.next();
        }
        Integer result = peekedElement;
        hasPeeked = false;
        peekedElement = null; //for GC
        return result;
    }

    @Override
    public Integer peek() {
        if (!hasPeeked) {
            peekedElement = super.next();
            hasPeeked = true;
        }
        return peekedElement;
    }

    @Override
    public int compareTo(IPeekingComparableIterator<Integer> o) {
        return peek().compareTo(o.peek());
    }
}

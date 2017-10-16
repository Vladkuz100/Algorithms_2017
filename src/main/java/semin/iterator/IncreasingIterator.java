package semin.iterator;

import java.util.Iterator;
import java.util.Random;

/**
 * Итератор возвращающий возрастающую последовательность
 */
public class IncreasingIterator implements Iterator<Integer> {

    protected int curr;
    protected int step;
    protected final Random random;
    protected final int maxGrowth;
    protected final int valueLimit;
    protected final int stepLimit;

    public IncreasingIterator(int start, int maxGrowth, int stepLimit) {
        this(start, maxGrowth, stepLimit, new Random());
    }

    public IncreasingIterator(int start, int maxGrowth, int stepLimit, Random random) {
        this.curr = start;
        this.maxGrowth = maxGrowth + 1; //because in random.nextInt(upperBound) — upperBound is exclusive
        this.valueLimit = Integer.MAX_VALUE - maxGrowth;
        this.stepLimit = stepLimit == 0 ? Integer.MAX_VALUE : stepLimit;
        this.random = random;
    }

    @Override
    public boolean hasNext() {
        return curr < valueLimit && step < stepLimit;
    }

    @Override
    public Integer next() {
        int prev = curr;
        curr += random.nextInt(maxGrowth);
        step++;
        return prev;
    }
}

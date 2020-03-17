package App;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    private Integer curr = null;
    Iterator<Integer> itr;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        itr = iterator;
        if(itr.hasNext()){
            curr = itr.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return curr;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = curr;
        curr = itr.hasNext() ? itr.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return curr != null;
    }
}

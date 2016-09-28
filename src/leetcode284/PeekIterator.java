package leetcode284;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> itr;
	boolean peeked;
	int peekVal;

	public PeekingIterator(Iterator<Integer> iterator) {
		this.itr = iterator;
	}

	public Integer peek() {
		if (peeked) {
			return peekVal;
		} else {
			peeked = true;
			peekVal = itr.next();
		}
		return peekVal;
	}

	@Override
	public Integer next() {
		if (peeked) {
			peeked = false;
			return peekVal;
		} else
			return itr.next();
	}

	@Override
	public boolean hasNext() {
		return peeked || itr.hasNext();
	}
}

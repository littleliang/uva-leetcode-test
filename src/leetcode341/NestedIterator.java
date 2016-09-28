package leetcode341;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

interface NestedInteger {
	public boolean isInteger();

	public Integer getInteger();

	public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

	private Stack<Cursor> stack = new Stack<>();

	public NestedIterator(List<NestedInteger> nestedList) {
		if (nestedList != null)
			stack.push(new Cursor(nestedList));
	}

	@Override
	public Integer next() {
		while (!stack.isEmpty()) {
			Cursor cursor = stack.peek();
			if (cursor.i < cursor.list.size()) {
				NestedInteger nested = cursor.list.get(cursor.i++);
				if (nested.isInteger())
					return nested.getInteger();
				stack.push(new Cursor(nested.getList()));
			} else {
				stack.pop();
			}
		}
		return null;
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			Cursor cursor = stack.peek();
			if (cursor.i < cursor.list.size()) {
				NestedInteger nested = cursor.list.get(cursor.i);
				if (nested.isInteger())
					return true;
				cursor.i++;
				stack.push(new Cursor(nested.getList()));
			} else {
				stack.pop();
			}
		}
		return false;
	}
}

class Cursor {
	List<NestedInteger> list;
	int i;

	Cursor(List<NestedInteger> list) {
		this.list = list;
	}
}

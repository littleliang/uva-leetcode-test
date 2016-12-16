package leetcode225;

import java.util.LinkedList;
import java.util.List;

class MyStack {
  List<Integer> queue1 = new LinkedList<Integer>();
  List<Integer> queue2 = new LinkedList<Integer>();

  public void push(int x) {
    if (!queue1.isEmpty()) {
      queue1.add(x);
    } else {
      queue2.add(x);
    }
  }

  public void pop() {
    if (queue1.isEmpty()) {
      List<Integer> tmp = queue2;
      queue2 = queue1;
      queue1 = tmp;
    }
    while (queue1.size() > 1) {
      queue2.add(queue1.remove(0));
    }
    queue1.clear();
  }

  public int top() {
    if (queue1.isEmpty()) {
      List<Integer> tmp = queue2;
      queue2 = queue1;
      queue1 = tmp;
    }
    while (queue1.size() > 1) {
      queue2.add(queue1.remove(0));
    }
    queue2.add(queue1.get(0));
    return queue1.remove(0);
  }

  public boolean empty() {
    return queue1.isEmpty() && queue2.isEmpty();
  }
}

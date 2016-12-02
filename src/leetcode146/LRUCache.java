package leetcode146;

import java.util.HashMap;

public class LRUCache {

  HashMap<Integer, Node> map;
  int capacity;
  Node head, tail;

  public LRUCache(int capacity) {
    map = new HashMap<Integer, Node>(capacity);
    this.capacity = capacity;
    head = new Node(-1, -1);
    tail = head;
  }

  public int get(int key) {
    if (!map.containsKey(key))
      return -1;

    Node prev = map.get(key);
    Node curr = prev.next;
    moveToTail(curr);
    return curr.val;
  }

  public void set(int key, int value) {
    if (!map.containsKey(key)) {
      Node node = new Node(key, value);
      tail.next = node;
      map.put(key, tail);
      tail = node;
      if (capacity > 0) {
        capacity--;
      } else {
        Node first = head.next;
        deleteNode(first);
      }
    } else {
      Node prev = map.get(key);
      Node curr = prev.next;
      curr.val = value;
      moveToTail(curr);
    }
  }

  public void moveToTail(Node curr) {
    if (curr == tail)
      return;
    Node prev = map.get(curr.key);
    Node post = curr.next;
    tail.next = curr;
    map.put(curr.key, tail);
    prev.next = post;
    map.put(post.key, prev);
    curr.next = null;
    tail = curr;
  }

  public void deleteNode(Node curr) {
    Node prev = map.get(curr.key);
    if (curr == tail) {
      prev.next = null;
      map.remove(curr.key);
    } else {
      Node post = curr.next;
      prev.next = post;
      map.put(post.key, prev);
      map.remove(curr.key);
    }
  }

  class Node {
    int key;
    int val;
    Node next = null;

    public Node(int key, int value) {
      this.key = key;
      this.val = value;
    }
  }
}

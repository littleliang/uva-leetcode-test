package leetcode208;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
  char c;
  boolean leaf;
  HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

  public TrieNode(char c) {
    this.c = c;
  }

  public TrieNode() {};
}


public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    Map<Character, TrieNode> children = root.children;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      TrieNode t;
      if (children.containsKey(c)) {
        t = children.get(c);
      } else {
        t = new TrieNode(c);
        children.put(c, t);
      }
      children = t.children;
      if (i == word.length() - 1)
        t.leaf = true;
    }
  }

  public boolean search(String word) {
    TrieNode t = searchNode(word);
    return t != null && t.leaf;
  }

  public boolean startsWith(String prefix) {
    return searchNode(prefix) != null;
  }

  private TrieNode searchNode(String word) {
    Map<Character, TrieNode> children = root.children;
    TrieNode t = null;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!children.containsKey(c))
        return null;
      t = children.get(c);
      children = t.children;
    }
    return t;
  }
}

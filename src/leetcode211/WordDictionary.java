package leetcode211;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
  class TrieNode {
    char c;
    boolean leaf;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

    public TrieNode(char c) {
      this.c = c;
    }

    public TrieNode() {};
  }

  private TrieNode root;

  public WordDictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
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
    TrieNode node = root;
    return search(word, 0, node);
  }

  public boolean search(String word, int pos, TrieNode node) {
    if (pos == word.length()) {
      return node.leaf;
    }
    char c = word.charAt(pos);
    if (c == '.') {
      for (TrieNode subNode : node.children.values()) {
        if (subNode != null && search(word, pos + 1, subNode)) {
          return true;
        }
      }
    } else if (node.children.containsKey(c)) {
      return search(word, pos + 1, node.children.get(c));
    }
    return false;
  }
}

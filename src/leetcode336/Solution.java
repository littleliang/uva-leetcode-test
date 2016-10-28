package leetcode336;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  class TrieNode {
    TrieNode[] children;
    ArrayList<Integer> ids;
    int index; 

    public TrieNode() {
      this.children = new TrieNode[26];
      this.ids = new ArrayList<Integer>();
      this.index = -1;
    }
  }

  private TrieNode root;

  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if (words.length < 2)
      return list;
    List<Integer> empty = new ArrayList<Integer>(); 
    root = new TrieNode();

    for (int i = 0; i < words.length; i++) { 
      if (words[i].length() == 0) {
        empty.add(i);
        continue;
      }
      insert(words[i], i);
    }

    for (int i = 0; i < words.length; i++) { 
      search(words[i], list, i, empty);
    }
    return list;
  }

  private void search(String word, List<List<Integer>> list, int idx, List<Integer> empty) {
    char[] wd = word.toCharArray();
    TrieNode cur = root;

    for (int i = wd.length - 1; i >= 0; i--) { 
      int pt = wd[i] - 'a';
      if (cur.index != -1 && isPalin(wd, 0, i)) { 
        List<Integer> li = new ArrayList<Integer>();
        li.add(cur.index);
        li.add(idx);
        list.add(li);
      }
      if (cur.children[pt] == null)
        return; 
      cur = cur.children[pt];
    }

    if (cur.ids.size() != 0) { 
      for (Integer in : cur.ids) {
        if (in != idx) {
          List<Integer> li = new ArrayList<Integer>();
          li.add(in);
          li.add(idx);
          list.add(li);
        } else {
          for (Integer em : empty) {
            List<Integer> li = new ArrayList<Integer>();
            li.add(em);
            li.add(idx);
            list.add(li);
            li = new ArrayList<Integer>();
            li.add(idx);
            li.add(em);
            list.add(li);
          }
        }
      }
    }
  }

  private void insert(String word, int idx) { 
    char[] wd = word.toCharArray();
    TrieNode cur = root;

    for (int i = 0; i < wd.length; i++) {
      int pt = wd[i] - 'a';
      if (cur.children[pt] == null) {
        cur.children[pt] = new TrieNode();
      }
      cur = cur.children[pt];
      if (i == wd.length - 1) {
        cur.index = idx;
      }
      if (isPalin(wd, i + 1, wd.length - 1)) {
        cur.ids.add(idx);
      }
    }
  }

  private boolean isPalin(char[] str, int i, int j) {
    while (j - i > 0) {
      if (str[i++] != str[j--])
        return false;
    }
    return true;
  }
}

package leetcode420;

import java.util.TreeMap;

public class Solution {
  TreeMap<Integer, Integer> repeat = new TreeMap<Integer, Integer>();
  int missing = 0;
  int ops = 0;

  public int strongPasswordChecker(String s) {
    int count = 0;
    boolean lower = false, upper = false, digit = false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c >= 'a' && c <= 'z')
        lower = true;
      if (c >= 'A' && c <= 'Z')
        upper = true;
      if (c >= '0' && c <= '9')
        digit = true;
      if (i > 0 && s.charAt(i) == s.charAt(i - 1))
        count++;
      else {
        if (count >= 3)
          increaseOne(count);
        count = 1;
      }
    }
    if (count >= 3)
      increaseOne(count);

    if (!lower)
      missing++;
    if (!upper)
      missing++;
    if (!digit)
      missing++;

    for (int i = 0; i < 6 - s.length(); i++)
      insert();
    for (int i = 0; i < s.length() - 20; i++)
      delete();
    for (int key : repeat.keySet())
      replace(key);
    if (missing > 0)
      ops += missing;
    return ops;
  }

  private void insert() {
    ops++;
    if (missing > 0)
      missing--;
    if (repeat.size() == 0)
      return;
    Integer key = repeat.firstKey();
    decreaseOne(key);
    if (key > 4)
      increaseOne(key - 2);
  }

  private void delete() {
    ops++;
    if (repeat.size() == 0)
      return;
    Integer key = repeat.firstKey();
    decreaseOne(key);
    if (key > 3)
      increaseOne(key - 1);
  }

  private void replace(Integer key) {
    int count = repeat.get(key) * (key / 3);
    if (missing > 0)
      missing -= count;
    ops += count;
  }

  private void increaseOne(int key) {
    if (!repeat.containsKey(key))
      repeat.put(key, 0);
    repeat.put(key, repeat.get(key) + 1);
  }

  private void decreaseOne(int key) {
    if (repeat.containsKey(key)) {
      repeat.put(key, repeat.get(key) - 1);
      if (repeat.get(key) == 0)
        repeat.remove(key);
    }
  }
}

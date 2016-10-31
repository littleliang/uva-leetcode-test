package leetcode381;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedCollection {
  List<Integer> vals;
  Map<Integer, List<Integer>> map;
  Random random;

  public RandomizedCollection() {
    vals = new ArrayList<>();
    map = new HashMap<>();
    random = new Random();
  }

  public boolean insert(int val) {
    List<Integer> list = map.get(val);
    boolean res = list == null || list.size() == 0 ? true : false;
    if (list == null) {
      list = new ArrayList<>();
    }
    list.add(vals.size());
    map.put(val, list);
    vals.add(val);
    return res;
  }

  public boolean remove(int val) {
    if (!map.containsKey(val) || map.get(val).size() == 0)
      return false;
    List<Integer> indexes = map.get(val);
    int index = indexes.get(indexes.size() - 1);
    indexes.remove(indexes.size() - 1);
    int lastVal = vals.get(vals.size() - 1);
    indexes = map.get(lastVal);
    if (index < vals.size() - 1) {
      vals.set(index, lastVal);
      indexes.remove(indexes.size() - 1);
      indexes.add(0, index);
    }
    vals.remove(vals.size() - 1);
    return true;
  }

  public int getRandom() {
    return vals.get(random.nextInt(vals.size()));
  }
}

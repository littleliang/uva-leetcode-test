package leetcode126;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  Set<String> mWordList;
  String mBeginWord, mEndWord;
  HashMap<String, Integer> lookup = new HashMap<String, Integer>();
  List<List<String>> myResultList = new ArrayList<List<String>>();

  public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    mWordList = new HashSet<String>(wordList);
    mBeginWord = beginWord;
    mEndWord = endWord;
    fillLookupTable();
    mWordList = wordList;
    int min = findMin();
    if (min != -1) {
      mWordList.remove(mBeginWord);
      List<String> partialResult = new ArrayList<String>();
      partialResult.add(mBeginWord);
      fillResult(partialResult, mBeginWord);
      mWordList.add(mBeginWord);
    }
    return myResultList;
  }

  // find the solution
  public void fillLookupTable() {
    lookup.put(mEndWord, 0);
    mWordList.remove(mEndWord);
    java.util.LinkedList<String> mQueue = new java.util.LinkedList<String>();
    mQueue.addLast(mEndWord);
    String str = "";
    int min = 0;
    List<String> wordList;
    while (mQueue.size() > 0) {
      str = mQueue.removeFirst();
      min = lookup.get(str) + 1;
      wordList = findOneDistanceWords(str);
      if (wordList != null) {
        for (String word : wordList) {
          if (!lookup.containsKey(word)) {
            lookup.put(word, min);
            mWordList.remove(word);
            mQueue.addLast(word);
          }
        }
      }
    }
  }

  public int findMin() {
    int min = -1;
    if (lookup.containsKey(mBeginWord)) {
      min = lookup.get(mBeginWord);
    }
    return min;
  }

  public void fillResult(List<String> partialResult, String word) {
    int newCopies = 0;
    if (word.equals(mEndWord)) {
      myResultList.add(partialResult);
      return;
    }
    List<String> wordList = findOneDistanceWords(word);
    int min = Integer.MAX_VALUE;
    String nextElement = "";
    Integer temp;
    for (String str : wordList) {
      temp = lookup.get(str);
      if (temp == null) {
        wordList.remove(str);
      } else {
        if (temp < min) {
          min = lookup.get(str);
          newCopies = 0;
        } else if (temp == min) {
          newCopies++;
        }
      }
    }
    for (String str : wordList) {
      if (lookup.get(str) == min) {
        nextElement = str;
        mWordList.remove(nextElement);
        if (newCopies != 0) {
          newCopies--;
          List<String> copyOfPartialResult = new ArrayList<String>(partialResult);
          copyOfPartialResult.add(nextElement);
          fillResult(copyOfPartialResult, nextElement);
        } else {
          partialResult.add(nextElement);
          fillResult(partialResult, nextElement);
        }
        mWordList.add(nextElement);
      }
    }
  }

  public List<String> findOneDistanceWords(String word) {
    List<String> result = null;
    for (String str : mWordList) {
      if (oneDistance(word, str)) {
        if (result == null) {
          result = new ArrayList<String>();
        }
        result.add(str);
      }
    }
    return result;
  }

  public boolean oneDistance(String word1, String word2) {
    int unmatched = 0;
    int length = word1.length();
    for (int i = 0; i < length; i++) {
      if (word1.charAt(i) != word2.charAt(i)) {
        unmatched++;
      }
      if (unmatched > 1) {
        return false;
      }
    }
    return true;
  }
}

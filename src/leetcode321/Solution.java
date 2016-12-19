package leetcode321;

import java.util.LinkedList;
import java.util.List;

public class Solution {
  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int[] maxNumber = new int[k];
    int[] leftClosest = getClosest(nums1);
    int[] rightClosest = getClosest(nums2);
    List<State> states = new LinkedList<State>();
    List<State> nextStates = new LinkedList<State>();
    states.add(new State(0, 0));
    boolean[][] stateSet = new boolean[nums1.length + 1][nums2.length + 1];
    stateSet[0][0] = true;
    for (int i = 0; i < k; i++) {
      int max = -1;
      for (State state : states) {
        stateSet[state.x][state.y] = false;
        int remainingDigits = k - i;
        int nextLeft =
            getNextIndex(leftClosest, state.x, remainingDigits - (nums2.length - state.y));
        int nextRight =
            getNextIndex(rightClosest, state.y, remainingDigits - (nums1.length - state.x));
        if (nextLeft != -1) {
          max = Math.max(max, nums1[nextLeft]);
        }
        if (nextRight != -1) {
          max = Math.max(max, nums2[nextRight]);
        }
      }
      maxNumber[i] = max;
      while (!states.isEmpty()) {
        State state = states.remove(states.size() - 1);
        int remainingDigits = k - i;
        int nextLeft =
            getNextIndex(leftClosest, state.x, remainingDigits - (nums2.length - state.y));
        int nextRight =
            getNextIndex(rightClosest, state.y, remainingDigits - (nums1.length - state.x));
        if (nextLeft != -1) {
          if (nums1[nextLeft] == max && stateSet[nextLeft + 1][state.y] == false) {
            stateSet[nextLeft + 1][state.y] = true;
            nextStates.add(new State(nextLeft + 1, state.y));
          }
        }
        if (nextRight != -1) {
          if (nums2[nextRight] == max && stateSet[state.x][nextRight + 1] == false) {
            stateSet[state.x][nextRight + 1] = true;
            nextStates.add(new State(state.x, nextRight + 1));
          }
        }
      }
      List<State> temp = states;
      states = nextStates;
      nextStates = temp;
    }
    return maxNumber;
  }

  private class State {
    int x, y;

    public State(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private int getNextIndex(int[] closest, int start, int needed) {
    int result = -1;
    if (start == closest.length) {
      return -1;
    }
    int index = start;
    while (index != -1 && closest.length - index >= needed) {
      result = index;
      index = closest[index];
    }
    return result;
  }

  private int[] getClosest(int[] A) {
    int[] closest = new int[A.length];
    if (A.length == 0) {
      return closest;
    }
    closest[A.length - 1] = -1;
    for (int i = A.length - 2; i >= 0; i--) {
      int j = i + 1;
      while (j != -1 && A[i] >= A[j]) {
        j = closest[j];
      }
      closest[i] = j;
    }
    return closest;
  }
}

package leetcode307;

public class NumArray {
  int[] processed;
  int[] nums;
  int length;

  public NumArray(int[] nums) {
    length = nums.length;
    processed = new int[length + 1];
    this.nums = nums;

    for (int i = 1; i <= length; i++) {
      int sum = 0;
      int count = 1;
      int counter = lowBit(i);

      while (count <= counter) {
        sum += nums[i - count];
        count++;
      }
      processed[i] = sum;
    }
  }

  void update(int i, int val) {
    int gap = val - nums[i];
    nums[i] = val;

    int index = i + 1;
    while (index <= length) {
      processed[index] += gap;
      index += lowBit(index);
    }
  }

  public int sumRange(int i, int j) {
    return sum(j + 1) - sum(i);
  }

  private int sum(int index) {
    int sum = 0;
    while (index > 0) {
      sum += processed[index];
      index -= lowBit(index);
    }
    return sum;
  }

  private int lowBit(int index) {
    return index & (-index);
  }
}

package leetcode324;

public class Solution {
  private int length;

  public void wiggleSort(int[] nums) {
    length = nums.length;
    int middle = quickselect(nums, 0, nums.length - 1, (nums.length - 1) / 2);
    int curr = 0;
    int left = 0;
    int right = nums.length - 1;
    while (curr <= right) {
      if (nums[mapping(curr)] > middle) {
        swap(nums, mapping(curr), mapping(left));
        curr++;
        left++;
      } else if (nums[mapping(curr)] < middle) {
        swap(nums, mapping(curr), mapping(right));
        right--;
      } else {
        curr++;
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private int mapping(int i) {
    return (i * 2 + 1) % (length | 1);
  }

  private int quickselect(int[] nums, int left, int right, int k) {
    if (left >= right) {
      return nums[left];
    }
    int position = partition(nums, left, right);
    if (position == k) {
      return nums[position];
    } else if (position < k) {
      return quickselect(nums, position + 1, right, k);
    } else {
      return quickselect(nums, left, position - 1, k);
    }
  }

  private int partition(int[] nums, int left, int right) {
    if (left >= right) {
      return left;
    }
    int value = nums[left];
    while (left < right) {
      while (left < right && nums[right] >= value) {
        right--;
      }
      nums[left] = nums[right];
      while (left < right && nums[left] < value) {
        left++;
      }
      nums[right] = nums[left];
    }
    nums[left] = value;
    return left;
  }
}

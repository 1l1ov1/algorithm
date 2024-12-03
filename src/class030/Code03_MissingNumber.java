package class030;

// 找到缺失的数字
// 测试链接 : https://leetcode.cn/problems/missing-number/
public class Code03_MissingNumber {

	public static int missingNumber(int[] nums) {
		int eorAll = 0, eorHas = 0;
		for (int i = 0; i < nums.length; i++) {
			eorAll ^= i;
			eorHas ^= nums[i];
		}
		// 因为我们需要考虑到数组中的数字范围是从 0 到 nums.length（包括两端），
		// 而我们想要找出这个范围内缺失的那个数字。在遍历过程中，我们实际上是对每一个下标 i 和数组中的元素进行了异或操作。
		// 但是这样处理后，我们只包含了 0 到 nums.length-1 这个区间内的数字的异或值（因为最长的下标仅到 nums.length-1），
		// 而完整的区间应该是包含 nums.length 这个数值本身的。
		eorAll ^= nums.length;
		// 缺失的数字就是 eorAll ^ eorHas
		return eorAll ^ eorHas;
	}

}

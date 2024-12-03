package class021;

// 归并排序，填函数练习风格
// 测试链接 : https://leetcode.cn/problems/sort-an-array/

public class Code02_MergeSort {

	public static int[] sortArray(int[] nums) {
		if (nums.length > 1) {
			// mergeSort1为递归方法
			// mergeSort2为非递归方法
			// 用哪个都可以
			// mergeSort1(nums);
			mergeSort2(nums);
		}
		return nums;
	}

	public static int MAXN = 50001;

	public static int[] help = new int[MAXN];

	// 归并排序递归版
	public static void mergeSort1(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	/**
	 * 对给定数组的指定部分进行归并排序。
	 * 归并排序是一种分治算法，它将数组分成较小的子数组，对每个子数组进行排序，然后将排序后的子数组合并成一个有序的大数组。
	 *
	 * @param arr 待排序的数组。
	 * @param l 子数组的左边界。
	 * @param r 子数组的右边界。注意，右边界是不包括在内的。
	 */
	public static void sort(int[] arr, int l, int r) {
	    // 如果子数组的长度为1或更小，则无需排序
	    if (l == r) {
	        return;
	    }
	    // 找到子数组的中间点，以便将数组分成两部分
	    int m = (l + r) / 2;
	    // 递归地对左半部分进行排序
	    sort(arr, l, m);
	    // 递归地对右半部分进行排序
	    sort(arr, m + 1, r);
	    // 合并已排序的左半部分和右半部分
	    merge(arr, l, m, r);
	}

	/**
	 * 使用归并排序算法对数组进行排序。
	 * 归并排序是一种 divide-and-conquer 算法，它通过不断拆分数组，然后合并已排序的子数组来实现排序。
	 * 这个实现是非递归的，使用了循环来逐步增加子数组的大小，直到整个数组排序完成。
	 *
	 * @param arr 待排序的整数数组。
	 */
	// 归并排序非递归版
	public static void mergeSort2(int[] arr) {
		// 获取数组长度
		int n = arr.length;

		// 逐步增加排序的子数组的大小，直到子数组大小覆盖整个数组
		for (int l, m, r, step = 1; step < n; step <<= 1) {
			// 初始化左边界
			// 左边界为0
			l = 0;
			// 遍历数组，直到左边界超过数组长度
			while (l < n) {
				// 计算当前子数组的右边界
				// 遍历
				m = l + step - 1;
				// 如果当前子数组的右边界加上1大于等于数组长度，说明剩下的部分不足以形成一个新的子数组，跳出循环
				if (m + 1 >= n) {
					break;
				}
				// 计算当前子数组的右边界，但不超过数组的最后一个元素
				r = Math.min(l + (step << 1) - 1, n - 1);
				// 合并从l到r的子数组
				merge(arr, l, m, r);
				// 更新左边界，为下一次合并做准备
				l = r + 1;
			}
		}
	}


	/**
	 * 合并两个有序子数组。
	 * 将数组 arr 中从下标 l 到 m 的部分（包含 l 和 m）与从下标 m+1 到 r 的部分（包含 m+1 和 r）合并，
	 * 并确保合并后的数组依然有序。合并后的结果直接写回到原数组 arr 中。
	 *
	 * @param arr 原始数组，合并后的结果将直接写回到这个数组中
	 * @param l 合并的起始下标
	 * @param m 合并的结束下标，不包含 m+1
	 * @param r 合并的范围上限，不包含 r
	 */
	public static void merge(int[] arr, int l, int m, int r) {
	    // i 用于在 help 数组中记录合并后的元素位置
	    int i = l;
	    // a 用于遍历左子数组
	    int a = l;
	    // b 用于遍历右子数组
	    int b = m + 1;
	    // 当左右子数组都有元素时，比较大小并合并
	    while (a <= m && b <= r) {
	        help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
	    }
	    // 如果左子数组还有剩余元素，将其全部合并到 help 中
	    while (a <= m) {
	        help[i++] = arr[a++];
	    }
	    // 如果右子数组还有剩余元素，将其全部合并到 help 中
	    while (b <= r) {
	        help[i++] = arr[b++];
	    }
	    // 将 help 中合并后的结果复制回原数组 arr
	    for (i = l; i <= r; i++) {
	        arr[i] = help[i];
	    }
	}

}
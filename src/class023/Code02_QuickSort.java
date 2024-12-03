package class023;

// 随机快速排序，填函数练习风格
// 测试链接 : https://leetcode.cn/problems/sort-an-array/

public class Code02_QuickSort {

	public static int[] sortArray(int[] nums) {
		if (nums.length > 1) {
			quickSort2(nums, 0, nums.length - 1);
		}
		return nums;
	}

	// 随机快速排序经典版(不推荐)
	public static void quickSort1(int[] arr, int l, int r) {
		if (l >= r) {
			return;
		}
		// 随机这一下，常数时间比较大
		// 但只有这一下随机，才能在概率上把快速排序的时间复杂度收敛到O(n * logn)
		int x = arr[l + (int) (Math.random() * (r - l + 1))];
		int mid = partition1(arr, l, r, x);
		quickSort1(arr, l, mid - 1);
		quickSort1(arr, mid + 1, r);
	}

	// 已知arr[l....r]范围上一定有x这个值
	// 划分数组 <=x放左边，>x放右边，并且确保划分完成后<=x区域的最后一个数字是x
	public static int partition1(int[] arr, int l, int r, int x) {
		// a : arr[l....a-1]范围是<=x的区域
		// xi : 记录在<=x的区域上任何一个x的位置，哪一个都可以
		int a = l, xi = 0;
		for (int i = l; i <= r; i++) {
			if (arr[i] <= x) {
				swap(arr, a, i);
				if (arr[a] == x) {
					xi = a;
				}
				a++;
			}
		}
		swap(arr, xi, a - 1);
		return a - 1;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// 随机快速排序改进版(推荐)
	public static void quickSort2(int[] arr, int l, int r) {
		if (l >= r) {
			return;
		}
		// 随机这一下，常数时间比较大
		// 但只有这一下随机，才能在概率上把快速排序的时间复杂度收敛到O(n * logn)
		int x = arr[l + (int) (Math.random() * (r - l + 1))];
		partition2(arr, l, r, x);
		// 为了防止底层的递归过程覆盖全局变量
		// 这里用临时变量记录first、l
		int left = first;
		int right = last;
		quickSort2(arr, l, left - 1);
		quickSort2(arr, right + 1, r);
	}

	// 荷兰国旗问题
	public static int first, last;

	/**
	 * 对数组进行分区操作，使得所有小于x的元素位于左侧，所有大于等于x的元素位于右侧。
	 * 特别地，等于x的元素会被放置在左侧边界之后、右侧边界之前的位置，即保持它们的相对顺序。
	 *
	 * @param arr 待分区的数组
	 * @param l 分区的起始位置
	 * @param r 分区的结束位置
	 * @param x 分区的基准值
	 */
	// 已知arr[l....r]范围上一定有x这个值
	// 划分数组 <x放左边，==x放中间，>x放右边
	// 把全局变量first, last，更新成==x区域的左右边界
	public static void partition2(int[] arr, int l, int r, int x) {
	    // 初始化first和last，它们分别表示等于x的元素右侧和左侧的边界
	    first = l;
	    last = r;
	    // 初始化i为当前检查的元素索引
	    int i = l;
	    // 遍历数组，进行分区操作
	    while (i <= last) {
	        // 当前元素等于x时，跳过，继续检查下一个元素
	        if (arr[i] == x) {
	            i++;
	        } else if (arr[i] < x) {
	            // 当前元素小于x时，将其与first位置的元素交换，并同时将first和i都向右移动一位
	            swap(arr, first++, i++);
	        } else {
	            // 当前元素大于x时，将其与last位置的元素交换，并将last向左移动一位
	            // 注意，这里不需要移动i，因为交换过来的元素已经完成了位置的调整
	            swap(arr, i, last--);
	        }
	    }
	}

}
package class004;

public class SelectBubbleInsert {

	// 数组中交换i和j位置的数
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// 选择排序
	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 重点选取当前位置作为基准点，然后找到最小的数，然后放到最前面
		for (int minIndex, i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}

	// 冒泡排序
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 从0到arr.length-1，每次比较相邻两个数，如果前一个数大于后一个数，则交换
		// 0 ~ n-1
		// 0 ~ n-2 ...
		for (int end = arr.length - 1; end > 0; end--) {
			// 0 ~ end
			for (int i = 0; i < end; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}

	/**
	 * 使用插入排序算法对整数数组进行排序。
	 * 插入排序的工作原理是将数组分为已排序和未排序两个部分，然后逐个将未排序元素插入到已排序部分的正确位置。
	 * 此方法直接在输入数组上进行排序，不需要额外的内存空间。
	 *
	 * @param arr 待排序的整数数组。如果数组为空或长度小于2，则不进行排序。
	 */
	// 插入排序
	public static void insertionSort(int[] arr) {
		// 检查数组是否为空或长度小于2，如果是，则无需排序
		if (arr == null || arr.length < 2) {
			return;
		}
		// 从第二个元素开始遍历数组，因为第一个元素默认已排序
		for (int i = 1; i < arr.length; i++) {
			// 将arr[i]插入到已排序部分的正确位置
			for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				// 交换arr[j]和arr[j+1]以确保较大的元素向后移动
				swap(arr, j, j + 1);
			}
		}
	}

}
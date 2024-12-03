package class027;

import java.util.PriorityQueue;

// 将数组和减半的最少操作次数
// 测试链接 : https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/
public class Code03_MinimumOperationsToHalveArraySum {

	// 提交时把halveArray1改名为halveArray
	public static int halveArray1(int[] nums) {
		// 大根堆，为了保证精度，用Double
		PriorityQueue<Double> heap = new PriorityQueue<>((a, b) -> b.compareTo(a));
		double sum = 0;
		for (int num : nums) {
			// 放入堆中
			heap.add((double) num);
			// 得到总和
			sum += num;
		}
		// sum，整体累加和，-> 要减少的目标！
		sum /= 2;
		// 操作次数
		int ans = 0;
		// 减少的幅度
		for (double minus = 0, cur; minus < sum; ans++, minus += cur) {
			// 得到当前减少的幅度
			cur = heap.poll() / 2;
			// 重新放入到堆中
			heap.add(cur);
		}
		return ans;
	}

	public static int MAXN = 100001;

	public static long[] heap = new long[MAXN];

	public static int size;

	// 提交时把halveArray2改名为halveArray
	public static int halveArray2(int[] nums) {
		size = nums.length;
		long sum = 0;
		for (int i = size - 1; i >= 0; i--) {
			// 每个数扩大2^20呗，防止溢出
			heap[i] = (long) nums[i] << 20;
			// 总和也扩大2^20
			sum += heap[i];
			// 堆化
			heapify(i);
		}
		// 总和除以2
		sum /= 2;
		int ans = 0;
		for (long minus = 0; minus < sum; ans++) {
			// 最大的数减小一半
			heap[0] /= 2;
			// 然后加上
			minus += heap[0];
			// 从0开始堆化
			heapify(0);
		}
		return ans;
	}

	/**
	 * 将指定索引的节点及其子节点调整为符合最大堆性质的结构。
	 * 此函数用于构建最大堆的过程中，将指定节点下沉以满足最大堆的定义。
	 *
	 * @param i 要调整的节点的索引
	 */
	public static void heapify(int i) {
	    /* 计算左子节点的索引 */
	    int l = i * 2 + 1;

	    /* 当左子节点在堆范围内时，进行调整 */
	    while (l < size) {
	        /* 确定当前较大的子节点，如果存在右子节点且大于左子节点 */
	        int best = l + 1 < size && heap[l + 1] > heap[l] ? l + 1 : l;
	        /* 比较当前较大的子节点与当前节点，确定是否需要交换 */
	        best = heap[best] > heap[i] ? best : i;

	        /* 如果当前节点已经是最大值，则结束调整 */
	        if (best == i) {
	            break;
	        }
	        /* 交换当前节点与较大子节点，将较大值下沉 */
	        swap(best, i);
	        /* 更新当前节点为较大子节点，继续检查其子节点 */
	        i = best;
	        /* 计算更新后的当前节点的左子节点索引 */
	        l = i * 2 + 1;
	    }
	}

	public static void swap(int i, int j) {
		long tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}

}

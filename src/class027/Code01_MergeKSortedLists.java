package class027;

import java.util.ArrayList;
import java.util.PriorityQueue;

// 合并K个有序链表
// 测试链接：https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6
public class Code01_MergeKSortedLists {

	// 不要提交这个类
	public static class ListNode {
		public int val;
		public ListNode next;
	}

	// 提交以下的方法
	public static ListNode mergeKLists(ArrayList<ListNode> arr) {
		// 小根堆
		PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
		for (ListNode h : arr) {
			// 遍历所有的头！
			if (h != null) {
				heap.add(h);
			}
		}
		if (heap.isEmpty()) {
			return null;
		}
		// 先弹出一个节点，做总头部
		ListNode h = heap.poll();
		ListNode pre = h;
		// 如果有下一个节点
		if (pre.next != null) {
			// 就将下一个节点放进去
			heap.add(pre.next);
		}
		// 如果堆不空
		while (!heap.isEmpty()) {
			// 得到堆顶
			ListNode cur = heap.poll();
			// 指向堆
			pre.next = cur;
			pre = cur;
			// 如果下一个节点还有下一个节点
			if (cur.next != null) {
				heap.add(cur.next);
			}
		}
		return h;
	}

}

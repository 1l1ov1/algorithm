package class030;

// 不用任何判断语句和比较操作，返回两个数的最大值
// 测试链接 : https://www.nowcoder.com/practice/d2707eaf98124f1e8f1d9c18ad487f76
public class Code02_GetMaxWithoutJudge {

	// 必须保证n一定是0或者1
	// 0变1，1变0
	public static int flip(int n) {
		// 符号位和1相异或
		// 如果n = 0 表示整数 异或1 为1
		// 如果n = 1 表示负数 异或1 为0
		return n ^ 1;
	}

	// 非负数返回1
	// 负数返回0
	public static int sign(int n) {
		// 无符号右移得到31位得到符号位
		return flip(n >>> 31);
	}

	// 有溢出风险的实现
	public static int getMax1(int a, int b) {
		int c = a - b;
		// c非负，returnA -> 1
		// c非负，returnB -> 0
		// c负数，returnA -> 0
		// c负数，returnB -> 1
		int returnA = sign(c);
		int returnB = flip(returnA);
		return a * returnA + b * returnB;
	}

	// 没有任何问题的实现
	public static int getMax2(int a, int b) {
		// c可能是溢出的
		int c = a - b;
		// a的符号
		int sa = sign(a);
		// b的符号
		int sb = sign(b);
		// c的符号
		int sc = sign(c);
		// // 通过异或运算判断a和b的符号是否相同，相同为0，不同为1
		// 判断A和B，符号是不是不一样，如果不一样diffAB=1，如果一样diffAB=0
		int diffAB = sa ^ sb;
		// 判断A和B，符号是不是一样，如果一样sameAB=1，如果不一样sameAB=0
		// 通过翻转diffAB的值来得到相同符号的判断结果，相同为1，不同为0
		int sameAB = flip(diffAB);
		// 计算如果选择a作为最大值时的返回值
		// 如果a和b符号不一样，且a为非负或者a和b的符号一样,那么c要为非负
		int returnA = diffAB * sa + sameAB * sc;
		// 计算如果选择b作为最大值时的返回值，通过翻转returnA的值来得到
		int returnB = flip(returnA);
		// 根据返回值和原数值的乘积来得到最终结果，确保选择的是较大的数
		return a * returnA + b * returnB;
	}

	public static void main(String[] args) {
		int a = Integer.MIN_VALUE;
		int b = Integer.MAX_VALUE;
		// getMax1方法会错误，因为溢出
		System.out.println(getMax1(a, b));
		// getMax2方法永远正确
		System.out.println(getMax2(a, b));
	}

}

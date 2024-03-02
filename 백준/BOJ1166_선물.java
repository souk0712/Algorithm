import java.util.Scanner;

public class BOJ1166_선물 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();

		double left = 0;
		double right = Math.max(L, Math.max(W, H));

//		for (int i = 0; i < 10000; i++) {
//			double mid = (left + right) / 2;
//			if ((long) (L / mid) * (long) (W / mid) * (long) (H / mid) >= N) {
//				left = mid;
//			} else {
//				right = mid;
//			}
//		}
		while (left < right) {
			double mid = (left + right) / 2;
			if ((long) (L / mid) * (long) (W / mid) * (long) (H / mid) >= N) {
				if (left == mid)
					break;
				left = mid;
			} else {
				if (right == mid)
					break;
				right = mid;
			}
		}
		System.out.println(left);

	}

}

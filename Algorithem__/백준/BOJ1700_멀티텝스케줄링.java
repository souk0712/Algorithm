import java.util.HashSet;
import java.util.Scanner;

public class BOJ1700_멀티텝스케줄링 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 	// 멀티탭 구멍의 개수 N
		int K = sc.nextInt();	// 전기 용품의 총 사용횟수 K
		int[] arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
		}

		int count = 0;
		if (N == 1) {
			for (int i = 1; i < K; i++) {
				if (arr[i] != arr[i - 1]) {
					count++;
				}
			}
		} else {
			HashSet<Integer> multitap = new HashSet<>();
			for (int i = 0; i < K; i++) {
				if (multitap.contains(arr[i])) {
					continue;
				}
				if (multitap.size() < N) {
					multitap.add(arr[i]);
				} else {
					HashSet<Integer> temp = new HashSet<>(multitap);
					for (int j = i + 1; j < K; j++) {
						if (temp.contains(arr[j])) {
							temp.remove(arr[j]);
						}
						if (temp.size() < 2) {
							break;
						}                                           
					}
					multitap.remove(temp.iterator().next());
					multitap.add(arr[i]);
					count++;
				}
			}
		}
		System.out.println(count);
	}
}

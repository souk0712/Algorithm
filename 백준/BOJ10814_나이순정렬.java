import java.util.Arrays;
import java.util.Scanner;

public class BOJ10814_나이순정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Info[] map = new Info[N];
		for (int i = 0; i < N; i++) {
			int age = sc.nextInt();
			String name = sc.next();
			map[i] = new Info(age, name, i);
		}
		Arrays.sort(map);
		for (int i = 0; i < map.length; i++) {
			System.out.print(map[i].age + " " + map[i].name + "\n");
		}

	}

	static class Info implements Comparable<Info> {
		int age;
		String name;
		int cnt;

		public Info(int age, String name, int cnt) {
			super();
			this.age = age;
			this.name = name;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Info o) {
			if (this.age == o.age) {
				return Integer.compare(this.cnt, o.cnt);
			} else
				return Integer.compare(this.age, o.age);
		}

	}

}

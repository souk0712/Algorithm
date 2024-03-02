package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Java1983 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            List<Student> student = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String a = br.readLine();
                StringTokenizer st = new StringTokenizer(a, " ");
                int middle = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int homework = Integer.parseInt(st.nextToken());
                float total = (float) (middle * 0.35 + end * 0.45 + homework * 0.2);
                student.add(new Student(i + 1, middle, end, homework, total, ""));
            }
            Comparator<Student> cp = new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    if (o1.total > o2.total) {
                        return -1;
                    } else if (o1.total < o2.total) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            };
            student.sort(cp);
            String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
            for (int i = 0; i < student.size(); i++) {
                student.get(i).setGrade(grade[i / (N / 10)]);
            }

            String answer = null;
            for (Student student1 : student) {
                if (student1.index == K) answer = student1.grade;
            }

            System.out.println("#" + (t + 1) + " " + answer);

        }
    }

    public static class Student {
        int index;
        int middle;
        int end;
        int homework;
        float total;
        String grade;

        public Student(
                int index,
                int middle,
                int end,
                int homework,
                float total,
                String grade
        ) {
            this.index = index;
            this.middle = middle;
            this.end = end;
            this.homework = homework;
            this.total = total;
            this.grade = grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }
}

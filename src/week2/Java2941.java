package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        int count = input.length;
        for (int i = 0; i < input.length; i++) {
            switch (input[i]) {
                case "c":
                    if (i + 1 < input.length) {
                        if (input[i + 1].equals("=")) {
                            i=i+1;
                            count--;
                        } else if (input[i + 1].equals("-")) {
                            count--;
                            i=i+1;

                        }
                    }
                    break;
                case "d":
                    if (i + 1 < input.length) {
                        if (input[i + 1].equals("z")) {
                            if(i + 2 < input.length)
                            if (input[i + 2].equals("=")) {
                                count = count-2;
                                i = i + 2;
                            }
                        } else if (input[i + 1].equals("-") && i + 1 < input.length) {
                            count--;
                            i=i+1;

                        }
                    }
                    break;
                case "l":
                case "n":
                    if( i + 1 < input.length)
                    if (input[i + 1].equals("j")) {
                        count--;
                        i=i+1;

                    }
                    break;
                case "s":
                case "z":
                    if( i + 1 < input.length)
                        if (input[i + 1].equals("=")) {
                        count--;
                        i=i+1;
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(count);
    }
}

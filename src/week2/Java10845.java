package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Java10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Deque<Integer> queue = new LinkedList();

        for (int i = 0; i < n; i++) {
            String input = bufferedReader.readLine();
            StringTokenizer st = new StringTokenizer(input);
            switch (st.nextToken()) {
                case "push":
                    queue.offer(Integer.valueOf(st.nextToken()));
                    break;
                case "pop":
                    if (queue.isEmpty())
                        System.out.println(-1);
                    else
                    System.out.println(queue.poll());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if (queue.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "front":
                    if (queue.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(queue.peekFirst());
                    break;
                case "back":
                    if (queue.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(queue.peekLast());
                    break;

            }
        }

    }
}

/**
 * 큐는 기본 원칙이 '선입선출(FIFO : First in First out)' : 먼저 들어온 것이 먼저 나오는 방식
 * Deque는 양방향 큐라서 양쪽에 데이터를 넣고 뺄 수 있음.
 * Deque<String> deque1 = new ArrayDeque<>();
 * Deque<String> deque2 = new LinkedBlockingDeque<>();
 * Deque<String> deque3 = new ConcurrentLinkedDeque<>();
 * Deque<String> deque4 = new LinkedList<>();

 * 추가
 * deque.addFirst() : 덱 앞쪽에 데이터 삽입. 용량 초과시 Exception
 * deque.offerFirst() : 덱 앞쪽에 데이터 삽입 후 true. 용량 초과시 false
 * deque.addLast() : 덱 뒤쪽에 데이터 삽입. 용량 초과시 Exception
 * deque.add() : addLast()와 동일
 * deque.offerLast() : 덱 뒤쪽에 데이터 삽입 후 true. 용량 초과시 false
 * deque.offer() : offerLast()와 동일
 * deque.push() : addFirst()와 동일
 * deque.pop() : removeFirst()와 동일

 * 삭제
 * deque.removeFirst() : 덱 앞에서 제거. 비어있으면 Exception
 * deque.remove() : removeFirst()와 동일
 * deque.poll() : 덱 앞에서 제거. 비어있으면 null 리턴
 * deque.pollFirst() : poll()와 동일
 * deque.removeLast() : 덱 뒤에서 제거. 비어있으면 Exception
 * deque.pollLast() : 덱 뒤에서 제거. 비어있으면 null 리턴
 *
 * deque.removeFirstOccurrence(Object o); : 덱 앞쪽에서 찾아서 첫 번째 데이터를 삭제
 * deque.removeLastOccurrence(Object o); : 덱 뒤쪽에서 찾아서 첫 번째 데이터를 삭제
 * deque.remove(Object o); : removeFirstOccurrence()와 동일
 *

 * 확인
 * deque.getFirst() :첫 번째 엘리먼트를 확인. 비어있으면 Exception
 * deque.peekFirst() : 첫 번째 엘리먼트를 확인. 비어있으면 null 리턴
 * deque.peek() : peekFirst()와 동일
 * deque.getLast() : 마지막 엘리먼트를 확인. 비어있으면 Exception
 * deque.peekLast() : 마지막 엘리먼트를 확인. 비어있으면 null 리턴
 * deque.contain(Object o) : Object 인자와 동일한 엘리먼트가 포함되어 있는지 확인
 * deque.size() : 덱에 들어있는 엘리먼트의 개수
 */
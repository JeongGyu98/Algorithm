import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front":
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (dq.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(dq.pollFirst()).append("\n");
                    }
                    break;
                case "pop_back":
                    if (dq.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(dq.pollLast()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if (dq.isEmpty()) {
                        sb.append("1").append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                    break;
                case "front":
                    if (dq.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(dq.peekFirst()).append("\n");
                    }
                    break;
                case "back":
                    if (dq.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(dq.peekLast()).append("\n");
                    }
                    break;
            }

        }
        System.out.println(sb);
    }

}
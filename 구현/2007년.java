import java.io.*;
import java.util.*;

public class Main {

        public static void main(String[] args) throws IOException {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                String[] days = new String[] {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
                int[] months = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

                int count = 0;

                for (int i = 1; i <= 12; i++) {
                        if (i == x) {
                                break;
                        }
                        count += months[i];
                }

                count += y;

                System.out.println(days[count % 7]);
        }

}
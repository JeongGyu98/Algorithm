import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] inputs = new String[input.length()];

        for (int i = 0; i < input.length(); i++) {
            inputs[i] = input.substring(i);
        }

        Arrays.sort(inputs);

        for (String i : inputs) {
            System.out.println(i);
        }
    }
}

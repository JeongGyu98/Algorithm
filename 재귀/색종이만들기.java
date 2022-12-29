import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int white;
    public static int blue;
    public static int[][] color;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        color = new int[N][N];
        StringTokenizer st;

        for(int i = 0; i < N; i ++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        quad(0,0,N);
        System.out.println(white);
        System.out.println(blue);

    }

    public static void quad(int x, int y, int size){

        if(check(x,y,size)){
            if(color[x][y] == 1){
                blue++;
            }
            else{
                white++;
            }
        } else {

            int newSize = size/2;

            quad(x, y, newSize);
            quad(x, y + newSize, newSize);
            quad(x + newSize, y, newSize);
            quad(x + newSize, y + newSize, newSize);
        }
    }

    public static boolean check(int x, int y, int size){

        int criteria = color[x][y];

        if(size == 1){
            return true;
        }

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if(criteria != color[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


}


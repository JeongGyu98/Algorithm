import java.util.Scanner;

public class Main {

    static int[][] arr;
    static String result = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];
        String number = "";

        for(int i = 0; i < n; i++){
            number = sc.next();
            for(int j = 0; j < n; j++){
                arr[i][j] = (int)number.charAt(j) - '0';
            }
        }
        quadtree(n, 0, 0);
        System.out.println(result);

    }

    public static void quadtree(int n, int x, int y){

        if(check(n, x, y)){
           result =  result + arr[x][y];
        }else {
            result = result + "(";
            quadtree(n/2, x, y);
            quadtree(n/2, x, y + n/2);
            quadtree(n/2, x + n/2, y);
            quadtree(n/2, x + n/2, y + n/2);
            result = result + ")";
        }
    }

    public static boolean check (int n, int x, int y){
        int criteria = arr[x][y];
        if(n == 1){
            return true;
        }
        else {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    if (criteria != arr[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

    }

}

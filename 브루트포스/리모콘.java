import java.util.*;

public class Main {

   public static void main(String[] args) {

      int N, M;
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      M = sc.nextInt();

      ArrayList<Integer> troubleButton = new ArrayList<Integer>();


      for(int i = 0; i<M; i++) {	//고장난 버튼
         int but = sc.nextInt();
         troubleButton.add(but);

      }

      int ans = Math.abs(100-N);			//+, - 버튼으로만 움직였을 때

      int mini = 987654321;
      int cnt = 0;

      for(int i = 0; i<=999999; i++) {		//완전 탐색

         String str = String.valueOf(i);
         boolean chk = true;
         for(int k = 0; k<str.length(); k++) {
            if(troubleButton.contains(str.charAt(k)-'0')) {		//고장난 버튼 때문에 바로 i 못 누르면 스킵
               chk=false; break;
            }
         }
         if(chk==false) continue;

         cnt = str.length() + Math.abs(i-N);	//고장난 버튼 없어서 바로 i를 누를 수 있으면 i 누르고 +/- 눌러서 이동


         if(cnt < mini) {
            mini = cnt;
         }

      }

      if(mini < ans) ans = mini;
      System.out.println(ans);


   }

}
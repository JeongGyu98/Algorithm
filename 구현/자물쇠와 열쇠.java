class Solution {

   public boolean solution(int[][] key, int[][] lock) {
      int m = key.length;
      int n = lock.length;
      int mapSize = key.length + ((lock.length - 1) * 2);

      int[][] map = new int[mapSize][mapSize];
      for(int i = 0; i < lock.length; i++){
         for(int j = 0; j < lock.length; j++){
            map[i + key.length - 1][j + key.length - 1] = lock[i][j];
         }
      }

      for(int r = 0; r < 4; r++){

         if(check(map, key, n)) {
            return true;
         }
         key = rotation(key, m);
      }

      return false;
   }

   int[][] rotation(int[][] key, int M){
      int[][] newKey = new int[M][M];
      for(int i = 0; i < M; i++){
         for(int j = 0; j < M; j++){
            if(key[i][j] == 1){
               newKey[j][M - 1 - i] = 1;
            }
         }
      }
      return newKey;
   }

   void print (int[][] map){
      for(int i = 0 ; i< map.length; i++){
         for(int j = 0; j < map.length;j ++){
            System.out.print(map[i][j]);
         }
         System.out.println();
      }
      System.out.println();
   }

   boolean check(int[][] map, int[][] key, int lock_length){
      for(int i = 0; i < map.length - key.length + 1; i++){
         for(int j = 0; j < map.length - key.length + 1; j++){

            for(int k = 0; k < key.length; k++){
               for(int l = 0; l < key.length; l++){
                  map[i + k][j + l] += key[k][l];
               }
            }


            boolean isMatch = true;

            for(int k = key.length - 1; k < lock_length + key.length - 1; k++){
               for(int l = key.length - 1; l < lock_length + key.length - 1; l++){
                  if(map[k][l] != 1){
                     isMatch = false;
                     break;
                  }
               }
               if(!isMatch) break;
            }


            if(isMatch) {
               return true;
            }

            for(int k=0; k<key.length; k++){
               for(int l=0; l<key.length; l++){
                  map[i+k][j+l] -= key[k][l];
               }
            }
         }
      }
      return false;
   }
}
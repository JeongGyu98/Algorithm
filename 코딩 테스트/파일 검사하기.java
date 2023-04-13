import java.io.*;
import java.util.*;
public class Main {


   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      String[][] folders = {{"animal", "root"}, {"fruit", "root"}};
//      String[][] files = {{"cat", "1B", "animal"}, {"dog", "2KB", "animal"}, {"apple", "4B", "fruit"}};
//      String[] selected = {"animal"};
//      String[] excepted = {"apple"};
      String[][] folders = {{"food", "root"}, {"meat", "food"}, {"fruit", "food"}, {"animal", "root"}};
      String[][] files = {{"cat", "1B", "animal"}, {"dog", "2B", "animal"}, {"fork", "1KB", "meat"}, {"beef", "8KB", "meat"}, {"apple", "4B", "fruit"}, {"fire", "83B", "root"}};
      String[] selected = {"root", "meet"};
      String[] excepted = {"fork", "apple"};

      System.out.println(solution(folders, files, selected, excepted)[0]);
      System.out.println(solution(folders, files, selected, excepted)[1]);

   }

   static int[] solution(String[][] folders, String[][] files, String[] selected, String[] excepted) {

      long sizeSum = 0;
      int fileCount = 0;

      //선택된 폴더만 검사
      for (String folder : selected) {
         for (String[] file : files) {
            String fileName = file[0];
            String fileSizeString = file[1];
            String folderName = file[2];

            //제외 대상이 아니라면
            if (!Arrays.asList(excepted).contains(fileName)) {
               long fileSize = convertFileSize(fileSizeString);

               // 검사 대상 폴더인 경우
               if (folderName.equals(folder)) {
                  sizeSum += fileSize;
                  fileCount++;
               }
               else if (isSubFolder(folders, folderName, folder)) {
                  sizeSum += fileSize;
                  fileCount++;
               }

            }
         }
      }

      return new int[]{(int)sizeSum, fileCount};
   }
   private static boolean isSubFolder(String[][] folders, String childFolder, String parentFolder) {
      for (String[] folder : folders) {
         String child = folder[0];
         String parent = folder[1];
         if (child.equals(childFolder) && parent.equals(parentFolder)) {
            return true;
         } else if (child.equals(childFolder)) {
            return isSubFolder(folders, parent, parentFolder);
         }
      }
      return false;
   }

   // 파일 크기를 byte 단위로 변환하는 메소드
   private static long convertFileSize(String fileSizeString) {

      long fileSize = 0;

      if(fileSizeString.endsWith("KB")){
         fileSize = Long.parseLong(fileSizeString.substring(0, fileSizeString.length() - 2));
         return fileSize * 1024;
      } else {
         fileSize = Long.parseLong(fileSizeString.substring(0, fileSizeString.length() - 1));
         return fileSize;
      }
   }


}
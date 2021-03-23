import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex06_Reader_Writer_Buffer {

    public static void main(String[] args) throws Exception {  // 원래 throws하면 안됌
        // Lotto
        // lotto에 파일 기록
        FileWriter fw = new FileWriter("Lotto.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write("로또");
        bw.newLine();
        bw.write("1,3,6,8,9");
        bw.newLine();
        bw.flush();
        

//        FileReader fr = null;
//        BufferedReader br = null;
//
//        try {
//            fr = new FileReader("Ex01_Stream.java"); // 2byte 하나씩 처리하지 않을거임 -> 그래서 buffered쓸거야
//            br = new BufferedReader(fr); // 한번에 태워서 보낼거임
//
//            // Line 단위 처리
//            // ㄴ 줄 단위로 (엔터 처리 처럼) 읽음
//            String line = "";
//            for (int i = 0; (line = br.readLine()) != null; i++) { // readline() 한줄씩 읽을 수 있음
//                // System.out.println(line);
//                if (line.indexOf(";") != -1) { // ; 있는 애들만 볼거임
//                    System.out.println(line);
//                }
//            }
//        } catch (Exception e) {
//            // TODO: handle exception
//        } finally {
//            try {
//                br.close();
//                fr.close();
//            } catch (Exception e2) {
//                // TODO: handle exception
//            }
//        }
    }

}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class Ex11_PrintWriter {

    public static void main(String[] args) {
        // 출력형식의 정의
        // printf, String.format
        // 출력물에 대한 형식 정의(레포팅) -> txt -> 이쁘게 출력할 수 있음
        // 현업 : 레포팅 -> 툴 -> 오즈, 크리스탈 레포트 소프트웨어
        // PrintWriter -> 예쁘게 그림을 그려준다.
        try {
            /*
             * (메모장으로 써지는 기능, 콘솔창 출력(x))
             * 이쁘게 그릴수 있는 보조Stream
            PrintWriter pw = new PrintWriter("C:\\Temp2\\homework.txt"); // 생성기능
            pw.println("********************************************"); // 이게 화면에 그려짐
            pw.println("***************HomeWork!!**************");
            pw.println("********************************************");
            pw.printf("%3s : %5d  %5d  %5d  %5.1f","아무개", 100, 90, 50,(float)(100+90+50)/3);
            pw.println();  // 엔터기능
            pw.close();
            */
            
            //PrintWriter의 장점은 라인단위로 먹는다.
            // read도 라인단위로!!!
            // 파일에 있는 걸 콘솔창으로 불러옴(파일에서 읽은 코드)
            FileReader fr = new FileReader("C:\\\\Temp2\\\\homework.txt"); // 난 여기서 파일 읽을거임!
            BufferedReader br = new BufferedReader(fr);  // 한번에 태워서 갈거임
            String str = "";  // 변수 설정
            while((str = br.readLine()) != null) {
                System.out.println(str);
            }
            
            br.close();
            fr.close();
        } catch (Exception e) {
            
        }

    }

}

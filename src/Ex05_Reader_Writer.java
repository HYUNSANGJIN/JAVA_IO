import java.io.FileReader;
import java.io.FileWriter;

/*
 * 한글처리
 * ㄴ 문자긱반의 데이터 처리(String  데이터 -> char[] 관리)
 * 
 * 한글 1자, 영문자 1자 -> 2byte로 통일해서 할거임
 * 
 * Reader , Writer(Stream이 안붙어 있으면 문자처리 하는거임)
 * 
 * 대상이 File이면 -> File(Reader, Writer)
 */
public class Ex05_Reader_Writer {

    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader("Ex01_Stream.java"); // read -> 빨대꽂음
            fw = new FileWriter("copy_Stream.txt"); // 파일을 생성 -> 그 파일에 write까지 작업

            int data = 0;
            while ((data = fr.read()) != -1) {
                // System.out.println((char)data);
                
                // 배포 파일을 보면 압축되었다고 함(엔터와 공백과 스페이스가 없는 파일)
                if(data != '\n' && data !='\r' && data !='\t' && data != ' ') {  // \r과 \n이 합치면 엔터역할
                    // 엔터도 아니고 탭도 아니고 공백도 아닌 압축 파일 만들기
                    fw.write(data);
                }
            }

        } catch (Exception e) {
            
        } finally {
            try {
                fw.close();
                fr.close();
            } catch (Exception e2) {
            }
        }

    }

}

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 대상  read, write (File) -> 예) 1.txt , 메모.txt
 *    ㄴ FileInputStream
 *    ㄴ FileOutputStream
 *    
 */
public class Ex02_Point_FileStream {
    public static void main(String[] args) {
        FileInputStream fs = null;
        FileOutputStream fos = null;
        String path = "C:\\Temp2\\a.txt"; // inputstream 빨대를 inputstream생성자에 꽂아버림

        try {
            fs = new FileInputStream(path);
            fos = new FileOutputStream("C:\\Temp2\\new.txt", true); // 없으면 만들고 빨대를 꽂아야한다(중복기능을 가지고 있음)
            //FileOutputStream
            // 1. write 하는 파일 존재하지 않으면 파일 생성
            //new FileOutputStream("C:\\Temp2\\new.txt",false); -> default 로 false가 되어있음
            // ㄴ true 옵션을 주면 c드라이브에 있는 temp2 폴더에 new.txt에서 실행시킬때마다' hello'라는 글자 하나씩 출력
            // ㄴ overwrite
            
            // append -> true
            int data = 0;
            while ((data = fs.read()) != -1) {
                System.out.println("정수 : " + data); // char를 정수로 변환해서 읽어줌
                // 문자값으로 출력
                System.out.println("문자 : " + (char) data);

                // new.txt 파일에 데이터 값을 write하겠다.
                // FileOutputStream -> write하려는 파일이 없으면 파일도 생성한다.(생성기능을 가지고있음)
                fos.write(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 정상적으로 코드가 수행하던
            // 비정상적으로 코드가 수행하던
            // 반드시 코드가 실행(강제적 실행)되어야 하던 영역(return이 있더라도 실행 됨)
            // 명시적인 자원 해제(객체) -> 가비지 컬렉터 관리(쓰지 않는 자원을 지워줌)
            // 가비지 컬렉터가 관리하지 못하는 자원
            // ㄴ 네트워크 관련 자원(I/O, Network) -> 개발자가 직접(명시적으로)자원을 해제 시켜야함
            // ㄴ예)엑셀파일 작업 하고 있으면 다른 사람이 열면 -> 읽기전용이라도 읽겠습니까? 이런식으로 뜸 -> 자바가 스스로 하지 못함
            // 생성자 <-> 소멸자 강제적으로 호출(close)
            try {
                fs.close();
                fos.close();  // 예외처리 하면 다른 사람들도 읽고 쓸수 있음.
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

}

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * File 처리 가장 느린 작업 (Disk)-> 원칙 : 한 Byte씩 read하고 write한다. 
 *  ㄴ 모아서 한번에 하고 싶으면?? -> read, write를 모아야한다.
 *                          ㄴ 예) 버스빌려서 -> 20명 태우고 데려다 주고 다시와서 태우고..)
 *                                ㄴ 버스 = buffer
 *  ㄴ I/O횟수가 줄어든다(성능이 좋아짐)
 *  ㄴ Line 단위(엔터)
 * 
 * 보조 스트림 : BufferedInputStream(주 클래스 의존)
 *  ㄴ 개발자가 의무적으로 사용한다.
 */
public class Ex04_Stream_Buffer {

    public static void main(String[] args) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            fos = new FileOutputStream("data.txt"); // data.txt가 없으면 파일을 만들고 , write도 같이함
            bos = new BufferedOutputStream(fos);
            
            for(int i=0; i<10; i++) {
                bos.write('A');
            }
           // bos.flush();
            // JAVA Buffer 크기 : 8kbyte : 8192byte
            // 1. buffer 안에 내용이 채워지면 스스로 출발(비운다) -> flush(후~불어서 내용을 비운다)
            // 2. buffer 강제로 비운다. (명시적으로 flush를 호출) flush()
            // 3. bos.close() -> 자원해제 -> 자동으로 flush()를 호출
            

        } catch (Exception e) {

        }finally {
            try {
                bos.close();
                fos.close();
                
            }catch(Exception e2) {
                
            }
        }

    }

}

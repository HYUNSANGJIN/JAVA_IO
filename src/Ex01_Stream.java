import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/*
 * Stream 중간 매개체(데이터의 통로) -> default값은 Byte
 * 
 * JAVA API(자바 만든 사람들이..)
 *  ㄴ [추상 클래스]
 *    ㄴ InputStream, OutPutStream
 *    
 *  입출력 [대상] 두개의 추상클래스 상속 받아서 재정의 사용해라.
 * 1. Memory : Byte InputStream , Byte OutputStream
 * 2. File : File InputStream, File OutputStream **   
 */
public class Ex01_Stream {

    public static void main(String[] args) {
        // byte(-128~127) : 정수값을 저장하는 데이터 타입
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        byte[] outSrc = null;  // null인 이유는 현재 메모리를 가지고 있지 않다..(초기화 안되어있음)
        
        // 데이터를 read하거나 write 하는 작업 대상이 memory
        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;
        
        input = new ByteArrayInputStream(inSrc); // inSrc배열(메모리)에 빨대를 꽂아서 read하겠다.
        output = new ByteArrayOutputStream(); // write 할때 쓸거임
        
        System.out.println("ourSrc before : " + Arrays.toString(outSrc));
        
        // 공식같은 로직
        int data = 0;
        while((data = input.read()) != -1) { // -1 -> 더이상 read data가 없으면 -1이 리턴됨
            System.out.println("data : " + data);
        }
//        while(input.read() != -1) {
//            System.out.println(input.read()); // read() 함수는 내부적으로 next()기능 가지고 있음
//        }
        
        //read한 데이터를 다른 메모리에 write하고 싶음 -> write는 출력 스트림 필요
        // write 대상이 data가 아니고
        // ByteArrayOutputStream 자신의 통로에 data를 가진다.
        output.write(data);
        
        System.out.println(output.toByteArray());  // 가지고 있는것의 주소 
        
        outSrc = output.toByteArray();
        
        System.out.println("outSrc after : " + Arrays.toString(outSrc));
    }
    
    

}

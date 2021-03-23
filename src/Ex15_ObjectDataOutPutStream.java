import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import kr.or.bit.UserInfo_Ex15;

public class Ex15_ObjectDataOutPutStream {

    public static void main(String[] args) {
        // 남자친구
        // 탱크 부품을 여자친구에게 보내는 코드
        String filename = "Userdata.txt"; // 객체를 직렬화해서 write

        FileOutputStream fos = null;
        BufferedOutputStream bos = null; // 성능때문에
        ObjectOutputStream out = null;

        try {
            fos = new FileOutputStream(filename, true); // append
            bos = new BufferedOutputStream(fos);

            // 직렬화 하고 싶으면
            out = new ObjectOutputStream(bos);

            // 직렬화 대상(조립식 제품을 만든다)
            UserInfo_Ex15 u1 = new UserInfo_Ex15("홍길동", "super", 500); // 완제품
            UserInfo_Ex15 u2 = new UserInfo_Ex15("scott", "tiger", 50); // 완제품

            // 벽에 구멍을 만들고 보낸다(예) 강사님이 말씀하신 탱크의 부품을 벽으로 보내는것)
            // 직렬화"Userdata.txt"
            out.writeObject(u1); // 분해해서 Userdata.txt 에다가 쓴거다(write)
            out.writeObject(u2); // 분해해서 Userdata.txt 에다가 쓴거다(write)

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                out.close();  // close()는 반대로 써준다.
                bos.close();
                fos.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }

    }

}

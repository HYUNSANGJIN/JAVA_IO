import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import kr.or.bit.UserInfo_Ex15;

// 여자친구
// 분해된 탱크를 다시 복원하는 작업
// ㄴ 역직렬화

public class Ex16_ObjectDataInPutStream {

    public static void main(String[] args) {
        String filename = "Userdata.txt";

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(filename);
            bis = new BufferedInputStream(fis);
            in = new ObjectInputStream(bis); // 분해된 부품을 조립하는 행위(역직렬화)

            /*
             * UserInfo_Ex15 r1 = (UserInfo_Ex15)in.readObject(); // readObject() -> 나눠진 부품을
             * 만들어진채로 읽겠다. UserInfo_Ex15 r2 = (UserInfo_Ex15)in.readObject();
             * 
             * System.out.println(r1.toString()); System.out.println(r2.toString());
             */

            // 몇개를 보내던 읽고 싶을때
            Object users = null;
            while ((users = in.readObject()) != null) {
                System.out.println(((UserInfo_Ex15) users).toString());
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지않습니다");
        } catch (EOFException eofe) {
            System.out.println("끝 " + eofe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        }finally {
            try {
                in.close();
                bis.close();
                fis.close();
            } catch (Exception e) {
            }
        }

    }

}

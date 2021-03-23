
import java.io.DataOutputStream;
import java.io.FileOutputStream;

/*
 * DataOutPutStream, DataInPutStream
 *  ㄴ 장점 : Java가 가지는 8가지 기본타입 형식(write. read)
 *           ㄴ단 자기들 끼리만
 * -> txt기록 -> 규칙적인 방법을 사용 -> 80  100  22  65 -> split -> 배열 -> 정수 -> 연산         
 */
public class Ex13_DataOutPutStream {

    public static void main(String[] args) {
        int[] score = { 100, 60, 55, 94, 23 };
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            fos = new FileOutputStream("score.txt");
            dos = new DataOutputStream(fos); // 보조역할 -> 보조가 메인을 도와줌(파일에 쓰는걸)
            for (int i = 0; i < score.length; i++) {
                dos.write(score[i]); // 배열에 있는 정수값을 write -> 단, 무조건 read는 outputstream으로 쓴건 반드시 inputstream으로 읽어라
                // dos.writeUTF(null); -> 한글, 영문 2또는 3byte 기준
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dos.close();
                fos.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }

    }

}

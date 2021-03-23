import java.io.DataInputStream;
import java.io.FileInputStream;

public class Ex14_DataInputStream {

    public static void main(String[] args) {
        int sum = 0;
        int score = 0;

        FileInputStream fis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream("score.txt");
            dis = new DataInputStream(fis);
            while (true) {
                score = dis.readInt(); // 아까 Ex_13번에서 writeInt()로 썻기때문에 readInt()로 읽는다
                System.out.println("score int 데이터 : " + score);
                sum += score;
            }
        } catch (Exception e) {
            // dis.readInt() -> 여기서 문제가 생기면 catch로 빠진다
            System.out.println(e.getMessage());
            System.out.println("sum 결과 : " + sum);
        } finally {
            try {
                dis.close();
                fis.close();
            } catch (Exception e2) {
            }
        }

    }

}

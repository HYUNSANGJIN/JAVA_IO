import java.io.File;
import java.io.IOException;

/*
 * 파일과 폴더 다루는 클랙스
 * 
 * JAVA : 파일, 폴더를 하나의 클래스 : File
 * ex) a.txt 생성, 삭제, 정보 read
 * -> Temp 폴더 생성, 삭제, 정보 read
 * 
 * c# : File클래스가 , Directory 클래스가 따로 있다.
 * 
 * 절대경로 : C:\\, D:\\ -> C:\\Temp\\a.txt
 * 상대경로 : 현재파일을 중심으로 C:\\Test -> 폴더가 하나 나가고 -> Temp로 나간다.
 * 
 */
public class Ex07_File {

    public static void main(String[] args) {

        // String path = "Lotto.txt";
        String path = "C:\\Temp2\\file.txt";
        File f = new File(path);

        // File 클래스 사용 : file 다양한 정보
        System.out.println("파일명 : " + f.getName()); // 파일명을 알려줌
        System.out.println("전체 경로 : " + f.getPath()); // 경로를 알려줌
        System.out.println("절대 경로 : " + f.getAbsolutePath()); // 절대경로
        System.out.println("너 폴더니 ?? : " + f.isDirectory()); // 폴더확인 false
        System.out.println("너 파일이니 ?? : " + f.isFile()); // 파일 확인 true
        System.out.println("파일에  크기 : " + f.length() + "byte"); // length가 byte를 읽음.(예)hello -> 5byte)
        System.out.println("부모경로 : " + f.getParent()); // 부모경로
        System.out.println("파일 폴더 실 존재 여부 : " + f.exists()); // 파일 유/무 확인 true
        try {
            System.out.println("파일 생성 : " + f.createNewFile());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // f.createNewFile() -> 파일 생성
        // f.delete() -> 파일 삭제
        // f.canRead() -> 내가 읽을 수 있을까?? -> true, false

    }

}

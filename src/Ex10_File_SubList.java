import java.io.File;

import java.util.ArrayList;
import java.util.List;

public class Ex10_File_SubList {
    static int totalfiles = 0;
    static int totaldirs = 0;

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("사용법 : java [실행할 파일명] [경로명]");
            System.out.println("예시) java Ex10_File_SubList C:\\Temp2");
            System.exit(0);
        }
        
        File f = new File(args[0]);
        if(!f.exists() || !f.isDirectory()) {  // 파일 유,무 확인 / 폴더 확인
            System.out.println("유효하지 않은 경로");
            System.exit(0);
        }
        // 여기까지오면 정상적인 경로이고 폴더라는게 확정
        printFileList(f);
        System.out.println("누적 총 파일수 : " + totalfiles);
        System.out.println("누적 총폴더수 : " + totaldirs);

    }
    static void printFileList(File dir) {
        System.out.println("[Full path : ]" + dir.getAbsolutePath());
        
        List<Integer> subdir = new ArrayList<Integer>();
        File[] files = dir.listFiles();
        
        // ex) [0] -> a.txt
        //     [1] -> 1.jpg
        //     [2] -> 2021폴더
        //     [3] -> 2022폴더
        for(int i=0; i<files.length; i++) {
            String filename = files[i].getName(); // 폴더명일수도 있고 파일명 일수도 있음
            if(files[i].isDirectory()) { // 폴더확인
                filename = "<DIR> [" + filename + " ]";
                
                //point
                subdir.add(i); // 왜??????
                // list[0] -> 2번째 방이 들어감
                // list[1] -> 3번째 방이 들어감
            }else {
                filename = filename + " / " + files[i].length() + "Byte";
            }
            System.out.println("   " + filename);
        }
        int dirnum = subdir.size();  // 폴더의 갯수를 보려는 것
        int filenum = files.length - dirnum; // 파일 갯수(폴더 전체갯수 - 폴더)
        
        // 함수가 종료 되어도 가지고 있고 싶다
        // ㄴ static 변수
        totaldirs += dirnum; // 총 누적(하위폴더)
        totalfiles += filenum; // 총 누적
        
        System.out.println("[Current dirNum] : " + dirnum);
        System.out.println("[Current fileNum] : " + filenum);
        System.out.println("****************************************");
        
        //point -> 하위폴더(폴더 안에 폴더) 보고싶당
        // 재귀호출(자신을 호출)
        for(int j=0; j<subdir.size(); j++) {
            int index = subdir.get(j);
            // 폴더가 2개이니까 처음에 들어가는건
            // index가 2라는 얘기는 2번째 방으로 들어가겠다.
            // 2번째방 -> printFileList(C:\\Temp2\\2021)
            
            // index가 3
            // 2번째방 -> printFileList(C:\\Temp2\\2022)
            printFileList(files[index]); // <- 얘가 포인트!!!! 재귀호출*********
        }
        
    }

}

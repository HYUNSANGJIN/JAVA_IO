import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// 검색기능
public class Ex12_PrintWriter_String_Finder {
    // 검색하기
    String basedir = "C:\\Temp2";  // 검색할 폴더를 써준다
    String word = "HELLO"; // 검색할 단어를 써준다
    String save = "result.txt"; // HELLO 단어가 들어있는 파일목록을 저장할거다
    
    void Find() throws IOException{ // 나를 쓴다면 io에 대한 예외처리 해주세용~throws
        File dir = new File(basedir);
        if(!dir.isDirectory()) {  // 너 디렉토리 아니니~?
            System.out.println("is not directory");
            System.exit(0); // 프로그램 강제 종료
        }
        
        PrintWriter writer = new PrintWriter(new FileWriter(save)); // 함수안에 썻다는 것은 한번 쓰고 버린단 내용!
        BufferedReader br = null; // 버퍼 하나 만들어줌
        
        File[] files = dir.listFiles();  // 목록(파일, 폴더) 하나식 다 가져올거임
        for(int i=0; i<files.length; i++) {
            if(!files[i].isFile()) { // 너 파일 아니지!
                System.out.println("This it not File");
                continue; // 스킵해라!(파일이 아닌경우에는 스킵)
            }
            // 파일이라면(~~.txt)
            br = new BufferedReader(new FileReader(files[i]));
            
            // 파일안에 한 문장씩 read하면서 검색할거야(HELLO 글자를 읽을거야)
            String line = "";
            while((line = br.readLine()) != null) {
                if(line.indexOf(word) != -1) { // 현재 read한 문장이 HELLO라는 단어가 하나라도 있는거다.
                    System.out.println("I got it");
                    writer.write("word = " + files[i].getAbsolutePath() + "\n"); // getAbsolutePath() 
                }
            }
            writer.flush();
            
        }
        br.close();
        writer.close();
        
    }

    public static void main(String[] args) {
        Ex12_PrintWriter_String_Finder StringFineder = new Ex12_PrintWriter_String_Finder();
        try {
            StringFineder.Find();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

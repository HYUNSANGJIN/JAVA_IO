package kr.or.bit;

import java.io.Serializable;

/*
 * 객체 통신
 * 객체(Car, Tv) , 네트워크 또는 파일(txt read, write), 프로세스 간에 통신을 할 수 있는것
 *  ㄴ 직렬화 : 객체를 분해해서 줄을 세워 보내는 전방적인 과정 
 *  ㄴ 역직렬화 : 객체를 조립하는 과정
 *  
 * 역직렬화 
 *  ㄴ실습
 *    ㄴ대상 -> 파일에다가 -> UserInfo객체에 write(직렬화)
 *    ㄴ대상 -> 파일 -> 직렬화된 UserInfo객체를 read해서 다시 조립한다.
 *    
 * 조립식 : 본드를 붙여서 조립하는방식
 * 레고식  : 붙였다가 떼고 할 수 있는거
 *  ㄴ implements Serializable(레고식 : 조립했다가 분해할 수 있음)
 */
public class UserInfo_Ex15 implements Serializable {  // implements Serializable -> 레고식
    private String name;
    private String pwd;
    private int age;
    
    public UserInfo_Ex15() {
        super();
    }
    

    public UserInfo_Ex15(String name, String pwd, int age) {
        super();
        this.name = name;
        this.pwd = pwd;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "UserInfo_Ex15 [name=" + name + ", pwd=" + pwd + ", age=" + age + "]";
    }
    
    
    
    

}

package com.company;
/*

 */
import java.util.Random;
import java.util.Scanner;

public class Lotto {      //생성자1 / 메뉴 / numbers setter / 중복제거 / 정렬 / 프린트 / 평균
    private int[] numbers;
    private Scanner sc;
    private Random r ;

    public Lotto(){                     //생성자
        numbers = new int[6];
        sc = new Scanner(System.in);
        r = new Random();
    }

    public int menuChoice(){            //메뉴 선택
        System.out.println("********************************");
        System.out.println("***   1. 당첨예상번호 추출하기  ***");
        System.out.println("***      2. 프로그램 종료      ***");
        System.out.println("********************************");
        System.out.println();
        System.out.println("원하는 메뉴 번호를 누르세요...");
        int menu = 0;
        menu = sc.nextInt();

        return menu;                //선택한 메뉴를 반환
    }

    public void setNumbers() { //로또 생성기
        for(int i=0; i< this.numbers.length; i++){
            this.numbers[i] = r.nextInt(45)+1;
        }
//            int tmp_num=r.nextInt(45)+1;
//
//            for(int j=0; j<=i; j++){
//                if(this.numbers[j]==tmp_num){
//                    dupli_Verification();
//                }
//            }
//            this.numbers[i] = tmp_num;
                                            // REVIEW!!!
        dupli_Verification();               // 논리적인 제어가 필요하다. 만약 로또배열이 생성되면 중복제거 함수를 호출하고
        lotto_Sort();                       // 중복제거 함수가 정상적으로 작동했다면 정렬을 하고 ->
        lotto_print();                      // 정렬을 정상적으로 작동했다면 출력을 하게 만들기!!
    }

    public void dupli_Verification(){                       //중복제거함수를 호출하면 한번에 쭉 보면서 중복되는지 확인
        for(int i=0; i<this.numbers.length-1; i++){
            for(int j=i+1; j<this.numbers.length;j++){
                if(this.numbers[i] == this.numbers[j]){     //중복 체크시 다시 난수생성하여 대입 후 j--
//                    System.out.println("중복제거 함수 실행");
                    numbers[j]=r.nextInt(45)+1;
                    j--;
                }
            }
        }
    }

    public void lotto_Sort(){// 정렬메소드
//        System.out.println("정렬메소드 실행");
        for(int i=0; i<this.numbers.length-1;i++) {
            if(this.numbers[i] > this.numbers[i+1]) {
                int tmp = this.numbers[i];
                this.numbers[i] = this.numbers[i+1];
                this.numbers[i+1] = tmp;
                i=-1;
            }
        }

    }
    public void lotto_print(){             //출력 메소드
        int avg=0;
        for(int i : this.numbers){          //전체값 합계 구하기
            avg+=i;
        }
        avg = avg/this.numbers.length;      //합계값을 평균으로

        System.out.printf("평균 : %d\n",avg);
        System.out.println("[ 선택한 Lotto 번호 ]");
        for(int i : this.numbers){              //로또 번호 전체 프린트
            System.out.printf("[ %d ] ",i);
        }
        System.out.println();
    }

}

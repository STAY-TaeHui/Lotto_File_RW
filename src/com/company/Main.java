package com.company;

public class Main {
    public static void main(String[] args){ // REVIEW!!!
        while(true) {                       // =======>>>>>>>>>>>>>>>>> ��׸� �Լ��� ����
            Lotto lt = new Lotto(); //��ü������ ������ ȣ��

            switch (lt.menuChoice()) { //menu ����
                case 1: {               //1�϶� �ζǻ����� ȣ��� print
                    lt.setNumbers();
                    lt.lotto_print();
                    break;
                }
                case 2: {               //2�϶� ���α׷� ����
                    System.out.println("���α׷��� �����մϴ�.");
                    System.out.println("Good Luck!!!!!");
                    System.exit(0);
                }
                default:{
                    System.out.println("�޴��� �ٽ� ������ �ּ���.");
                }
            }
        }
//        Lotto_LeeDong lotto = new Lotto_LeeDong();
//        lotto.selectLottoNumbers();


    }
}

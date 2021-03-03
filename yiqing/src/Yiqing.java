import java.util.Scanner;

public class Yiqing{
    public static void main(String[] args) {
        Ganran model = new Ganran();
        int i,check;
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入选择项：");
        System.out.println("是否佩戴口罩（1为是0为否）：");
        do {
            check = 1;
            i = scan.nextInt();
           //不佩戴口罩b=0.25，佩戴口罩b=0.1
            if(i==0){
                model.setB(0.25);
            }else if(i==1){
                model.setB(0.1);
            }else {
                check = 0;
                System.out.println("输入有误，请重新输入：");
            }
        }while(check == 0);
        System.out.println("是否限制出行（1为是0为否）：");
        do {
            check = 1;
            i = scan.nextInt();
            //不限制出行e=1，限制出行e=0.5
            if(i==0){
                model.setE(1);
            }else if(i==1){
                model.setE(0.5);
            }else {
                check = 0;
                System.out.println("输入有误，请重新输入：");
            }
        }while(check == 0);
        System.out.println("是否增设医院（1为是0为否）：");
        do {
            check = 1;
            i = scan.nextInt();
            //不增设医院c=0.04，d=0.01，增设医院c=0.08，d=0.005
            if(i==0){
                model.setBed(50);
                model.setC(0.04);
                model.setD(0.01);
            }else if(i==1){
                model.setBed(100);
                model.setC(0.08);
                model.setD(0.005);
            }else {
                check = 0;
                System.out.println("输入有误，请重新输入：");
            }
        }while(check == 0);
        model.change();
    }
}
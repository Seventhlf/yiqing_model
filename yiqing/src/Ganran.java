import java.util.ArrayList;
import java.util.Random;

public class Ganran {

    //b为接触后感染率，c为恢复率，d为死亡率，e为出行率
    public static double b,c,d,e;
    //bed为病床数
    public static int bed;
    //设置各类值
    public void setB(double b) {
        this.b = b;
    }
    public void setC(double c) {
        this.c = c;
    }
    public void setD(double d) {
        this.d = d;
    }
    public void setE(double e) {
        this.e = e;
    }
    public void setBed(int bed){
        this.bed = bed;
    }
    //S为易感者，I为感染者，R为恢复者，D为死亡者
    public void printf(int day,int S,int I,int R,int D){
        System.out.println("第" + day + "天：");
        System.out.println("易感者：" + S);
        System.out.println("感染者：" + I);
        System.out.println("恢复者：" + R);
        System.out.println("死亡者：" + D);
    }

    public void change(){
        Random rand = new Random();
        ArrayList people = new ArrayList<>();
        for(int i = 0;i <5000;i++){
            People a = new People();
            a.state = 1;
            people.add(a);
        }
        for(int i = 0;i < 10;i++){
            People a = (People) people.get(i);
            a.state = 2;
            people.set(i,a);
        }
        //S为易感者，I为感染者，R为恢复者，D为死亡者
        int S,D,I,R;
        //days为总共天数，count为累计确诊，day为第几天控制住疫情（感染者均住院即为控制住疫情），control为未住院感染者
        int days = 1,count = 10,control = 10,day = 0,h = 0;
        //初始4990个易感者，10个感染者
        S = 4990;
        I = 10;
        R = 0;
        D = 0;
        while(I != 0){
            if(control == 0){
                if(h == 0){
                    day = days;
                }
                h++;
            }
            days++;
            printf(days,S,I,R,D);
            //人群移动
            for(int i = 0;i < 5000;i++){
                People a = (People) people.get(i);
                if(a.state == 1 || a.state == 2 || a.state == 0){
                    a.move();
                    people.set(i,a);
                }
            }
            for(int i = 0;i < 5000;i++){
                People a = (People)people.get(i);
                if(a.state == 1){
                    for(int j = 0;j < 5000;j++){
                        People aa = (People) people.get(j);
                        if(i != j){
                            double num = Math.pow(a.x-aa.x,2) + Math.pow(a.y-aa.y,2);   //易感者与感染者距离
                            double be = b*e;    //感染率
                            if(rand.nextDouble() < be && aa.state == 2 && control != 0 && num < 36){//与感染者距离小于6易感者感染
                                a.state = 2;
                                people.set(i,a);
                                S--;
                                I++;
                                count++;
                                control++;
                                break;
                            }
                        }
                    }
                }else if(a.state == 2){
                    if(rand.nextDouble() <= c){//感染者恢复
                        a.state = 0;
                        people.set(i,a);
                        I--;
                        R++;
                        control--;
                    }else if(rand.nextDouble() <= d){//感染者死亡
                        a.state = 3;
                        people.set(i,a);
                        I--;
                        D++;
                        control--;
                    }else if(--a.date <= 0 && bed > 0){//感染者住院隔离
                        a.state = 4;
                        people.set(i,a);
                        bed--;
                        control--;
                    }
                }else if(a.state == 4){
                    if(rand.nextDouble() <= c){//住院者恢复
                        a.state = 0;
                        people.set(i,a);
                        I--;
                        bed++;
                        R++;
                    }else if(rand.nextDouble() <= d){//住院者死亡
                        a.state = 3;
                        people.set(i,a);
                        I--;
                        D++;
                        bed++;
                    }
                }
            }
        }
        printf(days,S,I,R,D);
        System.out.println("\n共经历：" + days + "天");
        System.out.println("累计确诊：" + count);
        System.out.println("未感染人数：" + S);
        System.out.println("感染恢复人数：" + R);
        System.out.println("累计死亡人数：" + D);
        System.out.println("第" + day + "天控制住疫情");
    }
}

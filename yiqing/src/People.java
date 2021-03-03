import java.util.Random;

public class People {
    public double x;
    public double y;
    public int state;
    public double date;

    public People(){
        Random rand = new Random();
        this.date = rand.nextInt(14);
        this.x = 400*rand.nextDouble();
        this.y = 400*rand.nextDouble();
    }
    public void move(){
        Random rand = new Random();
        this.x = (rand.nextGaussian() + this.x) % 400;
        this.y = (rand.nextGaussian() + this.y) % 400;
    }
}

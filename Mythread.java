import java.awt.*;

public class Mythread extends Thread {
    public int second=00,minutes=00,hours=00;
    public String Time = hours+":"+minutes+":"+second;
    @Override
    public void run() {
        for(int i = 1; i <= 60; i++) {
            second=i;
            Time=hours+":"+minutes+":"+second;
            System.out.println(Time);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(second==60){
                minutes=minutes+1;
                i=0;
            }
            if(minutes==60){
                minutes=0;
                second=0;
                hours=hours+1;
            }
        }
    }
}

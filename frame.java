import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame extends JFrame implements ActionListener {
    JButton startbutton = new JButton("Start");
    JButton stopbutton = new JButton("Stop");


    Mythread counter = new Mythread();

    JLabel timerlabel = new JLabel(counter.Time);


    public frame(){
        this.setBounds(0,0,500,500);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Soham's Stopwatch");
        this.add(startbutton);
        this.add(stopbutton);
        this.add(timerlabel);

        this.startbutton.setBounds(100,300,100,50);
        this.startbutton.setFocusable(false);
        this.startbutton.addActionListener(this);

        this.timerlabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        this.timerlabel.setBounds(220,100,100,50);
        this.timerlabel.setFocusable(false);

        this.stopbutton.setBounds(300,300,100,50);
        this.stopbutton.setFocusable(false);
        this.stopbutton.addActionListener(this);

        updatetimer();
    }
    void updatetimer(){
        while(true) {
            this.timerlabel.setText(counter.Time);
        }
    }

    public void paint(Graphics g){
        g.drawRect(100,100,300,100);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startbutton){
            System.out.println("counter Started");
            counter.start();
        }
        if(e.getSource() == stopbutton){
            System.out.println("counter Stopped");
            counter.interrupt();
        }
    }
}

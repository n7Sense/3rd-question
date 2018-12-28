/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zonehandler;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author nSense
 */
public class ZoneHandler   extends JFrame implements ActionListener, MouseListener{

     JPanel panel = new JPanel(), panel2 = new JPanel(), panel3 = new JPanel();
    JXDatePicker picker;
    DateTimeFormatter fmt;
    DateTime dateTime = new DateTime();
    
    String []timeZone = {"Asia/Kolkata", "Asia/Singapore" , "America/New_York", " Asia/Kathmandu", "Asia/Karachi", "Asia/Vientiane"};
    JComboBox<String> jcb, jcb2;
    JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6;
    JLabel l1, l2, l3, l4, l5;
    JRadioButton rb1, rb2;
    JButton b1;
    Font font = new Font("Courier", Font.BOLD,20);
    public ZoneHandler(){
        super("Time Zone Handler");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        jcb = new JComboBox<String>();
        for(String name : timeZone)
            jcb.addItem(name);
        
        
        
        jtf1 = new JTextField(10);
        jtf1.setText("DD/MM/YYYY");
        jtf1.setFont(font);
        jtf1.setEditable(false);
        jtf2 = new JTextField(5);
        jtf2.setFont(font);
        jtf2.setText("HH : MM");
        jtf2.setEditable(false);
        jtf3 = new JTextField(10);
        jtf3.setFont(font);
        jtf3.setText("Day");
        jtf3.setEditable(false);
        jtf4 = new JTextField(10);
        jtf4.setFont(font);
        jtf4.setText("Month");
        jtf4.setEditable(false);
        
        l1=new JLabel("Select Destination Time Zone");
        l5 = new JLabel("Select Source Time Zone");
        l5.setFont(font);
        rb1 = new JRadioButton("12-HRS-Format");
        rb1.setSelected(true);
        rb2 = new JRadioButton("24-HRS-Format");
      
       // panel.setLayout(new FlowLayout());
        jtf5  = new JTextField(6);
        jtf5.addMouseListener(this);
        jtf5.setFont(font);
        jtf5.setText("Hour");
        jtf6  = new JTextField(6);
        jtf6.addMouseListener(this);
        jtf6.setFont(font);
        jtf6.setText("Minute");
        
        l1 = new JLabel("Select Date");
        l1.setFont(font);
        picker = new JXDatePicker();
        picker.setFont(font);
        
        //panel.add(l1);panel.add(picker);panel.add(jtf5);panel.add(jtf6);
        //add(panel);
        
        
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        
        b1 = new JButton("Click Me");
        b1.addActionListener(this);
        add(l5);add(jcb);
        add(rb1);
        add(rb2);
        
        
        add(b1);
        
      
        add(jtf1);add(jtf2);add(jtf3);add(jtf4);
        
    }
    
    public static void main(String[] args) {
        
        ZoneHandler tzh = new ZoneHandler();
        tzh.setSize(600, 500);
        tzh.setVisible(true);
        tzh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        dateTime = dateTime.withZone(DateTimeZone.forID(jcb.getSelectedItem().toString()));
        
        String date=""+dateTime.getDayOfMonth()+"/"+dateTime.getMonthOfYear()+"/"+dateTime.getYear();
        jtf1.setText(date);
        
        
        fmt = DateTimeFormat.forPattern("a");
        String amOrPm = fmt.print(dateTime);
        int minute = dateTime.getMinuteOfDay();
        if(rb2.isSelected()){
            int hour = dateTime.getHourOfDay();
            jtf2.setText(((hour==0)? 12 : hour)+" : "+minute+" "+amOrPm);
        }else{
            fmt = DateTimeFormat.forPattern("h");
            String hour = fmt.print(dateTime);
            System.out.println(hour);
            jtf2.setText(hour+" : "+minute+" "+amOrPm);
        }
        
        
        
       
        
        
        try{Thread.sleep(100);}catch(InterruptedException ie){}
        
        
        
        
        switch(dateTime.getDayOfWeek()){
            case 1:   jtf3.setText("Monday");
                        break;
            case 2:   jtf3.setText("Tuesday");
                        break;
            case 3:   jtf3.setText("Wednesday");
                        break;
            case 4:   jtf3.setText("Thursday");
                        break;
            case 5:   jtf3.setText("Frieday");
                        break;
            case 6:   jtf3.setText("Saturday");
                        break;
            case 7:   jtf3.setText("Sunday");
                        break; 
        }
        switch (dateTime.getMonthOfYear()) {
            case 1:
                jtf4.setText("January");
                break;
            case 2:
                jtf4.setText("February");
                break;
            case 3:
                jtf4.setText("March");
                break;
            case 4:
                jtf4.setText("April");
                break;
            case 5:
                jtf4.setText("Jun");
                break;
            case 6:
                jtf4.setText("Jun");
                break;
            case 7:
                jtf4.setText("Julay");
                break;
            case 8:
                jtf4.setText("August");
                break;
            case 9:
                jtf4.setText("September");
                break;
            case 10:
                jtf4.setText("Octomber");
                break;
            case 11:
                jtf4.setText("November");
                break;
            case 12:
                jtf4.setText("December");
                break;
        }
        
 
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
         if(e.getSource().equals(jtf5))
            jtf5.setText("");
        if(e.getSource().equals(jtf6))
            jtf6.setText("");
        
        
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
     System.out.println("released");  
    }

    @Override
    public void mouseEntered(MouseEvent e) {
     System.out.println("entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
       System.out.println("exited");
    }
}

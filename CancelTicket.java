
package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import java.util.*;

public class CancelTicket extends JFrame implements ActionListener {
    
    JTextField tfPNR;
      JLabel tfname,lblfcode,lbldate,cancellationno;
      JButton fetchFlights,fetchButton;
       
    
   public  CancelTicket(){
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       Random random=new Random();
        
       JLabel  heading=new JLabel("CANCELLATION");
       heading.setBounds(180,20,250,35);
       heading.setFont(new Font("Tahoma",Font.PLAIN,32));
       add(heading);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icons/cancel.jpg"));
       Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(470,120,250,250);
       add(image);
       
       
       
         JLabel  lblAadhar=new JLabel("PNR number");
       lblAadhar.setBounds(60,80,150,25);
       lblAadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblAadhar);
       
         tfPNR=new JTextField();
       tfPNR.setBounds(220,80,150,25);
       add(tfPNR);
       
        fetchButton=new JButton("Fetch User");
       fetchButton.setBackground(Color.BLACK);
       fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380,80,120,25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        
        JLabel  lblname=new JLabel("Name");
       lblname.setBounds(60,130,150,25);
       lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblname);
       
       tfname=new JLabel();
       tfname.setBounds(220,130,150,25);
       add(tfname);
       
         JLabel  lblnationality=new JLabel("Cancellation No");
       lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblnationality);
       
         cancellationno=new JLabel("" +random.nextInt(1000000));
      cancellationno.setBounds(220,180,150,25);
       add(cancellationno);
      
      
       JLabel  lblAddress=new JLabel("Flight code");
       lblAddress.setBounds(60,230,150,25);
       lblAddress.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblAddress);
       
        lblfcode=new JLabel();
        lblfcode.setBounds(220,230,150,25);
       add(lblfcode);
       
        JLabel  lblgender=new JLabel("Date");
       lblgender.setBounds(60,280,150,25);
       lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblgender);
       
       lbldate=new JLabel();
        lbldate.setBounds(220,280,150,25);
       add(lbldate);
            
          
        fetchFlights=new JButton("Cancel");
      fetchFlights.setBounds(220,330,120,25);
       fetchFlights.setBackground(Color.BLACK);
       fetchFlights.setForeground(Color.WHITE);
     fetchFlights.addActionListener(this);
       add(fetchFlights);
       
    
       
       
       setSize(800,450);
       setLocation(350,150);
       setVisible(true);
   } 
       public void  actionPerformed(ActionEvent ae){
           if(ae.getSource()== fetchButton){
            
          String pnr=tfPNR.getText();
         
        
             try {
             Conn conn=new Conn();
              String query="SELECT * FROM reservation where PNR='"+pnr+"'";
              ResultSet rs=conn.s.executeQuery(query);
              if(rs.next()){
                  tfname.setText(rs.getString("name"));
                   lblfcode.setText(rs.getString("flightcode"));
                   lbldate.setText(rs.getString("ddate"));
                  
              }
                  
               else{
                  JOptionPane.showMessageDialog(null,"please enter correct PNR");
              }
            }
              
             catch(Exception e){
                e.printStackTrace();
             }
           }
       
       
        
  
          else if(ae.getSource()== fetchFlights){
            
          String name=tfname.getText();
          String pnr=tfPNR.getText();
          String cancelno=cancellationno.getText();  
          String fcode=lblfcode.getText();
          String date=lbldate.getText();
             try {
             Conn conn=new Conn();
              String query="INSERT INTO cancel (PNR, name, cancelno, fcode, ddate) VALUES ('" + pnr + "', '" + name + "', '" + cancelno + "', '" + fcode + "', '" + date + "')";

              conn.s.executeUpdate(query);
              conn.s.executeUpdate("delete from reservation where PNR='"+pnr+"'");
             
                  
               
                  JOptionPane.showMessageDialog(null,"Ticket cancelled ");
                  setVisible(false);
              
            }
              
             catch(Exception e){
                e.printStackTrace();
             }
           }
        
              
               
          
   
       
       }
   public static void main(String args[]){
        new  CancelTicket();
     
}
    
}

    


    

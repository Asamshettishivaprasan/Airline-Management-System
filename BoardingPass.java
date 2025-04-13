
package airline.management.system;
      
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener {
      JTextField tfpnr;
      JLabel tfname,tfnationality,lblsrc,lbldes,tfPhonenumber,labelgender,labeldate, labelfname, labelfcode;
      JButton fetchButton;
      
      
    
   public  BoardingPass(){
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
        
       JLabel  heading=new JLabel("AIR INDIA");
       heading.setBounds(380,10,450,35);
       heading.setFont(new Font("Tahoma",Font.PLAIN,32));
      
       add(heading);
       
         JLabel  subheading=new JLabel("Boarding pass");
      subheading.setBounds(360,50,300,30);
       subheading.setFont(new Font("Tahoma",Font.PLAIN,24));
       subheading.setForeground(Color.BLUE);
       add(subheading);
       
       
         JLabel  lblAadhar=new JLabel("PNR details");
       lblAadhar.setBounds(60,100,150,25);
       lblAadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblAadhar);
       
         tfpnr=new JTextField();
       tfpnr.setBounds(220,100,150,25);
       add(tfpnr);
       
         fetchButton=new JButton("Enter");
       fetchButton.setBackground(Color.BLACK);
       fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380,100,120,25);
        fetchButton.addActionListener(this);
        add(fetchButton);
       
       
     
        
        
        JLabel  lblname=new JLabel("Name");
       lblname.setBounds(60,140,150,25);
       lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblname);
       
       tfname=new JLabel();
       tfname.setBounds(220,140,150,25);
       add(tfname);
       
         JLabel  lblnationality=new JLabel("Nationality");
       lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblnationality);
       
         tfnationality=new JLabel();
       tfnationality.setBounds(220,180,150,25);
       add(tfnationality);
      
      
       JLabel  lblAddress=new JLabel("src");
       lblAddress.setBounds(60,220,150,25);
       lblAddress.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblAddress);
       
        lblsrc=new JLabel();
        lblsrc.setBounds(220,220,150,25);
       add(lblsrc);
       
        JLabel  lblgender=new JLabel("des");
       lblgender.setBounds(380,220,150,25);
       lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblgender);
       
       lbldes=new JLabel();
       lbldes.setBounds(540,220,150,25);
       add(lbldes);
            
       
       
      
       
       
       JLabel  lblfname=new JLabel("Flight Name");
       lblfname.setBounds(60,260,150,25);
       lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblfname);
       
        labelfname=new JLabel();
        labelfname.setBounds(220,260,150,25);
       add(labelfname);
       
       
       
       JLabel  lblfcode=new JLabel("Flight Code");
       lblfcode.setBounds(380 ,260,150,25);
     lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblfcode);
       
        labelfcode=new JLabel();
        labelfcode.setBounds(540,260,150,25);
       add(labelfcode);



       JLabel  lbldate=new JLabel("Date");
       lbldate.setBounds(60,300,150,25);
     lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lbldate);
       
         labeldate=new JLabel();
            labeldate.setBounds(220,300,150,25);
       add( labeldate);
              
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icons/airindia.png"));
       Image i2=i1.getImage().getScaledInstance(300,230,Image.SCALE_DEFAULT);
       ImageIcon image = new ImageIcon(i2);
       JLabel lblimage=new JLabel(image);
       lblimage.setBounds(600,0,300,300);
       add(lblimage);
       
       
       
       setSize(1000,450);
       setLocation(300,150);
       setVisible(true);
   } 
       public void  actionPerformed(ActionEvent ae){
         
            
          String pnr=tfpnr.getText();
         
        
             try {
             Conn conn=new Conn();
              String query="SELECT * FROM reservation where PNR='"+pnr+"'";
              ResultSet rs=conn.s.executeQuery(query);
             if(rs.next()){
                  tfname.setText(rs.getString("name"));
                  tfnationality.setText(rs.getString("Nationality"));
                  lblsrc.setText(rs.getString("src"));
                  labelfname.setText(rs.getString("flightname"));
                   labeldate.setText(rs.getString("ddate"));
                  lbldes.setText(rs.getString("des"));
                          
                                 
                  labelfcode.setText(rs.getString("flightcode"));
                   
              }
                  
               else{
                  JOptionPane.showMessageDialog(null,"please enter correct PNR");
              }}
              
             catch(Exception e){
                e.printStackTrace();
             }
             }
          
       
   public static void main(String args[]){
        new  BoardingPass();
     
}}


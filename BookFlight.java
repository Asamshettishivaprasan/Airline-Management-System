
package airline.management.system;
      
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight  extends JFrame implements ActionListener {
      JTextField tfAadhar;
      JLabel tfname,tfnationality,tfAddress,tfPhonenumber,labelgender,labelfname,labelfcode;
      JButton Bookticket,fetchFlights,fetchButton;
      Choice source,destination;
      JDateChooser dcdate;
    
   public  BookFlight (){
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
        
       JLabel  heading=new JLabel("Book Flight ");
       heading.setBounds(420,20,500,35);
       heading.setFont(new Font("Tahoma",Font.PLAIN,32));
       heading.setForeground(Color.BLUE);
       add(heading);
       
       
       
         JLabel  lblAadhar=new JLabel("Aadhar");
       lblAadhar.setBounds(60,80,150,25);
       lblAadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblAadhar);
       
         tfAadhar=new JTextField();
       tfAadhar.setBounds(220,80,150,25);
       add(tfAadhar);
       
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
       
         JLabel  lblnationality=new JLabel("Nationality");
       lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblnationality);
       
         tfnationality=new JLabel();
       tfnationality.setBounds(220,180,150,25);
       add(tfnationality);
      
      
       JLabel  lblAddress=new JLabel("Address");
       lblAddress.setBounds(60,230,150,25);
       lblAddress.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblAddress);
       
        tfAddress=new JLabel();
        tfAddress.setBounds(220,230,150,25);
       add(tfAddress);
       
        JLabel  lblgender=new JLabel("Gender");
       lblgender.setBounds(60,280,150,25);
       lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblgender);
       
       labelgender=new JLabel();
       labelgender.setBounds(220,280,150,25);
       add(labelgender);
            
        JLabel  lblsource=new JLabel("source");
       lblsource.setBounds(60,330,150,25);
       lblsource.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblsource);
       
        source=new Choice();
       source.setBounds(220,330,150,25);
       add(source);
       
       
        JLabel  lbldest=new JLabel("destination");
        lbldest.setBounds(60,380,150,25);
        lbldest.setFont(new Font("Tahoma",Font.PLAIN,16));
       add( lbldest);
      
         destination=new Choice();
       destination.setBounds(220,380,150,25);
       add(destination);
       
       try{
           Conn c=new Conn();
           String query="SELECT * FROM flight";
           ResultSet rs=c.s.executeQuery(query);
           
           while(rs.next()){
               source.add(rs.getString("source"));
               destination.add(rs.getString("destination"));
           }
           
       }
       catch(Exception e){
           e.printStackTrace();
       }
       
       
       
        fetchFlights=new JButton("Fetch");
      fetchFlights.setBounds(380,380,120,25);
       fetchFlights.setBackground(Color.BLACK);
       fetchFlights.setForeground(Color.WHITE);
     fetchFlights.addActionListener(this);
       add(fetchFlights);
       
       
       JLabel  lblfname=new JLabel("Flight Name");
       lblfname.setBounds(60,430,150,25);
       lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblfname);
       
        labelfname=new JLabel();
        labelfname.setBounds(220,430,150,25);
       add(labelfname);
       
       
       
       JLabel  lblfcode=new JLabel("Flight Code");
       lblfcode.setBounds(60,480,150,25);
     lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblfcode);
       
        labelfcode=new JLabel();
        labelfcode.setBounds(220,480,150,25);
       add(labelfcode);



       JLabel  lbldate=new JLabel("Date of travel");
       lbldate.setBounds(60,530,150,25);
     lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lbldate);
       
         dcdate=new JDateChooser();
            dcdate.setBounds(220,530,150,25);
       add( dcdate);
              
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icons/details.jpg"));
       Image i2=i1.getImage().getScaledInstance(450,320,Image.SCALE_DEFAULT);
       ImageIcon image = new ImageIcon(i2);
       JLabel lblimage=new JLabel(image);
       lblimage.setBounds(550,80,500,410);
       add(lblimage);
       
          Bookticket=new JButton("Book Flight");
       Bookticket.setBackground(Color.BLACK);
        Bookticket.setForeground(Color.WHITE);
         Bookticket.addActionListener(this);
        Bookticket.setBounds(220,580,150,25);
        add(Bookticket);
        
       
       
       setSize(1100,700);
       setLocation(200,50);
       setVisible(true);
   } 
       public void  actionPerformed(ActionEvent ae){
           if(ae.getSource()== fetchButton){
            
          String aadhar=tfAadhar.getText();
         
        
             try {
             Conn conn=new Conn();
              String query="SELECT * FROM passenger where aadhar='"+aadhar+"'";
              ResultSet rs=conn.s.executeQuery(query);
              if(rs.next()){
                  tfname.setText(rs.getString("name"));
                          tfnationality.setText(rs.getString("nationality"));
                                  tfAddress.setText(rs.getString("address"));
                                   labelgender.setText(rs.getString("gender"));
              }
                  
               else{
                  JOptionPane.showMessageDialog(null,"please enter correct aadhar");
              }
            }
              
             catch(Exception e){
                e.printStackTrace();
             }
           }
       
        
          else if(ae.getSource()== fetchFlights){
            
          String src=source.getSelectedItem();
          String dest=destination.getSelectedItem();
             try {
             Conn conn=new Conn();
              String query="SELECT * FROM flight where source='"+src+"' AND destination='"+dest+"'";
              ResultSet rs=conn.s.executeQuery(query);
              if(rs.next()){
                  labelfname.setText(rs.getString("f_name"));
                  labelfcode.setText(rs.getString("f_code"));
                                  
              }
                  
               else{
                  JOptionPane.showMessageDialog(null,"No flights found");
              }
            }
              
             catch(Exception e){
                e.printStackTrace();
             }
           }
          else{
              Random random=new Random();
              String aadhar=tfAadhar.getText();
              String name=tfname.getText();
              String nationality=tfnationality.getText();
              String flightname=labelfname.getText();
              String flightcode=labelfcode.getText();
              String src=source.getSelectedItem();
              String des=destination.getSelectedItem();
              String ddate=((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
              
               try {
             Conn conn=new Conn();
              String query="INSERT INTO reservation VALUES('PNR-"+random.nextInt(1000000)+"', 'TICKET-"+random.nextInt(10000)+"','"+aadhar+"','"+name+"','"+nationality+"','"+flightname+"','"+flightcode+"','"+src+"','"+des+"','"+ddate+"')";
              
              conn.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Ticket booked successfully");
              setVisible(false);
                  
              
              
            }
              
             catch(Exception e){
                e.printStackTrace();
             }
           }
              
          
   
       
       }
   public static void main(String args[]){
        new  BookFlight();
     
}
    
}

    


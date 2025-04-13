/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
    
public class Home extends JFrame implements ActionListener{  //we use swing so jframe we extend
    
    
    public Home(){
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icons/front.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1600,800);
        add(image);
        
        JLabel heading=new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(500,40,1000,40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma",Font.PLAIN,36));
        image.add(heading);
        
        JMenuBar menubar=new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details=new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails=new JMenuItem("flight details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
      
          
        JMenuItem customerDetails=new JMenuItem("customer details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
       
        
          
        JMenuItem bookFlight=new JMenuItem("booking details");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
          
        JMenuItem journeyDetails=new JMenuItem("journey details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
       
          
        JMenuItem ticketCancellation=new JMenuItem("cancel ticket");
       ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
        
        JMenu Ticket=new JMenu("Ticket");
          Ticket.setForeground(Color.RED);
           Ticket.setFont(new Font("Tahoma",Font.PLAIN,13));
        menubar.add(Ticket);
        
        JMenuItem boardingPass=new JMenuItem("Boarding pass");
         boardingPass.addActionListener(this);
        Ticket.add(boardingPass);
        
        
         
       
        
       setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setLocation(600,250);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String text=ae.getActionCommand();
       if(text.equals("flight details")){
           new FlightInfo();
       }
       else if(text.equals("customer details")){
        new AddCustomer();
    }
       else if (text.equals("booking details")){
           new BookFlight();
       }
       else if(text.equals("journey details")){
           new JourneyDetails();
       }
       else if(text.equals("cancel ticket")){
           new CancelTicket();
       }
       else if(text.equals("Boarding pass")){
           new BoardingPass();
       }
        
    }
    
    public static void main(String args[]){
        new Home();
    }
    
}

    
    


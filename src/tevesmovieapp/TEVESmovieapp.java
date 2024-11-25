
package tevesmovieapp;

import java.util.Scanner;

public class TEVESmovieapp {
config conf = new config();

    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
         try{
         
           System.out.println("1. customer: ");
        System.out.println("2. Staffs: ");
        System.out.print("Select user: ");
        int user = sc.nextInt();
        
        while(user> 2){ 
        System.out.print("try again : ");        
        user = sc.nextInt();}
        TEVESmovieapp map = new TEVESmovieapp();
        switch(user){
            case 1:
                map.caccnt();
            break;
            case 2:
                System.out.print("Enter password: ");
                String pass = sc.next();
                while(!(pass.equals("pass1234"))){
                    System.out.print("Incorrect password, try again: ");
                    pass = sc.next();
                }
                System.out.println("------------------------------------------------------------------");
                System.out.println("correct password\n");
                
                map.menu();
            break;
        }
       
             
         }catch(Exception e){
              System.out.print("enter a valid character");
          }
       
     
       
      }    
    public void menu(){   
      String resp;
        Scanner sc = new Scanner(System.in);
        movies mapp = new movies();
         try{
         
           do{
          System.out.println("-------------------------------");
          System.out.println("| MOVIE TICKETING APPLICATION |");
          System.out.println("-------------------------------");
          System.out.println("MAIN MENU");
          System.out.println("1. MOVIES");
          System.out.println("2. CUSTOMERS");
          System.out.println("3. BUY TICKETS");
          System.out.println("4. VIEW");
          System.out.println("5. EXIT");
          System.out.print("Enter choice: ");
          int choice = sc.nextInt();
          while(choice> 5){ 
            System.out.print("try again: ");
            choice = sc.nextInt();
    }       report rp = new report(); 
            transact trn = new transact();
            customer cst = new customer();
             switch(choice){
                 case 1:
                     
                     mapp.options();
                     break;
                 case 2:
                    
                      cst.options();
                     break;
                 case 3:
                     trn.options();
                     break;    
                 case 4:
                     rp.report();
                     break;
                 case 5:
                    TEVESmovieapp map = new TEVESmovieapp();
                    map.exitApp();
                     break;
                                                               
             }                                          
          System.out.print("do another transaction (yes/no): ");
          resp = sc.next();
      }while(resp.equalsIgnoreCase("yes"));
             
         }catch(Exception e){
              System.out.print("rnter a valid character");
          }
       
    
    }
    
    public void caccnt () {
     Scanner sc = new Scanner(System.in);
     String resp;
      try{
      do{
      System.out.print("\t CUSTOMER SELECTION ");
       System.out.print("\n1. Add account");
       System.out.print("\n2. Edit account "); 
       System.out.print("\n3. Buy tickets "); 
       System.out.print("\nEnter selection: ");
       int select = sc.nextInt();
        while(select> 5){ 
        System.out.print("invalid, try again : ");
        select = sc.nextInt();
    }  customer cst = new customer();
       transact trn = new transact();
        switch(select){
            case 1: 
                  cst.viewcustomer();
                  cst.addcustomers();
                break;
            case 2:
                cst.viewcustomer();
                cst.addcustomers();
                break;
            case 3:
               
                trn.addtransact();
              
                break;
        
        }
          System.out.print("do another transaction (yes/no): ");
          resp = sc.next();
       }while(resp.equalsIgnoreCase("yes"));
      }catch(Exception e){
              System.out.print("rnter a valid character");
          }
       
       
    }
    
     public void exitApp() {
         
        System.out.println("Exiting the application. Goodbye!");
        System.exit(0);  
    }
}

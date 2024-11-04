
package tevesmovieapp;

import java.util.Scanner;

public class TEVESmovieapp {
config conf = new config();

    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        System.out.println("1. customer: ");
        System.out.println("2. Staffs: ");
        System.out.print("Who's using? ");
        int user = sc.nextInt();
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
       
       
      }    
    public void menu(){   
      String resp;
        Scanner sc = new Scanner(System.in);
        movies mapp = new movies();
      do{
          System.out.println("-------------------------------");
          System.out.println("| MOVIE TICKETING APPLICATION |");
          System.out.println("-------------------------------");
          System.out.println("MAIN MENU");
          System.out.println("1. MOVIES");
          System.out.println("2. CUSTOMERS");
          System.out.println("3. VIEW");
          System.out.println("4. EXIT");
          System.out.print("Enter choice: ");
          int choice = sc.nextInt();
          while(choice> 5){ 
            System.out.print("try again: ");
            choice = sc.nextInt();
    }
            customer cst = new customer();
             switch(choice){
                 case 1:
                     
                     mapp.options();
                     break;
                 case 2:
                    
                      cst.options();
                     break;
                 case 3:
                     mapp.viewmovie();
                     cst.viewcustomer();
                     break;
                 case 4:
                    TEVESmovieapp map = new TEVESmovieapp();
                    map.exitApp();
                     break;
                                                               
             }                                          
          System.out.print("do another transaction (yes/no): ");
          resp = sc.next();
      }while(resp.equalsIgnoreCase("yes"));
    }
    
    public void caccnt () {
     Scanner sc = new Scanner(System.in);
       System.out.print("\t CUSTOMER SELECTION ");
       System.out.print("\n1. dont have an account");
       System.out.print("\n2. already have an account");   
       System.out.print("\nEnter selection: ");
       int select = sc.nextInt();
        while(select> 5){ 
        System.out.print("invalid, try again : ");
        select = sc.nextInt();
    }  
        switch(select){
            case 1: 
                movies mapp = new movies();
                 mapp.viewmovie();
                  customer cst = new customer();
                  cst.addcustomers();
                break;
            case 2:
                break;
        
        }
    }
     public void exitApp() {
        System.out.println("Exiting the application. Goodbye!");
        System.exit(0);  
    }
}

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
        
        switch(user){
            case 1:
                 movies mapp = new movies();
                 mapp.viewmovie();
               
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
                TEVESmovieapp map = new TEVESmovieapp();
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
          System.out.println("2. BUY TICKET");
          System.out.println("3. VIEW");
          System.out.println("4. EXIT");
          System.out.print("Enter choice: ");
          int choice = sc.nextInt();
          while(choice> 5){ 
            System.out.print("try again: ");
            choice = sc.nextInt();
    }
          
             switch(choice){
                 case 1:
                     
                     mapp.options();
                     break;
                 case 2:
                    
                     break;
                 case 3:
                     mapp.viewmovie();
                     
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
     public void exitApp() {
        System.out.println("Exiting the application. Goodbye!");
        System.exit(0);  
    }
}

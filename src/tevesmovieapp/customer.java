package tevesmovieapp;
import java.util.Scanner;

public class customer {
       config conf = new config();
        String resp;
        Scanner sc = new Scanner(System.in);
      public void options(){
      do{      
          System.out.println("-------------");
          System.out.println("| CUSTOMERS |");
          System.out.println("-------------");
          System.out.println("1. ADD CUSTOMERS");
          System.out.println("2. VIEW CUSTOMER'S LIST");
          System.out.println("3. EDIT CUSTOMER");
          System.out.println("4. DELETE CUSTOMERS");
          System.out.println("5. MAIN MENU");
          System.out.print("Enter choice: ");
              int choices = sc.nextInt();
    while(choices> 5){ 
        System.out.print("try again : ");
        choices = sc.nextInt();
    }
              movies mapp = new movies();
              customer cst = new customer();
             switch(choices){
                 case 1:
                     mapp.viewmovie();
                     cst.addcustomers();
                     break;
                 case 2:
                    cst.viewcustomer();
                     break;
                 case 3:
                      cst.viewcustomer();
                     cst.Updatecustomer();
                      cst.viewcustomer();
                     break;
                     
                 case 4:
                      cst.viewcustomer();
                      cst.deletecustomer();
                       cst.viewcustomer();
                     break;
                  case 5:
                       TEVESmovieapp map = new TEVESmovieapp();
                       map.menu(); 
                     break;
                                              
             } 
        System.out.print("do another transaction(yes/no): ");
        resp = sc.next();
        }while(resp.equalsIgnoreCase("yes"));
      }
      
      //add

   public void addcustomers() {   
          
        System.out.print("customer name: ");
        String name = sc.next();
        System.out.print("age: ");
        int age = sc.nextInt();
        System.out.print("cell no.: ");
        String no = sc.next();
        System.out.print("email: ");
        int email = sc.nextInt();
       
        String sql = "INSERT INTO tbl_movie (c_name, c_age, c_num, c_email) VALUES (?, ?, ?, ?)";
        conf.addRecord(sql, name, age, no, email);
        }



      // view
      
     public void viewcustomer() {
        String sqlQuery = "SELECT * FROM tbl_customer";

        String[] columnHeaders = {"ID", "Name", "age", "cell no. ","email"};
        String[] columnNames = {"c_id", "c_name", "c_age", "c_num", "c_email"};
       
        conf.viewRecords(sqlQuery, columnHeaders, columnNames);
    }
     
        // update 
    public void Updatecustomer(){
        System.out.print("Enter movie ID to edit: ");
        int id = sc.nextInt();
       System.out.print("customer name: ");
        String name = sc.next();
        System.out.print("age: ");
        int age = sc.nextInt();
        System.out.print("cell no.: ");
        String no = sc.next();
        System.out.print("email: ");
        int email = sc.nextInt();
      
        String sql = "UPDATE tbl_movie SET c_name = ?, c_age = ?, c_num = ?, c_email = ? WHERE c_id = ?";
    config conf = new config();
    conf.updateRecord(sql, name,  age, no, email, id);
    }
    
    public void deletecustomer(){
         String delmore;
        do{
         System.out.print("Enter customer ID to delete: ");
        int id = sc.nextInt();
        
         System.out.print("delete more:");
         delmore = sc.next();
         
         String sql = "DELETE FROM tbl_customer WHERE c_id = ?";
        config conf = new config();
        conf.deleteRecord(sql, id);
        }while(delmore.equalsIgnoreCase("yes"));
        
       
    }
    
    
    
}

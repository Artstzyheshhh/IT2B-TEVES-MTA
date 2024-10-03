package tevesmovieapp;

import java.util.Scanner;

public class TEVESmovieapp {
config conf = new config();
    public static void main(String[] args) {
        String resp;
        Scanner sc = new Scanner(System.in);
      do{
          System.out.println("1. ADD");
           System.out.println("2. EDIT");
            System.out.println("3. VIEW");
             System.out.println("4. DELETE");
              System.out.println("5. EXIT");
              System.out.println("Enter choice: ");
              int choice = sc.nextInt();
              TEVESmovieapp mapp = new TEVESmovieapp();
             switch(choice){
                 case 1:
                     mapp.addmovie();
                     break;
                 case 2:
                     mapp.viewmovie();
                     break;
                 case 3:
                     break;
                 case 4:
                     break;
                  case 5:
                     break;
                                    
             
             } 
              
              
              
          System.out.println("do another transaction: (yes/no)");
          resp = sc.next();
      }while(resp.equalsIgnoreCase("yes"));
      
    }
    public void addmovie(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Movie name: ");
        String name = sc.next();
        System.out.print("price: ");
        int price = sc.nextInt();
        System.out.print("category: ");
        String category = sc.next();
       

        String sql = "INSERT INTO tbl_movie (m_name, m_price, m_category) VALUES (?, ?, ?)";


        conf.addRecord(sql, name, price, category);
    }
    private void viewmovie() {
        String sqlQuery = "SELECT * FROM tbl_movie";
        String[] columnHeaders = {"ID", "Name", "price", "category"};
        String[] columnNames = {"m_id", "m_name", "m_price", "m_category"};

        conf.viewRecords(sqlQuery, columnHeaders, columnNames);
    }
}

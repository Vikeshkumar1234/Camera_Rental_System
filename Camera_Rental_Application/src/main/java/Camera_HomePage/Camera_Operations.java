package Camera_HomePage;

import java.sql.SQLOutput;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Camera_Operations {
    static Scanner sc = new Scanner(System.in);
 public static void My_Camera(TreeMap<Integer, Camera_Details> sa) {
         System.out.println("-------------------------------------------------");
         System.out.println("----> THIS IS MY CAMERA LIBRARY:");
         System.out.println("-------------------------------------------------");

         while (true) {
             Scanner sc = new Scanner(System.in);
             System.out.println("1. ADD THE CAMERA");
             System.out.println("2. REMOVE THE CAMERA");
             System.out.println("3. VIEW ALL MY CAMERAS");
             System.out.println("4. GO TO THE PREVIOUS MENU");
             System.out.print("ENTER THE OPTIONS IN THE CAMERA LIBRARY: ");

             int options = sc.nextInt();
             System.out.println("-------------------------------------------------");

             if (options == 1) {
                 System.out.print("ENTER THE CAMERA ID: ");
                 int id = sc.nextInt();
                 System.out.print("ENTER THE CAMERA BRAND: ");
                 String brand = sc.next();
                 System.out.print("ENTER THE CAMERA MODEL: ");
                 String model = sc.next();
                 System.out.print("ENTER THE CAMERA PRICE(PER DAY): ");
                 float price = sc.nextFloat();
                 String status = "AVAILABLE";

                 sa.put(id, new Camera_Details(id, brand, model, price, status));
                 System.out.println("-------------------------------------------------");
                 System.out.println("✅ YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE MENU");
                 System.out.println("-------------------------------------------------");
             }
             else if (options == 2) {
                 System.out.print("ENTER THE CAMERA ID TO REMOVE: ");
                 int id = sc.nextInt();

                 if (sa.containsKey(id)) {
                     sa.remove(id);
                     System.out.println("-------------------------------------------------");
                     System.out.println("✅ CAMERA SUCCESSFULLY REMOVED FROM THE MENU");
                     System.out.println("-------------------------------------------------");
                 } else {
                     System.out.println("-------------------------------------------------");
                     System.out.println("⚠️ THE CAMERA ID IS NOT IN THE MENU!");
                     System.out.println("-------------------------------------------------");
                 }
             }

             if (options == 3) {
                 Camera_Operations.View_All_Camera(sa);
             }

             if (options == 4) {
                 System.out.println("-------------------------------------------------");
                 System.out.println("------> GOING TO THE MENU PAGE.");
                 System.out.println("-------------------------------------------------");
                 break;
             }
         }
     }
 public static float Rent_Camera(TreeMap<Integer, Camera_Details> sa, float wallet_money)
 {
   TreeMap<Integer,Camera_Details>available=new TreeMap<>();
   for(Map.Entry<Integer,Camera_Details>en:sa.entrySet()) {
       Camera_Details check = en.getValue();
       if (check.getStatus().equals("AVAILABLE")) {
           available.put(en.getKey(), check);
       }
   }
     System.out.println("-------------------------------------------------");
     System.out.println("FOLLOWING IS THE LIST OF AVAILABLE CAMERA(S)");
     System.out.println("-------------------------------------------------");

     Camera_Operations.View_All_Camera(available);

     System.out.print("ENTER THE CAMERA ID YOU WANT TO RENT: ");
     int camera_id = sc.nextInt();

     System.out.println("-------------------------------------------------");

     if (available.containsKey(camera_id)) {
         Camera_Details cameraDetails = available.get(camera_id);

         if (cameraDetails.getPrice() <= wallet_money) {
             Camera_Details originallist = sa.get(camera_id);
             originallist.setStatus("RENTED");

             System.out.println("✅ YOUR TRANSACTION FOR CAMERA "
                     + originallist.getBrand() + " " + originallist.getModel()
                     + " WITH RENT INR. " + originallist.getPrice()
                     + " HAS SUCCESSFULLY COMPLETED.");
             wallet_money -= cameraDetails.getPrice();
         } else {
             System.out.println("❌ ERROR: TRANSACTION FAILED DUE TO INSUFFICIENT WALLET BALANCE.");
             System.out.println("PLEASE DEPOSIT THE AMOUNT IN YOUR WALLET.");
         }
     }
     else
     {
         System.out.println("YOUR RENT ID IS NOT IN THE MENU");
     }

     System.out.println("-------------------------------------------------");
       return wallet_money;
 }
 public static void View_All_Camera(TreeMap<Integer, Camera_Details> sa)
 {
     System.out.println("--------------------------------------------------------------------------------------");
     System.out.printf("| %-10s | %-15s | %-15s | %-20s | %-10s|\n",
             "CAMERA_ID", "CAMERA_BRAND", "CAMERA_MODEL", "CAMERA_PRICE(PER DAY)", "STATUS");
     System.out.println("--------------------------------------------------------------------------------------");

     for(Map.Entry<Integer, Camera_Details> en : sa.entrySet()) {
         Camera_Details cameraDetails = en.getValue();
         System.out.printf("| %-10d | %-15s | %-15s | %-20.2f | %-10s |\n",
                 cameraDetails.getCamera_Id(),
                 cameraDetails.getBrand(),
                 cameraDetails.getModel(),
                 cameraDetails.getPrice(),
                 cameraDetails.getStatus());
     }

     System.out.println("--------------------------------------------------------------------------------------");


 }
 public static float My_Wallet(float wallet_money)
 {
     System.out.println("-------------------------------------------------");
     System.out.println("               WALLET DETAILS");
     System.out.println("-------------------------------------------------");
     System.out.println("YOUR CURRENT WALLET BALANCE IS - INR. " + wallet_money);
     System.out.println("-------------------------------------------------");
     System.out.print("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET? \n1. YES\n2. NO\nEnter your choice: ");

     int choice = sc.nextInt();

     if (choice == 1) {
         System.out.print("ENTER THE AMOUNT TO DEPOSIT: INR. ");
         float depositAmount = sc.nextFloat();
         wallet_money += depositAmount;
         System.out.println("-------------------------------------------------");
         System.out.println("✅ WALLET UPDATED SUCCESSFULLY!");
         System.out.println("YOUR CURRENT WALLET BALANCE: INR. " + wallet_money);
         System.out.println("-------------------------------------------------");
     } else if (choice == 2) {
         System.out.println("-------------------------------------------------");
         System.out.println("❌ WALLET BALANCE NOT UPDATED");
         System.out.println("YOUR CURRENT WALLET BALANCE: INR. " + wallet_money);
         System.out.println("-------------------------------------------------");
     } else {
         System.out.println("⚠️ INVALID CHOICE! PLEASE ENTER 1 OR 2.");
     }
    return wallet_money;
 }
}

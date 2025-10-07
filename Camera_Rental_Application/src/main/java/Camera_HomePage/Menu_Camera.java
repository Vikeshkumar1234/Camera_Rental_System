package Camera_HomePage;

import java.util.Scanner;
import java.util.TreeMap;

public class Menu_Camera {
    public static void Menu(TreeMap<Integer, Camera_Details> sa, float wallet_money)
    {
        while(true)
        {
            System.out.println("+----------------------------------------+");
            System.out.println("|              CAMERA APP MENU           |");
            System.out.println("+----------------------------------------+");
            System.out.println("| 1. MY CAMERA                           |");
            System.out.println("| 2. RENT A CAMERA                       |");
            System.out.println("| 3. VIEW ALL CAMERAS                    |");
            System.out.println("| 4. MY WALLET                           |");
            System.out.println("| 5. EXIT                                |");
            System.out.println("+----------------------------------------+");

            System.out.print("ENTER THE OPTIONS TO PROCEED NEXT:");
            Scanner sc=new Scanner(System.in);
            int options=sc.nextInt();
            System.out.println("------------------------------------------");
            if(options==1)
            {
                Camera_Operations.My_Camera(sa);
            }
            else if(options==2)
            {
                wallet_money=Camera_Operations.Rent_Camera(sa,wallet_money);
            }
            else if(options==3)
            {
                Camera_Operations.View_All_Camera(sa);
            }
            else if(options==4)
            {
                wallet_money=Camera_Operations.My_Wallet(wallet_money);
            }
            else
            {
                System.out.println("-------------------------------------------------");
                System.out.println("✅ EXITED FROM THE APPLICATION. THANK YOU!");
                System.out.println("-------------------------------------------------");
                break;

            }
        }
    }
}

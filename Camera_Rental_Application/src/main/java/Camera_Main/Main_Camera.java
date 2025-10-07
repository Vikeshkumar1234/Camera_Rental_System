package Camera_Main;

import Camera_HomePage.Camera_Details;
import Camera_HomePage.Menu_Camera;
import Camera_Users.Users_BaseClass;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Main_Camera {
    public static void main(String[] args) {
        TreeMap<Integer, Camera_Details>sa=new TreeMap<>();
        sa.put(11,new Camera_Details(11,"Something","Some",200.0f,"AVAILABLE"));
        sa.put(12,new Camera_Details(12,"Some","Another",100.0f,"AVAILABLE"));
        sa.put(14,new Camera_Details(14,"NIKON","DSLR-D700",500.0f,"AVAILABLE"));
        sa.put(17,new Camera_Details(17,"Samsung","SM123",200.0f,"AVAILABLE"));
        sa.put(19,new Camera_Details(19,"SONY","SONY1234",123.0f,"AVAILABLE"));
        sa.put(15,new Camera_Details(15,"Sony","DSLR12",200.0f,"AVAILABLE"));
        sa.put(20,new Camera_Details(20,"cannon","5030",25000.0f,"AVAILABLE"));
        sa.put(21,new Camera_Details(21,"nikon","2030",500.0f,"AVAILABLE"));
        sa.put(33,new Camera_Details(33,"Khadeer","ONEPLUS",50000.0f,"RENTED"));
        float wallet_money=500.0f;
        Scanner sc=new Scanner(System.in);
        System.out.println("+--------------------------------------+");
        System.out.println("|      WELCOME TO CAMERA RENTAL APP    |");
        System.out.println("+--------------------------------------+");
        System.out.print("Enter the Username - ");
        String uname=sc.next();
        System.out.print("Enter the Password - ");
        String pwd=sc.next();
        if(Users_BaseClass.validate(uname,pwd)==1)
        {
            Menu_Camera.Menu(sa,wallet_money);
        }
        else
        {
            System.out.println("OOPS!.You are not a Authenticated User.");
        }

    }
}

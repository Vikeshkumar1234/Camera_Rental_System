package Camera_Users;

public class Users_BaseClass {
   public static int validate(String uname,String pwd)
   {
       if(uname.equals("admin") && pwd.equals("admin123"))
       {
           return 1;
       }
       else  return 0;
   }
}

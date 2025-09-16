package encapsulation;

public class BannkAccount {
     String accnumber;
     int balance;

      private static String bankname;
     private static int interest;

     public BannkAccount(String accnumber,int balance){
         this.balance= balance;
         this.accnumber= accnumber;
     }

     public static void setBankname(String bankname){
         BannkAccount.bankname= bankname;
     }
     public static String getBankname(){
         return bankname;
     }
     public static void setInterest(int interest){
         BannkAccount.interest=interest;
     }
     public  static int getInterest(){
         return  interest;
     }

     void printdetails(){
         System.out.println("Bank name :"+bankname);
         System.out.println("account number :"+accnumber);
         System.out.println("Balance :"+balance);
         System.out.println("interest :"+interest);
     }

    public static void main(String[] args) {
         BannkAccount.setBankname("sbi");
         BannkAccount.setInterest(10);
        BannkAccount obj= new BannkAccount("234h35wjk", 140000);
        obj.printdetails();
    }
}

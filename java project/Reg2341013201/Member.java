package Reg2341013201;
import java.util.Scanner;

public class Member extends Date{
Member(int day, String month, int year) {                     
        super(day, month, year);
        //TODO Auto-generated constructor stub
    }   
private int MemberID;
private String LastName;
private String FirstName; 
private int Handicap;
private char Gender;
private String Team;
private String MemberType; 
private int Coach;
private long Phone; 
private Date JoinDate; 
String a;

void seniorhandicap()
    {
        System.out.println("record of the senior members whose handicap score is less than 12" );
       
            if(this.MemberType.equalsIgnoreCase("senior") && this.Handicap<12)
            {
                this.display();
            }
       

    }
    void TeamBfemales()
    {
        System.out.println("records of all the female senior members who are part of TeamB." );
        if((this.Gender=='F'||this.Gender=='f')&& 
        this.Team.equalsIgnoreCase("TeamB")&& 
        this.MemberType.equalsIgnoreCase("senior")){
            this.display();
        }
    }

void setDetails()
{
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter memberId: (example:- 123)");
    this.MemberID=sc.nextInt();

    System.out.println("Enter Last Name:");
    this.LastName=sc.next();

    System.out.println("Enter First Name: ");
    this.FirstName= sc.next();

    System.out.println("Enter your Handicap number:\n(If unavailable enter: 0)");
    this.Handicap=sc.nextInt();

    System.out.println("Enter your Gender:\nFemale(F)/Male(M)");
    this.Gender=sc.next().charAt(0);
    this.a=sc.nextLine();

    System.out.println("Enter team:\n(If not in any team, only press enter:)");
    this.Team=sc.nextLine();
    if(this.Team==null)
    {
        System.out.println();
    }

    System.out.println("Enter MemberType:\n(Junior/Senior)");
    this.MemberType=sc.next().toLowerCase();

    System.out.println("Enter coach:\n(example:-32)\n(If not available enter: 0)");
    this.Coach=sc.nextInt();

    System.out.println("Enter phone:\n(example:-91928182)");
    this.Phone=sc.nextLong();

    this.JoinDate = new Date(0, null,0);
}

void display()
{
    
    System.out.print("MemberID: "+this.MemberID+"\n"+"LastName: "+
    this.LastName+"\n"+"FirstName: "+this.FirstName+"\n"+"HandiCap: "+this.Handicap+"\n"+"Gender: "+
    this.Gender+"\n"+"Team: "+this.Team+"\n"+"MemberType: "+this.MemberType+"\n"+"Coach: "+
    this.Coach+"\n"+"Phone: "+this.Phone+"\n"+"Joindate: ");
    this.displayDate();
}
public static void main(String[] args) {
    Scanner bb = new Scanner(System.in);
    System.out.println("Enter no.of Members of the club: ");
    Member m[]= new Member[bb.nextInt()];               
    String mon[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
   
    for(int i=0;i<m.length;i++)
    {
        System.out.println("\nEnter join date (date month year):\n(example:-2 Apr 9)");
        m[i]=new Member(bb.nextInt(), bb.next(),bb.nextInt());
        m[i].setDetails(); 
        System.out.println();
        //method for printing info of people who joined earlier than 7 April 9.
        int k=0;
        for(int j=0;j<mon.length;j++)
        {
        if(m[i].getmonth().equalsIgnoreCase(mon[j]))
        {
            k=j;
            if(((m[i].getday()<=7) && k==3 && (m[i].getyear()==9)) || (m[i].getday()<=31)&& k<=11 && m[i].getyear()<=8 ){
             m[i].display();
            }
        }
   }
        ////////////////////////////////////
       
       m[i].seniorhandicap();
       System.out.println();
       m[i].TeamBfemales();
          
    }    
}

}
class Date{
private int day;
private String month; 
private int year;

Date(int day,String month, int year)
{
    this.day=day;
    this.month=month;
    this.year=year;
}
void displayDate()
{
   System.out.print(this.day+" "+this.month+" "+this.year+"\n");
}
int getday()
{
   return this.day;
}
int getyear()
{
    return this.year;
}
String getmonth()
{
    return this.month;
}
}

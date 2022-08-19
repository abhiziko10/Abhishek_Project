package Problem_Statement;

import java.util.Scanner;

class Student
{
    int Id;
    String name;
    String techstack;
    long mobileNo;
    String city;
    Student s;
    Student s1[]=new Student[5];
    int count=0;
    void add()
    {
        Scanner sc=new Scanner(System.in);

        s=new Student();
        System.out.println("Enter your Id");
        s.Id=sc.nextInt();
        System.out.println("Enter the name");
        s.name=sc.nextLine();
        System.out.println("Enter the techstack");
        s.techstack=sc.nextLine();
        System.out.println("Enter the city");
        s.city=sc.nextLine();
        System.out.println("Enter the mobile number");
        s.mobileNo=sc.nextLong();
        s1[count++]=s;
        
    }
    void update(int id)
    {
        Student sp=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your ID");
        id=sc.nextInt();
        for(int i=0;i<s1.length;i++)
        {
            if(id==s1[i].Id)
            {
                sp=s1[i];
                break;
            }
        }
        System.out.println("Which attribute you want to change");
        String str=sc.nextLine();
        if(str.equals("name"))
        {
            sp.name=sc.nextLine();
        } else if (str.equals("city")) {
            sp.city=sc.nextLine();


        }


    }
    void Delete(int id)
    {
        Student sp1=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your ID");
        id=sc.nextInt();
        for(int i=0;i<s1.length;i++)
        {
            if(id==s1[i].Id)
            {
                sp1=s1[i];
                break;
            }
        }
        sp1.Id=0;
        sp1.name=null;
        sp1.city=null;
        sp1.techstack=null;
        sp1.mobileNo=0;
    }
    void fetch()
    {
        for(Student s:s1)
        {
            System.out.println(s.Id+" "+s.name+" "+s.techstack+" "+s.city+" "+s.mobileNo);
        }
    }



}

public class Array_Demo {
    public static void main(String[] args) {
        Student s=new Student();
        Scanner sc=new Scanner(System.in);
        while(true)
        {

            System.out.println("enter 1 for Insertion");
            System.out.println("Enter 2 for updation");
            System.out.println("enter 3 for fetching");
            System.out.println("enter 4 for deletion");
            int i=sc.nextInt();
            switch(i)
            {
                case 1:
                    s.add();
                    break;
                case 2:
                    System.out.println("Enter your ID");
                    int id= sc.nextInt();
                    s.update(id);
                    break;
                case 3:
                    new Student().fetch();
                    break;
                case 4:
                    System.out.println("Enter your ID");
                    int id1= sc.nextInt();

                    s.Delete(id1);
                    break;

            }
        }
    }
}

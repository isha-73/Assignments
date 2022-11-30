import java.util.*;
public class HactoberFest {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int flag=0;
        String s=sc.nextLine();
        StringBuilder sb=new StringBuilder(s);
        for(int t=0;t<sb.length()-1;t++) {
            for (int i = 0; i < sb.length() - 1; i++) { //to remove duplicate element
                for (int j = i + 1; j < sb.length(); j++) {
                    if (sb.charAt(i) == sb.charAt(j)) {
                        System.out.println("removed "+sb.charAt(i));
                        sb.deleteCharAt(j);
                        i = sb.length();
                        break;
                    }
                }
            }
        }
       /* for(int i=0;i<sb.length()-1;i++) { //to check if still duplicate element exists
            for(int j=i+1;j<sb.length();j++) {
                if(sb.charAt(i)==sb.charAt(j)) {
                    flag=1;
                    i=sb.length();
                    break;
                }
            }
        }*/




        if(flag==1)
            System.out.println("False");
        else
            System.out.println("True");
        System.out.println(sb);
        sc.close();
    }
}
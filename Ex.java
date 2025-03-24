/* Write a method that takes two Strings as input and returns the String whose 
first letter comes first in the alphabet. If the two Strings both begin with the 
same letter, then the method should return the shortest between the two. If they 
begin with the same letter and have the same length, then the method should 
return either one of them. */

import java.util.*;
public class Ex
{

public static String Twostrings (String a, String b)

    {
    if(a.charAt(0)< b.charAt(0)){
       return a;
    }
    else if (a.charAt(0) == b.charAt(0) && a.length() < b.length())
             return a;

    return b;
    }
    public static String reverseString (String a)
        {
        String r = "";
        for (int j = a.length() -1; j>=0; j--)
           {
            r=r+a.charAt(j);
           }
           return r;
        }



public static void main (String[] args)
{
    Scanner S = new Scanner (System.in);
    System.out.print("Please enter two names: ");
    String a = S.next(), b = S.next();
    System.out.println("First letter comes first in the alphabet is: " + Twostrings(a, b));
    System.out.println("First letter comes first in the alphabet is: " +reverseString(a));
    S.close();
}
}

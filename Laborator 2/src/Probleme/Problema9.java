package Probleme;
import java.util.Arrays;
public class Problema9
{
   public static int[] cauta(int[] v, int x)
   {
       int poz=0;
       for(int i=0;i<v.length;i++)
           if(v[i]==x)
           {
               poz = i;
               break;
           }

       int [] rez= Arrays.copyOfRange(v, poz, v.length);
           return rez;
   }

   public static void main(String[] args)
   {
       int [] v = {1,2,3,4,5,6,7,8,9,10};
       int x = 3;
       int []rez = cauta(v,x);
       System.out.println(Arrays.toString(v));
       System.out.println(Arrays.toString(rez));
   }
}

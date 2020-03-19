package Probleme;
import java.util.Vector;

public class coada {
    Vector tail = new Vector();
    int size;
    int alloc;

    coada()
    {
        this.tail = new Vector(100);
        this.size=0;
        this.alloc=100;
    }

    coada(int z)
    {
        this.tail = new Vector(z);
        this.size=0;
        this.alloc=z;
    }

    public void push(int x)
    {
        if(size+1>=alloc)
            throw new OutOfMemoryError("Coada este plina");

        tail.add(x);
        size++;

    }

    public int pop()
    {
        if(size==0)
            throw new ArithmeticException("Coada goala");

        int first=(int)tail.firstElement();
        tail.remove(0);
        size--;
        return first;
    }

    public boolean isEmpty()
    {
        if(size==0)
            return true;
        else
            return false;
    }

    public String toString()
    {
        String rez = "Numar elemente: "+size+" Elemente: ";
        for (int i=0;i<size;i++)
            rez= rez+ tail.get(i)+ " ";
        return rez;
    }

    public static void main(String[] args)
    {
        coada c= new coada(20);
        c.push(1);
        c.push(2);
        c.push(3);
        c.push(4);
        c.push(5);
        c.push(6);
        c.push(7);
        System.out.println(c.toString());
        System.out.println(c.pop());
        System.out.println(c.pop());
        System.out.println(c.pop());
        System.out.println(c.toString());

    }


}

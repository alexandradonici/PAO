package Probleme;

public class transpusa
{
    int dim;
    int [] a[];

    transpusa()
{
    this.a=new int[0][0];
    dim=0;
}

    transpusa(int var)
    {
        this.a=new int[var][var];
        dim=var;
    }

    public boolean simetrica()
    {
        for(int i=0;i<dim;i++)
            for(int j=0;j<i;j++)
                if(a[i][j]!=a[j][i])
                    return false;

         return true;
    }
    public static void main(String[] args)
    {
        transpusa t= new transpusa(3);
        t.a[0][0]=1;
        t.a[0][1]=7;
        t.a[0][2]=3;
        t.a[1][0]=7;
        t.a[1][1]=4;
        t.a[1][2]=-5;
        t.a[2][0]=3;
        t.a[2][1]=-5;
        t.a[2][2]=6;

        if(t.simetrica()==true)
            System.out.println("Matrice simetrica");
        else
            System.out.println("Matricea nu este simetrica");

    }
}

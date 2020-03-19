package Probleme;

public class matrice {
    int[] a[];
    int nrl, nrc;

    matrice() {
        this.nrl = 0;
        this.nrc = 0;
        this.a = new int[0][0];
    }

    matrice(int l, int c) {
        this.nrl = l;
        this.nrc = c;
        this.a = new int[l][c];
    }

    public matrice add(matrice m2) {
        matrice rez = new matrice(nrl, nrc);

        if (nrl != m2.nrl || nrc != m2.nrc)
            return null;

        for (int i = 0; i < nrl; i++)
            for (int j = 0; j < nrc; j++) {
                rez.a[i][j] = m2.a[i][j] + this.a[i][j];
            }

        return rez;
    }

    public matrice multiply(matrice m2)
    {
        matrice rez = new matrice(nrl, nrc);

        for(int i=0;i<nrl;i++)
            for(int j=0;j<nrc;j++)
                for(int k=0;k<nrl;k++)
                    rez.a[i][j]+=a[i][k]*m2.a[k][j];

         return rez;

    }

    public matrice pow(int power )
    {
        matrice rez = new matrice(nrl, nrc);
        rez=this.multiply(this);
        power=power-2;

        while(power>0) {
            rez = this.multiply(rez);
            power--;
        }

        return rez;

    }



    public String toString()
    {
        String print = "NRL: "+nrl +"\nNRC: "+nrc+"\n";
        for(int i =0;i<nrl;i++)
        {
            for(int j =0;j<nrc;j++)
            {
                print =print +a[i][j] + " ";
            }
            print+="\n";
        }

        return print;
    }

    public static void main(String[] args)
    {
        matrice m1,m2;
        m1= new matrice(3,3);

        m1.a[0][0]=1;
        m1.a[0][1]=2;
        m1.a[0][2]=3;
        m1.a[1][0]=4;
        m1.a[1][1]=5;
        m1.a[1][2]=6;
        m1.a[2][0]=7;
        m1.a[2][1]=8;
        m1.a[2][2]=9;

        m2= new matrice(3,3);

        m2.a[0][0]=1;
        m2.a[0][1]=2;
        m2.a[0][2]=3;
        m2.a[1][0]=4;
        m2.a[1][1]=5;
        m2.a[1][2]=6;
        m2.a[2][0]=7;
        m2.a[2][1]=8;
        m2.a[2][2]=9;

        matrice rez=new matrice(3,3);
        rez= m1.add(m2);
        System.out.println(rez.toString());


        matrice rez1=new matrice(3,3);
        rez1= m1.multiply(m2);
        System.out.println(rez1.toString());

        matrice rez2=new matrice(3,3);
        rez2= m1.pow(3);
        System.out.println(rez2.toString());


    }
}

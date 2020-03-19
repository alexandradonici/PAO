package geometry;

public class TestPunct {

        public static void main(String[] args)
        {
            Punct A = new Punct(1,3);
            Punct B = new Punct(-1,2);

            System.out.println("A="+A);
            System.out.println("B="+B);

            System.out.println(A.distance(B));
            System.out.println(B.getX()); // doar asa putem accesa datele clasei Punct

        }
}

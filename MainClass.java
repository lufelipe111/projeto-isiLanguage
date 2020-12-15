import java.util.Scanner;
public class MainClass {
    public static void main (String args[]) {
        Scanner _key = new Scanner(System.in);
        double  a;
        double  b;
        double  c;
        double  d;
        double  e;
        double  f;
        String  g;
        System.out.println("Programa Teste");
        System.out.println("Digite A");
        a = _key.nextDouble();
        System.out.println("Digite B");
        b = _key.nextDouble();
        g = "A eh menor que 2";
        if (a<2) {
            c = a+b;
        }
        else {
            c = a-b;
        }

        while (a<2) {
            System.out.println(g);
            a = a-1;
        }
        System.out.println("C e igual a ");
        System.out.println(a);
        d = c*a+b;
        System.out.println("D e igual a ");
        System.out.println(d);
    }
}
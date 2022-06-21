package designpateerns02day05chainofresponsibility;

/**
 *
 * @author 1999k
 */
public class Test {

    public static void main(String[] args) {

        A a1 = new A1();
        A a2 = new A2();
        A a3 = new A3();
//        a1.a=a2;
//        a2.a=a3;
//        a3.a=a4;
        a1.setNext(a2);
        a2.setNext(a3);

        a1.process(new X(10));
    }

}

class X {

    int i;

    public X(int i) {
        this.i = i;
    }

}

// meka thama me pattern eke key point eka mokda mekedi ekama warge object tikk thama chain ekk widiyata hadenne
abstract class A {

    protected A a;

    public void setNext(A a) { // meka kalin thibbe setA kiyala namuth meka rule ekk neme wade poddak lassana piliwela karaganne eeelga eka set karanwa kiyanan setNext kargannawa wade wenasak wenne na pattern eke widiyata eka kathai wage nisai mehema wenas karaganne api
        this.a = a;
    }

    public abstract void process(X x);
//    {

//        System.out.println("Proccessing...");
//        if (x.i > 5) {
//            this.a.process(x);
//        } else {
//            System.out.println("Error");
//        }
//    }
}

class A1 extends A {

    @Override
    public void process(X x) {
        System.out.println("Proccessing...");
        if (x.i > 5) {
            this.a.process(x);
        } else {
            System.out.println("Error1");
        }
    }

}

class A2 extends A {

    @Override
    public void process(X x) {
        System.out.println("Proccessing...");
        if (x.i % 2 == 0) {
            this.a.process(x);
        } else {
            System.out.println("Error2");
        }
    }

}

class A3 extends A {

    @Override
    public void process(X x) {
        System.out.println("Proccessing...");
        if (x.i < 20) {
            System.out.println("Finish Checking : Success");  // wade methanin ewara wenna one nisa thama methanin ehata continue karnana epa kiyala wade methanin nawaththanne 
        } else {
            System.out.println("Error3");
        }
    }

}

// meke aula thama meke eka eka waraga wala objects thama thinne eka aulak me pattern eke 
//class A {
//
//    B b;
//
//}
//
//class B {
//
//    C c;
//
//}
//
//class C {
//
//}

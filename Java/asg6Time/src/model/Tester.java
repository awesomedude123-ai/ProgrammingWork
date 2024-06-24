package model;

public class Tester {
    public static void main(String[] args) {
        NavigableDocModel<String> s = new NavigableDocModel<>();

        s.insertNewItemRt("d");
        System.out.println(s.toString());
        System.out.println(s.lenAfterBar());
        s.insertNewItemRt("c");
        System.out.println(s.toString());
        System.out.println(s.lenAfterBar());
        s.insertNewItemRt("b");
        System.out.println(s.toString());
        System.out.println(s.lenAfterBar());
        s.insertNewItemRt("a");
        System.out.println(s.toString());
        System.out.println(s.lenAfterBar());

        s.forward();
        System.out.println(s.toString());
        System.out.println(s.lenBeforeBar());
        s.forward();
        System.out.println(s.toString());
        System.out.println(s.lenBeforeBar());
        s.forward();
        System.out.println(s.toString());
        System.out.println(s.lenBeforeBar());
        s.forward();
        System.out.println(s.toString());
        System.out.println(s.lenBeforeBar());

        System.out.println(s.contains("d").first+" "+s.contains("d").second);

        s.reset();
        System.out.println(s.toString());

    }
}

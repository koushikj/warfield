package com.warfield.powermockitoExamples;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        Main.publicStaticVoidMethod(12);
        Main.privateStaticVoidMethod("hi");

        main.privateVoidMethod("hi");
        main.publicVoidMethod("hello");

        System.out.println(Main.publicStaticMethod(12));
        System.out.println(Main.privateStaticMethod("12"));

        System.out.println(main.privateMethod("hi"));
        System.out.println(main.publicMethod("hi"));

    }

    private void privateVoidMethod(String string){
        System.out.println("i'm privateVoidMethod");
    }

    private String privateMethod(String string){
        return "im privateMethod returning "+string;
    }

    private static void privateStaticVoidMethod(String string){
        System.out.println("i'm privateStaticVoidMethod");
    }

    private static String privateStaticMethod(String string){
        return "im privateStaticMethod returning "+string;
    }

    public static void publicStaticVoidMethod(int i){
        privateStaticVoidMethod("call from publicStaticVoidMethod");
        System.out.println("i'm publicStaticVoidMethod");
    }

    public static int publicStaticMethod(int i){
        privateStaticMethod("call from publicStaticMethod");
        i=+1;
        System.out.println("im publicStaticMethod returning "+i);
        return i;
    }

    public void publicVoidMethod(String s){
        privateVoidMethod("call from publicVoidMethod");
        System.out.println("im publicVoidMethod ");
    }

    public String publicMethod(String s){
        privateMethod("call from publicMethod");
        return "im publicMethod ".concat(s.concat(" hello"));
    }
}

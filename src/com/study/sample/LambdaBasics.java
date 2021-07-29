package com.study.sample;

public class LambdaBasics {

    interface Drawable {
        void draw();
    }

    interface Brewable {
        void brew(String brew);
    }

    public static void main(String[] args) {

        Drawable a = new Drawable() {
            public void draw() {
                System.out.println("Drawing a");
            }
        };

        Drawable b = () -> System.out.println("Drawing b");

        Drawable c = () -> {
            System.out.println("Drawing c");
        };

        a.draw();
        b.draw();
        c.draw();

        Brewable d = (brew) -> {
            System.out.println("Brewing " + brew);
        };

        Brewable e = (brew) -> System.out.println("Brewing " + brew);

        Brewable f = LambdaBasics::drink;


        d.brew("Beer");
        d.brew("Kvas");
    }

    public static void drink(String brew) {
        System.out.println("Drinking " + brew);
    }
}

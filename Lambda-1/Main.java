package org.example;

public class Main {
    @FunctionalInterface
    interface Animal {
        String Talk();

    }
    @FunctionalInterface
    interface Animal2 {
        String Talk2(String talk);

    }
    public static void main(String[] args) {
        // Первый способ:

        Cow cow = new Cow("Moo-moo!");

        System.out.println(cow.Talk());

        ///////////////////////////////
        // Второй способ:
        Animal animal = new Animal() {
            private String talk = "Moo-moo!";
            public String Talk(){
                System.out.println(talk);

                return null;
            }
        };
        animal.Talk();

        //////////////////////////
        //Третий способ:
        Animal2 animal2 = String::new;
        String talk = animal2.Talk2("Moo-moo!");
        System.out.println(talk);


        ////////////////////////////////
    }
}
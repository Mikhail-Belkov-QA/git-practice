package org.example;

public class Main {
    public static void main(String[] args)
    {
        Group group2 = new Group<>( 2, "radio" );
        group2.addStudent( new Student( "Igor", "20") );
        group2.addStudent( new Student( "Jack", "21") );

        System.out.println("Number of Group = " + group2.printGroup());


        System.out.println( "Number of students = " + group2.size() );
        group2.deleteStudent( "Igor" );
        System.out.println( "Number of students = " + group2.size() );
    }
}

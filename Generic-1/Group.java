package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Group <T> {
    public Group( T number_group, String facultet )
    {
        this.number_group = number_group;
        this.facultet = facultet;
     // С помощью ArrayList<>()
      //  students = new ArrayList<>();
        // С помощью LinkedList
        students = new LinkedList<>();
    }
    private T number_group;
    private String facultet;
 //   private ArrayList<Student> students;
    private LinkedList <Student> students;

    public int size()
    {
        return students.size();
    }

    /*public T getNumber_group() {
        return this.number_group;
   }

    public void setNumber_group( T number_group )
    {
      this.number_group = number_group;
    }*/

    public String facultet()
    {
        return facultet;
    }

    public void setfacultet( String facultet )
    {
        this.facultet = facultet;
    }

    public void addStudent( Student student )
    {
        students.add( student );
    }

    public void deleteStudent( String name )
    {
        students.removeIf( student -> ( student.getName().equalsIgnoreCase( name ) ) );
    }
    public T printGroup() {
       return number_group;
    }


}


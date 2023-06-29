package org.example;

import java.util.Date;

public class Main {
    public static void main( String[] args )
    {
        Shop shop = new Shop( 11 );

        shop.addProduct( new Food( "bread", 40, shop.initDate( 15, 6, 2023 ) ) );
        shop.addProduct( new Food( "milk", 80, shop.initDate( 27, 6, 2023 ) ) );
        shop.addProduct( new Food( "cheese", 400, shop.initDate( 30, 7, 2023 ) ) );
        shop.addProduct( new Food( "beef", 450, shop.initDate( 19, 9, 2023 ) ) );
        shop.addProduct( new Food( "chicken", 250, shop.initDate( 12, 10, 2023 ) ) );
        shop.addProduct( new Food( "eggs", 70, shop.initDate( 01, 06, 2023 ) ) );
        shop.addProduct( new Food( "tomatoes", 120, shop.initDate( 21, 11, 2023 ) ) );

        shop.addProduct( new Phone("iPhone 7", 18000, "Apple") );
        shop.addProduct( new Phone("Honor 8 Lite", 12000, "Huawei") );

        shop.addProduct( new Toy("Пирамидка", 1000, 3 ) );
        shop.addProduct( new Toy("Юла", 500, 2 ) );

        shop.printAllProductNames();
        System.out.println( "Products in shop: " + shop.size() );

        try
        {
            shop.addProduct( new Phone("iPhone 234", 1800000, "Apple" ) );
        }
        catch ( RuntimeException e )
        {
            System.out.println( e.getMessage() );
        }
        System.out.println( "Products in shop after try to add iPhone 234: " + shop.size() );

        try
        {
            shop.deleteProduct("beef");
        }
        catch ( RuntimeException e )
        {
            System.out.println( e.getMessage() );
        }
        System.out.println( "Products in shop after try to delete beef: " + shop.size() );
        if ( !shop.containsProduct( "beef" ) )
        {
            System.out.println( "Ok! Beef was not found" );
        }

        try
        {
            shop.deleteProduct("iPhone 234");
        }
        catch ( RuntimeException e )
        {
            System.out.println( e.getMessage() );
        }
        System.out.println( "Products in shop after try to add iPhone 234: " + shop.size() );

        Product[] productsCheaper = shop.getProducts( 90 );
        for ( Product product : productsCheaper )
        {
            System.out.println( product.getName() );
        }

        System.out.println( "Shop contains apple is " + shop.containsProduct( "apple" ) );
        System.out.println( "Shop contains egg is " + shop.containsProduct( "egg" ) );

        System.out.println( "Cheapest product in shop is " + shop.findTheCheapest().getName() );
        //System.out.println( "Phones maker " + shop.findPhones("Huawei") );


       /*/ System.out.println("Proizvoditel" + shop.getProizvoditel());
        System.out.println("Возрастное ограничение" + toy.getAgeOgr());
        System.out.println("Срок годности" + food.getSrokGod());*/

        System.out.println();
        Phone[] phones = shop.findPhones( "huawei" );
        for ( Phone phone : phones )
        {
            System.out.println( "Phones maker " + phone.getName() );
        }
        System.out.println();

        Toy[] toys = shop.findToys( 2 );
        for ( Toy toy : toys )
        {
            System.out.println( "Toys 2 years " + toy.getName() );
        }
        System.out.println();

        Date before = Shop.initDate( 21, 8, 2023 );
        Food[] foods = shop.findFood( before );
        for ( Food food : foods )
        {
            System.out.println( "Food best before 21.08.2023 " + food.getName() );
        }
    }
}
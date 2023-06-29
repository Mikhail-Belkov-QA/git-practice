package org.example;

import java.util.Calendar;
import java.util.Date;

public class Shop
{

    static Date initDate( int day, int month, int year )
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set( year, month, day );
        Date date = calendar.getTime();
        return date;
    }
    public Shop( int productsNumber )
    {
        this.productsNumber = productsNumber;
        products = new Product[productsNumber];
        productsInShop = 0;
    }

    public Product[] getProducts( int cost )
    {
        int numberOfProducts = 0;
        for ( Product product : products )
        {
            if ( product == null )
            {
                // дальше все продукты удалены
                break;
            }
            if ( product.getCost() <= cost )
            {
                numberOfProducts++;
            }
        }
        Product[] result = new Product[numberOfProducts];

        numberOfProducts = 0;
        for ( Product product : products )
        {
            if ( product == null )
            {
                // дальше все продукты удалены
                break;
            }
            if ( product.getCost() <= cost )
            {
                result[numberOfProducts++] = product;
            }
        }

        return result;
    }

    public boolean containsProduct( String name )
    {
        for ( Product product : products )
        {
            if ( product == null )
            {
                // дальше все продукты удалены
                break;
            }
            if ( product.getName().toLowerCase().contains( name.toLowerCase() ) )
            {
                return true;
            }
        }
        return false;
    }

    public Product findTheCheapest()
    {
        int minCost = Integer.MAX_VALUE;
        int minCostIndex = 0;
        for ( int i = 0; i < productsNumber; i++ )
        {
            if ( products[i] == null )
            {
                // дальше все продукты удалены
                break;
            }
            int cost = products[i].getCost();
            if ( cost < minCost )
            {
                minCost = cost;
                minCostIndex = i;
            }
        }

        return products[minCostIndex];
    }
    public Phone[] findPhones( String maker )
    {
        int numberOfPhones = 0;
        for ( Product product : products )
        {
            if ( product == null )
            {
                // дальше все продукты удалены
                break;
            }
            if( product instanceof Phone )
            {
                Phone phone = ( Phone ) product;
                if ( phone.getMaker().toLowerCase().contains( maker.toLowerCase() ) )
                {
                    numberOfPhones++;
                }
            }
        }
        Phone[] result = new Phone[numberOfPhones];
        numberOfPhones = 0;
        for ( Product product : products )
        {
            if ( product == null )
            {
                // дальше все продукты удалены
                break;
            }
            if( product instanceof Phone )
            {
                Phone phone = ( Phone ) product;
                if ( phone.getMaker().toLowerCase().contains( maker.toLowerCase() ) )
                {
                    result[numberOfPhones++] = phone;
                }
            }
        }

        return result;
    }

    public Toy[] findToys( int age )
    {
        int numberOfToys = 0;
        for ( Product product : products )
        {
            if ( product == null )
            {
                // дальше все продукты удалены
                break;
            }
            if( product instanceof Toy )
            {
                Toy toy = ( Toy ) product;
                if ( toy.getAge() <= age )
                {
                    numberOfToys++;
                }
            }
        }
        Toy[] result = new Toy[numberOfToys];
        numberOfToys = 0;
        for ( Product product : products )
        {
            if ( product == null )
            {
                // дальше все продукты удалены
                break;
            }
            if( product instanceof Toy )
            {
                Toy toy = ( Toy ) product;
                if ( toy.getAge() <= age )
                {
                    result[numberOfToys++] = toy;
                }
            }
        }

        return result;
    }
    public Food[] findFood( Date date )
    {
        int numberOfFood = 0;
        for ( Product product : products )
        {
            if ( product == null )
            {
                // дальше все продукты удалены
                break;
            }
            if( product instanceof Food )
            {
                Food food = ( Food ) product;
                if ( food.getDate().after( date ) )
                {
                    numberOfFood++;
                }
            }
        }
        Food[] result = new Food[numberOfFood];
        numberOfFood = 0;
        for ( Product product : products )
        {
            if ( product == null )
            {
                // дальше все продукты удалены
                break;
            }
            if( product instanceof Food )
            {
                Food food = ( Food ) product;
                if ( food.getDate().after( date ) )
                {
                    result[numberOfFood++] = food;
                }
            }
        }

        return result;
    }

    public void addProduct( Product product ) throws RuntimeException
    {
        if ( productsInShop == productsNumber )
        {
            throw new RuntimeException( "There is no space in shop!" );
        }

        products[productsInShop] = product;
        ++productsInShop;
    }

    public void deleteProduct( String name ) throws RuntimeException
    {
        // ищем продукт с заданным именем. Если не нашли, то productIndex останется -1
        int productIndex = -1;
        for ( int i = 0; i < productsInShop; ++i )
        {
            if ( products[i].getName().toLowerCase().contains( name.toLowerCase() ) )
            {
                productIndex = i;
                break;
            }
        }

        if ( productIndex == -1 )
        {
            throw new RuntimeException( "There is no such product in shop!" );
        }

        // идем начиная с удаляемого продукта и присваиваем ему следующий продукт - и удаляем, и сдвигаем
        // последний элемент сдвинут, и на его месте null
        for ( int i = productIndex; i < ( productsInShop - 1 ); ++i )
        {
            products[i] = products[i + 1];
        }
        products[productsInShop - 1] = null;
        --productsInShop;
    }

    public void printAllProductNames()
    {
        // выводим имена всех продуктов для проверки, что массив заполнен
        for ( Product product : products )
        {
            if ( product == null )
            {
                // дальше все продукты удалены
                break;
            }
            System.out.println( product.getName() );
        }
    }

    public int size()
    {
        return productsInShop;
    }

    private final int productsNumber;
    private int productsInShop;
    private Product[] products;
}

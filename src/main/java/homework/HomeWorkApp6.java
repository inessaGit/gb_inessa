package homework;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
/*
Создать классы Собака и Кот с наследованием от класса Животное.
Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
 Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать,
 собака 10 м.).
* Добавить подсчет созданных котов, собак и животных.
 */
public class HomeWorkApp6 {
    public static void main(String args[]){
        test();
    }
    public static void test(){
        List<Cat> cats  = new ArrayList<>();
        List<Dog> dogs  = new ArrayList<>();
        int i=5;
        while(i>0){
            Dog dog = new Dog();
            dogs.add(dog);
            Cat cat = new Cat();
            cats.add(cat);
            i--;
        }
        //Expected: 10 animals (super () is being called for every this() constractor: 5 cats 5 dogs
        int numOfAnimals = Animal.getNumberOfAnimalInstances();
        int numOfDogs= Dog.getNumberOfDogInstances();
        int numOfCats=Cat.getNumberOfCatInstances();
        Assert.assertTrue(numOfAnimals==10);
    }
}

abstract class Animal{
    private static int count=0;
    Animal(){
        count++;
    }
    public static int getNumberOfAnimalInstances(){
        System.out.println("Number of created animals "+count);
        return count;
    }
    public void run (int length){
        System.out.println("Animal ran " +length);
    }
    public abstract void swim(int length );
}
class Dog extends Animal{
    private static int count=0;
    Dog(){
        count++;
    }
    public static int getNumberOfDogInstances(){
        System.out.println("Number of created dogs "+count);
        return count;
    }
    @Override
    public void run (int length){
        if(length<=500)
        System.out.println("Dog ran " +length);
    }
    public void swim(int length){
        if(length<=10)
            System.out.println("Dog swam " +length);
    }
}
class Cat extends Animal{
    private static int count=0;
    Cat(){
        count++;
    }
    public static int getNumberOfCatInstances(){
        System.out.println("Number of created cats "+count);
        return count;
    }
    @Override
    public void run (int length){
        if(length<=200)
            System.out.println("Cat ran " +length);
    }
    public void swim(int length){
            System.out.println("Cat cannot swim ");
    }
}
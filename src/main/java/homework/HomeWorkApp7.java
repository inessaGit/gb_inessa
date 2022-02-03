package homework;
import com.github.javafaker.Faker;
import com.sun.javaws.exceptions.InvalidArgumentException;
import java.util.ArrayList;
import java.util.List;
/*
Расширить задачу про котов и тарелки с едой, выполнив следующие пункты:
- Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).
- Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
- Если коту удалось покушать (хватило еды), сытость = true.
Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт
(это сделано для упрощения логики программы).
Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
и потом вывести информацию о сытости котов в консоль.
Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
- similar/redundant because we have setFood(int n) method;
 */
public class HomeWorkApp7 {
    public static void main(String[] args) {
     test();
     testIsFull();
     testAddFood();
    }
    public static void test(){
        Rabbit rabbit = new Rabbit("Barsik", 5);
        Plate plate = new Plate(100);
        plate.info();
        rabbit.eat(plate);
        plate.info();
    }
    public static void testIsFull(){
        int num=5;
        List<Rabbit> rabbits = new ArrayList<>(num);
        Plate  plate2= new Plate(40);
        int n=0;
        while (n<num){
            Rabbit rabbit = new Rabbit();
             rabbit.eat(plate2);
             System.out.println(rabbit.getIsFull());
            rabbits.add(rabbit);
            n++;
        }
    }
    public static void testAddFood(){
        Rabbit rabbit = new Rabbit();
        Plate plate = new Plate(50);
        plate.info();
        plate.setFood(100);
        plate.info();

       plate.addFood(20);
       plate.info();
    }
}
 class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
     public int getFood() {
         return this.food;
     }
     public void setFood(int food) {
         this.food = food;
     }

     public void addFood(int n){
        this.food+=n;
     }
     //true if decreased successfully false otherwise
     public boolean decreaseFood(int n) throws InvalidArgumentException {
        if(n>this.food){
            throw new IllegalArgumentException(n+ " value is too big. Only available "+this.food);
        }
        else{
            this.food -= n;
            return true;
        }
  }
    public void info() {
        System.out.println("plate: " + food);
    }
}
 class Rabbit {
     private static Faker faker = new Faker();
     private String name;
     private int appetite;
     private boolean isFull = false;

     public Rabbit(){
         this.name=faker.name().firstName();
         this.appetite=faker.number().numberBetween(5,20);
     }
     public Rabbit(String name, int appetite) {
         this.name = name;
         this.appetite = appetite;
         this.isFull = false;
     }

     public String getName() {
         return this.name;
     }
     public void setName(String name) {
         this.name = name;
     }
     public int getAppetite() {
         return this.appetite;
     }
     public void setAppetite(int appetite) {
         this.appetite = appetite;
     }
     public boolean getIsFull() {
         return this.isFull;
     }
     public void setFull(boolean full) {
         this.isFull = full;
     }

     public void eat(Plate p) {
         try {
            this.isFull= p.decreaseFood(appetite);
         } catch (InvalidArgumentException e) {
             System.out.println(e.getMessage());
         }

     }
 }

public class HomeWorkApp2 {
/*
их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
 */
    public static boolean isTenToTwenty(int a, int b){
        int sum=a+b;
        return (sum>=10 && sum<=20) ? true: false;
    }
    public static void printIsPositiveNum(int a){
        System.out.println(a>0 ? "Positive number": "Negative number");
    }
/*
аписать метод, которому в качестве аргументов передается строка и число,
метод должен отпечатать в консоль указанную строку, указанное количество раз;
 */ public static void printString(String s, int n){
     int i=0;
     while(i<n){
         System.out.println(s);
         i++;
     }
}
    public static boolean isPositiveNum(int a){
        return (a>0 ? true: false);
    }
    /*
    Написать метод, который определяет, является ли год високосным, и возвращает boolean
     (високосный - true, не високосный - false).
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    The year must be evenly divisible by 4; &&
    The year is also evenly divisible by 400
     */
    public static boolean isDivisibleByFour(int a){
        boolean isDivisible=false;
        if (a>0 && a<10){
          isDivisible=  a%4==0 ?  true :  false ;
        }
        //last two digits of int
        else if (a>10){
         String s = String.valueOf(a);
         int lastDigits=Integer.parseInt(s.substring(s.length()-2));
         isDivisible= lastDigits%4 ==0 ? true: false;
        }
       return isDivisible;
    }
    public static boolean isLeapYear(int a){
        boolean isLeap = false;
       if (a>0 && a<400){
         if (a%100==0) {
             return isLeap;
         }
         isLeap= isDivisibleByFour(a) ==true ? true: false;
       }
       else {
           //if 400 or more check if divisible by 400
          isLeap= a%400==0 ? true: false;
       }
       return isLeap;
    }

    public static void main (String []args){
        isTenToTwenty(9,2);
        printIsPositiveNum(0);
        isPositiveNum(9);
        printString("hello january",4);
        isLeapYear(1800); //exp false
      //  test();
    }

    public static void test(){
        System.out.println(isDivisibleByFour(400));
        System.out.println(isDivisibleByFour(4));

        // years 2000 and 2400 are leap years,
        //while 1800, 1900, 2100, 2200, 2300, and 2500 are not leap years.
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(2400));
        System.out.println(isLeapYear(2500));
        System.out.println(isLeapYear(2300));
    }

}

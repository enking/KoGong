import java.util.Scanner;

public class baek9498 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if (a>=90 && a<=100){
                System.out.println("A");
        }
        else if (a>=80 && a<= 89){
            System.out.println("B");
        }
        else if (a>=70 && a<=79){
            System.out.println("C");
        }
        else if (a>=60 && a<=69){
            System.out.println("D");
        }
        else System.out.println("F");

    }
}
/*
* 1. 배열 갯수를 입력받게 함
* 2. 배열 입력을 받으면 그 배열을 돌면서 갯수를 세야되는데 어차피 어떤 숫자가 몇개 있는지는 세야됨
* 3. 그렇게 세고 나면 각 배열의 갯수가 적힌 새로운 배열을 만드는거지
* 4. 그리고 그 배열의 n+1 부터 이제 n보다 큰 수가 있는지 세면서 큰 수가 없다면 -1 출력 있다면 그 갯수를 세서 출력
* 5. 이렇게 하면 시간 초과가 나는데
*
*
* 하지만 그냥 스택을 쓰느것이 더 낫다는..
*   */

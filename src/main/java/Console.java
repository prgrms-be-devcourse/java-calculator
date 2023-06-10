import java.util.Scanner;

//콘솔 입력과 출력에 대한 클래스
public class Console {

    public void start(){
        Scanner scanner = new Scanner(System.in);
        //Operator operator = new Operator();
        //Memorizer memorizer = new Memorizer();

        while (true){
            getMenu();
            System.out.println("선택: ");
            int selectMenu = scanner.nextInt();

            //입력받은 값이 1이라면
            if(selectMenu == 1){
                //기억한 계산 결과를 출력함
                //memorizer.value();
            }else{
                //입력된 피연산자와 연산자를 이용하여 계산함
                //opeator.calculator(operator1,operator2);
            }
        }
    }

    //계산기 메뉴 선택 사항
    public static void getMenu(){
        System.out.println("1.조회");
        System.out.println("2.계산");
    };
}

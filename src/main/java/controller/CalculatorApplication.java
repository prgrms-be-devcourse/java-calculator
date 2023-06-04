package controller;


import view.InputView;
import view.OutputView;


public class CalculatorApplication {

    public void run() {
        boolean runFlag = true;
        while (runFlag) {
            OutputView.printSelectMenu();
            switch (InputView.selectInput()) {
                case CHECK -> System.out.println("조회"); //todo: 계산기 객체에게 책임 전달
                case CALCULATE -> System.out.println("계산");//todo: 저장소 객체에게 책임 전달
                case END -> runFlag = false;
            }
        }
    }
}

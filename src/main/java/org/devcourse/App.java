package org.devcourse;


import org.devcourse.calculator.Calculator;
import org.devcourse.io.ConsoleDevice;
import org.devcourse.io.IODevice;
import org.devcourse.repository.MemoryRepository;
import org.devcourse.repository.Repository;

public class App {
    public static void main(String[] args) {


        IODevice IODevice = new ConsoleDevice(); // 입력장치 선택: Console
        Repository repository = new MemoryRepository(); // 저장 선택: Memory

        Calculator calculator = new Calculator(IODevice, repository);
        calculator.run();

    }
}

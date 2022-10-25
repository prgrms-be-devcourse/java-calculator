package com.programmers.Application;


import com.programmers.calculation.Calculation;
import com.programmers.calculation.FourArithmeticImpl;
import com.programmers.io.console.Console;
import com.programmers.repository.RepositoryImpl;
import com.programmers.verification.VerificationImpl;

public class App {

  public static void main(String[] args) {

    Calculator calculation = new Calculator(new Console(), new Console(), new VerificationImpl(),
        new RepositoryImpl(), new Calculation(new FourArithmeticImpl()));
    calculation.run();

  }

}

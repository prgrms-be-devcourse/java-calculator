package org.example.engine;


import org.example.Console;



public class Calculator implements Runnable{
    private Console console;

    public Calculator(Console console){
        this.console = console;
    }

    @Override
    public void run() {

        while(true){
            int mode = console.inputSelectMode();

            switch(mode){
                case 1 : compute(); break;
                case 2 : loadHistory(); break;
            }
        }

    }

    public void compute(){
        System.out.println("compute에요");


    }

    public void loadHistory(){
        System.out.println("laodHistory에요");
    }





}

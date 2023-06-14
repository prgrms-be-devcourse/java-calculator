package org.example;

import org.example.Calculate.*;
import org.example.Input.Input;
import org.example.Input.UserInput;
import org.example.Output.Show;
import org.example.Output.ShowText;
import org.example.Repository.ExpressionRepository;
import org.example.Repository.Repository;

public class CalConfig {
    public Calculate calculate(){
        return new CalculateImpl(new CalOrderImpl());
    }
    public Repository repository(){
        return new ExpressionRepository();
    }
    public Input input(){
        return new UserInput();
    }
    public Show show(){
        return new ShowText();
    }
    public PreProcess preProcess() {
        return new PreProcessImpl();
    }
}

public class Main {
    public static void main(String[] args)
    {
        String a = "2+5*3+1";
        System.out.println(a);
        String operators[]=a.split("[0-9]");
        String operands[]=a.split("[*+-/]");
        int agregate = Integer.parseInt(operands[0]);
        for(int i=1;i<operands.length-1;i++){
            if(operators[i].equals("+"))
                agregate += Integer.parseInt(operands[i]);
            else if(operators[i].equals("-"))
                agregate -= Integer.parseInt(operands[i]);
            if(operators[i].equals("*"))
                agregate *= Integer.parseInt(operands[i]);
            else
                agregate /= Integer.parseInt(operands[i]);
        }

        System.out.println(agregate);
    }
}

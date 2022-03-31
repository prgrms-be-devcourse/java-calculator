package main.calculator;

import java.util.ArrayList;
import java.util.List;

public class Operator {

    public String calculate(String content){
        //Calculator에서 부를 녀석
        String[] oneline = content.split(" ");
        List<String> list = new ArrayList<>();
        for(String s1 : oneline){
            list.add(s1);
        }

        //먼저 * /, 그이후 + -  계산하기
        calc(list,"*","/");
        calc(list,"+","-");

        // 식 완성
        return list.get(0);
    }

    private void calc(List<String> list, String target1 ,String target2){
        //주어진 list를 돌면서 연산자를 찾았을때 앞뒤값 계산하기

        //연산자는 최소 1부터 시작, 그리고 2칸씩이동 다음 연산자 가능
        for (int i = 1; i <list.size() ; i+=2) {

            String cur = list.get(i);

            if(cur.equals(target1) || cur.equals(target2)){
                //앞뒤 빼오기
                // 1 + 2 이면 back =2, front = 1, 인덱스 +도 빼기
                double back = Double.parseDouble(list.remove(i+1));
                list.remove(i);
                double front = Double.parseDouble(list.remove(i-1));

                if(cur.equals("*")){
                    list.add(i-1,String.valueOf(front * back));
                }
                else if(cur.equals("/")){
                    list.add(i-1,String.valueOf(front / back));
                }
                else if(cur.equals("+")){
                    list.add(i-1,String.valueOf(front + back));
                }
                else if(cur.equals("-")){
                    list.add(i-1,String.valueOf(front - back));
                }
                //인덱스 제거 후 제자리
                i-=2;
            }
        }
    }
}

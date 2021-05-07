package com.sun.数据结构与算法.assignment;

import java.util.Scanner;
import java.util.Stack;

/**
 * 四则运算
 * create by qiulisun on 2018/12/19.<br>
 */
public class ArithmeticOperationDemo {

    public static void main(String[] args){


        //从控制台读取字符串
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        line = line.replaceAll("\\s", "");

        int result = simpleOperation(line);

        System.out.println(result);
    }

    /**
     * 简单四则运算
     * @param equation 四则运算式
     * @return 运算结果
     */
    public static int simpleOperation(String equation){
        Stack<Integer> nums = new Stack<>();//保存运算数字的栈
        Stack<String> symbols = new Stack<>();//保存运算符号的栈
        while(equation != null && equation.length() > 0){
            int symIndex = getLastIndex(equation);
            if(symIndex == -1){//表示已经到了运算式的结尾，需要返回结果了
                int num = Integer.valueOf(equation);
                return getResult(num, symbols.pop(), nums.pop());
            }
            int num = Integer.valueOf(equation.substring(0, symIndex));
            nums.push(num);
            String sym = equation.substring(symIndex, symIndex + 1);
            //完成计算流程
            String lastSym = symbols.empty() ? null : symbols.peek();//获取前一个运算符
            //前一个运算符存在，且它的等级是不小于当前运算符，就进行一次运算，
            //把数字栈中的后两个元素弹栈操作，使用前一个运算符完成计算
            //使用while的原因是可能在符号栈中需要继续进行往前一步的运算
            while(lastSym != null && getLevel(lastSym) >= getLevel(sym)){
                nums.push(getResult(nums.pop(), symbols.pop(), nums.pop()));
                lastSym = symbols.empty() ? null : symbols.peek();
            }
            symbols.push(sym);
            equation = equation.substring(symIndex + 1);
        }
        return 0;
    }

    //计算结果，因为是弹栈操作，所有后弹出的数字在运算符前面
    private static int getResult(int a, String sym, int b){
        switch(sym){
            case "+" : return b + a;
            case "-" : return b - a;
            case "*" : return b * a;
            default : return b / a;
        }
    }

    //运算符等级，等级越高需要越先完成计算
    private static int getLevel(String sym){
        return sym.equals("+") || sym.equals("-") ? 1 : 2 ;
    }

    //最接近运算式起始的符号位置，用来确定马上要参与运算的数字和该数字之后的运算符
    private static int getLastIndex(String equation){
        int addIndex = equation.indexOf("+");
        int symIndex = -1;
        if(addIndex > -1){
            symIndex = addIndex;
        }
        int subIndex = equation.indexOf("-");
        if(subIndex > -1 && (symIndex == -1 || symIndex > subIndex)){
            symIndex = subIndex;
        }
        int mulIndex = equation.indexOf("*");
        if(mulIndex > -1 && (symIndex == -1 || symIndex > mulIndex)){
            symIndex = mulIndex;
        }
        int divIndex = equation.indexOf("/");
        if(divIndex > -1 && (symIndex == -1 || symIndex > divIndex)){
            symIndex = divIndex;
        }
        return symIndex;
    }
}


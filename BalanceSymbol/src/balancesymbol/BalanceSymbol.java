/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balancesymbol;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
import sun.util.locale.StringTokenIterator;

/**
 *
 * @author INT303
 */
public class BalanceSymbol {

    /**
     * @param args the command line arguments
     */
    public static String check(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        if (!f.exists()) {
            throw new FileNotFoundException(fileName);
        }
        Scanner sc = new Scanner(f);
        LinkedList<String> stack = new LinkedList();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            StringTokenizer stk = new StringTokenizer(line, "{}[]()<>", true);
            while (stk.hasMoreTokens()) {
                String token = stk.nextToken();
                if (isBalanceSymbol(token)) {
                    if (isOpeningSymbol(token)) {
                        //System.out.println("push (" + token + ") to Stack");
                        stack.push(token);
                    } else {
                        String top = stack.peek();
                        if (top == null) {
                            return "Missing opening symbol";
                        }
                        if (getSymbolValue(top) != getSymbolValue(token)) {
                            return "Unbalance";
                        }
                        stack.pop();
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            return "Missing closing symbol";
        }
        return "Balanced";
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(check("C:\\Users\\INT303\\Documents\\NetBeansProjects\\JavaApplication\\src\\javaapplication\\Card.java")); //ชื่อไฟล์ ใส่เป็นpart ที่อยู่
    }

    private static boolean isBalanceSymbol(String symbol) {
        switch (symbol) {
            case "{":
            case "}":
            case "[":
            case "]":
            case "(":
            case ")":
            case "<":
            case ">":
                return true;
        }
        return false;
    }

    private static boolean isOpeningSymbol(String symbol) {
        switch (symbol) {
            case "{":
            case "[":
            case "(":
            case "<":
                return true;
        }
        return false;
    }

    private static int getSymbolValue(String symbol) {
        switch (symbol) {
            case "{":
            case "}":
                return 1;

            case "[":
            case "]":
                return 2;

            case "(":
            case ")":
                return 3;

            case "<":
            case ">":
                return 4;
        }
        return -1;
    }
}

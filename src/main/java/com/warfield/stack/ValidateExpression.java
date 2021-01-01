package com.warfield.stack;

import java.util.Scanner;
import java.util.Stack;

public class ValidateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the expression to check if its a valid one :");
        char[] characters = scanner.next().toCharArray();
        boolean result = isValidExpression(characters);
        if(result){
            System.out.println("Valid Expression!");
        }else {
            System.out.println("Invalid Expression");
        }

    }

    private static boolean isValidExpression(char[] characters) {
        Stack<Character> characterStack = new Stack<Character>();

        for (char c: characters ) {
            System.out.println(characterStack);
            if(c=='('){
                characterStack.push(c);
            }else if(c =='{'){
                characterStack.push(c);
            }else if(c == ')'){
                if (characterStack.empty() || characterStack.peek() !='('){
                    return false;
                }
                characterStack.pop();
            }else if(c == '}'){
                if (characterStack.empty() ||characterStack.peek() !='{'){
                    return false;
                }
                characterStack.pop();
            }

        }
     return characterStack.empty();
    }
}

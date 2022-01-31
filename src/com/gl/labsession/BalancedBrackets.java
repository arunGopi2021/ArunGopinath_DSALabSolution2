package com.gl.labsession;

import java.util.Stack;



public class BalancedBrackets {

    public static boolean isBalancedBrackets(String brcktExpression){

        if(brcktExpression.length()%2 != 0){
            return false;
        }// If the length is odd, then the bracket expression will be not balanced



        // use the stack data structure provided by the JAVA STD Library
        Stack <Character> stk = new Stack <Character>();
        // Initialze some variables
        boolean controlPushorPop = false;
        char c;

        for(int i =0; i<brcktExpression.length();i++){
            c = brcktExpression.charAt(i);

            if(!controlPushorPop){
                switch(c){
                    case '{':
                        stk.push('}');
                        break;
                    case '(':
                        stk.push(')');
                        break;
                    case '[':
                        stk.push(']');
                        break;
                    default:
                        controlPushorPop = true; 
                }
            }// if block for pushing elements to stack


            if((stk.isEmpty()) || (controlPushorPop && c != stk.pop())){
                return false;
            }// if block for popping out the elements from stack to match the elements.
            // If stack becomes empty, before we have completed the traversal of
            // the entire bracket expression, then again it is not a balanced bracket
             

        }// for loop


        if(stk.isEmpty()){
            return true;
        }else{
            return false;
        }// checking the condition where we have traversed the entire string
        // but stack still contains elements, if that is the case, then its not balanced bracket

    }//isBalancedBrackets() method


    public static void main(String[] args) {
        String[] brcktExpressionList = {"(([{}]))","(([{}]))()","(([{}]))))","(((([{}]))","({[}])"};


        for (String str : brcktExpressionList) {
            if(isBalancedBrackets(str)){
                System.out.println("The entered expression "+str+ ", is a balanced bracket expression.");
            }else{
                System.out.println("The entered expression "+str+ ", is not a balanced bracket expression.");
            }
        }// for-each loop

    }// main method

}//class

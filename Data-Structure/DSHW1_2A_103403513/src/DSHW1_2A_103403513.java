import java.util.Stack;
import java.util.Scanner;


public class DSHW1_2A_103403513{
    
    public static void main(String[] args){
        
        Scanner str = new Scanner(System.in);

        String ans;//used to get return data

        String origin = str.next(); // for users to input
        //step 1
        while(!check_parenthesis(origin)) {

            System.out.println("Please Enter Again:");
            origin = str.next();
        }
        System.out.println("==================================\nDiagram:\n==================================");
        ans = ToPostfix(origin);//get return data
        System.out.println("==================================\nPostfix:\n==================================");
        System.out.println(ans);
        System.out.println("==================================\ncalculate number:\n==================================");
        System.out.println(evaluate(ans));

    }//end main


    private static String evaluate(String post){

        Stack<String> st2 = new Stack<String>();

        String result ="";

        int i;

        String num1,num2,operator;

        for(i = 0; i < post.length() ;i++){
            if(post.charAt(i) == '+' || post.charAt(i) == '-' || post.charAt(i) == '*' || post.charAt(i) == '/'){
                num1 = st2.pop();
                num2 = st2.pop();
                operator = Character.toString( post.charAt(i));
                result = calculate(num2,num1,operator);
                //System.out.println(result);
                st2.push(result);
            }else{
                
                st2.push(Character.toString( post.charAt(i)));
            }
        }

        return result;

    }

    private static String calculate(String num2,String num1,String operator){
        int result = 0;
        int n1 = Integer.parseInt(num2);
        int n2 = Integer.parseInt(num1);
        switch(operator){
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                result = n1 / n2;
                break;
            default:
                System.out.println("error");
        }
        return Integer.toString(result);
    }

    private static String ToPostfix(String origin){

        Stack<String> st1 = new Stack<String>();

        String post = ""; //used to get postfix's result

        String operation_st ="";//used to get stack's data

        int len = origin.length();

        String temp;//to catch data temporary , such as from pop and push.
        
        //print title of each columns
        System.out.printf("%-15s %-20s %-20s\n","InputBuffer","OperatorStack","OutputString");

        System.out.printf("%-15s %-20s %-20s\n",origin,"Empty","Empty");

        //get each char in user's input formula

        for(int i = 0; i< len ; i++ ){
            //push '(' to stack if meet
            if( origin.charAt(i) == '(' ){

                 st1.push(Character.toString( origin.charAt(i) ) );
                 //concat output string,always follows behind a operation such as pop and push
                 operation_st += Character.toString(origin.charAt(i));
                 operation_st += " ";

            }
            //continuously popstack until meet ')'
            else if(origin.charAt(i) == ')'){

                temp = st1.pop();
                //delete last word from string
                operation_st = operation_st.substring(0,operation_st.lastIndexOf(" ")-1);
                while( temp.charAt(0) != '(' ){
                    //concat output string,always follows behind a operation such as pop and push
                    post += temp;
                    temp = st1.pop();
                    //delete last word from string
                    operation_st = operation_st.substring(0,operation_st.lastIndexOf(" ")-1);
                }         
            
            }
            
            // check operator
            else if(origin.charAt(i) == '+' || origin.charAt(i) == '-' || origin.charAt(i) == '*' || origin.charAt(i) == '/'){
                
                if(!st1.empty()){

                    temp = st1.peek();
                    while( !st1.empty() &&  new_has_low_priority(Character.toString( origin.charAt(i) ) , temp )  ){

                        temp = st1.pop();
                        //delete last word from string , always follows behind a pop
                        operation_st = operation_st.substring(0,operation_st.lastIndexOf(" ")-1);
                        //concat output string,always follows behind a operation such as pop and push
                        post += temp;
                        System.out.printf("%-15s %-20s %-20s\n",origin.substring(i,len),(st1.empty()?"Empty":operation_st),post);
                        if(!st1.empty()) temp = st1.peek();
                    }
                }
                st1.push(Character.toString(origin.charAt(i)));
                //concat output string,always follows behind a operation such as pop and push
                operation_st += Character.toString(origin.charAt(i));
                operation_st += " ";

                
            }
            //check operand print it out
            else{
                post += Character.toString( origin.charAt(i));
            }//end if
            //output a form
            System.out.printf("%-15s %-20s %-20s\n",origin.substring(i+1,len),(st1.empty()?"Empty":operation_st),post);

        }//end for

        //clear a stack and print all operators out
        while(!st1.empty()){
            temp = st1.pop();
            //delete last word from string , always follows behind a pop
            operation_st = operation_st.substring(0,operation_st.lastIndexOf(" ")-1);
            //concat output string,always follows behind a operation such as pop and push
            post += temp;
            System.out.printf("%-15s %-20s %-20s\n"," ",(st1.empty()?"Empty":operation_st),post);
        }

        return post;
    }

    //check the new data has a lower priority or not
    private static boolean new_has_low_priority(String newData , String topData){
        int newprio = 0;
        int topprio = 0;

        switch (topData){
            case "(":
            case ")":
                topprio = 0;
                break;
            case "+":    
            case "-":
                topprio = 1;
                break;
            case "*":
            case "/":
                topprio = 2;
                break;
            default:
                return false;       
        }
        switch (newData){
            case "(":
            case ")":
                newprio = 100;
                break;
            case "+":    
            case "-":
                newprio = 1;
                break;
            case "*":
            case "/":
                newprio = 2;
                break;
            default:
                return false;      
        }
        if(newprio <= topprio) return true;
        else return false;
    }//end priority

    //step1: check if the parenthesis is matched
    private static boolean check_parenthesis(String origin){

        Stack<String> st = new Stack<String>();
        
        for(int i = 0; i<origin.length() ; i++ ){
                
            if( origin.charAt(i) == '(' ){
                
                st.push(Character.toString( origin.charAt(i) ) );
            
            }
            
            else if(origin.charAt(i) == ')')
            {
                
                if( st.empty() ) {
                    System.out.println("Closing parethesis not matched.");
                    return false;
                }
                else{ st.pop();}  //end if
                
            }//end if
            
        }//end for
        if( !st.empty() ){
            System.out.println("Opening parethesis not matched.");
            return false;
        }
        return true;
    }//end check_parethesis

}//end class
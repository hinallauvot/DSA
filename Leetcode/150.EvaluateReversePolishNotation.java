class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String ch : tokens){
            if((ch.charAt(0) >= '0' && ch.charAt(0) <= '9') || (ch.length() > 1 && ch.charAt(0) == '-' )){
                stack.push(Integer.parseInt(ch));
            }    
            else{
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch(ch){
                    case "+" : stack.push(num1 + num2);
                                break;
                    case "-" : stack.push( num2 - num1);
                                break;
                    case "*" : stack.push(num1 * num2);
                                break;
                    case "/" : stack.push(num2/num1);
                                break;
                }
            }
        }
        return stack.pop();
    }
}
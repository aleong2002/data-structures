package DSHw2;

import java.util.Scanner;

public class PostfixCalculator extends Converter{
	public PostfixCalculator(String str) {
		super(str);
	}
	
	@SuppressWarnings("unchecked")
	public Object calculate(String postfix) {
		ArrayStack d = new ArrayStack<String>();
		char[] x = postfix.replaceAll(" ","").toCharArray();
    	parse(x);
    	
		for (int i = 0; i < x.length;i++) {
			if (Character.isDigit(x[i])) { 
				d.push((double)x[i] - '0');
			}
			else{
				double n1 = (double) d.pop();
                double n2 = (double) d.pop();
                
            	switch (x[i]) {
           			case '+': d.push(n2 + n1); break;
           			case '-': d.push(n2 - n1); break;
           			case '*': d.push(n2 * n1); break;
           			case '/': d.push(n2 / n1); break;
           			case '^': d.push(Math.pow(n1, n2));
            	}
				
			}
		}
		return d.pop();
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
    	
    	System.out.println("Type in-fix equation: ");
    	String i = input.nextLine();
    	PostfixCalculator u = new PostfixCalculator(i);
    	System.out.println("Converted to post-fix: " + u.toPostFix(i));
    	System.out.println("Answer: " + u.calculate(u.toPostFix(i)));
    	
    	input.close();
	}
}

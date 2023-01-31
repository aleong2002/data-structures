package QueueHW;
import java.util.Scanner;

public class Sieve extends ArrayQueue<Integer> {
	private static ArrayQueue<Integer> numbers, primes;
	private int num;
	
	public Sieve() {
		
	}
	
	public Sieve(int num) {
		this.num = num;
		numbers = new ArrayQueue<Integer>(num);

		for (int i = 2; i <= num; i++) {
			numbers.enqueue(i);
		}
				
		primes = new ArrayQueue<Integer>(num);
	}
	
	void addPrimes() {
		if (numbers.size() > 1) {
		 int p = numbers.dequeue();
         primes.enqueue(p); 

         do {

             int size = numbers.size();
              
             for (int j = 0; j < size; j++){ 
            	 int element = numbers.dequeue(); 
            	 
                 if ((element % p) != 0){
                	 numbers.enqueue(element); 
                 } 
             } 
             p = numbers.dequeue(); 

            primes.enqueue(p); 

         } while (p <= Math.sqrt(num));
          
         while (!numbers.isEmpty()){ 
             p = numbers.dequeue(); 
             primes.enqueue(p); 
             }  
		}
		else {
			primes.enqueue(2);
		}
		
	}
	
	static void primesTo(int n) throws InvalidNumberException {
		if (n >= 2) {
			primes.display();
			
		}
		else {
			throw new InvalidNumberException();
		}
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the upper bound: ");
		
		try {
			int number = input.nextInt();
			if (number < 2) {
				throw new InvalidNumberException();
			}
			Sieve x = new Sieve(number);
			x.addPrimes();
			primesTo(number);
			

		} catch (InvalidNumberException e) {
			System.out.println("Error: number must be more than 2");
		}
	}
}

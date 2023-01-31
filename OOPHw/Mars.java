package OOPhw;
public class Mars extends Currency implements Exchangeable {
	
	public Mars() {
		super("MarsMoney", 0);
		this.planet = "Mars";
	}
	
	public Mars(double totalFunds) {
		super("MarsMoney", totalFunds);
		this.planet = "Mars";
	}

	@Override
	public double toEarthDollars(double amount) {
		return amount / MM;
	}

	@Override
	public double fromEarthDollars(double EarthDollars) {
		return EarthDollars * MM;
	} 
	
	@Override
	public void exchange(Currency other, double amount) {
		if (amount > this.totalFunds) {
			System.out.printf("Uh oh - Mars has an available balance of $%.2f, which is less than $%.2f!\n", this.totalFunds, amount);
			System.out.println();
		}
		else {
			System.out.println("Converting from " + super.currencyName + " to " + other.currencyName + " and initiating transfer...");
			System.out.printf("$%.2f MarsMoney = $%.2f EarthDollars = %.2f %s\n", amount, toEarthDollars(amount), other.fromEarthDollars(toEarthDollars(amount)), other.currencyName);
			this.totalFunds -= amount;
			System.out.printf("Mars has a total of $%.2f MarsMoney\n", this.totalFunds);
			other.totalFunds += other.fromEarthDollars(toEarthDollars(amount));
			System.out.printf("%s has a total of $%.2f %s\n", other.planet, other.totalFunds, other.currencyName);
			System.out.println();
		}
		
	}

	
}
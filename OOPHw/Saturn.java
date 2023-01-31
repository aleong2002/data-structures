package OOPhw;
public class Saturn extends Currency implements Exchangeable {
	public Saturn() {
		super("SaturnSilver", 0);
		this.planet = "Saturn";
	}
	
	public Saturn(double totalFunds) {
		super("SaturnSilver", totalFunds);
		this.planet = "Saturn";
	}

	@Override
	public double toEarthDollars(double amount) {
		return amount / SS;
	}

	@Override
	public double fromEarthDollars(double EarthDollars) {
		return EarthDollars * SS;
	} 
	
	@Override
	public void exchange(Currency other, double amount) {
		if (amount > this.totalFunds) {
			System.out.printf("Uh oh - Saturn has an available balance of $%.2f, which is less than $%.2f!\n", this.totalFunds, amount);
			System.out.println();
		}
		else {
			System.out.println("Converting from " + super.currencyName + " to " + other.currencyName + " and initiating transfer...");
			System.out.printf("$%.2f SaturnSilver = $%.2f EarthDollars = %.2f %s\n", amount, toEarthDollars(amount), other.fromEarthDollars(toEarthDollars(amount)), other.currencyName);
			this.totalFunds -= amount;
			System.out.printf("Saturn has a total of $%.2f SaturnSilver\n", this.totalFunds);
			other.totalFunds += other.fromEarthDollars(toEarthDollars(amount));
			System.out.printf("%s has a total of $%.2f %s\n", other.planet, other.totalFunds, other.currencyName);
			System.out.println();
		}
		
	}

	
}



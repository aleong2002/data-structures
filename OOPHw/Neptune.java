package OOPhw;
public class Neptune extends Currency implements Exchangeable{
	
	public Neptune() {
		super("NeptuneNickel", 0.0);
		this.planet = "Neptune";
	}
	
	public Neptune(double totalFunds) {
		super("NeptuneNickel", totalFunds);
		this.planet = "Neptune";
	}
	
	
	@Override
	public void exchange(Currency other, double amount) {
		if (amount > this.totalFunds) {
			System.out.printf("Uh oh - Neptune has an available balance of $%.2f, which is less than $%.2f!\n", this.totalFunds, amount);
			System.out.println();
		}
		else {
			System.out.println("Converting from " + super.currencyName + " to " + other.currencyName + " and initiating transfer...");
			System.out.printf("$%.2f NeptuneNickel = $%.2f EarthDollars = %.2f %s\n", amount, toEarthDollars(amount), other.fromEarthDollars(toEarthDollars(amount)), other.currencyName);
			this.totalFunds -= amount;
			System.out.printf("Neptune has a total of $%.2f NeptuneNickel\n", this.totalFunds);
			other.totalFunds += other.fromEarthDollars(toEarthDollars(amount));
			System.out.printf("%s has a total of $%.2f %s\n", other.planet, other.totalFunds, other.currencyName);
			System.out.println();
		}
		
	}

	@Override
	public double toEarthDollars(double amount) {
		return amount / NN;
	}

	@Override
	public double fromEarthDollars(double EarthDollars) {
		return EarthDollars * NN;
	}

}

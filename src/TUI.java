import java.util.Scanner;

public class TUI implements Iui{
	
	Scanner keyboard;
	public TUI(){
		keyboard = new Scanner(System.in);
	}
		
	@Override
	public int showMenu(OperatorDTO loggedin) {
		System.out.println();
		System.out.println("Velkommen!");
		System.out.println("1. Opret ny bruger");
		System.out.println("2. Ændre en bruger");
		System.out.println("3. Afvejning");
		System.out.println("4. Afslut");
		if (loggedin == null) {
			System.out.println("5. log-in");
		} else if (loggedin != null) {
			System.out.println("5. log ud");
		}
		System.out.println("6. slet en bruger");
		int x = keyboard.nextInt();	
		return x;
	}


	@Override
	public int getUserID() {
		int out;
		System.out.println("Skriv dit user id");
		out = keyboard.nextInt();
		return out - 9;
	}

	@Override
	public String getPassword() {
		String out;
		System.out.println("Skriv dit password");
		out = keyboard.next();
		return out;
	}

	@Override
	public String getName() {
		System.out.println("Skriv dit navn");
		String name = keyboard.next();
		name = name + " " + keyboard.next();
		return name;
	}

	@Override
	public long getCpr() {
		System.out.println("Skriv dit cpr");
		long cpr;
		cpr = keyboard.nextLong();
		return cpr;
	}

	@Override
	public int getChangeUserOption() {
		System.out.println("Vælg hvad du vil ændre:");
		System.out.println("1. Ændre users navn");
		System.out.println("2. Ændre users CPR-nummer");
		System.out.println("3. Ændre users Password");
		System.out.println("4. Ændre users System Admin indstillinger");
		return keyboard.nextInt();
	}

	@Override
	public int getOtherUserid() {
		System.out.println("Skriv id på den user du vil ændre i");
		return keyboard.nextInt() - 9;
	}

	@Override
	public boolean askUserSetSysAdminTrue() {
		System.out.println("Sikker på at du vil gøre denne bruger til system admin? (ja)");
		String x = keyboard.next();
		if(x.equals("ja")){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean askUserSetSysAdminFalse() {
		System.out.println("Sikker på at du vil slette denne bruger fra listen af system admins? (ja)");
		String x = keyboard.next();
		if(x.equals("ja")){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public void tellSysAdminSetTrue() {
		System.out.println("User er nu system admin");
	}

	@Override
	public void tellSysAdminSetFalse() {
		System.out.println("User er ikke længere system admin");
	}

	@Override
	public int chooseUserToDelete() {
		System.out.println("Skriv bruger id på den bruger du vil slette");
		return keyboard.nextInt() - 9;
	}

	@Override
	public void showUserDeletionSuccess() {
		System.out.println("Bruger er succesfuldt slettet");
		
	}

	@Override
	public void showLoggedinInfo(OperatorDTO user) {
		System.out.println(user);
	}

	@Override
	public long getOtherCpr() {
		System.out.println("Skriv dit cpr");
		long cpr;
		cpr = keyboard.nextLong();
		return cpr;
	}

	@Override
	public double getTaraWeight() {
		System.out.println("Skriv tara vægt i kg og tryk enter:");
		double tara = keyboard.nextDouble();
		return tara;
	}

	@Override
	public double getBruttoWeight() {
		System.out.println("Skriv brutto vægt i kg og tryk enter:");
		double brutto = keyboard.nextDouble();
		return brutto;
	}

	@Override
	public void printNettoWeight(double netto) {
		System.out.println("Nettovægten er: " + netto);
	}
}

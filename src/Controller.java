import java.util.Scanner;

public class Controller {

	
	Scanner keyboard;
	Iui ui;
	OperatorDTO loggedin;
	OperatorDAO operatorDAO;
	Afvejning vægt;
	
	public Controller() {
		keyboard = new Scanner(System.in);
		ui = new TUI();
		loggedin = null;
		operatorDAO = new OperatorDAO(ui);
		vægt = new Afvejning(ui);
	}

	public void loop(){
		while(true){
			int x = ui.showMenu(loggedin);
			switch(x){
			case 1:		// Opret ny bruger
				try{
				operatorDAO.createOperatoer(loggedin);
				}
				catch(DALException e){
					
				}
				break;
				
				
			case 2:  	// Ændre en bruger
				try{
				operatorDAO.updateOperatoer(loggedin);
				}
				catch(DALException e){
					
				}
				break;
				
				
			case 3:		// Afvejning
				if(loggedin != null){
					vægt.UdskrivVaegt();
				}
				break;
				
				
			case 4:		// Afslut programmet
				System.exit(0);
				break;
				
				
			case 5:		// Log ud/ log in
				if(loggedin == null){
					int userid = ui.getUserID();
					String password = ui.getPassword();
					try{
					if(password.equals(operatorDAO.getOperatoer(userid).getPassword())){
						loggedin = operatorDAO.getOperatoer(userid);
						ui.showLoggedinInfo(loggedin);
					}
					}
					catch(DALException e){
						
					}
				}
				else{
					loggedin = null;
				}
				break;
				
				
			case 6:		// Slet en bruger
				try{
				operatorDAO.deleteOperatoer(loggedin);
				}
				catch(DALException e){
					
				}
				break;
			}
		}
	}
}
//	public void updateUser(int oprId) {
//		boolean loop = true;
//		while (loop) {
//			System.out.println();
//			System.out.println("Du er ved at ændre i " + users[oprId-11].getOprNavn());
//			System.out.println("1. Skift navn");
//			System.out.println("2. Skift password");
//			System.out.println("3. Skift cpr");
//			System.out.println("4. Set bruger til admin");
//			System.out.println("5. Slet bruger");
//			System.out.println("6. Afslut");
//			System.out.println();
//			keyboard = new Scanner(System.in);
//			switch (keyboard.nextInt()) {
//			case 1:
//				System.out.println("Skriv hvad du vil ændre navnet på brugeren til:");
//				users[oprId-11].setOprNavn(keyboard.next());
//				break;
//			case 2:
//				System.out.println("Du er ved at ændre password for brugeren: " + users[oprId-11].getOprNavn());
//				users[oprId-11].generatePassword();
//				System.out.println("Det nye password er: " + users[oprId-11].getPassword());
//				break;
//			case 3:
//				System.out.println("Skriv hvad du vil ændre cpr til:");
//				users[oprId-11].setCpr(keyboard.nextLong());
//				break;
//			case 4:
//				System.out.println("Den nye admin er:  " + users[oprId-11].getOprNavn());
//				System.out.println("Skriv hvad det nye admin password skal være:");
//				users[oprId-11].setSysAdmin(true, keyboard.next());
//				break;
//			case 5:
//				System.out.println("Du er ved at slette følgende bruger:  " + users[oprId-11].getOprNavn());
//				System.out.println("Er du sikker? Tryk 1 for ja, tryk 2 for nej");
//				switch(keyboard.nextInt()){
//				case 1:
//					deleteUser(oprId);
//					loop = false;
//					break;
//				case 2: 
//					break;
//				}
//				break;
//			case 6:
//				loop = false;
//				break;
//			}
//		}
//	}
//}

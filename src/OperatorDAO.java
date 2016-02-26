import java.util.ArrayList;
import java.util.List;

public class OperatorDAO implements IOperatorDAO {

	private List<OperatorDTO> users;
	private int currentID;
	private Iui ui;
	
	public OperatorDAO(Iui ui){
		users = new ArrayList<OperatorDTO>();
		currentID = 11;
		OperatorDTO SystemAdmin = new OperatorDTO("Martin Dalby", 1234567890, 10);
		users.add(SystemAdmin);
		users.get(0).setSysAdmin(true, "Abc02324");
		this.ui = ui;
	}

	@Override
	public OperatorDTO getOperatoer(int oprId) throws DALException {
		return users.get(oprId-1);
	}

	@Override
	public List<OperatorDTO> getOperatoerList() throws DALException {
		return users;
	}

	@Override
	public void createOperatoer(OperatorDTO opr) throws DALException {
		if(opr.isSysAdmin()){
			String name = ui.getName();
			long cpr = ui.getCpr();
			OperatorDTO x = new OperatorDTO(name, cpr, currentID);
			users.add(x);
			currentID++;
			System.out.println("Bruger oprettet, dit password er: " + x.getPassword() + " og dit bruger ID er: " + x.getOprId());
			
		}
		else{
			// Should tell user to log in as SysAdmin to access this functionality
		}
		
	}

	@Override
	public void updateOperatoer(OperatorDTO opr) throws DALException {
		if(opr.isSysAdmin()){
			int user = ui.getOtherUserid();
			user = user -1;
			int x = ui.getChangeUserOption();
			switch(x){
			case 1:		//ændre users navn
				String navn = ui.getName();
				users.get(user).setOprNavn(navn);
				break;
				
				
			case 2:		//ændre users cpr nummer
				long cpr = ui.getOtherCpr();
				users.get(user).setCpr(cpr);
				break;
				
				
			case 3:		// ændre users password
				String password = ui.getPassword();
				if(password.equals(users.get(user).getPassword())){
					String newPassword = ui.getPassword();
					users.get(user).setPassword(newPassword);
				}
				break;
				
				
			case 4:		// Ændre users System administrator indstilling
				if(users.get(user).isSysAdmin() == false){
					boolean answer = ui.askUserSetSysAdminTrue();
					if(answer){
						users.get(user).setSysAdmin(true, users.get(user).getPassword());
						ui.tellSysAdminSetTrue();
					}
				}
				else{
					boolean answer = ui.askUserSetSysAdminFalse();
					if(answer){
						users.get(user).setSysAdmin(false, users.get(user).getPassword());
						ui.tellSysAdminSetFalse();
					}
				}
				break;
			}
			
		}
		
	}

	@Override
	public void deleteOperatoer(OperatorDTO opr) throws DALException {
		if(opr.isSysAdmin()){
			int user = ui.chooseUserToDelete();
			user = user - 1;
			users.remove(user);
			ui.showUserDeletionSuccess();
		}
		else{
			// Should tell user to log in as SysAdmin to access this functionality
		}
	}

}

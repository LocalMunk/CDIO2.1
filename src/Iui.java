
public interface Iui {

	void showUserDeletionSuccess();

	String getPassword();

	int showMenu(OperatorDTO loggedin);

	int getUserID();

	String getName();

	long getCpr();

	int getChangeUserOption();

	int getOtherUserid();

	boolean askUserSetSysAdminTrue();

	boolean askUserSetSysAdminFalse();

	void tellSysAdminSetTrue();

	void tellSysAdminSetFalse();

	int chooseUserToDelete();

	void showLoggedinInfo(OperatorDTO user);

	long getOtherCpr();

	double getTaraWeight();

	double getBruttoWeight();

	void printNettoWeight(double netto);

}		//lol

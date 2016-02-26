import java.util.Scanner;
public class Afvejning {
	
	Iui ui;
	
	public Afvejning(Iui ui){
		this.ui = ui;
	}

	public double UdskrivVaegt() {
		// TODO Auto-generated method stub
		double tara = ui.getTaraWeight();
		double brutto = ui.getBruttoWeight();
		double netto = brutto-tara;
		ui.printNettoWeight(netto);
		return netto;
	}

}

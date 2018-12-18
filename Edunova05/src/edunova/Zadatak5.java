package edunova;

import javax.swing.JOptionPane;

public class Zadatak5 {
	
	//Napiši program koji prima broj i provjerava dali je on prim (prosti) broj

	public static void main(String[] args) {
		
		int n=Integer.parseInt(JOptionPane.showInputDialog
				("Zadaj broj kako bi saznao pripada li među  proste brojeve"));
		if(n==1) {System.out.println("broj "+n+" je prosti broj"); return;}
		if(n==2) {System.out.println("broj "+n+" nije prosti broj"); return;}

		for(int i=2;i<n;i++) {
			if(n%i==0) {
				System.out.println("Broj "+n+" nije prosti broj");
				return;
				}
		}
		System.out.println("Broj "+n+" je prosti broj");
	}
	
}






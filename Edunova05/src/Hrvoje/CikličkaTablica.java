package Hrvoje;

import javax.swing.JOptionPane;

public class CikličkaTablica {
	public static void main(String[] args) {
		
		int m=Integer.parseInt(JOptionPane.showInputDialog("Zadaj broj redaka"));
		int n=Integer.parseInt(JOptionPane.showInputDialog("Zadaj broj stupaca"));
		
		
		int[][] tablica= new int [m][n];
		
		int minStup = 0;
		int maxStup = n-1;
		int minRed = 0;
		int maxRed = m-1;
	    int broj=1;    
		
	    while(broj<=(m*n)){
			for (int i = maxStup; i >= minStup; i--){
				tablica[maxRed][i] = broj++;
				}
			if(broj>(m*n)) {
				break;
			}
			for (int i = maxRed-1; i >= minRed; i--) {
				tablica[i][minStup] = broj++;
				}
			if(broj>(m*n)) {
				break;
			}
			for (int i = minStup+1; i <= maxStup; i++){
				tablica[minRed][i] = broj++;
				}
			if(broj>(m*n)) {
				break;
			}
			for (int i = minRed+1; i <= maxRed-1; i++){
				tablica[i][maxStup] = broj++;
				}
			if(broj>(m*n)) {
				break;
			}
			
			minStup++;
			minRed++;
			maxStup--;
			maxRed--;
		        }
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(tablica[i][j]+ "	");
				
			}
		System.out.println();
		}
		
	}
}
	




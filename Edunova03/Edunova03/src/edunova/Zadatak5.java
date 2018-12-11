package edunova;

import javax.swing.JOptionPane;

public class Zadatak5 {

	// Program učitava 4 broja.
	// u slučaju da je prvi jednak zadnjem broju ispisuje
	// zbroj drugog i trećeg broja
	// inače ispisuje sljedno brojeve od najmanjeg prema najvećem


	public static void main(String[] args) {

		long a=Long.parseLong(JOptionPane.showInputDialog("Zadaj 1. broj"));
		long b=Long.parseLong(JOptionPane.showInputDialog("Zadaj 2. broj"));
		long c=Long.parseLong(JOptionPane.showInputDialog("Zadaj 3. broj"));
		long d=Long.parseLong(JOptionPane.showInputDialog("Zadaj 4. broj"));
		
		long e=0,f=0,g=0,h=0;
		
		if(a==d) {
			System.out.println(b+c);
			return;
		}else {
		//Najveći broj
			
			if(a>=b) {
				e=a;
			}else {
				e=b;
			}
			if(c>=e) {
				e=c;
			}
			if(d>=e) {
				e=d;
			}
			
		//drugi po veličini
			
			if(a<e && a>f) {
				f=a; 
			}
			if(b<e && b>f){
				f=b; 
			}
			if(c<e && c>f) {
				f=c; 
			}
			if(d<e && d>f) {
				f=d; 
			}
			
		//treći po veličini
			
			if(a<f && a>g) {
				g=a; 
			}
			if(b<f && b>g){
				g=b; 
			}
			if(c<f && c>g) {
				g=c; 
			}
			if(d<f && d>g) {
				g=d; 
			}

		//najmanji
			
			if(a<g && a>h) {
				h=a; 
			}
			if(b<g && b>h){
				h=b; 
			}
			if(c<g && c>h) {
				h=c; 
			}
			if(d<g && d>h) {
				h=d; 
			}

	}
	//Ispis brojeva
		if(e==a) {
			System.out.println(a);
		}if(e==b) {
			System.out.println(b);
		}if(e==c) {
			System.out.println(c);
		}if(e==d) {
			System.out.println(d);
		}
		
		
		if(f==a) {
			System.out.println(a);
		}if(f==b) {
			System.out.println(b);
		}if(f==c) {
			System.out.println(c);
		}if(f==d) {
			System.out.println(d);
		}
		
		
		if(g==a) {
			System.out.println(a);
		}if(g==b) {
			System.out.println(b);
		}if(g==c) {
			System.out.println(c);
		}if(g==d) {
			System.out.println(d);
		}
		
		
		if(h==a) {
			System.out.println(a);
		}if(h==b) {
			System.out.println(b);
		}if(h==c) {
			System.out.println(c);
		}if(h==d) {
			System.out.println(d);
		}
			
	}
}

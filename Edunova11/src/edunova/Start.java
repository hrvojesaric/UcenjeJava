package edunova;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Start {
	
	private List<Osoba> osobe;
	private Scanner ulaz;
	
	
	public Start() {
		ulaz= new Scanner(System.in);
		osobe = new ArrayList<>();
		odabir();
		
		ulaz.close();
	}
	
	private void odabir() {
		System.out.println(" ----------------");
		System.out.println("|  CRUD primjer  |");
		System.out.println(" ----------------");
		System.out.println("***Unesite broj za akciju***");
		System.out.println("1: Dodaj novu osobu");
		System.out.println("2: Promjeni postojeću osobu");
		System.out.println("3: Obriši osobu");
		System.out.println("4: Izlistaj sve osobe");
		System.out.println("5: Izlaz iz programa");
		System.out.println("6: Ispis imena i prezimena osobe s najvećim primanjima");
		System.out.println("7: Ispis prosjeka svih primanja");
		System.out.println("8: Dodavanje 10 osoba s slučajnim vrijednostima");
		System.out.println("9: Brisanje svake osobe čija šifra je parni broj");
		System.out.println("------------------------------------------------------------------");
		
		switch (Pomocno.ucitajBroj(ulaz,"Unesi odabir", 1, 9)) {
		case 1:
			dodajNovuOsobu();
			break;
		case 2:
			promjeniOsobu();
			break;
		case 3:
			obrisiOsobu();
			break;
		case 4:
			izlistajSveOsobe();
			break;
		case 5:
			return;
		case 6:
			ispisiOsobuNajvecihPrimanja();
			break;
		case 7:
			ispisProsjekaPrimanja();
			break;
		case 8:
			dodajDesetOsobaSaSlucajnimVrijednostima();
			break;
		case 9:
			obrisiOsobeParnaSifra();
			break;

		default:
			break;
		}
		odabir();
	}

	private void dodajNovuOsobu() {
		Osoba o = new Osoba();
		o=postaviVrijednostiSvojstava(ulaz, o);
		
		osobe.add(o);
	}

	private void promjeniOsobu() {
		if(osobe.size()==0) {
			return;
		}
		System.out.println("Odaberite redni broj osobe za promjenu");
		for(int i=0;i<osobe.size();i++) {
			System.out.println((i+1) + ": " + osobe.get(i));
		}
		
		int index = Pomocno.ucitajBroj(
				ulaz, 
				"redni broj osobe", 
				1, osobe.size());
		
		Osoba o = osobe.get(index-1);
		
		o=promjeniVrijednostiSvojstava(ulaz, o);
		
		osobe.set(index-1, o);
		
	}
	
	private void obrisiOsobu() {
		if(osobe.size()==0) {
			return;
		}
		System.out.println("Odaberite redni broj osobe za brisanje");
		for(int i=0;i<osobe.size();i++) {
			System.out.println((i+1) + ": " + osobe.get(i));
		}
		
		int index = Pomocno.ucitajBroj(
				ulaz, 
				"redni broj osobe", 
				1, osobe.size());
		osobe.remove(index-1);
		
	}
	
	private void izlistajSveOsobe() {
		for(Osoba o: osobe) {
			System.out.println(o);
		}
	}
	
	private void ispisiOsobuNajvecihPrimanja() {
		BigDecimal maxprimanja = new BigDecimal(0.0);
		for(int i=0;i<osobe.size();i++) {
			
			if(maxprimanja.compareTo(osobe.get(i).getPrimanje())  < 0) {
				
				maxprimanja = osobe.get(i).getPrimanje();
			}
		}
		
		for(int i=0;i<osobe.size();i++) {
			if(maxprimanja.compareTo(osobe.get(i).getPrimanje())==0) {
				System.out.println("Osoba s najvećim primanjima je "+osobe.get(i).getIme()+"  "+osobe.get(i).getPrezime());
			}
		}
		
	}

	private void ispisProsjekaPrimanja() {
		BigDecimal duz= new BigDecimal(osobe.size());
		BigDecimal zbroj = new BigDecimal(0.0);
		BigDecimal prosjek = new BigDecimal(0.0);
		for(int i=0;i<osobe.size();i++) {
		zbroj=zbroj.add(osobe.get(i).getPrimanje());
		}
		prosjek=zbroj.divide(duz);
		System.out.println("\n"+"Prosjek primanja svih osoba iznosi = "+prosjek +"\n");
	}

	private void dodajDesetOsobaSaSlucajnimVrijednostima() {
		for(int i=0;i<10;i++) {
		Osoba sl = new Osoba();
		sl.setIme(Pomocno.slucajniString());
		sl.setPrezime(Pomocno.slucajniString());
		sl.setPrimanje(Pomocno.slucajniBigDecimal());
		sl.setSifra(Pomocno.slucajniInteger());
		osobe.add(sl);
		
		}
		System.out.println("Uspješno ste dodali 10 nasumičnih osoba sa slučajnim podacima");
	}

	private void obrisiOsobeParnaSifra() {
		
		for(int i=0;i<osobe.size();i++) {
			if(osobe.get(i).getSifra()%2==0) {
				osobe.remove(i);
			}
			
		}
		System.out.println("Obrisali ste sve osobe koje su sadržavale parnu šifru");
		
	}

	
	

	

	
	
	private Osoba postaviVrijednostiSvojstava(Scanner ulaz,Osoba o) {
		int sifra=Pomocno.ucitajBroj(ulaz,"Unesi šifru", 1, Integer.MAX_VALUE);
	
				for(int i=0;i<osobe.size();i++) {
					if(sifra==osobe.get(i).getSifra()) {
						i=0;
						System.err.println("Nije moguće unijeti dvije osobe s istom šifrom.");
						sifra=Pomocno.ucitajBroj(ulaz,"Unesi šifru", 1, Integer.MAX_VALUE);	
						
					}				
					
				}
		o.setSifra(sifra);
		o.setIme(Pomocno.ucitajString(ulaz,"Unesi ime"));
		o.setPrezime(Pomocno.ucitajString(ulaz, "Unesi prezime"));
		while(true) {
			
		BigDecimal primanje = Pomocno.ucitajDecimalniBroj(ulaz,"Unesi primanje");
		if(primanje.compareTo(BigDecimal.ZERO) >=0) {
		o.setPrimanje(primanje);
		break;
		
		}else {
			System.err.println("Primanje mora biti pozitivnog iznosa.");
			}
		}return o;
	}
	
	private Osoba promjeniVrijednostiSvojstava(Scanner ulaz,Osoba o) {	
		int sifra=Pomocno.ucitajBroj(ulaz,"Unesi šifru", 1, Integer.MAX_VALUE);		
		for(int i=0;i<osobe.size();i++) {
			if(sifra==osobe.get(i).getSifra()) {
				i=0;
				System.err.println("Nije moguće unijeti dvije osobe s istom šifrom.");
				sifra=Pomocno.ucitajBroj(ulaz,"Unesi šifru", 0, Integer.MAX_VALUE);	
				}				
			}
		o.setSifra(sifra);
		o.setIme(Pomocno.ucitajString(ulaz,"Unesi ime"));
		o.setPrezime(Pomocno.ucitajString(ulaz, "Unesi prezime"));
		while(true) {
			BigDecimal primanje = Pomocno.ucitajDecimalniBroj(ulaz,"Unesi primanje");
			if(primanje.compareTo(BigDecimal.ZERO) >=0) {
				o.setPrimanje(primanje);
				break;
				}else {
					System.err.println("Primanje mora biti pozitivnog iznosa.");
					}
			}return o;
			}
	public static void main(String[] args) {
		new Start();
		}
	}


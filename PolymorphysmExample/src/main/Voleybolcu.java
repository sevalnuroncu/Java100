package main;

public class Voleybolcu implements Sporcu, VoleybolcuOynayabilir{

	public void antrenmanYap() {
		System.out.println("Voleybolcu antrenman yapıyor");
		
	}

	@Override
	public void pasAt() {
		System.out.println("Pas atılıyor.");
		
	}

	@Override
	public void servisAt() {
		System.out.println("Oyun başladı");
		
	}

	@Override
	public void blokYap() {
		System.out.println("Blok yapıldı");
		
	}




}

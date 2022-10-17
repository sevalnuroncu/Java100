package main;

public class Futbolcu implements Sporcu, FutbolcuOynayabilir {

	@Override
	public void antrenmanYap() {
		System.out.println("Futbolcu antrenman yapıyor.");
		
	}

	@Override
	public void pasAt() {
		System.out.println("Futbolcu pas atıyor.");
		
	}

	@Override
	public void serbestVurusYap() {
		System.out.println("Serbest vuruş yapılıyor");
		
	}



}

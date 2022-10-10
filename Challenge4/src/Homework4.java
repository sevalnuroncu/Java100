import java.util.ArrayList;
import java.util.Scanner;

/*Konsoldan girilen string içerisinde hangi harften kaç tane bulunduğunu sıralı bir şekilde yazmak, map kullanarak
Örnek: numan -> n2u1m1a1
Numan karaaslan n3u1m1a5 1k1r1s1l1
Konsoldan girilen ifadeyi zipleyip harfleri listeye atmak (arraylist ile)
Örnek: numankaraaslan -> numakrsl*/

public class Homework4 {

	public static void main(String[] args) {
		
	//countLetter();
	zip();
		
	}

	private static void zip() {
		Scanner scan=new Scanner(System.in);
		System.out.println("isim giriniz: ");
		String metin = scan.nextLine();
		ArrayList<Character> karakterler=new ArrayList<>();
		for(int i=0; i<metin.length(); i++) { //metin arrayliste çevrildi
			karakterler.add(metin.charAt(i));
		}
		ArrayList<Character> liste=new ArrayList<>();
		for(int i=0; i<karakterler.size(); i++) {//Boş bir liste oluşturuldu ve karakter dizisinin  elemanları tekrarsız eklendi.
			int tekrarsayısı=0;
			for(int j=0; j<i; j++) {
				if(karakterler.get(i)==karakterler.get(j)) {
					tekrarsayısı=1;
					break;
				}	
			}
			if(tekrarsayısı==0) {
				liste.add(karakterler.get(i));				
			}
		}
		for(char harf:liste) {
		 if(harf!=' '){
			System.out.print(harf);
		 }
		}
		//System.out.println(liste.toString());
		
	}

	private static void countLetter() {
		Scanner scan=new Scanner(System.in);
		System.out.println("isim giriniz: ");
		String metin = scan.nextLine();
		ArrayList<Character> karakterler=new ArrayList<>();
		for(int i=0; i<metin.length(); i++) { //metin arrayliste çevrildi
			karakterler.add(metin.charAt(i));
		}
		ArrayList<Character> liste=new ArrayList<>();
		for(int i=0; i<karakterler.size(); i++) {//Boş bir liste oluşturuldu ve karakter dizisinin  elemanları tekrarsız eklendi.
			int tekrarsayısı=0;
			for(int j=0; j<i; j++) {
				if(karakterler.get(i)==karakterler.get(j)) {
					tekrarsayısı=1;
					break;
				}
			
			}
			if(tekrarsayısı==0) {
				liste.add(karakterler.get(i));
			}
		}

		int count=0;
		for(char harf:liste) {
			for(int i=0; i<karakterler.size(); i++) {
				if(harf==karakterler.get(i)) {
					count=count+1;
				}
			}
			System.out.print(harf);
			System.out.print(count);
			count=0;
			
		}
		
	}

}

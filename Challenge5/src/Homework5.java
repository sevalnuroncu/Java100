
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*Konsoldan girilen string içerisinde hangi harften kaç tane bulunduğunu 
sıralı !!! bir şekilde yazmak (Map kullanarak)
Örnek: numan -> n2u1m1a1*/


public class Homework5 {

	public static void main(String[] args) {

		countLetter();
	}

	private static void countLetter() {
		Scanner scan=new Scanner(System.in);
		System.out.println("isim giriniz: ");
		String metin = scan.nextLine();
        //linkedhashmap ile sıralı olması sağlandı
        Map<Character, Integer> hashMap = new LinkedHashMap<>();
 
        
        // Konsoldan alınan girdi letters adında char array'e dönüştürldü
        char[] letters = new char[metin.length()];
        metin.getChars(0, metin.length(), letters, 0);
        //System.out.println(letters);
        
        for (char letter : letters) {
            // hashmap içerisinde letter varsa value'yu arttır. ve key ve value'yu
        	//hashmap'e ekle. Yoksa key'i ekle value'yu 1 olarak ekle.
            if (hashMap.containsKey(letter))
                hashMap.put(letter, hashMap.get(letter) + 1);
 
            else
                hashMap.put(letter, 1);
        }
        //key ve value'ları yanyana yazdırıldı.
        for(Entry<Character, Integer> entry:hashMap.entrySet()) {
        	System.out.print(entry.getKey()+""+entry.getValue());
        }
        //System.out.println(hashMap);
    }

	
}


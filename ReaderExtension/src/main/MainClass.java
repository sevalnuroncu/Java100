package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
/*
Bir reader extension 'ı yazılması gerekiyor
dosyadaki büyün kelimeleri okuma yapabilmesi gerekiyor
dosyadan istediğim satır numarasını okuyabilmesi gerekiyor
String 'lerin Split fonksiyonu kullanılmayacak
ArrayList<String> kelimeler = myReader.readWords("C:/dosya.txt");
String satir = myReader.readLineAt(4);
  */

public class MainClass {

	public static void main(String[] args) {

		ReaderClass myReader=new ReaderClass();
		myReader.readWords("C:\\Development\\eclipse\\workspace\\ReaderExtension\\src\\main\\examplefile.txt");
		myReader.readLineAt(6);
	}
		
}

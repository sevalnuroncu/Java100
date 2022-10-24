package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderClass {

	public void readWords(String uri) {
		File file=new File(uri);
		try {
			Scanner reader=new Scanner(file);
			while(reader.hasNextLine()) {
				String str=reader.nextLine();
				str=str+" ";//son kelimeyi okutabilmek için boşluk eklendi
				ArrayList<String> words=new ArrayList<>();
				ArrayList<Integer> spaceIndex=new ArrayList<>();//Boşluk indeksleri için integer arraylist oluşturuldu
					spaceIndex.add(0);	
				for(int i=0; i<str.length(); i++) {
					//Boşluk olan karakterlerin indeksi spaceIndex arraylistine eleman olarak eklendi
					if(str.charAt(i)==' ') {
						spaceIndex.add(i);	
					}
				}
				for(int j=1; j<spaceIndex.size(); j++) {
					//kelimeler boşluk karakterinden alt kümeye bölündü ve words arraylistine eklendi
					words.add(str.substring(spaceIndex.get(j-1),spaceIndex.get(j)));
					//System.out.println(words.toString());
				}
				
				//System.out.println(spaceIndex.toString());//[0, 5, 10, 14, 20]
				System.out.println(words.toString());
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void readLineAt(int index) {
		BufferedReader reader=null;
		try {
			String uri="C:\\Development\\eclipse\\workspace\\ReaderExtension\\src\\main\\examplefile.txt";
			reader=new BufferedReader(new FileReader(uri));
			String line=null;
			ArrayList<String> lines=new ArrayList<>();
			while((line=reader.readLine())!=null) {
				lines.add(line);
				//System.out.println(line);
			}
			System.out.println(lines.get(index));
			
			reader.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

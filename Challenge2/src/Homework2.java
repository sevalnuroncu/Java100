public class Homework2 {

	public static void main(String[] args) {
		// 1 2 3 -> 9 8 7
		// 4 5 6 -> 6 5 4
		// 7 8 9 -> 3 2 1
		// arrayFlip1();
		// ----------------
		// 1 2 3 -> 7 4 1
		// 4 5 6 -> 8 5 2
		// 7 8 9 -> 9 6 3
		// arrayFlip2();
		// ----------------
		// hangi karakterden kaç kere tekrar ettiğini söylüyor
		// "aaaafggg assssvv t"
		// "a4f1g3 a1s4v2 t1"
		// zip();
		
		//arrayFlip1();
		//arrayFlip2();
		zip();

		}

	private static void zip() {
		String metin="aaaafggg assssvv t";
		metin=metin+" ";//son karakterini yazdırmak için
		int count=1;
		for(int i=1; i<metin.length(); i++) {
			if (metin.charAt(i)==metin.charAt(i-1)) {
				count=count+1;		
			}
			else {
				System.out.print(metin.charAt(i-1));
				if(metin.charAt(i-1)!=' ') {//Boşluk karakterini saydırmamak için.
					System.out.print(count);
				}
				count=1;
			}	
		}	
	}

	private static void arrayFlip2() {
		int[][] matris= {{1,2,3},{4,5,6},{7,8,9}};
		for(int i=0; i<matris.length; i++ ) {
			for(int j=matris[i].length-1; j>=0; j--) {
				System.out.print(matris[j][i]+ " ");
			}
			System.out.println();
			
		}
		
	}

	private static void arrayFlip1() {
		int[][] matris= {
				{1,2,3},
				{4,5,6},
				{7,8,9}};
		for (int i = matris.length-1; i >=0; i--) {
		    for (int j = matris[i].length-1; j>=0; j--) {
		        System.out.print(matris[i][j] + " ");
		    }
		    System.out.println();
		}
		
	}

}

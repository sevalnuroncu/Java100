
public class MainClass {

	public static void main(String[] args) {
		Musician musician=new Musician();
		Pianist pianist=new Pianist();
		Soloist soloist=new Soloist();
		soloist.setAge(30);
		System.out.println(soloist.getAge());
		soloist.concert();
		soloist.sing();
		pianist.compose();
		
		
		

	}

}

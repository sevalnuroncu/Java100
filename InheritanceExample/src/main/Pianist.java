package main;
public class Pianist extends Musician {
	private String compositionName;
	
	@Override
	public void concert() {
		System.out.println("Pianist is giving a concert");
	}
	
	public void compose() {
		System.out.println("Pianist is composing something");
	}



	public String getCompositionName() {
		return compositionName;
	}



	public void setCompositionName(String compositionName) {
		this.compositionName = compositionName;
	}
	
	

	
	
}

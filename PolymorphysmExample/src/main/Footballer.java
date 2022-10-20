package main;

public class Footballer implements SportsPerson, FPlayable {

	@Override
	public void doExercise() {
		System.out.println("Footballer is doing exercise");
		
	}

	@Override
	public void pass() {
		System.out.println("Footballer is passing");
		
	}

	@Override
	public void doCornerKick() {
		System.out.println("Corner kick is being done ");
		
	}



}

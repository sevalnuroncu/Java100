package main;

public class VolleyballPlayer implements SportsPerson, VPlayable{
	@Override
	public void doExercise() {
		System.out.println("VolleyballPlayer is doing exercise.");
		
	}

	@Override
	public void pass() {
		System.out.println("VolleyballPlayer is passing.");
		
	}

	@Override
	public void throwServe() {
		System.out.println("Game has started.");
		
	}

	@Override
	public void doBlock() {
		System.out.println("Block is being done.");
		
	}




}

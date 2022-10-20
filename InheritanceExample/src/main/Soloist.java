package main;

public class Soloist extends Musician {
	private String songName;
	
	@Override
	public void concert() {
		System.out.println("Soloist is giving a concert");
	}
	
	public void sing() {
		System.out.println("Soloist is singing a song");
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	
}

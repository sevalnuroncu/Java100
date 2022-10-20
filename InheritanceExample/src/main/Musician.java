package main;

public class Musician {
	private String musicianName;
	private int age;
	
	public void concert() {
		System.out.println("give a concert");
	}

	public String getMusicianName() {
		return musicianName;
	}

	public void setMusicianName(String musicianName) {
		this.musicianName = musicianName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}

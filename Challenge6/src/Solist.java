
public class Solist extends Muzisyen {
	private String sarkıAdı;
	
	public void soyle() {
		System.out.println("Şarkı söyle");
	}

	public String getSarkıAdı() {
		return sarkıAdı;
	}

	public void setSarkıAdı(String sarkıAdı) {
		this.sarkıAdı = sarkıAdı;
	}
	
	@Override
	public String getMuzisyenAdi() {
		return super.getMuzisyenAdi();
	}
	
	@Override
	public int getYas() {
		return super.getYas();
	}
}

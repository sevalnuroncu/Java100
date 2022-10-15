
public class Piyanist extends Muzisyen {
	private String besteAdı;
	
	
	
	public void besteYap() {
		System.out.println("Beste Yap");
	}
	
	@Override
	public String getMuzisyenAdi() {
		return super.getMuzisyenAdi();
	}
	
	@Override
	public int getYas() {
		
		return super.getYas();
	}
	
	public String getBesteAdı() {
		return besteAdı;
	}

	public void setBesteAdı(String besteAdı) {
		this.besteAdı = besteAdı;
		System.out.println("Beste adı");
	}
	
	
}

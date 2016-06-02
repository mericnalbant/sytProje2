package syt2proje;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class kayýt {
	private String grupNo;
	private String ogrNo;
	private String adSoyad;
	private String not;
	
	public String getGrupNo(){
		return grupNo;
	}
	
	public void setGrupNo(String grupNo){
		this.grupNo=grupNo;
	}
	
	public String getOgrNo(){
		return ogrNo;
	}
	
	public void setOgrNo(String ogrNo){
		this.ogrNo=ogrNo;
	}
	
	public String getAdSoyad(){
		return adSoyad;
	}
	
	public void setAdSoyad(String adSoyad){
		this.adSoyad=adSoyad;
	}
	
	public String getNot(){
		return not;
	}
	
	public void setNot(String not){
		this.not=not;
	}
	
}

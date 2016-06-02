package syt2proje;

import javax.annotation.ManagedBean;

@ManagedBean
public class otoKontrol extends Thread{
	private mailYoklama yoklama=null;
	
	otoKontrol(){
		//email adresini kontrol eden 'mailYoklama' sýnýfý tipinde 'yoklama' isminde bir nesne yartýldý
		yoklama=new mailYoklama();
	}

	public void run() {
		while(true)
		{
			System.out.println("Thread baþlatýldý.");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			//ilgili mail adresi 'readingEmail' fonksiyonuyla kontrol edilir.
			yoklama.readingEmail();
		}
	}
}

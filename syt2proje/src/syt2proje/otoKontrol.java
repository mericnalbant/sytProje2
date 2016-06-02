package syt2proje;

import javax.annotation.ManagedBean;

@ManagedBean
public class otoKontrol extends Thread{
	private mailYoklama yoklama=null;
	
	otoKontrol(){
		//email adresini kontrol eden 'mailYoklama' s�n�f� tipinde 'yoklama' isminde bir nesne yart�ld�
		yoklama=new mailYoklama();
	}

	public void run() {
		while(true)
		{
			System.out.println("Thread ba�lat�ld�.");
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

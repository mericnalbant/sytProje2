package syt2proje;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.*;


@ManagedBean
@SessionScoped
public class kayýtCek {
	
	public List<kayýt> getKayýtlarTablosu() throws IOException {
	    
		//dosyamýzdaki herbir satýra ait kelimeleri(alanlarý-->grupNo,ogrNo,adSoyad,not)
		//atayacaðýmýz dizi
		String[] kayýtAlanlarý=new String[5];
		FileReader fr=new FileReader("C:\\Users\\meric\\Desktop\\dosya.txt");
        BufferedReader br=new BufferedReader(fr);
        
        String str;
        //Dosyadan bir satýr okundu
        str=br.readLine();
        List<kayýt> liste=new ArrayList<>();
        //Dosyanýn sonuna gelinene kadar satýr okunmaya devam edilecek
        while(str!=null)
        {	
        	//Okunan satýrdaki bilgiler aralarýndaki boþluklar kullanýlýp ayýrýlarak
        	//'kayýtAlanlarý' dizisine atanýr.
        	kayýtAlanlarý=str.split(" ");
        	//'kayýt' tipinde 'mevcutKayýt' isminde yeni bir nesne oluþturuldu.
        	kayýt mevcutKayýt=new kayýt();
        	//yaratýlan bu nesnenin özelliklerine,dosyadan çektiðimiz bilgiler atanýr
        	mevcutKayýt.setGrupNo(kayýtAlanlarý[0]); 
        	mevcutKayýt.setOgrNo(kayýtAlanlarý[1]);
        	mevcutKayýt.setAdSoyad(kayýtAlanlarý[2]+" "+kayýtAlanlarý[3]);
        	mevcutKayýt.setNot(kayýtAlanlarý[4]);
        	//oluþturduðumuz listeye yarattýðýmýz nesne eklenir.
            liste.add(mevcutKayýt);
        	
            str=br.readLine();
        }
		
        br.close();
        return liste;
        
	}
}

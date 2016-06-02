package syt2proje;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.*;


@ManagedBean
@SessionScoped
public class kay�tCek {
	
	public List<kay�t> getKay�tlarTablosu() throws IOException {
	    
		//dosyam�zdaki herbir sat�ra ait kelimeleri(alanlar�-->grupNo,ogrNo,adSoyad,not)
		//atayaca��m�z dizi
		String[] kay�tAlanlar�=new String[5];
		FileReader fr=new FileReader("C:\\Users\\meric\\Desktop\\dosya.txt");
        BufferedReader br=new BufferedReader(fr);
        
        String str;
        //Dosyadan bir sat�r okundu
        str=br.readLine();
        List<kay�t> liste=new ArrayList<>();
        //Dosyan�n sonuna gelinene kadar sat�r okunmaya devam edilecek
        while(str!=null)
        {	
        	//Okunan sat�rdaki bilgiler aralar�ndaki bo�luklar kullan�l�p ay�r�larak
        	//'kay�tAlanlar�' dizisine atan�r.
        	kay�tAlanlar�=str.split(" ");
        	//'kay�t' tipinde 'mevcutKay�t' isminde yeni bir nesne olu�turuldu.
        	kay�t mevcutKay�t=new kay�t();
        	//yarat�lan bu nesnenin �zelliklerine,dosyadan �ekti�imiz bilgiler atan�r
        	mevcutKay�t.setGrupNo(kay�tAlanlar�[0]); 
        	mevcutKay�t.setOgrNo(kay�tAlanlar�[1]);
        	mevcutKay�t.setAdSoyad(kay�tAlanlar�[2]+" "+kay�tAlanlar�[3]);
        	mevcutKay�t.setNot(kay�tAlanlar�[4]);
        	//olu�turdu�umuz listeye yaratt���m�z nesne eklenir.
            liste.add(mevcutKay�t);
        	
            str=br.readLine();
        }
		
        br.close();
        return liste;
        
	}
}

package syt2proje;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class guncelleSil {
	String ogrNo;
	String ogrGrupNo;
	String ogrYeniNo;
	String ogrAd;
	String ogrSoyad;
	String puan;
	

	public String getogrNo(){
		return ogrNo;
	}
	
	public void setogrNo(String ogrNo){
		this.ogrNo=ogrNo;
	}
	
	public String getogrGrupNo(){
		return ogrGrupNo;
	}
	
	public void setogrGrupNo(String ogrGrupNo){
		this.ogrGrupNo=ogrGrupNo;
	}
	
	public String getogrYeniNo(){
		return ogrYeniNo;
	}
	
	public void setogrYeniNo(String ogrYeniNo){
		this.ogrYeniNo=ogrYeniNo;
	}
	
	public String getogrAd(){
		return ogrAd;
	}
	
	public void setogrAd(String ogrAd){
		this.ogrAd=ogrAd;
	}
	
	public String getogrSoyad(){
		return ogrSoyad;
	}
	
	public void setogrSoyad(String ogrSoyad){
		this.ogrSoyad=ogrSoyad;
	}
	
	public String getpuan(){
		return puan;
	}
	
	public void setpuan(String puan){
		this.puan=puan;
	}
	public void guncelle(){
		try {
			//Dosya a��l�r
            FileInputStream fstream = new FileInputStream("C:\\Users\\meric\\Desktop\\dosya.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            //Dosya sat�r sat�r okunur
            while ((strLine = br.readLine()) != null) {
            	//Okunan her sat�r i�ersindeki kelimeler,aralar�ndaki bo�luklar
            	//yard�m�yla ayr�larak 'tokens' dizisine atan�r.
                String tokens[] = strLine.split(" ");
                //token dizisi bo� de�ilse
                if (tokens.length > 0) {
                    // okudu�umuz sat�rdki bilgiler arad���m�z ��renciye ait ise
                    if (tokens[1].equals(ogrNo)) {
                    	//Burada 'tokens'(��renci bilgilerini ta��yan dizi) g�ncelleme i�lemi i�in 
                    	//xhtml sayfas�ndaki inputtext'lerden gelen
                    	//de�erleri alacak.Buradaki if bloklar�nda inputtextboxlardan
                    	//de�er gelip gelmedi�i kontrl edilir
                        if(ogrGrupNo!="")
                        	tokens[0]=ogrGrupNo;
                        if(ogrYeniNo!="")
                        	tokens[1]=ogrYeniNo;
                        if(ogrAd!="")
                        	tokens[2]=ogrAd;
                        if(ogrSoyad!="")
                        	tokens[3]=ogrSoyad;
                        if(puan!="")
                        	tokens[4] =puan;
                      //art�k ilgili ��renciye dair g�ncellemek istedi�imiz bilgiler 'tokens' dizisine at�ld�.
                        String newLine = tokens[0] + " " + tokens[1] + " " + tokens[2]+" "+tokens[3]+" "+tokens[4];
                      //ve bu yeni bilgilerden olu�an sat�r fileContent'e eklendi.
                        fileContent.append(newLine);
                        fileContent.append(System.getProperty("line.separator"));
                    } else {
                        // e�er sat�rdaki bilgiler arad���m�z ��renciye ait de�ilse
                    	//sat�rda bir de�i�iklik yapmadan oldu�u gibi fileContent'e at.
                        fileContent.append(strLine);
                        fileContent.append(System.getProperty("line.separator"));
                    }
                }
            }
            //fileContent de�i�enimiz art�k g�ncel bilgileri tutuyor ve ba�ta i�lem
            //yapt���m�z dosyay� g�ncelleyecek(�zerine yazacak)
            FileWriter fstreamWrite = new FileWriter("C:\\Users\\meric\\Desktop\\dosya.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            
            out.close();
            br.close();
            //input stream kapat�l�r
     
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
	}
	
	public void sil(){
		try {
			//Dosya a��l�r
            FileInputStream fstream = new FileInputStream("C:\\Users\\meric\\Desktop\\dosya.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
          //Dosya sat�r sat�r okunur
            while ((strLine = br.readLine()) != null) {
            	//Okunan her sat�r i�ersindeki kelimeler,aralar�ndaki bo�luklar
            	//yard�m�yla ayr�larak 'tokens' dizisine atan�r.
                String tokens[] = strLine.split(" ");
                //token dizisi bo� de�ilse
                if (tokens.length > 0) {
                	 // okudu�umuz sat�rdki bilgiler arad���m�z ��renciye ait ise
                	if (tokens[1].equals(ogrNo)) {
                        //Hi� bir�ey yapma,yani bu sat�rdaki bilgilere sahip ��renciyi
                		//fileContent de�i�kenine alma.
                    } else {
                        // arad���m�z ��renci de�ilse(yani silmek istemed�imiz ��rencilere ait bilgiler),
                		//bunlar� hi� de�i�iklik yapmadan fileContent de�i�kenine al.
                        fileContent.append(strLine);
                        fileContent.append(System.getProperty("line.separator"));
                    }
                }
            }
            //fileContent de�i�enimiz art�k g�ncel bilgileri tutuyor ve ba�ta i�lem
            //yapt���m�z dosyay� g�ncelleyecek(�zerine yazacak)
            FileWriter fstreamWrite = new FileWriter("C:\\Users\\meric\\Desktop\\dosya.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            
            out.close();
            br.close();
            //input stream kapat�l�r
     
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
	}
}

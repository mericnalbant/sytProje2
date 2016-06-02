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
			//Dosya açýlýr
            FileInputStream fstream = new FileInputStream("C:\\Users\\meric\\Desktop\\dosya.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            //Dosya satýr satýr okunur
            while ((strLine = br.readLine()) != null) {
            	//Okunan her satýr içersindeki kelimeler,aralarýndaki boþluklar
            	//yardýmýyla ayrýlarak 'tokens' dizisine atanýr.
                String tokens[] = strLine.split(" ");
                //token dizisi boþ deðilse
                if (tokens.length > 0) {
                    // okuduðumuz satýrdki bilgiler aradýðýmýz öðrenciye ait ise
                    if (tokens[1].equals(ogrNo)) {
                    	//Burada 'tokens'(öðrenci bilgilerini taþýyan dizi) güncelleme iþlemi için 
                    	//xhtml sayfasýndaki inputtext'lerden gelen
                    	//deðerleri alacak.Buradaki if bloklarýnda inputtextboxlardan
                    	//deðer gelip gelmediði kontrl edilir
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
                      //artýk ilgili öðrenciye dair güncellemek istediðimiz bilgiler 'tokens' dizisine atýldý.
                        String newLine = tokens[0] + " " + tokens[1] + " " + tokens[2]+" "+tokens[3]+" "+tokens[4];
                      //ve bu yeni bilgilerden oluþan satýr fileContent'e eklendi.
                        fileContent.append(newLine);
                        fileContent.append(System.getProperty("line.separator"));
                    } else {
                        // eðer satýrdaki bilgiler aradýðýmýz öðrenciye ait deðilse
                    	//satýrda bir deðiþiklik yapmadan olduðu gibi fileContent'e at.
                        fileContent.append(strLine);
                        fileContent.append(System.getProperty("line.separator"));
                    }
                }
            }
            //fileContent deðiþenimiz artýk güncel bilgileri tutuyor ve baþta iþlem
            //yaptýðýmýz dosyayý güncelleyecek(üzerine yazacak)
            FileWriter fstreamWrite = new FileWriter("C:\\Users\\meric\\Desktop\\dosya.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            
            out.close();
            br.close();
            //input stream kapatýlýr
     
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
	}
	
	public void sil(){
		try {
			//Dosya açýlýr
            FileInputStream fstream = new FileInputStream("C:\\Users\\meric\\Desktop\\dosya.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
          //Dosya satýr satýr okunur
            while ((strLine = br.readLine()) != null) {
            	//Okunan her satýr içersindeki kelimeler,aralarýndaki boþluklar
            	//yardýmýyla ayrýlarak 'tokens' dizisine atanýr.
                String tokens[] = strLine.split(" ");
                //token dizisi boþ deðilse
                if (tokens.length > 0) {
                	 // okuduðumuz satýrdki bilgiler aradýðýmýz öðrenciye ait ise
                	if (tokens[1].equals(ogrNo)) {
                        //Hiç birþey yapma,yani bu satýrdaki bilgilere sahip öðrenciyi
                		//fileContent deðiþkenine alma.
                    } else {
                        // aradýðýmýz öðrenci deðilse(yani silmek istemedðimiz öðrencilere ait bilgiler),
                		//bunlarý hiç deðiþiklik yapmadan fileContent deðiþkenine al.
                        fileContent.append(strLine);
                        fileContent.append(System.getProperty("line.separator"));
                    }
                }
            }
            //fileContent deðiþenimiz artýk güncel bilgileri tutuyor ve baþta iþlem
            //yaptýðýmýz dosyayý güncelleyecek(üzerine yazacak)
            FileWriter fstreamWrite = new FileWriter("C:\\Users\\meric\\Desktop\\dosya.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            
            out.close();
            br.close();
            //input stream kapatýlýr
     
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
	}
}

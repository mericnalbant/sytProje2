package syt2proje;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class sonId {
	
	public int getId() throws IOException{
		String[] grupNo=new String[1];
		String sat;
		FileReader fr=new FileReader("C:\\Users\\meric\\Desktop\\dosya.txt");
        BufferedReader br=new BufferedReader(fr);
        int gecici=0;
        
     	sat = br.readLine();// dosyadan bir sat�r okunur
     	if(sat==null)
     	{
     		br.close();
            fr.close();
     		return gecici;
     	}
        while (sat!=null) {//dosyan�n sonuna gelene dek okuma i�lemi yap�l�r.
       	 grupNo=sat.split(" "); // okunan sat�rdaki grupno bilgisi bo�luklar yard�m�yla �ekilerek
       	 //'grupNo' de�i�kenine atan�r
       	 if(Integer.parseInt(grupNo[0])>gecici) // okunan en b�y�k grupNo bilgisi tutulur.
       		 gecici=Integer.parseInt(grupNo[0]);
         
       	 sat = br.readLine();
        }
        br.close();
        fr.close();
       
        System.out.println(gecici);
	    return gecici;//dosyada yer alan en b�y�k grupNo bilgisi d�nd�r�l�r
	  
	}
}

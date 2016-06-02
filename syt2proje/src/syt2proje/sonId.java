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
        
     	sat = br.readLine();// dosyadan bir satýr okunur
     	if(sat==null)
     	{
     		br.close();
            fr.close();
     		return gecici;
     	}
        while (sat!=null) {//dosyanýn sonuna gelene dek okuma iþlemi yapýlýr.
       	 grupNo=sat.split(" "); // okunan satýrdaki grupno bilgisi boþluklar yardýmýyla çekilerek
       	 //'grupNo' deðiþkenine atanýr
       	 if(Integer.parseInt(grupNo[0])>gecici) // okunan en büyük grupNo bilgisi tutulur.
       		 gecici=Integer.parseInt(grupNo[0]);
         
       	 sat = br.readLine();
        }
        br.close();
        fr.close();
       
        System.out.println(gecici);
	    return gecici;//dosyada yer alan en büyük grupNo bilgisi döndürülür
	  
	}
}

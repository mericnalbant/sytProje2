package syt2proje;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.search.FlagTerm;

@ManagedBean
public class mailYoklama {

	public void readingEmail(){
		int grupNumaras�;
		Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com", "sytproje@gmail.com", "yasmerogu");
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE);
            Message[] msg = inbox.search(new FlagTerm(new Flags (Flags.Flag.SEEN),false));
            
            sonId grupNo=new sonId(); 
            grupNumaras�=grupNo.getId();//dosyada yer alan en b�y�k grupnumaras� bilgisi al�nd�.
            
            File file = new File("C:\\Users\\meric\\Desktop\\dosya.txt");
           /*if (!file.exists()) { //bu simde bir dosya yoksa yarat�l�r.
                    file.createNewFile();
                }*/
                       
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
              
            for(int i=0; i<msg.length; i++)
            {
            	grupNumaras�++;// dosyadan �ekilen grup numaras� yeni kay�tlar i�in 1 artt�r�l�r
                String[] from = msg[i].getFrom()[0].toString().split("<|>");
                String fromMail = from[1];//geribildirim g�nderilecek mail adresi
                System.out.println("FROM:"+fromMail);
                Multipart mp = (Multipart) msg[i].getContent();
                BodyPart bp = mp.getBodyPart(0);
                System.out.println("SENT DATE:" + msg[i].getSentDate());
                System.out.println("SUBJECT:" + msg[i].getSubject());
                //System.out.println("CONTENT:" + bp.getContent());
                
                // gelen mesaj�n i�eri�i 'text' de�i�kenine atan�r.
                String text = bp.getContent().toString();
                //bu mesaj ':' karakterine g�re split edilir ve hemen a�a��da text2 ye atan�r.
                String[] noktaliSplit = text.split(":");
                
                String text3=noktaliSplit[0];
                String[] kosul=text3.split("\\\n");
                text3=kosul[1].trim();
                kosul=text3.split(" ");
              //ilgili mail SYT dersinin 2.projesi ile ilgiliyse
                if(kosul[0].equals("SYT") && kosul[2].equals("2.proje"))
                {
                	//text2 'sat�rba��' ve '-' karakterlerine g�re split edilir.
                    String text2 = noktaliSplit[1];
                    String[] tireliSplit = text2.split("\\\n|-");
                    //ve elimize mail'in ayr��t�r�lm�� hali ge�er
                    
                    
                    for(int j=1; j<tireliSplit.length; j++){
                        System.out.println(tireliSplit[j].trim());
                        if(j%2==1) // ilgili eleman ��renci numaras� ise
                        	bWriter.write(grupNumaras�+" "); // grupno bilgisi ve bir bo�luk yazd�r
                        bWriter.write(tireliSplit[j].trim());
                        if((j%2)==1)
                            bWriter.write(" ");
                        if((j%2)==0 && j!=0){
                            bWriter.write(" 0");
                            bWriter.newLine();
                        }
                    }
                    send(from[1]);
                }
                else
                {
                	System.out.println("Mail i�eri�e uygun gonderilmemi�!!!!");
                	grupNumaras�--;
                }
            }
            bWriter.close();
        } catch (Exception mex) {
            mex.printStackTrace();
        }
	}
	
	public static void send(String to)
    {
		//mail g�nderimi i�in gerekli bilgiler
        Properties propert = new Properties();
        propert.put("mail.smtp.host", "smtp.gmail.com");
        propert.put("mail.smtp.socketFactory.port", "465");
        propert.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        propert.put("mail.smtp.auth", "true");
        propert.put("mail.smtp.port", "465");

        Session session = Session.getInstance(propert, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){ return new PasswordAuthentication("sytproje@gmail.com","yasmerogu");}
        });

        try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("sytproje@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject("Mesajiniz Alindi!");
        message.setText("Projeye kaydiniz basariyla olusturuldu.");
        Transport.send(message); //mail gonderimi ger�ekle�ir.
        System.out.println("Mail ba�ar�yla g�nderildi.");
        
        } catch(MessagingException e)
        {
            throw new RuntimeException(e);
        }
    }

}

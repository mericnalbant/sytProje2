package syt2proje;


import java.io.IOException;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class login {
	String userName;
	String password;
	Thread kontrolThread=null;
	static int flag=0; //Thread in sadece bir kere çalýþmasýný saðlayan kontrol flag'i
	
	//login ekranýnda kabul edilecek kullanýcý adý-þifre kombinasyonlarý
	String[] users={"yasin","oguzhan","meric"};
	String[] passwords={"onsoz","karaduman","nalbant"};
	
	public String getuserName(){
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getpassword(){
		return password;
	}
	
	public void setpassword(String password){
		this.password=password;
	}
	
	public String control() throws IOException{
	
		//kullanýcý ismi-þifre kombinasyonunun doðruluðunu test eden döngü
		for(int i=0;i<3;i++)
		{
			if(userName.equals(users[i]))
			{
				if(passwords[i].equals(password))
				{
					System.out.println("Login '"+userName+"' tarafýndan baþarýyla gerçekleþti");
					return "HomePage";
				}
			}
		}
		return "Login";
	}
	public String otoKontrolActivate(){
		if(flag==0)//o ana kadar sistemde hiç thread yaratýlmamýþsa
		{ 
			kontrolThread=new otoKontrol();
			kontrolThread.start();
			flag++;//sistemde bir thread yaratýldý.Bir tane daha yaratýmasýný önlemek için
			//'flag' static deðiþkeni arttýrýlýyor.
			return "Kontrol";
		}
		else// sistemde zaten bir thread oluþturulmuþ.Yeni bir tane oluþturulmaz.
			return "HomePage";
	}
}

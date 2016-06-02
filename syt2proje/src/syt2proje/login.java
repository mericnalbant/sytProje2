package syt2proje;


import java.io.IOException;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class login {
	String userName;
	String password;
	Thread kontrolThread=null;
	static int flag=0; //Thread in sadece bir kere �al��mas�n� sa�layan kontrol flag'i
	
	//login ekran�nda kabul edilecek kullan�c� ad�-�ifre kombinasyonlar�
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
	
		//kullan�c� ismi-�ifre kombinasyonunun do�rulu�unu test eden d�ng�
		for(int i=0;i<3;i++)
		{
			if(userName.equals(users[i]))
			{
				if(passwords[i].equals(password))
				{
					System.out.println("Login '"+userName+"' taraf�ndan ba�ar�yla ger�ekle�ti");
					return "HomePage";
				}
			}
		}
		return "Login";
	}
	public String otoKontrolActivate(){
		if(flag==0)//o ana kadar sistemde hi� thread yarat�lmam��sa
		{ 
			kontrolThread=new otoKontrol();
			kontrolThread.start();
			flag++;//sistemde bir thread yarat�ld�.Bir tane daha yarat�mas�n� �nlemek i�in
			//'flag' static de�i�keni artt�r�l�yor.
			return "Kontrol";
		}
		else// sistemde zaten bir thread olu�turulmu�.Yeni bir tane olu�turulmaz.
			return "HomePage";
	}
}

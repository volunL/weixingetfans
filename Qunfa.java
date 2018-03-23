package weixinqunfa;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class Qunfa {

	public static void main(String[] args) throws FindFailed,InterruptedException{
		boolean v=true;
		String l[]={
				





};
		for(int i=0;i<l.length;i++){
		 Screen s=new Screen();
		 try{
			 s.find("pics//loginbox.png");
			 System.out.println("Source image found");
			 s.type("pics//loginbox.png",l[i]+"\t" );
			 s.type("");
		 }catch(Exception e){
			 s.wait(5.0);
			 s.find("pics//loginbox.png");
			 System.out.println("Source image found");
			 s.type("pics//loginbox.png",l[i]+"\t" );
			 s.type("mingfei123");
		 }
		 
		 
		 try{
		 s.click("pics//loginbtn.png");}
		 catch (Exception e){
			 v=false;
		 }
		 
		 
		 try{
			 while(!v){
				 s.click("pics//loginbtn.png");
				 try{s.wait("pics//qunfa.png");
				     v=true;
				 }catch(Exception e){
					 s.click("pics//loginbtn.png");
				 }
			 }
			 
			 
			 if(s.exists("pics//protect.png") != null){
				 s.click("pics//refresh.png");
				 continue;
			 }
			 
			 
		 s.wait("pics//qunfabtn.png");
		 s.click("pics//qunfabtn.png");}
		 catch(Exception e){ 
			 s.wait(5.0);
			 s.wait("pics//qunfabtn.png");
			 s.click("pics//qunfabtn.png");
		 }
		 
		 
		 try{
		 s.wait("pics//select.png");
		 s.click("pics//select.png");}
		 catch(Exception e){
			 s.wait(6.0);
			 s.wait("pics//select.png");
			 s.click("pics//select.png");
		 }
		 
		 
		 try{
			 s.wait(3.0);
			 s.wait("pics//content.png");
			 s.click("pics//content.png");}
		 catch(Exception e){
			 s.wait("pics//cancelbtn.png");
			 s.click("pics//cancelbtn.png");
			 s.wait("pics//select.png");
			 s.click("pics//select.png");
			 s.wait(5.0);
			 s.wait("pics//content.png");
			 s.click("pics//content.png");
		 }
		 
		 
		 
		 
		 s.click("pics//ccbtn.png");
		 s.wait("pics//qbtn.png");
		 s.click("pics//qbtn.png");
		 
		/*try{
		 s.click("pics//jixuqunfa.png");}
		 catch(Exception e){s.wait(2.0);s.click("pics//jixuqunfa.png");}*/
		 
		 try{
			 s.wait("pics//cc.png");
			 s.wait("pics//cccbtn.png");
			 s.click("pics//cccbtn.png");
		 }catch(Exception e){
			 s.wait(5.0);
			 s.wait("pics//cc.png");
			 s.wait("pics//cccbtn.png");
			 s.click("pics//cccbtn.png");
		 }
		 
		 
		 
		 
		 s.wait(3.0);
		 s.wait("pics//out.png");
		 s.click("pics//out.png");
		 
		 System.out.print("hhhhhh");}
	}

}

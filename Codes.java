
import java.util.Scanner;

public class Codes {

	public static int smallcode(String input,int start){
		if(start==0){
			return (int)(input.charAt(start))-48;
		}

		int number = smallcode(input,start-1);
		int temp= ((int)(input.charAt(start))-48)+number*10;
		return temp;

	}

	public static int convertStringToInt(String input){

		return (smallcode(input,input.length()-1));

	}

	public static char findchars(int rem){
		char ans=(char)(rem+96);
		return ans;
	}

	public static void printStarray(String[] input){
		for(int i=0;i<input.length;i++){
			System.out.println(input[i]);
		}
	}

	public static  String[] getCode(String input,int start){
		if(start==input.length()-1){
			String pass[]=new String[1];
			pass[0]=findchars(convertStringToInt(input.charAt(start)+""))+"";
			return pass;
		}

		if(start==input.length()){
			String pass[]=new String[1];
			pass[0]="";
			return pass;
		}
		boolean flag=false;
		if(convertStringToInt(input.charAt(start)+""+input.charAt(start+1)+"")<=26){
			flag=true;
		}
		

		String temp[]=getCode(input,start+1);
		String temp2[]=getCode(input, start+2);

		String ans[]=new String[2];
		ans[0]=findchars(convertStringToInt(input.charAt(start)+""))+"";
		

		ans[1]=findchars(convertStringToInt(input.charAt(start)+""+input.charAt(start+1)+""))+"";

		String ret[]=new String[temp2.length+temp.length];
		int count=0;
		for(int j=0;j<temp.length;j++){
			ret[count]=ans[0]+temp[j]+"";
			count++;
		}

		for(int j=0;j<temp2.length;j++){
			ret[count]=ans[1]+temp2[j]+"";
			count++;


		}

		return ret;
	}

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		String str=s.next();
		printStarray(getCode(str,0));

	}

}

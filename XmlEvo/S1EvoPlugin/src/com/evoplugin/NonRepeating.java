package com.evoplugin;

public class NonRepeating {

	public static void main(String args[])
	{
		String name="apple";
		int index= -1;
		char fuc=' ';
		
		for(char i : name.toCharArray())
		{
			if(name.indexOf(i))==name.lastIndexof(i))
                   {
                	   fun=i;
                	   break;
	
                    }
                   else {
                	   index+=1;
                   }
                   
		}
		
		if(index==1)
		{
			System.out.println("Either all char are repeating or "+ "string is empty");
		}
		else
		{
			System.out.println("non repeating char is"+ fun);
		}
	
	}

}



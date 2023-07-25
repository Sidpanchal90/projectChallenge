package com.evoplugin;

public class ConcurrentHashingMap {

	public static void main(String [] args)
		{
		
		ConcurrentHashingMap<String, int> con=new ConcurrentHashMap<String ,int>();
		
		con.put("sid",101);
		con.put("fid",102);
		con.put("tid",103);
		
		System.out.println("Map size :" con.size);
		}

}

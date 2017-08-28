package com.corejava.filehandling;
import java.io.*;
public class DataOutputStreamTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File file=new File("file.txt");
		FileOutputStream fos=new FileOutputStream(file);
		DataOutputStream dos=new DataOutputStream(fos);
		dos.writeInt(1);
		dos.writeUTF("ABC");
		dos.writeDouble(12009);
		dos.writeInt(2);
		dos.writeUTF("DEF");
		dos.writeDouble(1780082);
		dos.writeInt(3);
		dos.writeUTF("GHI");
		dos.writeDouble(21316);
		dos.flush();
		fos.flush();
		dos.close();
		fos.close();
	}

}

package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeMutable {

	public static void main(String[] args) {
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;
		try {
			Person simple=new Person("simple", 25);
			oos=new ObjectOutputStream(new FileOutputStream("./src/io/mutable.txt"));
			oos.writeObject(simple);
			simple.setAge(26);
			oos.writeObject(simple);
			
			ois=new ObjectInputStream(new FileInputStream("./src/io/mutable.txt"));
			Person readPerson1=(Person)ois.readObject();
			System.out.println(readPerson1);
			Person readPerson2=(Person)ois.readObject();
			System.out.println(readPerson2);
			System.out.println(readPerson1==readPerson2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos!=null) {
					oos.close();
				}
				if(ois!=null) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

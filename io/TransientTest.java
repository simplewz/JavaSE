package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {

	public static void main(String[] args) {
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;
		try{
			Person simple=new Person("simple", 25);
			System.out.println(simple);
			oos=new ObjectOutputStream(new FileOutputStream("./src/io/transient.txt"));
			oos.writeObject(simple);
			
			ois=new ObjectInputStream(new FileInputStream("./src/io/transient.txt"));
			Person serializePerson=(Person)ois.readObject();
			System.out.println(serializePerson);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos!=null) {
					oos.close();
				}
				if(ois!=null) {
					ois.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

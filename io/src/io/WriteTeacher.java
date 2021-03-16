package io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteTeacher {
	
	public static void main(String[] args) {
		try(
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("./src/io/teacher.txt"))
			)
		{
			Person student=new Person("simple", 25);
			Teacher t1=new Teacher("Chinese", student);
			Teacher t2=new Teacher("English", student);
			oos.writeObject(t1);
			oos.writeObject(t2);
			oos.writeObject(student);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

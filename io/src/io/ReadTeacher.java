package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadTeacher {

	public static void main(String[] args) {
		try(
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream("./src/io/teacher.txt"));)
		{
			Teacher t1=(Teacher)ois.readObject();
			System.out.println(t1);
			Teacher t2=(Teacher)ois.readObject();
			System.out.println(t2);
			Person student=(Person)ois.readObject();
			System.out.println(student);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

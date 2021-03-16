package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

public class SerializeObject {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Person simple=new Person("simple", 25);
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("./src/io/person.json"));
		oos.writeObject(simple);
		System.out.println(simple);
		
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("./src/io/person.json"));
		Person person=(Person) ois.readObject();
		System.out.println(person);
	}
	
}

class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	/**
	 * transient�ؼ������ε����ԣ���ʾ���ֶ��ڶ������л�ʱ�����л����ֶ�
	 */
	private transient Integer age;
	
	public Person() {
		super();
	}
	
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	/**
	 * �Զ������л�
	 * @param out
	 * @throws IOException
	 */
	private void writeObject(java.io.ObjectOutputStream out) throws IOException{
		out.writeObject(new StringBuffer(this.name).reverse().toString());
		out.writeInt(age);
	}
	
	/**
	 * �����л�
	 * @param in
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
		this.name = ((StringBuffer)in.readObject()).reverse().toString();
		this.age = in.readInt();
	}
	
	/**
	 * ���л�����ʱ�ı䷵�صĶ���
	 * @return
	 * @throws ObjectStreamException
	 */
	private Object writeReplace() throws ObjectStreamException{
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(name);
		list.add(age);
		return list;
	}
}

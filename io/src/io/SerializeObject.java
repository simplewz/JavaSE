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
	 * transient关键字修饰的属性，表示该字段在对象序列化时不序列化该字段
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
	 * 自定义序列化
	 * @param out
	 * @throws IOException
	 */
	private void writeObject(java.io.ObjectOutputStream out) throws IOException{
		out.writeObject(new StringBuffer(this.name).reverse().toString());
		out.writeInt(age);
	}
	
	/**
	 * 反序列化
	 * @param in
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
		this.name = ((StringBuffer)in.readObject()).reverse().toString();
		this.age = in.readInt();
	}
	
	/**
	 * 序列化对象时改变返回的对象
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

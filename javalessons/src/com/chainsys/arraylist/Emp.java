package com.chainsys.arraylist;

import java.io.Serializable;

public class Emp implements Serializable{
	private final int Id;
	public String Name;
	public Emp(int v1, String sName) {
		Id=v1;
		Name=sName;
	}
public int getID() {
	return Id;
}
@Override
public boolean equals(Object obj) {
	Class c1 = obj.getClass();
	boolean flag = false;
	if(c1==this.getClass()) {
		Emp other = (Emp) obj;
		if (this.hashCode() == other.hashCode())
			flag = true;
	}
return flag;
}
/*public int hashCode() {
	return this.Id;
}*/
}
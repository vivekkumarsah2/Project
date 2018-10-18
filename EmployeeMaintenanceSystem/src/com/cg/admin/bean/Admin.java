package com.cg.admin.bean;

public final class Admin 
{
	private String Id;
	private String Name;
	private String Password;
	private String Type;
	
	public String getId()
	{
		return Id;
	}
	public void setId(String id)
	{
		Id = id;
	}
	public String getName()
	{
		return Name;
	}
	public void setName(String name)
	{
		Name = name;
	}
	public String getPassword()
	{
		return Password;
	}
	public void setPassword(String password)
	{
		Password = password;
	}
	public String getType()
	{
		return Type;
	}
	public void setType(String type)
	{
		Type = type;
	}
	
}

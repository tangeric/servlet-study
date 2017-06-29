package data;



public class Stuinfo {

	private int[] id;
	private String[] name;
	private int[] clanguage;
	private int[] datastruct;
	private int[] java;
	private int[] datebase;
	private int[] maths;
	public int getId(int i) {
		return id[i];
	}
	public void setId(int[] id) {
		this.id = id;
	}
	public String getName(int i) {
		return name[i];
	}
	public void setName(String[] name) {
		this.name = name;
	}
	public int getClanguage(int i) {
		return clanguage[i];
	}
	public void setClanguage(int[] clanguage) {
		this.clanguage = clanguage;
	}
	public int getDatastruct(int i) {
		return datastruct[i];
	}
	public void setDatastruct(int[] datastruct) {
		this.datastruct = datastruct;
	}
	public int getJava(int i) {
		return java[i];
	}
	public void setJava(int[] java) {
		this.java = java;
	}
	public int getDatebase(int i) {
		return datebase[i];
	}
	public void setDatebase(int[] datebase) {
		this.datebase = datebase;
	}
	public int getMaths(int i) {
		return maths[i];
	}
	public void setMaths(int[] maths) {
		this.maths = maths;
	}
	public int[] getId() {
		return id;
	}
	
	
	
}

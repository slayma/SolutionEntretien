package fr.sg.code;

public interface Robot {
	public void rotate(String instruct);
	public void move();
	public String finaLocation() ;
	public Boolean ValidInstruction();
}

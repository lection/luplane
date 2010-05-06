package model;

public class GameHouse {
	public static final int WAIT = 0;
	public static final int READY = 1;
	public static final int BEGIN = 0;
	
	private int id;
	private String name;
	private int level = -1;
	private User owner;
	private User caller;
	private int state;
	
}

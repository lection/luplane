package model;

public class GameHouse implements Comparable<GameHouse>{
	public static final int WAIT = 0;
	public static final int READY = 1;
	public static final int BEGIN = 0;
	
	
	private Integer id;
	private String name;
	private String password;
	private int level;
	private User owner;
	private User caller;
	private int state = WAIT;
	public GameHouse(String name, String password, int level, User owner) {
		this.name = name;
		this.password = password;
		this.level = level;
		this.owner = owner;
	}
	
	public int compareTo(GameHouse o) {
		return this.id.compareTo(o.id);
	}

}

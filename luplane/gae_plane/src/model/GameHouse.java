package model;

public class GameHouse implements Comparable<GameHouse>{
	public static final int WAIT = 0;
	public static final int READY = 1;
	public static final int BEGIN = 0;
	
	private static int number = 1;
	
	private Integer id;
	private String name;
	private String password;
	private int level;
	private User owner;
	private User caller;
	private int state = WAIT;
	
	private int ownerPlaneCount = 0;
	private int callerPlaneCount = 0;
	
	private short[][] ownerPoints = new short[10][10];
	private short[][] callerPoints = new short[10][10];
	
	private PlaneModel planeModel;
	
	public GameHouse(){
		id = number++;
	}
	
	public GameHouse(String name, String password, int level, User owner) {
		id = number++;
		this.name = name;
		this.password = password;
		this.level = level;
		this.owner = owner;
	}
	
	public void addPlaneCount(User user){
		if(user == owner)
			ownerPlaneCount++;
		else
			callerPlaneCount++;
	}
	
	public int getPlaneCount(User user){
		if(user == owner)
			return ownerPlaneCount;
		else
			return callerPlaneCount;
	}
	
	public boolean addPlane(User user,int x,int y,short type){
		short[][] points = null;
		if(user == owner)
			points = ownerPoints;
		else
			points = callerPoints;
		if(x>=0 && x<10 && y>=0 && y<10 && points[x][y] == 0){
			points[x][y] = type;
			return true;
		}
		else
			return false;
	}
	
	public void clearCount(){
		ownerPlaneCount = 0;
		callerPlaneCount = 0;
		ownerPoints = new short[10][10];
		callerPoints = new short[10][10];
	}
	
	public int compareTo(GameHouse o) {
		return this.id.compareTo(o.id);
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public User getOwner() {
		return owner;
	}

	public int getState() {
		return state;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getCaller() {
		return caller;
	}

	public void setCaller(User caller) {
		this.caller = caller;
	}

	public PlaneModel getPlaneModel() {
		return planeModel;
	}

	public void setPlaneModel(PlaneModel planeModel) {
		this.planeModel = planeModel;
	}
}

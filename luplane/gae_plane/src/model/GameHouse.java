package model;

import java.util.HashSet;
import java.util.Set;

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
	
	private User player;
	private Set<String> ownerPointSet = new HashSet<String>(8);
	private Set<String> callerPointSet = new HashSet<String>(8);
	private int[] last_point = new int[2];
	
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
		player = this.owner;
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
		last_point = new int[2];
	}
	
	public User getInfoUser(User user){
		if(user == owner){
			if(caller == null){
			}else{
				return caller;
			}
		}else if(user == caller){
			return owner;
		}
		return null;
	}
	
	public void changePlayer(){
		if(player == owner){
			player = caller;
		}else{
			player = owner;
		}
	}
	
	public short clickPoints(User user,int point_x,int point_y){
		short[][] points = null;		
		Set<String> headSet = null;
		if(user == owner){
			points = callerPoints;
			headSet = ownerPointSet;
		}else{
			points = ownerPoints;
			headSet = callerPointSet;
		}
		if(point_x>points.length || point_y>points[point_x].length){
			return -1;
		}
		last_point[0] = point_x;
		last_point[1] = point_y;
		short type = points[point_x][point_y];
		if(type == PlaneModel.PLANE_HEAD){
			headSet.add(point_x+","+point_y);
			if(headSet.size()==3){
				last_point = null;
				type = -2;
			}
		}
		return type!=0?type:-1;
	}
	
	public String check(User user,int point_x,int point_y){
		if(user != player){
			return "没有轮到你";
		}
		Set<String> set = user==owner?ownerPointSet:callerPointSet;
		if(set.contains(point_x+","+point_y)){
			return "这个位置已经炸过了";
		}
		return null;
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

	public User getPlayer() {
		return player;
	}

	public int[] getLast_point() {
		return last_point;
	}
}

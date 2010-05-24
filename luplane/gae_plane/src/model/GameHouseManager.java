package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

public class GameHouseManager {
	public int pageSize = 10;
	public int maxPageSize = 50;
	
	private Map<Integer,GameHouse> ghMap = new TreeMap<Integer, GameHouse>();
	private Map<String,PlaneModel> planeModelMap = new HashMap<String,PlaneModel>();
	
	{
		PlaneModel model1 = new PlaneModel(new int[][]{
			{ 0, 1 }, { 0, 2 },{ 1, 1 }, { -1, 1 }, { 2, 1 }, { -2, 1 }, { 0, 3 }, { 1, 3 },{ -1, 3 }
		});
		planeModelMap.put("game_plane_classic", model1);
	}
	
	public GameHouse createGameHouse(String name, String password, int level, User owner){
		if(ghMap.size()>maxPageSize){
			return null;
		}
		if(StringUtils.isBlank(name)){
			name = "未命名房间";
		}
		if(StringUtils.isBlank(password)){
			password = null;
		}
		GameHouse house = new GameHouse(name,password,level,owner);
		house.setPlaneModel(planeModelMap.get("game_plane_classic"));
		ghMap.put(house.getId(), house);
		return house;
	}
	
	public GameHouse getHouseById(Integer id){
		return ghMap.get(id);
	}
	
	public List<GameHouse> listHouse(int page){
		int max = page*pageSize;
		if(max > ghMap.size())max = ghMap.size();
		return new ArrayList(ghMap.values()).subList((page-1)*pageSize, max);
	}
	
	public int countHouse(){
		return ghMap.size();
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setMaxPageSize(int maxPageSize) {
		this.maxPageSize = maxPageSize;
	}
}

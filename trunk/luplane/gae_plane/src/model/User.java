package model;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class User implements Serializable {
	private static final long serialVersionUID = 2785832344281694847L;
	public static final int GRANT = 1;
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.UNSPECIFIED)
	private Long id;
	@Persistent
	private int useType;
	@Persistent
	private int experience;
	@Persistent
	private int money;
	@Persistent
	private int victory;
	@Persistent
	private int fail;
	@Persistent
	private int level;
	
	private GameHouse gameHouse;
	
	public User() {
	}
	
	public User(Long id){
		super();
		this.id = id;
		useType = GRANT;
		experience = 0;
		money = 0;
		victory = 0;
		fail = 0;
		level = 0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUseType() {
		return useType;
	}

	public void setUseType(int useType) {
		this.useType = useType;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getVictory() {
		return victory;
	}

	public void setVictory(int victory) {
		this.victory = victory;
	}

	public int getFail() {
		return fail;
	}

	public void setFail(int fail) {
		this.fail = fail;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public GameHouse getGameHouse() {
		return gameHouse;
	}

	public void setGameHouse(GameHouse gameHouse) {
		this.gameHouse = gameHouse;
	}
}

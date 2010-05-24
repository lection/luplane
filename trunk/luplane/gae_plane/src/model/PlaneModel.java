package model;

public class PlaneModel {
	public static final short PLANE_HEAD = 1;
	public static final short PLANE_BODY = 2;
	
	private int[][] pointArray;

	public PlaneModel(int[][] pointArray) {
		this.pointArray = pointArray;
	}

	public int[][] getPointArray() {
		return pointArray;
	}
	
}

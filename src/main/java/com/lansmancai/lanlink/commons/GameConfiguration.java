package com.lansmancai.lanlink.commons;

/**
 * ������Ϸ���õĶ���
 */
public class GameConfiguration {
	// ��������һά�ĳ���
	private int xSize;

	// ���������ά�ĳ���
	private int ySize;

	// �����е�һ��ͼƬ���ֵ�x����
	private int beginImageX;

	// �����е�һ��ͼƬ���ֵ�y����
	private int beginImageY;

	// ÿ��ɹ����ӵķ�ֵ
	private long perGrade;

	// ����ÿ�ֵ�ʱ��, ��λ����
	private long gameTime;

	// �ṩһ��������
	public GameConfiguration(int xSize, int ySize, int beginImageX,
			int beginImageY, long perGrade, long gameTime) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.beginImageX = beginImageX;
		this.beginImageY = beginImageY;
		this.perGrade = perGrade;
		this.gameTime = gameTime;
	}

	public long getGameTime() {
		return gameTime;
	}

	public long getPerGrade() {
		return perGrade;
	}

	public int getXSize() {
		return xSize;
	}

	public int getYSize() {
		return ySize;
	}

	public int getBeginImageX() {
		return beginImageX;
	}

	public int getBeginImageY() {
		return beginImageY;
	}

}

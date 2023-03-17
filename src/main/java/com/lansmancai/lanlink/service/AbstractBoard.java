package com.lansmancai.lanlink.service;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.awt.image.BufferedImage;

import com.lansmancai.lanlink.commons.GameConfiguration;
import com.lansmancai.lanlink.commons.Piece;
import com.lansmancai.lanlink.utils.ImageUtil;

/**
 * ��Ϸ����ĳ�����
 * 
 */
public abstract class AbstractBoard {
	// �����̶����м�¼ÿ��ͼƬ�Ŀ�
	private int commonImageWidth;

	// �����̶����м�¼ÿ��ͼƬ�ĸ�
	private int commonImageHeight;

	public int getCommonImageWidth() {
		return this.commonImageWidth;
	}

	public int getCommonImageHeight() {
		return this.commonImageHeight;
	}

	// ����һ�����󷽷�, ������ȥʵ��
	protected abstract List<Piece> createPieces(GameConfiguration config,
			Piece[][] pieces);

	public Piece[][] create(GameConfiguration config) {
		// �����������
		Piece[][] pieces = new Piece[config.getXSize()][config.getYSize()];
		// ���طǿյ�Piece����, �ü���������ȥ����
		List<Piece> notNullPieces = createPieces(config, pieces);
		// ���ݷǿ�Piece����ļ��ϵĴ�С��ȡͼƬ
		List<BufferedImage> playImages = getPlayImages(notNullPieces.size());
		int imageWidth = playImages.get(0).getWidth();
		int imageHeight = playImages.get(0).getHeight();
		// ����һ��ͼƬ�Ŀ�͸����������, ����Լ����ÿ��ͼƬ�Ĵ�С����һ��
		this.commonImageWidth = imageWidth;
		this.commonImageHeight = imageHeight;
		// �����ǿյ�Piece����
		for (int i = 0; i < notNullPieces.size(); i++) {
			// �õ����洴���ķǿ�Piece��, �����¹���һ��Piece����, ���ڷŽ�������
			Piece piece1 = notNullPieces.get(i);
			// ��ȡpiece1��indexX(��������һά��ֵ)
			int indexX = piece1.getIndexX();
			// ��ȡpiece1��indexY(�������ж�ά��ֵ)
			int indexY = piece1.getIndexY();
			// ��piece1��indexX��indexY�����¹���һ��Piece, ��������µ�Piece����ŵ�������
			Piece piece2 = new Piece(indexX * imageWidth
					+ config.getBeginImageX(), indexY * imageHeight
					+ config.getBeginImageY(), indexX, indexY, playImages
					.get(i));
			// ��piece2�ŵ�������
			pieces[indexX][indexY] = piece2;
		}
		return pieces;
	}

	// ��ȡsize��ͼƬ
	public List<BufferedImage> getPlayImages(int size) {
		return ImageUtil.getPlayImages(new File("images/pieces"), size);
	}
}

package com.lansmancai.lanlink.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lansmancai.lanlink.commons.GameConfiguration;
import com.lansmancai.lanlink.commons.Piece;
import com.lansmancai.lanlink.service.AbstractBoard;

/**
 * 创建方形的游戏区域
 * 
 */

public class SquareBoard extends AbstractBoard {
	protected List<Piece> createPieces(GameConfiguration config,
			Piece[][] pieces) {
		List<Piece> notNullPieces = new ArrayList<Piece>();
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[i].length; j++) {
				// 先构造一个Piece对象, 只设置数组中的位置为i, j，其他值不设置
				Piece piece = new Piece(i, j);
				// 添加到非空Piece对象的集合中
				notNullPieces.add(piece);
			}
		}
		return notNullPieces;
	}
}

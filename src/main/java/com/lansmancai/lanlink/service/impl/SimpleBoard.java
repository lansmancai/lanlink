package com.lansmancai.lanlink.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lansmancai.lanlink.commons.GameConfiguration;
import com.lansmancai.lanlink.commons.Piece;
import com.lansmancai.lanlink.service.AbstractBoard;

/**
 * �������ε���Ϸ����
 */

public class SimpleBoard extends AbstractBoard {
	protected List<Piece> createPieces(GameConfiguration config,
			Piece[][] pieces) {
		List<Piece> notNullPieces = new ArrayList<Piece>();
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[i].length; j++) {
				// �����ж�, ����һ��������ȥ����Piece����, ���ӵ�������
				if (i % 2 == 0) {// ���x�ܱ�2����, �������в��ᴴ������
					// �ȹ���һ��Piece����, ֻ���������е�λ��Ϊi, j������ֵ������
					Piece piece = new Piece(i, j);
					// ��ӵ��ǿ�Piece����ļ�����
					notNullPieces.add(piece);
				}
			}
		}
		return notNullPieces;
	}
}

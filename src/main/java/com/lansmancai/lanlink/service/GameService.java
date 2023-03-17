package com.lansmancai.lanlink.service;

import javax.swing.JLabel;

import com.lansmancai.lanlink.commons.LinkInfo;
import com.lansmancai.lanlink.commons.Piece;


/**
 * ��Ϸ�߼��ӿ�
 * 
 */
public interface GameService {
	/**
	 * ����һ���ӿڷ���, ���ڷ���һ����ά����
	 * 
	 * @return ������Ӷ���Ķ�ά����
	 */
	Piece[][] getPieces();

	/**
	 * ����һ����ʼ������������Ϸ�Ŀ�ʼ
	 * 
	 */
	void start();

	/**
	 * ��������x�����y����, ���ҳ�һ��Piece����
	 * 
	 * @param mouseX
	 *            �������x����
	 * @param mouseY
	 *            �������y����
	 * @return ����һ����Ӧ��Piece����, û�з���null
	 */
	Piece findPiece(int mouseX, int mouseY);

	/**
	 * ��������Piece����, ��������, ����LinkInfo����
	 * 
	 * @param p1
	 *            ��һ��Piece����
	 * @param p2
	 *            �ڶ���Piece����
	 * @return ����һ��LinkInfo����, �������Piece����������, ����null
	 */
	LinkInfo link(Piece p1, Piece p2);

	/**
	 * ���㵱ǰ��Ϸ�ķ���
	 * 
	 * @return ���ص�ǰ����
	 */
	long countGrade();

	/**
	 * �жϲ���pieces���Ƿ񻹴���Piece����
	 * 
	 * @return ����Piece���󷵻�true, û�з���false
	 */
	boolean hasPieces(Piece[][] pieces);
}

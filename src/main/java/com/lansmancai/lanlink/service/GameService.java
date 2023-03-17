package com.lansmancai.lanlink.service;

import javax.swing.JLabel;

import com.lansmancai.lanlink.commons.LinkInfo;
import com.lansmancai.lanlink.commons.Piece;


/**
 * 游戏逻辑接口
 * 
 */
public interface GameService {
	/**
	 * 定义一个接口方法, 用于返回一个二维数组
	 * 
	 * @return 存放棋子对象的二维数组
	 */
	Piece[][] getPieces();

	/**
	 * 定义一个开始方法，用于游戏的开始
	 * 
	 */
	void start();

	/**
	 * 根据鼠标的x坐标和y坐标, 查找出一个Piece对象
	 * 
	 * @param mouseX
	 *            鼠标点击的x坐标
	 * @param mouseY
	 *            鼠标点击的y坐标
	 * @return 返回一个对应的Piece对象, 没有返回null
	 */
	Piece findPiece(int mouseX, int mouseY);

	/**
	 * 连接两个Piece对象, 可以连接, 返回LinkInfo对象
	 * 
	 * @param p1
	 *            第一个Piece对象
	 * @param p2
	 *            第二个Piece对象
	 * @return 返回一个LinkInfo对象, 如果两个Piece不可以连接, 返回null
	 */
	LinkInfo link(Piece p1, Piece p2);

	/**
	 * 计算当前游戏的分数
	 * 
	 * @return 返回当前分数
	 */
	long countGrade();

	/**
	 * 判断参数pieces中是否还存在Piece对象
	 * 
	 * @return 还有Piece对象返回true, 没有返回false
	 */
	boolean hasPieces(Piece[][] pieces);
}

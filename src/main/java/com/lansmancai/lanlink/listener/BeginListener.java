package com.lansmancai.lanlink.listener;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

import com.lansmancai.lanlink.commons.GameConfiguration;
import com.lansmancai.lanlink.service.GameService;
import com.lansmancai.lanlink.timer.TimerTask;
import com.lansmancai.lanlink.view.GamePanel;

import java.util.Timer;

/**
 * 开始按钮监听器
 * 
 */
public class BeginListener extends MouseInputAdapter {
	private GamePanel gamePanel;

	private GameService gameService;

	private JLabel pointLabel;

	private JLabel timeLabel;

	private GameConfiguration config;

	private Timer timer;

	private TimerTask task;

	public BeginListener(GamePanel gamePanel, GameService gameService,
			JLabel pointLabel, JLabel timeLabel, GameConfiguration config) {
		this.gamePanel = gamePanel;
		this.gameService = gameService;
		this.pointLabel = pointLabel;
		this.timeLabel = timeLabel;
		this.config = config;
	}

	public Timer getTimer() {
		return this.timer;
	}

	// 当鼠标点击时，执行这个方法

	public void mousePressed(MouseEvent e) {
		if (this.timer != null) {
			this.timer.cancel();
		}
		this.timer = new Timer();
		gamePanel.setSelectPiece(null);
		gamePanel.setOverImage(null);
		// 将分数清0
		pointLabel.setText("0");
		// 将时间变成原来设置的时间(在GameConfiguration中设置)
		timeLabel.setText(String.valueOf(config.getGameTime()));
		// 调用gameService的start方法

		gameService.start();
		// 开始进行任务
		task = new TimerTask(this.gamePanel, this.config.getGameTime(),
				this.timeLabel);
		timer.schedule(task, 0, 1000);
		// 对gamePanel进行重新绘制
		gamePanel.repaint();
	}
}

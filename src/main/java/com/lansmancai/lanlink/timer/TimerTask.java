package com.lansmancai.lanlink.timer;

import javax.swing.JLabel;

import com.lansmancai.lanlink.utils.ImageUtil;
import com.lansmancai.lanlink.view.GamePanel;


/**
 * 定时任务对象
 * 
 */
public class TimerTask extends java.util.TimerTask {
	// 当前用掉的时候
	private long time;

	private GamePanel gamePanel;

	private long gameTime;

	private JLabel timeLabel;

	public TimerTask(GamePanel gamePanel, long gameTime, JLabel timeLabel) {
		this.time = 0;
		this.gamePanel = gamePanel;
		this.gameTime = gameTime;
		this.timeLabel = timeLabel;
	}

	public void run() {
		// 游戏时间已到
		if (this.gameTime - this.time <= 0) {
			// 设置游戏图片为失败
			this.gamePanel.setOverImage(ImageUtil.getImage("images/lose.gif"));
			// 取消这个任务
			this.cancel();
			this.gamePanel.repaint();
		}
		// 如果游戏仍然继续, 设置时间
		this.timeLabel.setText(String.valueOf(this.gameTime - this.time));
		this.timeLabel.repaint();
		// 使用的时间+1
		this.time += 1;
	}
}

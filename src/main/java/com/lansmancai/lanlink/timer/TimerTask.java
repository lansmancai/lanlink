package com.lansmancai.lanlink.timer;

import javax.swing.JLabel;

import com.lansmancai.lanlink.utils.ImageUtil;
import com.lansmancai.lanlink.view.GamePanel;


/**
 * ��ʱ�������
 * 
 */
public class TimerTask extends java.util.TimerTask {
	// ��ǰ�õ���ʱ��
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
		// ��Ϸʱ���ѵ�
		if (this.gameTime - this.time <= 0) {
			// ������ϷͼƬΪʧ��
			this.gamePanel.setOverImage(ImageUtil.getImage("images/lose.gif"));
			// ȡ���������
			this.cancel();
			this.gamePanel.repaint();
		}
		// �����Ϸ��Ȼ����, ����ʱ��
		this.timeLabel.setText(String.valueOf(this.gameTime - this.time));
		this.timeLabel.repaint();
		// ʹ�õ�ʱ��+1
		this.time += 1;
	}
}

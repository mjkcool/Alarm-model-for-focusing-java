package alarm.cod;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;



public class TimerThread extends Thread{
	
	String soundfileLnk = "ring.MP3";
	
	/*Ÿ�̸� ����*/
	public void action(int run_sec/*Ÿ�̸� �ð�(��)*/, int period_sec/*�ݺ� �ð�(��)*/, Timer_Ex timerObj) {
		int count;

		Timer m_timer = new Timer();
		TimerTask m_task = new TimerTask() {
			
			@Override
			public void run() {
					Date now = new Date();
					//�˶��Ҹ�
					if(now.getTime() <= timerObj.getFinish_D().getTime()) {
						System.out.println(timerObj.timeTxt.format(new Date())+"/�����ð�:"+timerObj.getRemainingRunTime());
						soundPlay();
					}else { 
						m_timer.cancel();
						System.out.println("Ÿ�̸� ����:"+timerObj.timeTxt.format(new Date()));
					}
			}
			
		}; /*�ݺ�*/m_timer.schedule(m_task, period_sec, period_sec);
	
	}
	
	public void soundPlay() {
		
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

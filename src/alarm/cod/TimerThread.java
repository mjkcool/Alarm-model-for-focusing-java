package alarm.cod;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;



public class TimerThread extends Thread{
	
	String soundfileLnk = "ring.MP3";
	
	/*타이머 실행*/
	public void action(int run_sec/*타이머 시간(초)*/, int period_sec/*반복 시간(초)*/, Timer_Ex timerObj) {
		int count;

		Timer m_timer = new Timer();
		TimerTask m_task = new TimerTask() {
			
			@Override
			public void run() {
					Date now = new Date();
					//알람소리
					if(now.getTime() <= timerObj.getFinish_D().getTime()) {
						System.out.println(timerObj.timeTxt.format(new Date())+"/남은시간:"+timerObj.getRemainingRunTime());
						soundPlay();
					}else { 
						m_timer.cancel();
						System.out.println("타이머 종료:"+timerObj.timeTxt.format(new Date()));
					}
			}
			
		}; /*반복*/m_timer.schedule(m_task, period_sec, period_sec);
	
	}
	
	public void soundPlay() {
		
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

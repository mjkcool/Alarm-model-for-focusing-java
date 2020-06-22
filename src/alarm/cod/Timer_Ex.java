package alarm.cod;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Timer_Ex{
	SimpleDateFormat timeTxt = new SimpleDateFormat("a hh:mm:ss");
	
	/*타이머 시간, 반복시간*/ int runTime_min, periodTime_min;
	/*타이머 시작 시간*/ Date startTime;
	
	
	/* 타이머 객체 생성 (생성자) */
	public Timer_Ex(int run_min/*타이머 시간(분)*/, int period_min/*반복 시간(분)*/) {
		
		this.runTime_min = run_min;
		this.periodTime_min = period_min;
		
		/*시작 시간 저장*/startTime = new Date();
		System.out.println("[알람 유효기간:"+getRunTime()+"/반복시간:"+getPeriodTime()+"/알람 종료시간:"+getFinishTime()+"]");
		System.out.println("타이머객체생성:"+timeTxt.format(startTime));
		
		/*타이머 실행*///new TimerThread.runTimer(run_min*60000, period_min*60000, this);
		(new TimerThread()).action(run_min*60000, period_min*60000, this);
	}
	
	
	
	/*알람 실행시간 반환*/
	public String getRunTime() {
		
			if(runTime_min/60>=1) { //1시간 이상일 경우
				/*시간으로 반환*/ return (runTime_min/60+"시간 "+runTime_min%60+"분");			
			}else /*분으로 반환*/ return (runTime_min+"분");
	
	}
	
	
	/*알람 반복시간 반환*/
	public String getPeriodTime() {
			
			if(periodTime_min/60>=1) { //1시간 이상일 경우
				/*시간으로 반환*/ return (periodTime_min/60+"시간 "+periodTime_min%60+"분");			
			}else /*분으로 반환*/ return (periodTime_min+"분");
			
	}

	
	/*알람 남은 시간(상대시간) 반환*/
	public String getRemainingRunTime() {

			Date now = new Date();
			long rest = getFinish_D().getTime() - now.getTime();
			
			if(rest/60000<1) {
				return (rest/1000+"초");
			}
			else if(rest/3600000<1) {
				return (rest/60000+"분 "+(rest%60000)/1000+"초");
			}
			else {
				return (rest/3600000+"시간 "+(rest%3600000)/60000+"분");
			}

	}

	
	/*알람 시작시간 반환*/
	public String getStartTime() {
		return timeTxt.format(startTime);
	}
	
	/*알람 종료시간 시스템내 반환*/
	protected Date getFinish_D() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startTime);
		cal.add(Calendar.MINUTE, runTime_min);
		Date finish = new Date(cal.getTimeInMillis());
		
		return finish;
	}
	
	/*알람 종료 시간(절대시간) 반환*/
	public String getFinishTime() {	
		return /*종료시간*/timeTxt.format(getFinish_D());
	}
	

}

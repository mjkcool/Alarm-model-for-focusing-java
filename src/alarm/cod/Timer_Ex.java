package alarm.cod;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Timer_Ex{
	SimpleDateFormat timeTxt = new SimpleDateFormat("a hh:mm:ss");
	
	/*Ÿ�̸� �ð�, �ݺ��ð�*/ int runTime_min, periodTime_min;
	/*Ÿ�̸� ���� �ð�*/ Date startTime;
	
	
	/* Ÿ�̸� ��ü ���� (������) */
	public Timer_Ex(int run_min/*Ÿ�̸� �ð�(��)*/, int period_min/*�ݺ� �ð�(��)*/) {
		
		this.runTime_min = run_min;
		this.periodTime_min = period_min;
		
		/*���� �ð� ����*/startTime = new Date();
		System.out.println("[�˶� ��ȿ�Ⱓ:"+getRunTime()+"/�ݺ��ð�:"+getPeriodTime()+"/�˶� ����ð�:"+getFinishTime()+"]");
		System.out.println("Ÿ�̸Ӱ�ü����:"+timeTxt.format(startTime));
		
		/*Ÿ�̸� ����*///new TimerThread.runTimer(run_min*60000, period_min*60000, this);
		(new TimerThread()).action(run_min*60000, period_min*60000, this);
	}
	
	
	
	/*�˶� ����ð� ��ȯ*/
	public String getRunTime() {
		
			if(runTime_min/60>=1) { //1�ð� �̻��� ���
				/*�ð����� ��ȯ*/ return (runTime_min/60+"�ð� "+runTime_min%60+"��");			
			}else /*������ ��ȯ*/ return (runTime_min+"��");
	
	}
	
	
	/*�˶� �ݺ��ð� ��ȯ*/
	public String getPeriodTime() {
			
			if(periodTime_min/60>=1) { //1�ð� �̻��� ���
				/*�ð����� ��ȯ*/ return (periodTime_min/60+"�ð� "+periodTime_min%60+"��");			
			}else /*������ ��ȯ*/ return (periodTime_min+"��");
			
	}

	
	/*�˶� ���� �ð�(���ð�) ��ȯ*/
	public String getRemainingRunTime() {

			Date now = new Date();
			long rest = getFinish_D().getTime() - now.getTime();
			
			if(rest/60000<1) {
				return (rest/1000+"��");
			}
			else if(rest/3600000<1) {
				return (rest/60000+"�� "+(rest%60000)/1000+"��");
			}
			else {
				return (rest/3600000+"�ð� "+(rest%3600000)/60000+"��");
			}

	}

	
	/*�˶� ���۽ð� ��ȯ*/
	public String getStartTime() {
		return timeTxt.format(startTime);
	}
	
	/*�˶� ����ð� �ý��۳� ��ȯ*/
	protected Date getFinish_D() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startTime);
		cal.add(Calendar.MINUTE, runTime_min);
		Date finish = new Date(cal.getTimeInMillis());
		
		return finish;
	}
	
	/*�˶� ���� �ð�(����ð�) ��ȯ*/
	public String getFinishTime() {	
		return /*����ð�*/timeTxt.format(getFinish_D());
	}
	

}

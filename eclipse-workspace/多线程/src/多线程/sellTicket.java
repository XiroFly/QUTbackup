package 多线程;

public class sellTicket {
	int amount5=3,amount10=0,amount20=0;
	String s=null;
	public synchronized void 售票规则(int money){
		String name=Thread.currentThread().getName();
		if(money==5) {
			
			amount5=amount5+1;
			s="给"+name+"入场券,"+name+"的钱正好";
			windowTicket.text.append("\n"+s);
		}
		else if(money==10) {
			while(amount5==0) {
				try {windowTicket.text.append("\n"+name+"靠边等。。。");
				wait();
				}
				catch(InterruptedException e) {}
			}
			amount5=amount5-1;
			s="给"+name+"入场券,"+name+"给10元，找5元";
			windowTicket.text.append("\n"+s);
		}
		else if(money==20) {
			while(amount5*5+amount10*10<15) {
				try {windowTicket.text.append("\n"+name+"靠边等。。。");
				wait();
				}
				catch(InterruptedException e) {}
			}
			if(amount10!=0&&amount5!=0) {
				amount10=amount10-1;
				amount5=amount5-1;
			}
			else if(amount10==0&&amount5>=3) {
				amount5=amount5-3;
			}
				
			s="给"+name+"入场券,"+name+"给20元，找15元";
			windowTicket.text.append("\n"+s);
		}
		notifyAll();
		
	}

}
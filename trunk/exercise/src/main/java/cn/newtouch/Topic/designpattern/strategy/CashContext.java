package cn.newtouch.Topic.designpattern.strategy;

public class CashContext {

	private CashSuper cs;
	
	public CashContext(int flag) {
		
		switch (flag) {
			
			case 1:
				CashNormal cs0 = new CashNormal();
				cs = cs0;
				break;
			case 2:
				CashReturn cs1 = new CashReturn();
				cs = cs1;
				break;
			case 3:
				CashRebate cs2 = new CashRebate();
				cs = cs2;
				break;
		}
	}
	
	public void getResult() {
		
		cs.Algorithm();
	}
}
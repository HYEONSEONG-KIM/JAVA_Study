package g_oop2;

public class StarCraft {

	public static void main(String[] args) {
		Marine marine = new Marine();
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		SCV scv = new SCV();
		
		scv.repair(tank);
		scv.repair(dropship);
		
//		scv.repair(marine);
	}

}

class Unit{
	int hp;
	final int Max_Hp;
	
	Unit(int hp){
		
		Max_Hp = hp;
		this.hp = Max_Hp;
	}
	
}

class Marine extends Unit{

	Marine() {
		super(40);
	}
	
}

class Tank extends Unit implements Repairalbe{

	Tank() {
		super(150);
	}
	
}


class Dropship extends Unit implements Repairalbe{

	Dropship() {
		super(125);
	}
	
}

class SCV extends Unit{

	SCV() {
		super(60);
	}
	
	void repair(Repairalbe r){
		if(r instanceof Unit){ //Unit으로 형변환이 가능한지 확인
			Unit u = (Unit)r;
			
			while(u.hp < u.Max_Hp){
				u.hp++;
			}
		}
	}
	
}

interface Repairalbe{
	
}






















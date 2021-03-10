package f_game;

public class Item {
	
	String name;	//이름
	int hp;			//체력
	int mp;			//마나
	int att;		//공격력
	int def;		//방어력

	Item(String name, int hp, int mp, int att, int def){
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.att =att;
		this.def = def;
	}
	
	public String itemInfo() {
		
		String info = name + " :";
		
		if(hp > 0) info += "체력+" + hp;
		if(mp > 0) info += "마나+" + mp;
		if(att > 0) info += "공격+" + att;
		if(def > 0) info += "방어+" + def;
		
		return info;
	}
	
	

}














package e_oop;

public class TV {
	
	/*
	 * 과제 : 임의의 사물을 대상으로 클래스 만들기
	 * 사물이 가지고 있는 속성을 변수로 만들고,
	 * 변수와 관계의 동작들을 메서드로 만들기
	 */
	int volume;
	int channel;
	boolean power;

	TV(boolean power, int volume , int channel){
		this.power = power;
		this.volume = volume;
		this.channel = channel;
	}
	
	TV(){
		this(false, 0, 1);
	}
	
	void power(){
		power = !power;
		System.out.println(power ? "ON" : "OFF");
	}
	
	
	void volumeMethod(String up_down){
		if(power){
			if(up_down.equals("+")){
				volume++;
				if(volume > 30){
					volume = 30;
					System.out.println("최대 볼륨은 30 입니다");
				}else{
					System.out.println("현재 볼륨은 " + volume + " 입니다" );
				}
				
			}else if(up_down.equals("-")){
				volume --;
				if(volume < 0){
					volume = 0;
					System.out.println("최소 볼륨은 0 입니다");
				}else{
					System.out.println("현재 볼륨은 " + volume + " 입니다" );
				}
			}else{
				System.out.println("입력정보가 올바르지 않습니다");
			}
				
		}else{
			System.out.println("전원을 켜주세요");
		}
	}
	
	
	void channelMathod(String up_down){
		if(power){
			if(up_down.equals("+")){
				channel++;
				if(channel == 101){
					channel = 1;
					System.out.println("현재 채널은" + channel + " 입니다");
				}
				System.out.println("현재 채널은" + channel + " 입니다");
			}else if(up_down.equals("-")){
				channel--;
				if(channel == -1){
				channel = 100;
				System.out.println("현재 채널은" + channel + " 입니다");
				}
				System.out.println("현재 채널은" + channel + " 입니다");
			}else{
				System.out.println("입력정보가 올바르지 않습니다");
			}
		}else{
			System.out.println("전원을 켜주세요");
		}
	}
	
	
	void setChannel(int Channel){
		this.channel = channel;
		
		if(power){
			if(channel > 100){
				channel = 100;
				System.out.println("검색된 채널번호는 100번까지 입니다, 100번으로 이동합니다");
				System.out.println("현재 채널의 번호는" + channel + " 입니다");
			}else if(channel < 0){
				channel = 1;
				System.out.println("채널의 번호는 양수입니다, 1번으로 이동합니다");
				System.out.println("현재 채널의 번호는" + channel + " 입니다");
			}
		}else{
			System.out.println("전원을 켜주세요");
		}
		
	}
	
}



















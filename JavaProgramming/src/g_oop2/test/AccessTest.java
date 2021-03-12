package g_oop2.test;

import g_oop2.AccessModifier;

public class AccessTest extends AccessModifier{

	public static void main(String[] args) {
		
		AccessModifier am =	new AccessModifier();
		
		System.out.println(am.publicVar);
		am.publicMethod();
		
		
//		System.out.println(am.protectedVar);
//		am.protectedMethod();
		
//		System.out.println(am.defaultVar);
//		am.defaultMethod();
		
//		System.out.println(am.privateVar);
//		am.privateMathod();
		
		
		AccessTest at =new AccessTest();
		System.out.println(at.protectedVar);
		at.protectedMethod();
	}

}

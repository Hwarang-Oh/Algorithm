package com.SSAFY_1.day2.c_constructor;

public class SmartPhoneTest {
    public SmartPhone getPhone() {
        return null;
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        SmartPhone sphone = new SmartPhone();
        sphone.number = "010";
        System.out.println(sphone.osName + " : " + sphone.number);
        sphone.call("011");

        SmartPhone sphone2 = new SmartPhone();
        sphone2.number = "010-111-1111";
        System.out.println(sphone2.osName + " : " + sphone2.number);

        SmartPhone.osName = "android 4.0"; // Static 접근하여 변경
        System.out.println(sphone.osName + " : " + sphone.number); // sphone.number는 안바뀜
    }
}

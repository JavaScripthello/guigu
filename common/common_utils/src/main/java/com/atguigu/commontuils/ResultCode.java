package com.atguigu.commontuils;

import java.time.Instant;

public interface ResultCode {
    Integer SUCCESS =20000;
    Integer ERROR =201;


    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
class Super{
    public Super(){
        overrideMe();
    }

    public void overrideMe() {
    }
}

final  class Sub extends Super{
    private  final Instant instant;
    Sub(){
        instant = Instant.now();
    }
    @Override
    public void overrideMe() {
        System.out.println(instant);
    }
}
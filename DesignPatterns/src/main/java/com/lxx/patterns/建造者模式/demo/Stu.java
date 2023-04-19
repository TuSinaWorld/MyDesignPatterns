package com.lxx.patterns.建造者模式.demo;


//底层例子:StringBuffer
public class Stu {
    private String name;
    private Integer age;
    private String gender;
    private Stu(){}
    private Stu(Build b){
        this.name = b.name;
        this.age = b.age;
        this.gender = b.gender;
    }
    private Stu(String name, Integer age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static Build builder(){
        return new Build();
    }

    public static class Build{
        private String name = "null";
        private Integer age = 0;
        private String gender = "null";

        public Build setName(String name) {
            this.name = name;
            return this;
        }

        public Build setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Build setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Stu build(){
            return new Stu(this);
        }
    }

}

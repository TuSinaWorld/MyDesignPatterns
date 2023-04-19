package com.lxx.patterns.建造者模式.demo1;


//定义一个类
public class Stu {
    //定义属性~~
    private String name;
    private Integer age;
    private String gender;
    //定义构造方法,使用建造者类构建
    private Stu(Build b){
        this.name = b.name;
        this.age = b.age;
        this.gender = b.gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //普普通通toString
    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    //获取建造者类罢了~~
    public static Build builder(){
        return new Build();
    }

    public static class Build{
        //建造者类中属性应与要建造类的属性相同,可以带有默认值
        private String name = "null";
        private Integer age = 0;
        private String gender = "null";

        //建造方法,对应需建造类中的属性
        public Build name(String name) {
            this.name = name;
            return this;
        }

        public Build age(Integer age) {
            this.age = age;
            return this;
        }

        public Build gender(String gender) {
            this.gender = gender;
            return this;
        }

        //利用建造者类调用需构建类的构造函数
        public Stu build(){
            return new Stu(this);
        }
    }

}

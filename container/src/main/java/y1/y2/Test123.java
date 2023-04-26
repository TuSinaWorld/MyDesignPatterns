package y1.y2;

import org.ycframework.annotation.YcComponent;

@YcComponent
public class Test123 {
    private int id = 0;

    public Test123() {
        System.out.println("多个AppConfig测试成功!");
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "test{" +
                "id=" + id +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }
}

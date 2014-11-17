/**
 * Created by liudingyu on 14/11/17.
 */
public class TestInnerClass {
    private String mName = null;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public TestInnerClass(String name) {
        mName = name;
    }

    public TestInnerClass() {
        this(null);
    }

    @Override
    public String toString() {
        return mName;
    }

    private void printInfo() {
        printInfo("无参数");
    }
    public void printInfo(String content) {
        System.out.println(mName + " " + content);
    }
}

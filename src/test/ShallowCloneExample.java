package test;

/**
 * @author ly
 * @date 2019/6/11 9:56
 * 拷贝对象和原始对象的引用类型引用同一个对象。
 */
public class ShallowCloneExample implements Cloneable{
    private Integer arr;

    public Integer getArr() {
        return arr;
    }

    public void setArr(Integer arr) {
        this.arr = arr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShallowCloneExample)) return false;

        ShallowCloneExample that = (ShallowCloneExample) o;

        return getArr().equals(that.getArr());
    }

    @Override
    public int hashCode() {
        return getArr().hashCode();
    }

    @Override
    protected ShallowCloneExample clone() throws CloneNotSupportedException {
        return (ShallowCloneExample)super.clone();
    }
}

package pojo;

/**
 * 
 * 点结点
 */
public class Vnode implements Cloneable{
    /**
     * 入度域
     */
    private int in;
    /**
     * 数据域
     */
    private Course data;
    /**
     * 指针域
     */
    private ArcNode firstArc;

    public Vnode(){
        in = -1;
        data = null;
        firstArc = null;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        Vnode vnode = null;
        try {
            vnode = (Vnode)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        vnode.in = ((Vnode)vnode.clone()).getIn();
        vnode.data = (Course)data.clone();
        vnode.firstArc = (ArcNode)firstArc.clone();
        return vnode;
    }
    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public Course getData() {
        return data;
    }

    public void setData(Course data) {
        this.data = data;
    }

    public ArcNode getFirstArc() {
        return firstArc;
    }

    public void setFirstArc(ArcNode firstArc) {
        this.firstArc = firstArc;
    }
}
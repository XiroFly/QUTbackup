package test;

import pojo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static constant.MyConstants.maxStudy;

/**
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入课程总数和课程依赖边数");
        System.out.println("顶点数：");
        int number = scanner.nextInt();
        System.out.println("依赖边数：");
        int edge = scanner.nextInt();
        Graph graph = new Graph(number,edge);
        //创建AOV无环网
        graph.creatAdj();
        System.out.println("输入1：题目一：判断课程能否顺利学完，若能，输出一个正确的学习顺序");
        System.out.println("输入2：题目二：求学完这些课程最少需要几个学期，并给出一个初步的教学计划（每个学期学习哪几门课程）");
        System.out.println("输入3：题目三：由于学生精力的限制，学校对每学期选课数的上限进行了约束，请判断约束后学生能够在原来的学期数内完成学习，若不能，此时最少需要几个学期学完这些课程（选做）");
        System.out.println("请输入指令：");
        int x = scanner.nextInt();
        switch (x){
            case (1):
                topSort1(graph);
                break;
            case (2):
                topSort2(graph);
                break;
            case (3):
                topSort3(graph);
                break;
            default:
                return;
        }
        scanner.close();
    }

    /**
     * 学习顺序
     * @param graph
     */
    public static void topSort1(Graph graph){
        //建立空栈，用于存放入度为0的点
        Stack stack = new Stack();
        stack.top = 0;
        int count = 0;
        //对邻接表进行遍历，将其中度为0的点压入栈中
        for (int i = 0; i < graph.adjList.length-1; i++) {
            if (graph.adjList[i].getIn() == 0){
                stack.push(graph.adjList[i].getData());
            }
        }
        System.out.println("学习顺序为：");
        while (stack.top!=0){
            //出栈并输出一个元素
            Course course = stack.pop();
            System.out.print(course.getId()+":"+course.getName());
            count++;
            //所有与其有关系的点的入度均减一
            ArcNode p = graph.adjList[graph.locateVex(course)].getFirstArc();
            while (p != null){
                int in = graph.adjList[p.adjVex].getIn()-1;
                graph.adjList[p.adjVex].setIn(in);
                //若入度减一后存在顶点的度减少为0，便将其入栈
                if (graph.adjList[p.adjVex].getIn() == 0){
                    stack.push(graph.adjList[p.adjVex].getData());
                }
                p = p.nextArc;
            }
            if (count!=graph.adjList.length){
                System.out.print("->");
            }
        }
        //出栈的元素数量小于顶点表的长度时，则表明有环产生
        if (count < graph.adjList.length){
            System.out.println("有回路产生，即无法全部学完所有课程");
        }
        System.out.println();
    }

    /**
     * 教学顺序
     * @param graph
     */
    public static void topSort2(Graph graph){
        //建立空栈，用于存放入度为0的点
        Stack stack = new Stack();
        stack.top = 0;
        int count = 0;
        int day = 0;
        //对邻接表进行遍历，将其中度为0的点压入栈中
        for (int i = 0; i < graph.adjList.length-1; i++) {
            if (graph.adjList[i].getIn() == 0){
                stack.push(graph.adjList[i].getData());
            }
        }
        while (stack.top!=0){
            //使用ArrayList集合来存储每次栈中的元素
            List<Course> list = new ArrayList<Course>();
            //将所有度为零的元素全部出栈
            while (stack.top!=0){
                Course course = stack.pop();
                list.add(course);
                count++;
            }
            day++;
            System.out.println("第"+day+"个学期的学习：");
            for (Course c : list) {
                System.out.print(c.getId()+" "+c.getName()+" ");
            }
            System.out.println();
            for (int i = 0; i < list.size(); i++) {
                ArcNode p = graph.adjList[graph.locateVex(list.get(i))].getFirstArc();
                //所有与其有关系的点的入度均减一
                while (p != null){
                    graph.adjList[p.adjVex].setIn(graph.adjList[p.adjVex].getIn()-1);
                    //若入度减一后存在顶点的度减少为0，便将其入栈
                    if (graph.adjList[p.adjVex].getIn() == 0){
                        stack.push(graph.adjList[p.adjVex].getData());
                    }
                    p = p.nextArc;
                }
            }
        }
        //若循环结束后day值大于学期最大值常数，则表明无法再大学期间学完所有课程
        if (day>maxStudy){
            System.out.println("不能在大学四年8个学期内学完");
        }else {
            System.out.println("以上为初步教学顺序");
        }
    }

    /**
     * 选课上限限制
     * @param graph
     */
    public static void topSort3(Graph graph){
        Stack stack = new Stack();
        int limit = 0;
        stack.top = 0;
        int day = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请设置选课上限：");
        limit = scanner.nextInt();
        //对邻接表进行遍历，将其中度为0的点压入栈中
        for (int i = 0; i < graph.adjList.length-1; i++) {
            if (graph.adjList[i].getIn() == 0){
                stack.push(graph.adjList[i].getData());
            }
        }
        while (stack.top!=0){
            int count = 0;
            List<Course> list = new ArrayList<Course>();
            //使用集合存储出栈的元素，但出栈和加入集合的元素数量应小于limit且栈不为空
            while (stack.top!=0 && count < limit){
                Course course = stack.pop();
                list.add(course);
                count++;
            }

            day++;
            System.out.println("第"+day+"个学期的学习：");
            for (Course c : list) {
                System.out.print(c.getId()+" "+c.getName()+" ");
            }
            System.out.println();
            for (int i = 0; i < list.size(); i++) {
                ArcNode p = graph.adjList[graph.locateVex(list.get(i))].getFirstArc();
                //所有与其有关系的点的入度均减一
                while (p != null){
                    graph.adjList[p.adjVex].setIn(graph.adjList[p.adjVex].getIn()-1);
                    //若入度减一后存在顶点的度减少为0，便将其入栈
                    if (graph.adjList[p.adjVex].getIn() == 0){
                        stack.push(graph.adjList[p.adjVex].getData());
                    }
                    p = p.nextArc;
                }
            }
        }
        //若学期数大于学期最大值常数，则表明无法在学完所有课程，并输出所有的学期以及所上的课程
        if (day>maxStudy){
            System.out.println("需要"+day+"个学期才能学完"+"不能在大学四年8个学期内学完");
        }else {
            System.out.println("以上为限制选课教学顺序");
        }
    }
}

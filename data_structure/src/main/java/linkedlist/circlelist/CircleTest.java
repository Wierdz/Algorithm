package linkedlist.circlelist;

/**
 * @author Wierdz
 * @version 1.0
 */
public class CircleTest {
    public static void main(String[] args) {
        CircleList cList = new CircleList();
        cList.createCircleList(5);

        cList.show();
        System.out.println(cList.getLength());
        System.out.println("按照从第二个开始每隔一个出列");
        cList.joseph(5, 2);
    }
}

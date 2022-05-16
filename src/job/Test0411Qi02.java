package job;

import java.util.*;

/**
 *
 * 撤销/恢复操作具有广泛的用途，比如word文档中输入一个单词，可以点撤销，然后可以再恢复。
 * 编程实现如下功能：  从标准输入读取到一个字符串，字符串可包含0个或多个单词，单词以空格或者tab分隔； 如果遇到 "undo" 字符串，表示"撤销"操作，前一个字符串被撤销掉； 如果遇到"redo"字符串，表示恢复刚才撤销掉的字符串.
 * 例如:   输入字符串 "hello undo redo world."，  对字符串中的 undo 和 redo 处理后， 最终输出的结果为 "hello world."
 *
 * 先初始化两个栈stack和redo，然后利用双栈求解。遍历词表：
 * 遇到普通词就压入stack，并清空redo栈，因为此时写入了一个新词，再往前的词已经找不回来了；
 * 遇到undo就从stack中弹栈至redo；
 * 遇到redo就从redo中弹栈至stack。
 * 最终stack中的词就是最后保留下来的词
 * @author 曾奕
 */
public class Test0411Qi02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            ctrlZ(sc.nextLine());
        }
    }

    private static void ctrlZ(String str) {

        List<String> list = new ArrayList<>(Arrays.asList(str.replace("\t", " ").split(" ")));

        Deque<String> deque = new LinkedList<>();

        for (int i=0;i<list.size();i++){
            if("undo".equals(list.get(i))){
                list.remove(i--);
                if(i>=0){
                    deque.push(list.get(i));
                    list.remove(i--);
                }
            }else if("redo".equals(list.get(i))){
                list.remove(i);
                if(!deque.isEmpty()){
                    list.add(i++,deque.pop());
                }
                i--;
            }else{
                deque.clear();
            }
        }
        System.out.println(String.join(" ",list));
    }
}

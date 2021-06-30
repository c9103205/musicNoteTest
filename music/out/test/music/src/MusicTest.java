import jdk.swing.interop.SwingInterOpUtils;
import org.jfugue.player.Player;

import java.util.*;

public class MusicTest {
    public static void main(String[] args) {
        System.out.println("絕對音感記憶遊戲");

        Player pp = new Player();
        pp.play("C D E F G A B C6");

        //出題用的list答題用的list
        List<Integer> queList = new ArrayList();
        //達題用的list
        List<Integer> ansList = new ArrayList();

        int count = 1;
        while (count > 0) {
            //生成1~8的音符
            Integer note = new Random().nextInt(8) + 1;
            queList.add(note);
            play(queList);

            System.out.println("請根據所聽到之音符，輸入1-8的數字");
            System.out.println("我是作弊的答案: " + queList);
            Scanner sc = new Scanner(System.in);

            ansList.clear();
            for (int i = 1; i <= count; i++) {
                int guess = sc.nextInt();
                ansList.add(guess);
            }

            System.out.println("ansList: " + ansList);
            if (queList.equals(ansList)) {
                System.out.println("本題答對，繼續挑戰!");
                count++;
            } else {
                System.out.println("答錯，請再接再厲QQ");
                count = 0;
            }
        }
    }








    static void play(List<Integer> queList) {
        Player pp = new Player();
        for (Integer ans : queList) {
            if (ans == 1) {
                pp.play("C5qqqq");
            }
            if (ans == 2) {
                pp.play("D5qqqq");
            }
            if (ans == 3) {
                pp.play("E5qqqq");
            }
            if (ans == 4) {
                pp.play("F5qqqq");
            }
            if (ans == 5) {
                pp.play("G5qqqq");
            }
            if (ans == 6) {
                pp.play("A5qqqq");
            }
            if (ans == 7) {
                pp.play("B5qqqq");
            }
            if (ans == 8) {
                pp.play("C6qqqq");
            }
        }
    }
}
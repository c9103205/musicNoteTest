import org.jfugue.player.Player;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class musGui extends JDialog {
    private JPanel contentPane;
    private JButton DoButton;
    private JButton ReButton;
    private JButton miButton;
    private JButton faButton;
    private JButton soButton;
    private JButton laButton;
    private JButton siButton;
    private JButton doButton;
    private JButton ruleButton;
    private JButton startButton;
    private JButton clearButton;
    private JButton submitButton;
    private JTextField textField1;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel1;
    private ArrayList quesList = new ArrayList();
    private ArrayList ansList = new ArrayList();
    private Integer count = 1;


    public musGui() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(DoButton);
        setTitle("音感測驗小遊戲  作者 Martin Cheng");

        DoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appear(1);
            }
        });

        ReButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appear(2);
            }
        });

        miButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appear(3);
            }
        });

        faButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appear(4);
            }
        });

        soButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appear(5);
            }
        });

        laButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appear(6);
            }
        });

        siButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appear(7);
            }
        });

        //高音do
        doButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appear(8);
            }
        });

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                allReset();
                musicTest();
            }
        });

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //清空欄位及list物件
                ansList.clear();
                textField1.setText(ansList + "");
            }
        });

        ruleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "您會聽到音符，請選出對應的音符，答案確定後且按下 'submit'", "規則說明",
                        JOptionPane.DEFAULT_OPTION);

            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void appear(int num) {
        this.ansList.add(num);
        List list = this.ansList;
        textField1.setText(list + "");
    }

    public void checkAnswer() {
        if (quesList.equals(ansList)) {
            JOptionPane.showMessageDialog(null, "回答正確，進入下一階段，請聽好", null,
                    JOptionPane.DEFAULT_OPTION);
            count++;
            label1.setText("目前關卡: "+count);
            nextLevel(count);

        } else {
            label1.setText("回答錯誤，請再接再勵QQ");
            label2.setText("正確答案:" + quesList + " ,您回答:" + ansList);
            count = 1;

        }
    }


    public void musicTest() {
        //清空題目
        this.quesList.clear();
        Player pp = new Player();
        pp.play("C D E F G A B C6");
        label1.setText("目前關卡: "+count);
        nextLevel(count);
    }

    void nextLevel(int count) {
        System.out.println("關卡:" + count);
        //生成1~8的音符
        Integer note = new Random().nextInt(8) + 1;
        this.quesList.add(note);
        System.out.println("我是作弊的答案" + quesList);
        play(quesList);
    }

    void allReset(){
        this.quesList.clear();
        this.ansList.clear();
        this.count = 1;
        label1.setText("重新開始~~");
        label2.setText("");

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

    public static void main(String[] args) {
        musGui dialog = new musGui();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}

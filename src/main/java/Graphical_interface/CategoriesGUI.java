package Graphical_interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoriesGUI extends JDialog{
    protected JPanel MainPanel;//protected обов'язково
    protected JRadioButton A1true;
    protected JRadioButton A1false;
    protected JRadioButton B1true;
    protected JRadioButton Btrue;
    protected JRadioButton C1true;
    protected JRadioButton Ctrue;
    protected JRadioButton D1true;
    protected JRadioButton Dtrue;
    protected JRadioButton C1Etrue;
    protected JRadioButton BEtrue;
    protected JRadioButton CEtrue;
    protected JRadioButton D1Etrue;
    protected JRadioButton DEtrue;
    protected JRadioButton T1true;
    protected JRadioButton T2true;
    protected JRadioButton Afalse;
    protected JRadioButton B1false;
    protected JRadioButton Bfalse;
    protected JRadioButton C1false;
    protected JRadioButton Cfalse;
    protected JRadioButton D1false;
    protected JRadioButton Dfalse;
    protected JRadioButton C1Efalse;
    protected JRadioButton BEfalse;
    protected JRadioButton CEfalse;
    protected JRadioButton D1Efalse;
    protected JRadioButton DEfalse;
    protected JRadioButton T1false;
    protected JRadioButton T2false;
    protected JRadioButton Atrue;

    public CategoriesGUI(){
        setContentPane(MainPanel);
        setSize(800,700);
        setModal(true);
        A1false.setSelected(true);//спочатку ставимо, що всі категорії не здані
        Afalse.setSelected(true);
        B1false.setSelected(true);
        Bfalse.setSelected(true);
        C1false.setSelected(true);
        Cfalse.setSelected(true);
        D1false.setSelected(true);
        Dfalse.setSelected(true);
        C1Efalse.setSelected(true);
        BEfalse.setSelected(true);
        CEfalse.setSelected(true);
        D1Efalse.setSelected(true);
        DEfalse.setSelected(true);
        T1false.setSelected(true);
        T2false.setSelected(true);

        A1true.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                A1true.setSelected(true);
                A1false.setSelected(false);

            }
        });
        A1false.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                A1false.setSelected(true);
                A1true.setSelected(false);
            }
        });


        Atrue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                Atrue.setSelected(true);
                Afalse.setSelected(false);

            }
        });
        Afalse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                Afalse.setSelected(true);
                Atrue.setSelected(false);
            }
        });


        B1true.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                B1true.setSelected(true);
                B1false.setSelected(false);

            }
        });
        B1false.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                B1false.setSelected(true);
                B1true.setSelected(false);
            }
        });


        Btrue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                Btrue.setSelected(true);
                Bfalse.setSelected(false);

            }
        });
        Bfalse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                Bfalse.setSelected(true);
                Btrue.setSelected(false);
            }
        });


        C1true.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                C1true.setSelected(true);
                C1false.setSelected(false);

            }
        });
        C1false.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                C1false.setSelected(true);
                C1true.setSelected(false);
            }
        });


        Ctrue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                Ctrue.setSelected(true);
                Cfalse.setSelected(false);

            }
        });
        Cfalse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                Cfalse.setSelected(true);
                Ctrue.setSelected(false);
            }
        });


        D1true.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                D1true.setSelected(true);
                D1false.setSelected(false);

            }
        });
        D1false.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                D1false.setSelected(true);
                D1true.setSelected(false);
            }
        });


        Dtrue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                Dtrue.setSelected(true);
                Dfalse.setSelected(false);

            }
        });
        Dfalse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                Dfalse.setSelected(true);
                Dtrue.setSelected(false);
            }
        });


        C1Etrue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                C1Etrue.setSelected(true);
                C1Efalse.setSelected(false);

            }
        });
        C1Efalse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                C1Efalse.setSelected(true);
                C1Etrue.setSelected(false);
            }
        });


        BEtrue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                BEtrue.setSelected(true);
                BEfalse.setSelected(false);

            }
        });
        BEfalse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                BEfalse.setSelected(true);
                BEtrue.setSelected(false);
            }
        });


        CEtrue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                CEtrue.setSelected(true);
                CEfalse.setSelected(false);

            }
        });
        CEfalse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                CEfalse.setSelected(true);
                CEtrue.setSelected(false);
            }
        });


        D1Etrue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                D1Etrue.setSelected(true);
                D1Efalse.setSelected(false);

            }
        });
        D1Efalse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                D1Efalse.setSelected(true);
                D1Etrue.setSelected(false);
            }
        });


        DEtrue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                DEtrue.setSelected(true);
                DEfalse.setSelected(false);

            }
        });
        DEfalse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                DEfalse.setSelected(true);
                DEtrue.setSelected(false);
            }
        });


        T1true.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                T1true.setSelected(true);
                T1false.setSelected(false);

            }
        });
        T1false.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                T1false.setSelected(true);
                T1true.setSelected(false);
            }
        });


        T2true.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                T2true.setSelected(true);
                T2false.setSelected(false);

            }
        });
        T2false.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//щоб з 2 можна було вибрати тільки 1 радіокнопку
                T2false.setSelected(true);
                T2true.setSelected(false);
            }
        });
    }

//    public static void main(String[] args) {
//        CategoriesGUI c = new CategoriesGUI();
//        c.setVisible(true);
//    }
}

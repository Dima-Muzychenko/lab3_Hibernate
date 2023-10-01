package Graphical_interface;

import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainGUI extends JDialog{
    private JPanel Main;
    private JTable table1;
//    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    static EntityManagerFactory factory;


    public static void main(String[] args) {
        MainGUI pane = new MainGUI();
        pane.setVisible(true);
        pane.setModal(true);

    }

    public MainGUI(){
        setContentPane(Main);
        setSize(800,600);
        table1.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JMenuBar menuBar = new JMenuBar();//менюбар
        this.setJMenuBar(menuBar);

        //Це меню прийшлось прописувати вручну, бо JMenu в InteliJ IDEA нема
        //SELECT
        JMenu MenuSELECT = new JMenu("Select");//Select
        MenuSELECT.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menuBar.add(MenuSELECT);

        JMenuItem SAutoCoursesMenu = new JMenuItem("AutoCourses");
        SAutoCoursesMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuSELECT.add(SAutoCoursesMenu);
        SAutoCoursesMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectEntity(AutoCoursesEntity.class);

            }
        });
        JMenuItem SCertificateMenu = new JMenuItem("Certificate");
        SCertificateMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuSELECT.add(SCertificateMenu);
        SCertificateMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectEntity(CertificateEntity.class);

            }
        });
        JMenuItem SDriverMenu = new JMenuItem("Driver");
        SDriverMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuSELECT.add(SDriverMenu);
        SDriverMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectEntity(DriverEntity.class);

            }
        });
        JMenuItem SExaminationMenu = new JMenuItem("Examination");
        SExaminationMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuSELECT.add(SExaminationMenu);
        SExaminationMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectEntity(ExaminationEntity.class);

            }
        });
        JMenuItem SMIAMenu = new JMenuItem("MIA");
        SMIAMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuSELECT.add(SMIAMenu);
        SMIAMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectEntity(MIAEntity.class);

            }
        });
        JMenuItem SPracticeMenu = new JMenuItem("Practice");
        SPracticeMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuSELECT.add(SPracticeMenu);
        SPracticeMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectEntity(PracticeEntity.class);

            }
        });
        JMenuItem STestMenu = new JMenuItem("Test");
        STestMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuSELECT.add(STestMenu);
        STestMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectEntity(TestEntity.class);

            }
        });


        //INSERT
        JMenu MenuINSERT = new JMenu("Insert");//Select
        MenuINSERT.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menuBar.add(MenuINSERT);

        JMenuItem IAutoCoursesMenu = new JMenuItem("AutoCourses");
        IAutoCoursesMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuINSERT.add(IAutoCoursesMenu);
        IAutoCoursesMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AutoCoursesGUI AC = new AutoCoursesGUI("Insert",null);
                AC.setVisible(true);
                selectEntity(AutoCoursesEntity.class);
            }
        });
        JMenuItem ICertificateMenu = new JMenuItem("Certificate");
        ICertificateMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuINSERT.add(ICertificateMenu);
        ICertificateMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CertificateGUI AC = new CertificateGUI("Insert",null);
                AC.setVisible(true);
                selectEntity(CertificateEntity.class);
            }
        });
        JMenuItem IDriverMenu = new JMenuItem("Driver");
        IDriverMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuINSERT.add(IDriverMenu);
        IDriverMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DriverGUI AC = new DriverGUI("Insert",null);
                AC.setVisible(true);
                selectEntity(DriverEntity.class);
            }
        });
        JMenuItem IExaminationMenu = new JMenuItem("Examination");
        IExaminationMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuINSERT.add(IExaminationMenu);
        IExaminationMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExaminationGUI AC = new ExaminationGUI("Insert",null);
                AC.setVisible(true);
                selectEntity(ExaminationEntity.class);
            }
        });
        JMenuItem IMIAMenu = new JMenuItem("MIA");
        IMIAMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuINSERT.add(IMIAMenu);
        IMIAMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MIAGUI AC = new MIAGUI("Insert",null);
                AC.setVisible(true);
                selectEntity(MIAEntity.class);
            }
        });
        JMenuItem IPracticeMenu = new JMenuItem("Practice");
        IPracticeMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuINSERT.add(IPracticeMenu);
        IPracticeMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PracticeGUI AC = new PracticeGUI("Insert",null);
                AC.setVisible(true);
                selectEntity(PracticeEntity.class);
            }
        });
        JMenuItem ITestMenu = new JMenuItem("Test");
        ITestMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuINSERT.add(ITestMenu);
        ITestMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TestGUI AC = new TestGUI("Insert",null);
                AC.setVisible(true);
                selectEntity(TestEntity.class);
            }
        });


        //DELETE
        JMenu MenuDELETE = new JMenu("Delete");//Select
        MenuDELETE.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menuBar.add(MenuDELETE);

        JMenuItem DAutoCoursesMenu = new JMenuItem("AutoCourses");
        DAutoCoursesMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuDELETE.add(DAutoCoursesMenu);
        DAutoCoursesMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteDialog deleteDialog = new DeleteDialog("Auto_courses","Delete Course", AutoCoursesEntity.getTableTitlesForDelete(), AutoCoursesEntity.class);
                deleteDialog.setVisible(true);
                selectEntity(AutoCoursesEntity.class);
            }
        });
        JMenuItem DCertificateMenu = new JMenuItem("Certificate");
        DCertificateMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuDELETE.add(DCertificateMenu);
        DCertificateMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteDialog deleteDialog = new DeleteDialog("Certificate","Delete Certificate", CertificateEntity.getTableTitlesForDelete(), CertificateEntity.class);
                deleteDialog.setVisible(true);
                selectEntity(CertificateEntity.class);
            }
        });
        JMenuItem DDriverMenu = new JMenuItem("Driver");
        DDriverMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuDELETE.add(DDriverMenu);
        DDriverMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteDialog deleteDialog = new DeleteDialog("Driver","Delete Driver", DriverEntity.getTableTitlesForDelete(), DriverEntity.class);
                deleteDialog.setVisible(true);
                selectEntity(DriverEntity.class);
            }
        });
        JMenuItem DExaminationMenu = new JMenuItem("Examination");
        DExaminationMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuDELETE.add(DExaminationMenu);
        DExaminationMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteDialog deleteDialog = new DeleteDialog("Examination","Delete Examination", ExaminationEntity.getTableTitlesForDelete(), ExaminationEntity.class);
                deleteDialog.setVisible(true);
                selectEntity(ExaminationEntity.class);
            }
        });
        JMenuItem DMIAMenu = new JMenuItem("MIA");
        DMIAMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuDELETE.add(DMIAMenu);
        DMIAMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteDialog deleteDialog = new DeleteDialog("MIA","Delete MIA", MIAEntity.getTableTitles(), MIAEntity.class);
                deleteDialog.setVisible(true);
                selectEntity(MIAEntity.class);
            }
        });
        JMenuItem DPracticeMenu = new JMenuItem("Practice");
        DPracticeMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuDELETE.add(DPracticeMenu);
        DPracticeMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteDialog deleteDialog = new DeleteDialog("Practice","Delete Practice", PracticeEntity.getTableTitlesForDelete(), PracticeEntity.class);
                deleteDialog.setVisible(true);
                selectEntity(PracticeEntity.class);
            }
        });
        JMenuItem DTestMenu = new JMenuItem("Test");
        DTestMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuDELETE.add(DTestMenu);
        DTestMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteDialog deleteDialog = new DeleteDialog("Test","Delete Test", TestEntity.getTableTitlesForDelete(), TestEntity.class);
                deleteDialog.setVisible(true);
                selectEntity(TestEntity.class);
            }
        });

        //UPDATE
        JMenu MenuUPDATE = new JMenu("Update");//Select
        MenuUPDATE.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menuBar.add(MenuUPDATE);

        JMenuItem UAutoCoursesMenu = new JMenuItem("AutoCourses");
        UAutoCoursesMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuUPDATE.add(UAutoCoursesMenu);
        UAutoCoursesMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//сопчатку потрібно зобразити таблицю, яку хочему змінити і виділити потрібний рядок
                List<String> data=getRowData();//отримуємо інформацію рядка для зміни
                if(data==null){//якщо не вибрали рядок для зміни
                    JOptionPane.showMessageDialog(getContentPane(), "No rows are selected", "Failing", JOptionPane.PLAIN_MESSAGE);
                }else{
                    AutoCoursesGUI dialog = new AutoCoursesGUI("Update", data);
                    dialog.setVisible(true);
                    selectEntity(AutoCoursesEntity.class);
//                    JOptionPane.showMessageDialog(getContentPane(), "Row is updated", "Success", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        JMenuItem UCertificateMenu = new JMenuItem("Certificate");
        UCertificateMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuUPDATE.add(UCertificateMenu);
        UCertificateMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> data=getRowData();//отримуємо інформацію рядка для зміни
                if(data==null){//якщо не вибрали рядок для зміни
                    JOptionPane.showMessageDialog(getContentPane(), "No rows are selected", "Failing", JOptionPane.PLAIN_MESSAGE);
                }else{
                    CertificateGUI dialog = new CertificateGUI("Update", data);
                    dialog.setVisible(true);
                    selectEntity(CertificateEntity.class);
//                    JOptionPane.showMessageDialog(getContentPane(), "Row is updated", "Success", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        JMenuItem UDriverMenu = new JMenuItem("Driver");
        UDriverMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuUPDATE.add(UDriverMenu);
        UDriverMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> data=getRowData();//отримуємо інформацію рядка для зміни
                if(data==null){//якщо не вибрали рядок для зміни
                    JOptionPane.showMessageDialog(getContentPane(), "No rows are selected", "Failing", JOptionPane.PLAIN_MESSAGE);
                }else{
                    DriverGUI dialog = new DriverGUI("Update", data);
                    dialog.setVisible(true);
                    selectEntity(DriverEntity.class);
//                    JOptionPane.showMessageDialog(getContentPane(), "Row is updated", "Success", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        JMenuItem UExaminationMenu = new JMenuItem("Examination");
        UExaminationMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuUPDATE.add(UExaminationMenu);
        UExaminationMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> data=getRowData();//отримуємо інформацію рядка для зміни
                if(data==null){//якщо не вибрали рядок для зміни
                    JOptionPane.showMessageDialog(getContentPane(), "No rows are selected", "Failing", JOptionPane.PLAIN_MESSAGE);
                }else{
                    ExaminationGUI dialog = new ExaminationGUI("Update", data);
                    dialog.setVisible(true);
                    selectEntity(ExaminationEntity.class);
//                    JOptionPane.showMessageDialog(getContentPane(), "Row is updated", "Success", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        JMenuItem UMIAMenu = new JMenuItem("MIA");
        UMIAMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuUPDATE.add(UMIAMenu);
        UMIAMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> data=getRowData();//отримуємо інформацію рядка для зміни
                if(data==null){//якщо не вибрали рядок для зміни
                    JOptionPane.showMessageDialog(getContentPane(), "No rows are selected", "Failing", JOptionPane.PLAIN_MESSAGE);
                }else{
                    MIAGUI dialog = new MIAGUI("Update", data);
                    dialog.setVisible(true);
                    selectEntity(MIAEntity.class);
//                    JOptionPane.showMessageDialog(getContentPane(), "Row is updated", "Success", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        JMenuItem UPracticeMenu = new JMenuItem("Practice");
        UPracticeMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuUPDATE.add(UPracticeMenu);
        UPracticeMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> data=getRowData();//отримуємо інформацію рядка для зміни
                if(data==null){//якщо не вибрали рядок для зміни
                    JOptionPane.showMessageDialog(getContentPane(), "No rows are selected", "Failing", JOptionPane.PLAIN_MESSAGE);
                }else{
                    PracticeGUI dialog = new PracticeGUI("Update", data);
                    dialog.setVisible(true);
                    selectEntity(PracticeEntity.class);
//                    JOptionPane.showMessageDialog(getContentPane(), "Row is updated", "Success", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        JMenuItem UTestMenu = new JMenuItem("Test");
        UTestMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MenuUPDATE.add(UTestMenu);
        UTestMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> data=getRowData();//отримуємо інформацію рядка для зміни
                if(data==null){//якщо не вибрали рядок для зміни
                    JOptionPane.showMessageDialog(getContentPane(), "No rows are selected", "Failing", JOptionPane.PLAIN_MESSAGE);
                }else{
                    TestGUI dialog = new TestGUI("Update", data);
                    dialog.setVisible(true);
                    selectEntity(TestEntity.class);
//                    JOptionPane.showMessageDialog(getContentPane(), "Row is updated", "Success", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

    }

    private List<String> getRowData() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        int columnCount=model.getColumnCount();
        List<String> data=new ArrayList();
        if(table1.getSelectedRow()==-1){//якщо не вибрали рядок
            return null;
        }
        else{
            for(int i=0;i<columnCount;i++){
                data.add((String)table1.getValueAt(table1.getSelectedRow(),i));//в data записуємо елементи виділеного нами рядка
            }
            return data;
        }
    }

    public boolean selectEntity(Class<?> cl){
        factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        String objc = cl.getSimpleName();
        setTitle(cl.getSimpleName());
//        EntityTransaction tx = manager.getTransaction();
//        tx.begin();//навіщо цей EntityTransaction взагалі потрібен
        List<Object> list = manager.createQuery("FROM "+objc).getResultList();
//        Query query = manager.createQuery("FROM "+objc);//створюємо запит на отримання всіх елементів з переданої таблиці (cl)
//        List list = (List) query.getResultList();//list зберігає всі значення таблиці cl (список всіх її об'єктів)
        if(list==null){//перевірка на пустоту
            System.out.println("No result");
        }
        else {
            try {
                Method columname = cl.getMethod("getTableTitles");
                Method elements = cl.getMethod("getSelected", Object.class);
                Object[] columnames = (Object[]) columname.invoke(this);//this-cl
                DefaultTableModel model = new DefaultTableModel(columnames, 0);
                Object[] row;
                for (Object obj : list) {
                    row = (Object[]) elements.invoke(this, obj);
                    model.addRow(row);
                }
                table1.setModel(model);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
//            tx.commit();
            manager.close();
        }
        return true;
    }
}

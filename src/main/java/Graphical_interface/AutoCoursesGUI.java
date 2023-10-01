package Graphical_interface;

import entity.AutoCoursesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AutoCoursesGUI extends CategoriesGUI{


    private JTextField institutionCode;
    private JPanel MainAC;
    private JTextField coursesName;
    private JTextField address;
    private JTextField teacherFullName;
    public JButton ok=new JButton("Ok");


    public AutoCoursesGUI(String action, List<String> oldData){
        setTitle("AutoCourse");
        if(action.equals("Update")){//при апдейті
            institutionCode.setText(oldData.get(0));//в поле ID виводимо ID та
            institutionCode.setEditable(false);//робимо його неможливим для зміни
        }
//        getContentPane().setLayout(new FlowLayout());//Створюємо Layout для того, щоб там розташувати JPanel MainAC з усіма його елементами
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));//Але чому ми не можемо в старий Layout помістити? як це працює???
        add(MainAC,getContentPane());
        add(ok,getContentPane());
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
                EntityManager manager = factory.createEntityManager();
                try {
                    List<Object> data = new ArrayList<>();
//                    data.add(Integer.parseInt(institutionCode.getText()));
                    data.add(institutionCode.getText());
                    if(A1true.isSelected()==true)
                        data.add(Boolean.parseBoolean(A1true.getText()));
                    else {data.add(Boolean.parseBoolean(A1false.getText()));}
                    if(Atrue.isSelected()==true)
                        data.add(Boolean.parseBoolean(Atrue.getText()));
                    else {data.add(Boolean.parseBoolean(Afalse.getText()));}
                    if(B1true.isSelected()==true)
                        data.add(Boolean.parseBoolean(B1true.getText()));
                    else {data.add(Boolean.parseBoolean(B1false.getText()));}
                    if(Btrue.isSelected()==true)
                        data.add(Boolean.parseBoolean(Btrue.getText()));
                    else {data.add(Boolean.parseBoolean(Bfalse.getText()));}
                    if(C1true.isSelected()==true)
                        data.add(Boolean.parseBoolean(C1true.getText()));
                    else {data.add(Boolean.parseBoolean(C1false.getText()));}
                    if(Ctrue.isSelected()==true)
                        data.add(Boolean.parseBoolean(Ctrue.getText()));
                    else {data.add(Boolean.parseBoolean(Cfalse.getText()));}
                    if(D1true.isSelected()==true)
                        data.add(Boolean.parseBoolean(D1true.getText()));
                    else {data.add(Boolean.parseBoolean(D1false.getText()));}
                    if(Dtrue.isSelected()==true)
                        data.add(Boolean.parseBoolean(Dtrue.getText()));
                    else {data.add(Boolean.parseBoolean(Dfalse.getText()));}
                    if(C1Etrue.isSelected()==true)
                        data.add(Boolean.parseBoolean(C1Etrue.getText()));
                    else {data.add(Boolean.parseBoolean(C1Efalse.getText()));}
                    if(BEtrue.isSelected()==true)
                        data.add(Boolean.parseBoolean(BEtrue.getText()));
                    else {data.add(Boolean.parseBoolean(BEfalse.getText()));}
                    if(CEtrue.isSelected()==true)
                        data.add(Boolean.parseBoolean(CEtrue.getText()));
                    else {data.add(Boolean.parseBoolean(CEfalse.getText()));}
                    if(D1Etrue.isSelected()==true)
                        data.add(Boolean.parseBoolean(D1Etrue.getText()));
                    else {data.add(Boolean.parseBoolean(D1Efalse.getText()));}
                    if(DEtrue.isSelected()==true)
                        data.add(Boolean.parseBoolean(DEtrue.getText()));
                    else {data.add(Boolean.parseBoolean(DEfalse.getText()));}
                    if(T1true.isSelected()==true)
                        data.add(Boolean.parseBoolean(T1true.getText()));
                    else {data.add(Boolean.parseBoolean(T1false.getText()));}
                    if(T2true.isSelected()==true)
                        data.add(Boolean.parseBoolean(T2true.getText()));
                    else {data.add(Boolean.parseBoolean(T2false.getText()));}
                    data.add(coursesName.getText());
                    data.add(address.getText());
                    data.add(teacherFullName.getText());
                    //Щоб перевірити, ми робимо видалення чи оновлення можна в конструктор передавати поле "Insert" чи "Update"
                    // і потім це поле через equel перевіряти, чи потрібно викликати пеіні функції
                    if(action.equals("Update")) {
                        AutoCoursesEntity course = manager.find(AutoCoursesEntity.class, oldData.get(0));//знаходимо потрібний курс по institutionCode
                        course.setInstitutionCode((String) data.get(0));//якщо змінювати ID, то виникає помилка
                        course.setCategoryA1((Boolean) data.get(1));
                        course.setCategoryA((Boolean) data.get(2));
                        course.setCategoryB1((Boolean) data.get(3));
                        course.setCategoryB((Boolean) data.get(4));
                        course.setCategoryC1((Boolean) data.get(5));
                        course.setCategoryC((Boolean) data.get(6));
                        course.setCategoryD1((Boolean) data.get(7));
                        course.setCategoryD((Boolean) data.get(8));
                        course.setCategoryC1E((Boolean) data.get(9));
                        course.setCategoryBe((Boolean) data.get(10));
                        course.setCategoryCe((Boolean) data.get(11));
                        course.setCategoryD1E((Boolean) data.get(12));
                        course.setCategoryDe((Boolean) data.get(13));
                        course.setCategoryT1((Boolean) data.get(14));
                        course.setCategoryT2((Boolean) data.get(15));
                        course.setCoursesName((String) data.get(16));
                        course.setAddress((String) data.get(17));
                        course.setTeacherFullName((String) data.get(18));
                        manager.getTransaction().begin();
                        manager.merge(course);//оновляємо дані
                        manager.getTransaction().commit();
                    }
                    else{//при доданні
                        AutoCoursesEntity course = new AutoCoursesEntity();//знаходимо потрібний курс по institutionCode
                        course.setInstitutionCode((String) data.get(0));//якщо змінювати ID, то виникає помилка
                        course.setCategoryA1((Boolean) data.get(1));
                        course.setCategoryA((Boolean) data.get(2));
                        course.setCategoryB1((Boolean) data.get(3));
                        course.setCategoryB((Boolean) data.get(4));
                        course.setCategoryC1((Boolean) data.get(5));
                        course.setCategoryC((Boolean) data.get(6));
                        course.setCategoryD1((Boolean) data.get(7));
                        course.setCategoryD((Boolean) data.get(8));
                        course.setCategoryC1E((Boolean) data.get(9));
                        course.setCategoryBe((Boolean) data.get(10));
                        course.setCategoryCe((Boolean) data.get(11));
                        course.setCategoryD1E((Boolean) data.get(12));
                        course.setCategoryDe((Boolean) data.get(13));
                        course.setCategoryT1((Boolean) data.get(14));
                        course.setCategoryT2((Boolean) data.get(15));
                        course.setCoursesName((String) data.get(16));
                        course.setAddress((String) data.get(17));
                        course.setTeacherFullName((String) data.get(18));
                        manager.getTransaction().begin();
                        manager.merge(course);//оновляємо дані
                        manager.getTransaction().commit();
                    }
                }catch(Exception e1){
                    JOptionPane.showMessageDialog(getContentPane(), "Failing", "Update", JOptionPane.PLAIN_MESSAGE);
                }
                factory.close();//dispose()-те саме
            }
        });
    }

//    public static void main(String[] args) {
//        AutoCoursesGUI testing = new AutoCoursesGUI();
//        testing.setVisible(true);
//    }
}

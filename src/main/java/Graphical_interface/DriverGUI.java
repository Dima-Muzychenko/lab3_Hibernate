package Graphical_interface;

import entity.DriverEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DriverGUI extends CategoriesGUI{
    private JPanel MainDriver;
    private JTextField full_name;
    private JTextField passport_id;
    private JTextField birthday;
    public JButton ok=new JButton("Ok");

    public DriverGUI(String action, List<String> oldData){
        setTitle("Driver");
        if(action.equals("Update")){
            passport_id.setText(oldData.get(17));
            passport_id.setEditable(false);
        }
//        getContentPane().setLayout(new FlowLayout());//Створюємо Layout для того, щоб там розташувати JPanel MainAC з усіма його елементами
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));//Але чому ми не можемо в старий Layout помістити? як це працює???
        add(MainDriver,getContentPane());
        add(ok,getContentPane());
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
                EntityManager manager = factory.createEntityManager();
                try {
                    List<Object> data = new ArrayList<>();
//                    data.add(Integer.parseInt(institutionCode.getText()));
                    data.add(full_name.getText());
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
                    data.add(birthday.getText());
                    data.add(passport_id.getText());
                    //Щоб перевірити, ми робимо видалення чи оновлення можна в конструктор передавати поле "Insert" чи "Update"
                    // і потім це поле через equel перевіряти, чи потрібно викликати пеіні функції
                    if(action.equals("Update")) {
                        DriverEntity course = manager.find(DriverEntity.class, oldData.get(17));//знаходимо потрібний курс по institutionCode
                        course.setFullName((String) data.get(0));//якщо змінювати ID, то виникає помилка
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
                        Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(data.get(16)));
                        course.setBirthdayDate(dob);
                        manager.getTransaction().begin();
                        manager.merge(course);//оновляємо дані
                        manager.getTransaction().commit();
                    }else{
                        DriverEntity course = new DriverEntity();
                        course.setFullName((String) data.get(0));//якщо змінювати ID, то виникає помилка
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
                        Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(data.get(16)));
                        course.setBirthdayDate(dob);
                        course.setPasportId((String) data.get(17));
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
//        DriverGUI testing = new DriverGUI();
//        testing.setVisible(true);
//    }
}

package Graphical_interface;

import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ExaminationGUI extends JDialog{
    private JPanel MainExamination;
    private JTextField examination_id;
    private JTextField pasport_id;
    private JTextField mia_id;
    private JTextField category;
    private JButton ok;


    public ExaminationGUI(String action, List<String> oldData){
        setContentPane(MainExamination);
        setModal(true);
        if(action.equals("Update")){
            examination_id.setEditable(false);
            examination_id.setText(oldData.get(0));
        }
        setSize(500,220);
        setTitle("Examination");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
                EntityManager manager = factory.createEntityManager();
                try {
                    List<Object> data = new ArrayList<>();
                    data.add(examination_id.getText());
                    data.add(pasport_id.getText());
                    data.add(mia_id.getText());
                    data.add(category.getText());
                    //Щоб перевірити, ми робимо видалення чи оновлення можна в конструктор передавати поле "Insert" чи "Update"
                    // і потім це поле через equel перевіряти, чи потрібно викликати пеіні функції
                    if(action.equals("Update")) {
                        ExaminationEntity exam = manager.find(ExaminationEntity.class, oldData.get(0));//знаходимо потрібний курс по institutionCode
                        DriverEntity driver = manager.find(DriverEntity.class, data.get(1));//шукаємо водія за зміненою нами адресою
                        exam.setDriverByPasportId(driver);
                        MIAEntity mia = manager.find(MIAEntity.class, data.get(2));
                        exam.setMiaByMinistryOfInternalAffairsId(mia);
                        exam.setCategoryA1(false);//ставимо спочатку всі категорії не зданими
                        exam.setCategoryA(false);//а потім виберемо 1 здану
                        exam.setCategoryB1(false);
                        exam.setCategoryB(false);
                        exam.setCategoryC1(false);
                        exam.setCategoryC(false);
                        exam.setCategoryD1(false);
                        exam.setCategoryD(false);
                        exam.setCategoryC1E(false);
                        exam.setCategoryBe(false);
                        exam.setCategoryCe(false);
                        exam.setCategoryD1E(false);
                        exam.setCategoryDe(false);
                        exam.setCategoryT1(false);
                        exam.setCategoryT2(false);
                        exam.setPassedCategory((String) data.get(3));
                        if (category.getText().equals("A1")) {
                            exam.setCategoryA1(true);
                        } else if (category.getText().equals("A")) {
                            exam.setCategoryA(true);
                        } else if (category.getText().equals("B1")) {
                            exam.setCategoryB1(true);
                        } else if (category.getText().equals("B")) {
                            exam.setCategoryB(true);
                        } else if (category.getText().equals("C1")) {
                            exam.setCategoryC1(true);
                        } else if (category.getText().equals("C")) {
                            exam.setCategoryC(true);
                        } else if (category.getText().equals("D1")) {
                            exam.setCategoryD1(true);
                        } else if (category.getText().equals("D")) {
                            exam.setCategoryD(true);
                        } else if (category.getText().equals("C1E")) {
                            exam.setCategoryC1E(true);
                        } else if (category.getText().equals("DE")) {
                            exam.setCategoryDe(true);
                        } else if (category.getText().equals("CE")) {
                            exam.setCategoryCe(true);
                        } else if (category.getText().equals("D1E")) {
                            exam.setCategoryD1E(true);
                        } else if (category.getText().equals("DE")) {
                            exam.setCategoryDe(true);
                        } else if (category.getText().equals("T1")) {
                            exam.setCategoryT1(true);
                        } else if (category.getText().equals("T2")) {
                            exam.setCategoryT2(true);
                        } else {
                            JOptionPane.showMessageDialog(getContentPane(), "Failing. Wrong category", "Update", JOptionPane.PLAIN_MESSAGE);
                        }

                        manager.getTransaction().begin();
                        manager.merge(exam);//оновляємо дані
                        manager.getTransaction().commit();
                    }else{
                        ExaminationEntity exam = new ExaminationEntity();//знаходимо потрібний курс по institutionCode
                        DriverEntity driver = manager.find(DriverEntity.class, data.get(1));//шукаємо водія за зміненою нами адресою
                        exam.setDriverByPasportId(driver);
                        MIAEntity mia = manager.find(MIAEntity.class, data.get(2));
                        exam.setMiaByMinistryOfInternalAffairsId(mia);
                        exam.setCategoryA1(false);//ставимо спочатку всі категорії не зданими
                        exam.setCategoryA(false);//а потім виберемо 1 здану
                        exam.setCategoryB1(false);
                        exam.setCategoryB(false);
                        exam.setCategoryC1(false);
                        exam.setCategoryC(false);
                        exam.setCategoryD1(false);
                        exam.setCategoryD(false);
                        exam.setCategoryC1E(false);
                        exam.setCategoryBe(false);
                        exam.setCategoryCe(false);
                        exam.setCategoryD1E(false);
                        exam.setCategoryDe(false);
                        exam.setCategoryT1(false);
                        exam.setCategoryT2(false);
                        exam.setPassedCategory((String) data.get(3));
                        if (category.getText().equals("A1")) {
                            exam.setCategoryA1(true);
                        } else if (category.getText().equals("A")) {
                            exam.setCategoryA(true);
                        } else if (category.getText().equals("B1")) {
                            exam.setCategoryB1(true);
                        } else if (category.getText().equals("B")) {
                            exam.setCategoryB(true);
                        } else if (category.getText().equals("C1")) {
                            exam.setCategoryC1(true);
                        } else if (category.getText().equals("C")) {
                            exam.setCategoryC(true);
                        } else if (category.getText().equals("D1")) {
                            exam.setCategoryD1(true);
                        } else if (category.getText().equals("D")) {
                            exam.setCategoryD(true);
                        } else if (category.getText().equals("C1E")) {
                            exam.setCategoryC1E(true);
                        } else if (category.getText().equals("DE")) {
                            exam.setCategoryDe(true);
                        } else if (category.getText().equals("CE")) {
                            exam.setCategoryCe(true);
                        } else if (category.getText().equals("D1E")) {
                            exam.setCategoryD1E(true);
                        } else if (category.getText().equals("DE")) {
                            exam.setCategoryDe(true);
                        } else if (category.getText().equals("T1")) {
                            exam.setCategoryT1(true);
                        } else if (category.getText().equals("T2")) {
                            exam.setCategoryT2(true);
                        } else {
                            JOptionPane.showMessageDialog(getContentPane(), "Failing. Wrong category", "Update", JOptionPane.PLAIN_MESSAGE);
                        }
                        exam.setExaminationId(examination_id.getText());
                        manager.getTransaction().begin();
                        manager.merge(exam);//оновляємо дані
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
//        ExaminationGUI testing = new ExaminationGUI();
//        testing.setVisible(true);
//    }
}

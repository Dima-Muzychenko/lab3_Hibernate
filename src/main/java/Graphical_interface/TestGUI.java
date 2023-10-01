package Graphical_interface;

import entity.ExaminationEntity;
import entity.TestEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TestGUI extends JDialog{
    private JPanel MainTest;
    private JTextField examination_id;
    private JRadioButton passedRadioButton;
    private JRadioButton unpassedRadioButton;
    private JTextField used_attempts;
    private JButton ok;

    public TestGUI(String action, List<String> oldData){
        setContentPane(MainTest);
        setTitle("Test");
        setModal(true);
        setSize(400,200);

        unpassedRadioButton.setSelected(true);
        passedRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passedRadioButton.setSelected(true);
                unpassedRadioButton.setSelected(false);
            }
        });
        unpassedRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passedRadioButton.setSelected(false);
                unpassedRadioButton.setSelected(true);
            }
        });

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
                EntityManager manager = factory.createEntityManager();
                try {
                    List<Object> data = new ArrayList<>();
                    data.add(examination_id.getText());
                    if(passedRadioButton.isSelected()==true)
                        data.add(true);
                    else {data.add(false);}
                    data.add(Integer.valueOf(used_attempts.getText()));
                    if(action.equals("Update")) {
                        TestEntity practice = manager.find(TestEntity.class, Integer.valueOf(oldData.get(4)));
                        ExaminationEntity exam = manager.find(ExaminationEntity.class, data.get(0));
                        practice.setExaminationByExaminationId(exam);
                        practice.setPassedUnpassed((Boolean) data.get(1));
                        practice.setUsedAttempts((Integer) data.get(2));
                        practice.setDate();
                        manager.getTransaction().begin();
                        manager.merge(practice);//оновляємо дані
                        manager.getTransaction().commit();
                    }else{
                        TestEntity practice = new TestEntity();
                        ExaminationEntity exam = manager.find(ExaminationEntity.class, data.get(0));
                        practice.setExaminationByExaminationId(exam);
                        practice.setPassedUnpassed((Boolean) data.get(1));
                        practice.setUsedAttempts((Integer) data.get(2));
                        practice.setDate();
                        manager.getTransaction().begin();
                        manager.merge(practice);//оновляємо дані
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
//        TestGUI test = new TestGUI();
//        test.setVisible(true);
//    }
}

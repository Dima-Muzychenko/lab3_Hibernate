package Graphical_interface;

import entity.ExaminationEntity;
import entity.PracticeEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PracticeGUI extends JDialog{
    private JPanel MaimPractice;
    private JTextField examination_id;
    private JRadioButton passedRadioButton;
    private JRadioButton unpassedRadioButton;
    private JTextField left_attempts;
    private JTextField uset_attempts;
    private JButton ok;

    public PracticeGUI(String action, List<String> oldData){
        setContentPane(MaimPractice);
        setTitle("Practice");
        setModal(true);
        setSize(400,205);
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
                    data.add(Integer.valueOf(left_attempts.getText()));
                    data.add(Integer.valueOf(uset_attempts.getText()));
                    if(action.equals("Update")) {
                        PracticeEntity practice = manager.find(PracticeEntity.class, Integer.valueOf(oldData.get(5)));
                        ExaminationEntity exam = manager.find(ExaminationEntity.class, data.get(0));
                        practice.setExaminationByExaminationId(exam);
                        practice.setPassedUnpassed((Boolean) data.get(1));
                        practice.setLeftAttempts((Integer) data.get(2));
                        practice.setUsedAttempts((Integer) data.get(3));
                        practice.setDate();
                        manager.getTransaction().begin();
                        manager.merge(practice);//оновляємо дані
                        manager.getTransaction().commit();
                    }else{
                        PracticeEntity practice =new PracticeEntity();
                        ExaminationEntity exam = manager.find(ExaminationEntity.class, data.get(0));
                        practice.setExaminationByExaminationId(exam);
                        practice.setPassedUnpassed((Boolean) data.get(1));
                        practice.setLeftAttempts((Integer) data.get(2));
                        practice.setUsedAttempts((Integer) data.get(3));
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
//        PracticeGUI test = new PracticeGUI();
//        test.setVisible(true);
//
//    }
}

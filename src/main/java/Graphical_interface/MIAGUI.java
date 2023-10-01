package Graphical_interface;

import entity.MIAEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MIAGUI extends JDialog{
    private JPanel MainMIA;
    private JTextField mia_id;
    private JTextField address;
    private JButton ok;

    public MIAGUI(String action, List<String> oldData){
        setContentPane(MainMIA);
        setModal(true);
        setSize(500,150);
        setTitle("MIA");
        if(action.equals("Update")){
            mia_id.setText(oldData.get(0));
            mia_id.setEditable(false);
        }
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
                EntityManager manager = factory.createEntityManager();
                try {
                    List<Object> data = new ArrayList<>();
                    data.add(mia_id.getText());
                    data.add(address.getText());
                    if(action.equals("Update")) {
                        MIAEntity Mia = manager.find(MIAEntity.class, oldData.get(0));//знаходимо потрібний курс по institutionCode
                        Mia.setAddress((String) data.get(1));
                        manager.getTransaction().begin();
                        manager.merge(Mia);//оновляємо дані
                        manager.getTransaction().commit();
                    }else{
                        MIAEntity Mia = new MIAEntity();
                        Mia.setAddress((String) data.get(1));
                        Mia.setMiaId((String) data.get(0));
                        manager.getTransaction().begin();
                        manager.merge(Mia);//оновляємо дані
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
//        MIAGUI testing = new MIAGUI();
//        testing.setVisible(true);
//    }
}

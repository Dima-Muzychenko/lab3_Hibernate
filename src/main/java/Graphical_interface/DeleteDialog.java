package Graphical_interface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DeleteDialog extends JDialog{
    private JPanel MainDelete;
    private JComboBox comboBox;
    private JTextField textField1;
    private JButton Okbutton;

    public DeleteDialog(String tablename, String title, Object[] data, Class<?> clas){
        setContentPane(MainDelete);
        setModal(true);
        setSize(500,120);
        setTitle(title);
        String classname = clas.getSimpleName();//ім'я класу

        for(Object row: data){
            comboBox.addItem(row);
        }
        Okbutton.addActionListener(new ActionListener() {//не працює
            @Override
            public void actionPerformed(ActionEvent e) {
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
                EntityManager manager = factory.createEntityManager();
                manager.getTransaction().begin();
                String selectedfield = (String)comboBox.getSelectedItem();
                String value = textField1.getText();
                List<Object> list = manager.createQuery("SELECT e FROM "+classname+" e WHERE e."+selectedfield+" = '"+value+"'").getResultList();
                if(list==null){
                    System.out.println("No elements to delete");
                }
                else{
                    System.out.println("Results:");
                    System.out.println(list);
                    for(Object obj:list) {
                        manager.remove(obj);
                    }
                }
                manager.getTransaction().commit();
                manager.close();

            }
        });



    }
}

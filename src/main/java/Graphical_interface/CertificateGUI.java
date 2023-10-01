package Graphical_interface;

import entity.AutoCoursesEntity;
import entity.CertificateEntity;
import entity.DriverEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CertificateGUI extends CategoriesGUI{
    private JPanel MainCertificate;
    private JTextField passport_id;
    private JTextField institution_id;
    public JButton ok=new JButton("Ok");

    public CertificateGUI(String action, List<String> oldData){
        setTitle("Certificate");
//        getContentPane().setLayout(new FlowLayout());//Створюємо Layout для того, щоб там розташувати JPanel MainAC з усіма його елементами
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));//Але чому ми не можемо в старий Layout помістити? як це працює???
        add(MainCertificate,getContentPane());
        add(ok,getContentPane());
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
                EntityManager manager = factory.createEntityManager();
                try {
                    List<Object> data = new ArrayList<>();
                    data.add(passport_id.getText());
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
                    data.add(institution_id.getText());
                    //Щоб перевірити, ми робимо видалення чи оновлення можна в конструктор передавати поле "Insert" чи "Update"
                    // і потім це поле через equel перевіряти, чи потрібно викликати пеіні функції
                    if(action.equals("Update")) {
                        CertificateEntity certificate = manager.find(CertificateEntity.class, Integer.valueOf(oldData.get(0)));//знаходимо потрібний курс по institutionCode
                        DriverEntity driver = manager.find(DriverEntity.class, data.get(0));//шукаємо водія за зміненою нами адресою
                        certificate.setDriverByPasportId(driver);//якщо змінювати ID, то виникає помилка
                        certificate.setCategoryA1((Boolean) data.get(1));
                        certificate.setCategoryA((Boolean) data.get(2));
                        certificate.setCategoryB1((Boolean) data.get(3));
                        certificate.setCategoryB((Boolean) data.get(4));
                        certificate.setCategoryC1((Boolean) data.get(5));
                        certificate.setCategoryC((Boolean) data.get(6));
                        certificate.setCategoryD1((Boolean) data.get(7));
                        certificate.setCategoryD((Boolean) data.get(8));
                        certificate.setCategoryC1E((Boolean) data.get(9));
                        certificate.setCategoryBe((Boolean) data.get(10));
                        certificate.setCategoryCe((Boolean) data.get(11));
                        certificate.setCategoryD1E((Boolean) data.get(12));
                        certificate.setCategoryDe((Boolean) data.get(13));
                        certificate.setCategoryT1((Boolean) data.get(14));
                        certificate.setCategoryT2((Boolean) data.get(15));
                        AutoCoursesEntity course = manager.find(AutoCoursesEntity.class, data.get(16));
                        certificate.setAutoCoursesByInstitutionId(course);
                        manager.getTransaction().begin();
                        manager.merge(certificate);//оновляємо дані
                        manager.getTransaction().commit();
                    }else {
                        CertificateEntity certificate = new CertificateEntity();
                        DriverEntity driver = manager.find(DriverEntity.class, data.get(0));//шукаємо водія за зміненою нами адресою
                        certificate.setDriverByPasportId(driver);//якщо змінювати ID, то виникає помилка
                        certificate.setCategoryA1((Boolean) data.get(1));
                        certificate.setCategoryA((Boolean) data.get(2));
                        certificate.setCategoryB1((Boolean) data.get(3));
                        certificate.setCategoryB((Boolean) data.get(4));
                        certificate.setCategoryC1((Boolean) data.get(5));
                        certificate.setCategoryC((Boolean) data.get(6));
                        certificate.setCategoryD1((Boolean) data.get(7));
                        certificate.setCategoryD((Boolean) data.get(8));
                        certificate.setCategoryC1E((Boolean) data.get(9));
                        certificate.setCategoryBe((Boolean) data.get(10));
                        certificate.setCategoryCe((Boolean) data.get(11));
                        certificate.setCategoryD1E((Boolean) data.get(12));
                        certificate.setCategoryDe((Boolean) data.get(13));
                        certificate.setCategoryT1((Boolean) data.get(14));
                        certificate.setCategoryT2((Boolean) data.get(15));
                        AutoCoursesEntity course = manager.find(AutoCoursesEntity.class, data.get(16));
                        certificate.setAutoCoursesByInstitutionId(course);
                        manager.getTransaction().begin();
                        manager.merge(certificate);//оновляємо дані
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
//        CertificateGUI testing = new CertificateGUI();
//        testing.setVisible(true);
//    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.GUI;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Formacion
 */
public class DatosAlumno extends javax.swing.JPanel {

    private static final long serialVersionUID = 4673890389548850367L;

    /**
     * Creates new form DatosAlumno
     */
    public DatosAlumno() {
        initComponents();
    }

    public JTextField getjTextFieldIdAlumno() {
        return jTextFieldIdAlumno;
    }

    public JTextField getjTextFieldNombre() {
        return jTextFieldNombre;
    }

    public JTextField getjTextFieldDNI() {
        return jTextFieldDNI;
    }

    public JTextField getjTextFieldAnnio() {
        return jTextFieldAnnio;
    }

    public JTextField getjTextFieldDia() {
        return jTextFieldDia;
    }

    public JTextField getjTextFieldMes() {
        return jTextFieldMes;
    }

    public JTextField getjTextFieldPrimerApellido() {
        return jTextFieldPrimerApellido;
    }

    public JTextField getjTextFieldSegundoApellido() {
        return jTextFieldSegundoApellido;
    }

    public JTextField getjTextFieldTelefono() {
        return jTextFieldTelefono;
    }

    public JComboBox getjComboBoxtipodeAlumno() {
        return jComboBoxtipodeAlumno;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDatosAlumno = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelPrimerApellido = new javax.swing.JLabel();
        jLabelSegundoApellido = new javax.swing.JLabel();
        jLabelDNI = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelFechaNac = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldPrimerApellido = new javax.swing.JTextField();
        jLabelIdAlumno = new javax.swing.JLabel();
        jTextFieldIdAlumno = new javax.swing.JTextField();
        jTextFieldSegundoApellido = new javax.swing.JTextField();
        jTextFieldDNI = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabelTipodeAlumno = new javax.swing.JLabel();
        jComboBoxtipodeAlumno = new javax.swing.JComboBox();
        jTextFieldDia = new javax.swing.JTextField();
        jLabelBarra = new javax.swing.JLabel();
        jTextFieldMes = new javax.swing.JTextField();
        jLabelBarra2 = new javax.swing.JLabel();
        jTextFieldAnnio = new javax.swing.JTextField();

        jPanelDatosAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Alumno"));

        jLabelNombre.setText("Nombre:");

        jLabelPrimerApellido.setText("Primer apellido:");

        jLabelSegundoApellido.setText("Segundo apellido:");

        jLabelDNI.setText("DNI:");

        jLabelTelefono.setText("Teléfono:");

        jLabelFechaNac.setText("Fecha de Nacimiento (dd/mm/aaaa):");

        jLabelIdAlumno.setText("Identificador de Alumno:");

        jTextFieldIdAlumno.setEditable(false);
        jTextFieldIdAlumno.setOpaque(false);

        jLabelTipodeAlumno.setText("Tipo de Alumno:");

        jComboBoxtipodeAlumno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Presencial", "A distancia" }));

        jLabelBarra.setText("/");

        jLabelBarra2.setText("/");

        javax.swing.GroupLayout jPanelDatosAlumnoLayout = new javax.swing.GroupLayout(jPanelDatosAlumno);
        jPanelDatosAlumno.setLayout(jPanelDatosAlumnoLayout);
        jPanelDatosAlumnoLayout.setHorizontalGroup(
            jPanelDatosAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosAlumnoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDatosAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTipodeAlumno)
                    .addComponent(jLabelIdAlumno)
                    .addComponent(jLabelTelefono)
                    .addComponent(jLabelDNI)
                    .addComponent(jLabelSegundoApellido)
                    .addComponent(jLabelNombre)
                    .addComponent(jLabelPrimerApellido)
                    .addComponent(jLabelFechaNac))
                .addGap(4, 4, 4)
                .addGroup(jPanelDatosAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxtipodeAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDatosAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addComponent(jTextFieldPrimerApellido)
                        .addComponent(jTextFieldIdAlumno)
                        .addComponent(jTextFieldSegundoApellido)
                        .addComponent(jTextFieldDNI)
                        .addComponent(jTextFieldTelefono))
                    .addGroup(jPanelDatosAlumnoLayout.createSequentialGroup()
                        .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelBarra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelBarra2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAnnio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        jPanelDatosAlumnoLayout.setVerticalGroup(
            jPanelDatosAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosAlumnoLayout.createSequentialGroup()
                .addGroup(jPanelDatosAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdAlumno)
                    .addComponent(jTextFieldIdAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrimerApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSegundoApellido)
                    .addComponent(jTextFieldSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDNI)
                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefono)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaNac)
                    .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBarra)
                    .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBarra2)
                    .addComponent(jTextFieldAnnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipodeAlumno)
                    .addComponent(jComboBoxtipodeAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDatosAlumno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDatosAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBoxtipodeAlumno;
    private javax.swing.JLabel jLabelBarra;
    private javax.swing.JLabel jLabelBarra2;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelFechaNac;
    private javax.swing.JLabel jLabelIdAlumno;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPrimerApellido;
    private javax.swing.JLabel jLabelSegundoApellido;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTipodeAlumno;
    private javax.swing.JPanel jPanelDatosAlumno;
    private javax.swing.JTextField jTextFieldAnnio;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldDia;
    private javax.swing.JTextField jTextFieldIdAlumno;
    private javax.swing.JTextField jTextFieldMes;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrimerApellido;
    private javax.swing.JTextField jTextFieldSegundoApellido;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables

}

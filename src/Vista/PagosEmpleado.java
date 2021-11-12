/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Facundo
 */
public class PagosEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form PagosEmpleado
     */
    public PagosEmpleado() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/iconFrame.png")).getImage());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //PARA CERRAR VENTANA Y NO TODA LA APLICACION
        setResizable(false);
        setTitle("REGISTRAR PAGOS");
        setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        checkLunes = new javax.swing.JCheckBox();
        checkMartes = new javax.swing.JCheckBox();
        checkMiercoles = new javax.swing.JCheckBox();
        checkJueves = new javax.swing.JCheckBox();
        checkViernes = new javax.swing.JCheckBox();
        checkSabado = new javax.swing.JCheckBox();
        checkPremio = new javax.swing.JCheckBox();
        txt1L = new javax.swing.JTextField();
        txt2L = new javax.swing.JTextField();
        txt3L = new javax.swing.JTextField();
        txt4L = new javax.swing.JTextField();
        txtLDes = new javax.swing.JTextField();
        txt1Ma = new javax.swing.JTextField();
        txt2Ma = new javax.swing.JTextField();
        txt4Ma = new javax.swing.JTextField();
        txt3Ma = new javax.swing.JTextField();
        txt1Mi = new javax.swing.JTextField();
        txtMaDes = new javax.swing.JTextField();
        txt2Mi = new javax.swing.JTextField();
        txt3Mi = new javax.swing.JTextField();
        txt4Mi = new javax.swing.JTextField();
        txtMiDes = new javax.swing.JTextField();
        txt1J = new javax.swing.JTextField();
        txt2J = new javax.swing.JTextField();
        txt3J = new javax.swing.JTextField();
        txt4J = new javax.swing.JTextField();
        txtJDes = new javax.swing.JTextField();
        txt1V = new javax.swing.JTextField();
        txt2V = new javax.swing.JTextField();
        txt3V = new javax.swing.JTextField();
        txt4V = new javax.swing.JTextField();
        txtVDes = new javax.swing.JTextField();
        txt1S = new javax.swing.JTextField();
        txt2S = new javax.swing.JTextField();
        txt3S = new javax.swing.JTextField();
        txt4S = new javax.swing.JTextField();
        txtSDes = new javax.swing.JTextField();
        txt1P = new javax.swing.JTextField();
        txt2P = new javax.swing.JTextField();
        txt3P = new javax.swing.JTextField();
        txt4P = new javax.swing.JTextField();
        txtPDes = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtTotal = new javax.swing.JTextField();
        btnVerTotal = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fechaTurno = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        checkLunes.setBackground(new java.awt.Color(153, 153, 153));
        checkLunes.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        checkLunes.setForeground(new java.awt.Color(0, 0, 0));
        checkLunes.setText("LUNES");
        checkLunes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        checkLunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkLunesActionPerformed(evt);
            }
        });

        checkMartes.setBackground(new java.awt.Color(153, 153, 153));
        checkMartes.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        checkMartes.setForeground(new java.awt.Color(0, 0, 0));
        checkMartes.setText("MARTES");

        checkMiercoles.setBackground(new java.awt.Color(153, 153, 153));
        checkMiercoles.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        checkMiercoles.setForeground(new java.awt.Color(0, 0, 0));
        checkMiercoles.setText("MIERCOLES");
        checkMiercoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMiercolesActionPerformed(evt);
            }
        });

        checkJueves.setBackground(new java.awt.Color(153, 153, 153));
        checkJueves.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        checkJueves.setForeground(new java.awt.Color(0, 0, 0));
        checkJueves.setText("JUEVES");

        checkViernes.setBackground(new java.awt.Color(153, 153, 153));
        checkViernes.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        checkViernes.setForeground(new java.awt.Color(0, 0, 0));
        checkViernes.setText("VIERNES");

        checkSabado.setBackground(new java.awt.Color(153, 153, 153));
        checkSabado.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        checkSabado.setForeground(new java.awt.Color(0, 0, 0));
        checkSabado.setText("SABADO");

        checkPremio.setBackground(new java.awt.Color(153, 153, 153));
        checkPremio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        checkPremio.setForeground(new java.awt.Color(0, 0, 0));
        checkPremio.setText("PREMIO");

        txt1L.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt1L.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1LKeyTyped(evt);
            }
        });

        txt2L.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt2L.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2LKeyTyped(evt);
            }
        });

        txt3L.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt3L.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3LKeyTyped(evt);
            }
        });

        txt4L.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt4L.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt4LKeyTyped(evt);
            }
        });

        txtLDes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtLDes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLDesKeyTyped(evt);
            }
        });

        txt1Ma.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt1Ma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1MaKeyTyped(evt);
            }
        });

        txt2Ma.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt2Ma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2MaKeyTyped(evt);
            }
        });

        txt4Ma.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt4Ma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt4MaKeyTyped(evt);
            }
        });

        txt3Ma.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt3Ma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3MaKeyTyped(evt);
            }
        });

        txt1Mi.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt1Mi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1MiKeyTyped(evt);
            }
        });

        txtMaDes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtMaDes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaDesKeyTyped(evt);
            }
        });

        txt2Mi.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt2Mi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2MiKeyTyped(evt);
            }
        });

        txt3Mi.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt3Mi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3MiKeyTyped(evt);
            }
        });

        txt4Mi.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt4Mi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt4MiKeyTyped(evt);
            }
        });

        txtMiDes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtMiDes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMiDesKeyTyped(evt);
            }
        });

        txt1J.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt1J.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1JKeyTyped(evt);
            }
        });

        txt2J.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt2J.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2JKeyTyped(evt);
            }
        });

        txt3J.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt3J.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3JKeyTyped(evt);
            }
        });

        txt4J.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt4J.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt4JKeyTyped(evt);
            }
        });

        txtJDes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtJDes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJDesKeyTyped(evt);
            }
        });

        txt1V.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt1V.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1VKeyTyped(evt);
            }
        });

        txt2V.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt2V.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2VKeyTyped(evt);
            }
        });

        txt3V.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt3V.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3VKeyTyped(evt);
            }
        });

        txt4V.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt4V.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt4VKeyTyped(evt);
            }
        });

        txtVDes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtVDes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVDesKeyTyped(evt);
            }
        });

        txt1S.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt1S.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1SKeyTyped(evt);
            }
        });

        txt2S.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt2S.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2SKeyTyped(evt);
            }
        });

        txt3S.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt3S.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3SKeyTyped(evt);
            }
        });

        txt4S.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt4S.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt4SKeyTyped(evt);
            }
        });

        txtSDes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtSDes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSDesKeyTyped(evt);
            }
        });

        txt1P.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt1P.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1PKeyTyped(evt);
            }
        });

        txt2P.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt2P.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2PKeyTyped(evt);
            }
        });

        txt3P.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt3P.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3PKeyTyped(evt);
            }
        });

        txt4P.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt4P.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt4PKeyTyped(evt);
            }
        });

        txtPDes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtPDes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPDesKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("DESCUENTOS");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dias.png"))); // NOI18N
        jLabel4.setText("SELECCIONE DIA");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_opt (1).png"))); // NOI18N
        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkMartes)
                            .addComponent(checkMiercoles)
                            .addComponent(checkJueves)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkViernes)
                                    .addComponent(checkSabado)
                                    .addComponent(checkPremio)))
                            .addComponent(checkLunes))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt1S, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt1P, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(171, 171, 171))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt1L, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt2L, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt3Mi, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt3Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt3L, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt4L, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt4Ma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt4Mi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(37, 37, 37)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMaDes, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtLDes, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtMiDes, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(85, 85, 85)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt3P, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt3S, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt4P, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt4S, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(37, 37, 37)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSDes, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPDes, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(56, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txt1V, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(171, 171, 171)
                                                .addComponent(txt3V, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txt3J, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt4V, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt4J, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(37, 37, 37)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtJDes, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtVDes, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txt2V, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txt1J, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txt2J, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txt1Mi, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txt2Mi, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txt1Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32)
                                                .addComponent(txt2Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(txt2S, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt2P, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(387, 387, 387))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(20, 20, 20))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt1J, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt2J, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt3J, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt4J, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJDes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkJueves))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVDes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt4V, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt3V, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt2V, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt1V, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkViernes))
                        .addGap(110, 110, 110)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt1P, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt2P, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt3P, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt4P, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPDes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkPremio))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txt2L, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt3L, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt4L, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtLDes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(checkLunes)
                                                .addGap(48, 48, 48)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(checkMartes)
                                                    .addComponent(txt1Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt2Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt4Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt3Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtMaDes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(38, 38, 38)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(checkMiercoles)
                                            .addComponent(txtMiDes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt4Mi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt3Mi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt2Mi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt1Mi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(128, 128, 128)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(checkSabado)
                                    .addComponent(txt1S, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt2S, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt3S, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt4S, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSDes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txt1L, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(122, 122, 122))))
        );

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setForeground(new java.awt.Color(153, 0, 0));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        btnVerTotal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnVerTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calcular.png"))); // NOI18N
        btnVerTotal.setText("VER TOTAL");

        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardarPago_1.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");

        btnModificar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1modificarPago.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerTotal)
                .addGap(39, 39, 39)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnGuardar)
                .addGap(66, 66, 66))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel3.setBackground(new java.awt.Color(153, 0, 0));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CARGAR PAGO");

        txtEmpleado.setBackground(new java.awt.Color(204, 204, 204));
        txtEmpleado.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtEmpleado.setForeground(new java.awt.Color(0, 0, 0));
        txtEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpleadoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fecha.png"))); // NOI18N
        jLabel3.setText("SELECCIONE FECHA");

        fechaTurno.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fechaTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmpleado)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(fechaTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpleadoActionPerformed

    private void checkLunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkLunesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkLunesActionPerformed

    private void checkMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMiercolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkMiercolesActionPerformed

    private void txt1LKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1LKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt1LKeyTyped

    private void txt2LKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2LKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt2LKeyTyped

    private void txt3LKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3LKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt3LKeyTyped

    private void txt4LKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4LKeyTyped
       soloNumeros(evt);
    }//GEN-LAST:event_txt4LKeyTyped

    private void txtLDesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLDesKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txtLDesKeyTyped

    private void txt1MaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1MaKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt1MaKeyTyped

    private void txt2MaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2MaKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt2MaKeyTyped

    private void txt3MaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3MaKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt3MaKeyTyped

    private void txt4MaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4MaKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt4MaKeyTyped

    private void txtMaDesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaDesKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txtMaDesKeyTyped

    private void txt1MiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1MiKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt1MiKeyTyped

    private void txt2MiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2MiKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt2MiKeyTyped

    private void txt3MiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3MiKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt3MiKeyTyped

    private void txt4MiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4MiKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt4MiKeyTyped

    private void txtMiDesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMiDesKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txtMiDesKeyTyped

    private void txt1JKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1JKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt1JKeyTyped

    private void txt2JKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2JKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt2JKeyTyped

    private void txt3JKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3JKeyTyped
        soloNumeros(evt);
        
    }//GEN-LAST:event_txt3JKeyTyped

    private void txt4JKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4JKeyTyped
        soloNumeros(evt);

    }//GEN-LAST:event_txt4JKeyTyped

    private void txtJDesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJDesKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txtJDesKeyTyped

    private void txt1VKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1VKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt1VKeyTyped

    private void txt2VKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2VKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt2VKeyTyped

    private void txt3VKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3VKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt3VKeyTyped

    private void txt4VKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4VKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt4VKeyTyped

    private void txtVDesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVDesKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txtVDesKeyTyped

    private void txt1SKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1SKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt1SKeyTyped

    private void txt2SKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2SKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt2SKeyTyped

    private void txt3SKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3SKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt3SKeyTyped

    private void txt4SKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4SKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt4SKeyTyped

    private void txtSDesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDesKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txtSDesKeyTyped

    private void txt1PKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1PKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt1PKeyTyped

    private void txt2PKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2PKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt2PKeyTyped

    private void txt3PKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3PKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt3PKeyTyped

    private void txt4PKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4PKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txt4PKeyTyped

    private void txtPDesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPDesKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txtPDesKeyTyped

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed
    
    public void soloNumeros(KeyEvent e){
        int key = e.getKeyChar();
        boolean numeros= key >=48 && key<=57;
        if(!numeros){
            e.consume();
        }
    }
    
    public static void main(String args[]) {
        

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new PagosEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnVerTotal;
    public javax.swing.JCheckBox checkJueves;
    public javax.swing.JCheckBox checkLunes;
    public javax.swing.JCheckBox checkMartes;
    public javax.swing.JCheckBox checkMiercoles;
    public javax.swing.JCheckBox checkPremio;
    public javax.swing.JCheckBox checkSabado;
    public javax.swing.JCheckBox checkViernes;
    public com.toedter.calendar.JDateChooser fechaTurno;
    public com.toedter.calendar.JCalendar jCalendar1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JTextField txt1J;
    public javax.swing.JTextField txt1L;
    public javax.swing.JTextField txt1Ma;
    public javax.swing.JTextField txt1Mi;
    public javax.swing.JTextField txt1P;
    public javax.swing.JTextField txt1S;
    public javax.swing.JTextField txt1V;
    public javax.swing.JTextField txt2J;
    public javax.swing.JTextField txt2L;
    public javax.swing.JTextField txt2Ma;
    public javax.swing.JTextField txt2Mi;
    public javax.swing.JTextField txt2P;
    public javax.swing.JTextField txt2S;
    public javax.swing.JTextField txt2V;
    public javax.swing.JTextField txt3J;
    public javax.swing.JTextField txt3L;
    public javax.swing.JTextField txt3Ma;
    public javax.swing.JTextField txt3Mi;
    public javax.swing.JTextField txt3P;
    public javax.swing.JTextField txt3S;
    public javax.swing.JTextField txt3V;
    public javax.swing.JTextField txt4J;
    public javax.swing.JTextField txt4L;
    public javax.swing.JTextField txt4Ma;
    public javax.swing.JTextField txt4Mi;
    public javax.swing.JTextField txt4P;
    public javax.swing.JTextField txt4S;
    public javax.swing.JTextField txt4V;
    public javax.swing.JTextField txtEmpleado;
    public javax.swing.JTextField txtJDes;
    public javax.swing.JTextField txtLDes;
    public javax.swing.JTextField txtMaDes;
    public javax.swing.JTextField txtMiDes;
    public javax.swing.JTextField txtPDes;
    public javax.swing.JTextField txtSDes;
    public javax.swing.JTextField txtTotal;
    public javax.swing.JTextField txtVDes;
    // End of variables declaration//GEN-END:variables
}

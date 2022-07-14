package vista;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import mvc.operaciones;

public class principal extends javax.swing.JFrame {

    /**
     * Creates new form principal
     */
    private static int tipo_usu = 0;
    private operaciones opc = new operaciones();
    String tipo = "Folio";
    private boolean status = false;
    private static int matricula = 0;

    public principal(int ad, int mat) {
        initComponents();
        tipo_usu = ad;
        matricula = mat;
        esperarCierre();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setIconImage(new ImageIcon(getClass().getResource("/imgs/icon1.png")).getImage());
        this.setTitle("SISTEMA DE BUSQUEDA Y REGISTRO DE LIBROS DEL ÁREA DE BIBLIOTECA DE LA UTCGG");
        foto();
        tabla_libros.setRowHeight(28);
        inicioSe(tipo_usu);
        size_cell();
    }

    public void foto() {
        ImageIcon img = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/imgs/img.png")));
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(log_ut.getWidth(), log_ut.getHeight(), Image.SCALE_DEFAULT));
        log_ut.setIcon(icono);
        ImageIcon a = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/imgs/abr.png")));
        Icon iconos = new ImageIcon(a.getImage().getScaledInstance(log_lib.getWidth(), log_lib.getHeight(), Image.SCALE_DEFAULT));
        log_lib.setIcon(iconos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        log_ut = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        log_lib = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txt_buscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        rad_folio = new javax.swing.JRadioButton();
        rad_titulo = new javax.swing.JRadioButton();
        rad_carrera = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        btn_verAlumnos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btn_verAlumnos1 = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_libros = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        item_nvousu = new javax.swing.JMenuItem();
        item_nvoal = new javax.swing.JMenuItem();
        item_nvoli = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(15, 120, 20));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BIBLIOTECA DE LA UNIVERSIDAD TECNOLÓGICA DE LA");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("COSTA GRANDE DE GUERRERO");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("\"Educación de excelencia con compromiso social\"");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(log_ut, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel3)))
                .addGap(90, 90, 90)
                .addComponent(log_lib, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(log_ut, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
            .addComponent(log_lib, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_buscar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(15, 120, 20));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/ver_registro.png"))); // NOI18N
        jButton1.setText("Ver registro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        grupo.add(rad_folio);
        rad_folio.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        rad_folio.setText("Folio");
        rad_folio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_folioActionPerformed(evt);
            }
        });

        grupo.add(rad_titulo);
        rad_titulo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        rad_titulo.setText("Título");
        rad_titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_tituloActionPerformed(evt);
            }
        });

        grupo.add(rad_carrera);
        rad_carrera.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        rad_carrera.setText("Carrera");
        rad_carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_carreraActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Buscar por:");

        btn_verAlumnos.setBackground(new java.awt.Color(15, 120, 20));
        btn_verAlumnos.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btn_verAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        btn_verAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/ver.png"))); // NOI18N
        btn_verAlumnos.setText("Ver alumnos");
        btn_verAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verAlumnosActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/buscar.png"))); // NOI18N

        btn_verAlumnos1.setBackground(new java.awt.Color(15, 120, 20));
        btn_verAlumnos1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btn_verAlumnos1.setForeground(new java.awt.Color(255, 255, 255));
        btn_verAlumnos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/actualizar.png"))); // NOI18N
        btn_verAlumnos1.setText("Refrescar");
        btn_verAlumnos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verAlumnos1ActionPerformed(evt);
            }
        });

        btn_buscar.setBackground(new java.awt.Color(15, 120, 20));
        btn_buscar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/internet.png"))); // NOI18N
        btn_buscar.setText("(BETA)Buscar en internet");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_folio)
                        .addGap(18, 18, 18)
                        .addComponent(rad_titulo)
                        .addGap(18, 18, 18)
                        .addComponent(rad_carrera)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_verAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_verAlumnos1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rad_folio)
                    .addComponent(rad_titulo)
                    .addComponent(rad_carrera)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(btn_verAlumnos)
                    .addComponent(jLabel5)
                    .addComponent(btn_verAlumnos1)
                    .addComponent(btn_buscar))
                .addContainerGap())
        );

        tabla_libros.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tabla_libros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_libros.setSelectionBackground(new java.awt.Color(0, 153, 51));
        jScrollPane1.setViewportView(tabla_libros);
        tabla_libros.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/menu.png"))); // NOI18N
        jMenu1.setText("Menú");
        jMenu1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jMenu1.setHideActionText(true);

        item_nvousu.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        item_nvousu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/agregar_usuario.png"))); // NOI18N
        item_nvousu.setText("Nuevo usuario");
        jMenu1.add(item_nvousu);

        item_nvoal.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        item_nvoal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/registrar_alumno.png"))); // NOI18N
        item_nvoal.setText("Registrar alumno");
        item_nvoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_nvoalActionPerformed(evt);
            }
        });
        jMenu1.add(item_nvoal);

        item_nvoli.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        item_nvoli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/agregar_libro.png"))); // NOI18N
        item_nvoli.setText("Registrar libro");
        item_nvoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_nvoliActionPerformed(evt);
            }
        });
        jMenu1.add(item_nvoli);

        jMenuItem3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/cerrar.png"))); // NOI18N
        jMenuItem3.setText("Cerrar sesión");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void item_nvoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_nvoliActionPerformed
        registrar rgr = new registrar(null, true);
        rgr.setVisible(true);
        boolean b = rgr.isShowing();
        while (b) {
            b = rgr.isShowing();
        }
        tabla_libros.setModel(opc.getRegistros());
        size_cell();
        rad_folio.setSelected(true);
        txt_buscar.setText("");


    }//GEN-LAST:event_item_nvoliActionPerformed

    private void rad_folioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_folioActionPerformed
        txt_buscar.setText("");
        tipo = "Folio";
        tabla_libros.setModel(opc.getRegistros());
        size_cell();
    }//GEN-LAST:event_rad_folioActionPerformed

    private void rad_tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_tituloActionPerformed
        if (tipo_usu == 1) {
            txt_buscar.setText("");
            tipo = "Titulo";
            tabla_libros.setModel(opc.getRegistros());
            size_cell();
        } else if (tipo_usu == 2) {
            tabla_libros.setModel(opc.librosAlumnos(matricula));
            size_cell();
            tipo = "Titulo";
        }
    }//GEN-LAST:event_rad_tituloActionPerformed

    private void rad_carreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_carreraActionPerformed
        if (tipo_usu == 1) {
            txt_buscar.setText("");
            tipo = "Carrera";
            tabla_libros.setModel(opc.getRegistros());
            size_cell();
        } else if (tipo_usu == 2) {
            tabla_libros.setModel(opc.librosAlumnos(matricula));
            size_cell();
        }
    }//GEN-LAST:event_rad_carreraActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        if (!txt_buscar.getText().trim().equals("")) {
            if (tipo_usu == 1) {
                System.out.println(tipo);
                tabla_libros.setModel(opc.buscar(tipo, txt_buscar.getText().trim()));
                size_cell();
            } else if (tipo_usu == 2) {
                tabla_libros.setModel(opc.buscarlumno(txt_buscar.getText().trim(), matricula));
                size_cell();
            }
        } else {
            if (tipo_usu == 1) {
                tabla_libros.setModel(opc.getRegistros());
                size_cell();
            } else if (tipo_usu == 2) {
                tabla_libros.setModel(opc.librosAlumnos(matricula));
                size_cell();
            }

        }
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        close();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        getFila();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void item_nvoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_nvoalActionPerformed
        new registrar_alumno(null, true, 0).setVisible(true);
    }//GEN-LAST:event_item_nvoalActionPerformed

    private void btn_verAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verAlumnosActionPerformed
        new vista_alumnos(null, true).setVisible(true);
    }//GEN-LAST:event_btn_verAlumnosActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed

    }//GEN-LAST:event_txt_buscarActionPerformed

    private void btn_verAlumnos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verAlumnos1ActionPerformed
        /**
         * *
         * metodo encargado de refrescar los registros de la tabla(refrescar)
         */
        if (tipo_usu == 1) {
            System.out.println(tipo);
            tabla_libros.setModel(opc.getRegistros());
            size_cell();
            txt_buscar.setText("");
            rad_folio.setSelected(true);
        } else if (tipo_usu == 2) {
            tabla_libros.setModel(opc.librosAlumnos(matricula));
            size_cell();
        }
    }//GEN-LAST:event_btn_verAlumnos1ActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        new busqueda_internet(null, true).setVisible(true);
    }//GEN-LAST:event_btn_buscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal(tipo_usu, matricula).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_verAlumnos;
    private javax.swing.JButton btn_verAlumnos1;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JMenuItem item_nvoal;
    private javax.swing.JMenuItem item_nvoli;
    private javax.swing.JMenuItem item_nvousu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel log_lib;
    private javax.swing.JLabel log_ut;
    private javax.swing.JRadioButton rad_carrera;
    private javax.swing.JRadioButton rad_folio;
    private javax.swing.JRadioButton rad_titulo;
    private javax.swing.JTable tabla_libros;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables

    private void size_cell() {
        TableColumn col1, col2, col3, col4, col5, col6;
        col1 = tabla_libros.getColumnModel().getColumn(0);
        col1.setMaxWidth(105);
        col2 = tabla_libros.getColumnModel().getColumn(1);
        col2.setMaxWidth(500);
        col3 = tabla_libros.getColumnModel().getColumn(2);
        col3.setMaxWidth(400);
        col4 = tabla_libros.getColumnModel().getColumn(3);
        col4.setMaxWidth(170);
        col5 = tabla_libros.getColumnModel().getColumn(4);
        col5.setMaxWidth(170);
        col6 = tabla_libros.getColumnModel().getColumn(5);
        col6.setMaxWidth(158);
    }

    private void inicioSe(int op) {
        if (op == 1) {
            item_nvousu.setEnabled(false);
            tabla_libros.setModel(opc.getRegistros());
            rad_folio.setSelected(true);
        } else if (op == 2) {
            tipo = "Titulo";
            item_nvoal.setVisible(false);
            item_nvoli.setVisible(false);
            item_nvousu.setVisible(false);
            rad_carrera.setVisible(false);
            btn_buscar.setVisible(false);
            rad_folio.setVisible(false);
            rad_titulo.setSelected(true);
            btn_verAlumnos.setVisible(false);
            tabla_libros.setModel(opc.librosAlumnos(matricula));
        }
    }

    /**
     * Metodo para ver los detalles del registro (ver registro)
     */
    private void getFila() {
        try {
            int fila = tabla_libros.getSelectedRow();
            String folio = String.valueOf(tabla_libros.getValueAt(fila, 0));
            System.out.println(folio);
            new ver_registros(null, true, folio, tipo_usu).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Es necesario seleccionar un registro de la tabla");
        }
    }

    /**
     *
     * esperarCierre() ---------Hilos de espera a cierre de
     * frame----------------------
     */
    private void esperarCierre() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
    }

    /**
     * su función es mostrar un mensaje de confirmacion de cierre de la vista .
     */
    private void close() {
        if (status != true) {
            int o = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea salir?");
            if (o == JOptionPane.OK_OPTION) {
                new login().setVisible(true);
                this.dispose();
                status = true;
            }
        }
    }
}

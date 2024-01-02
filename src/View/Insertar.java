/**
 * GESTION DE ARCHIVOS DE TEXTO PLANO CON JAVA
 * Github: ItsEddyGD666
 */
package View;

public class Insertar extends javax.swing.JFrame {
   
    public Insertar() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextCuenta = new RSMaterialComponent.RSTextFieldMaterial();
        jTextNombre = new RSMaterialComponent.RSTextFieldMaterial();
        jTextAP = new RSMaterialComponent.RSTextFieldMaterial();
        jTextAM = new RSMaterialComponent.RSTextFieldMaterial();
        jTextFecha = new RSMaterialComponent.RSTextFieldMaterial();
        jTextProm = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel3 = new javax.swing.JLabel();
        jComboLic = new RSMaterialComponent.RSComboBox();
        jComboSemestre = new RSMaterialComponent.RSComboBox();
        btnLimpiar = new rojerusan.RSMaterialButton();
        btnAgregar = new rojerusan.RSMaterialButton();
        btnRegresar = new rojerusan.RSMaterialButton();
        btnMostrar = new rojerusan.RSMaterialButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(153, 153, 255));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(204, 204, 204));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.CENTRAL);

        jLabel1.setFont(new java.awt.Font("Unispace", 0, 18)); // NOI18N
        jLabel1.setText("Insertar");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("*Ingrese todos los campos correspondientes");

        jTextCuenta.setPlaceholder("Numero de cuenta");

        jTextNombre.setPlaceholder("Nombre(s)");

        jTextAP.setPlaceholder("Apellido Paterno");

        jTextAM.setPlaceholder("Apellido Materno");

        jTextFecha.setPlaceholder("Fecha de Nacimiento dd/mm/aaaa");

        jTextProm.setPlaceholder("Promedio");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/file_user.png"))); // NOI18N

        jComboLic.setForeground(new java.awt.Color(0, 0, 0));
        jComboLic.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Licenciatura", "Ingeniería en Computacion", "Licenciatura en Administración", "Licenciatura en Contabilidad", "Licenciatura en Ciencias Politicas y Administración Publilca", "Licenciatura en Turismo", "Licenciatura en Informática Administrativa" }));
        jComboLic.setColorBorde(new java.awt.Color(37, 45, 223));
        jComboLic.setColorBoton(new java.awt.Color(204, 204, 204));
        jComboLic.setColorFondo(new java.awt.Color(255, 255, 255));
        jComboLic.setConBorde(true);

        jComboSemestre.setBackground(new java.awt.Color(0, 0, 0));
        jComboSemestre.setForeground(new java.awt.Color(0, 0, 0));
        jComboSemestre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Semestre", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jComboSemestre.setColorFondo(new java.awt.Color(255, 255, 255));
        jComboSemestre.setColorSeleccionTXT(new java.awt.Color(0, 0, 0));
        jComboSemestre.setConBorde(true);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setTypeBorder(rojerusan.RSMaterialButton.TYPEBORDER.ROUND);

        btnAgregar.setText("Agregar");
        btnAgregar.setTypeBorder(rojerusan.RSMaterialButton.TYPEBORDER.ROUND);
        btnAgregar.setTypeButton(rojerusan.RSMaterialButton.TYPEBUTTON.PRIMARY);

        btnRegresar.setText("Regresar");
        btnRegresar.setTypeBorder(rojerusan.RSMaterialButton.TYPEBORDER.ROUND);

        btnMostrar.setText("Mostrar");
        btnMostrar.setTypeBorder(rojerusan.RSMaterialButton.TYPEBORDER.ROUND);

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboSemestre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboLic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                            .addComponent(jTextProm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextAP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextAM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextCuenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboLic, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jTextProm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static rojerusan.RSMaterialButton btnAgregar;
    public static rojerusan.RSMaterialButton btnLimpiar;
    public static rojerusan.RSMaterialButton btnMostrar;
    public static rojerusan.RSMaterialButton btnRegresar;
    public static RSMaterialComponent.RSComboBox jComboLic;
    public static RSMaterialComponent.RSComboBox jComboSemestre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static RSMaterialComponent.RSTextFieldMaterial jTextAM;
    public static RSMaterialComponent.RSTextFieldMaterial jTextAP;
    public static RSMaterialComponent.RSTextFieldMaterial jTextCuenta;
    public static RSMaterialComponent.RSTextFieldMaterial jTextFecha;
    public static RSMaterialComponent.RSTextFieldMaterial jTextNombre;
    public static RSMaterialComponent.RSTextFieldMaterial jTextProm;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    // End of variables declaration//GEN-END:variables
}

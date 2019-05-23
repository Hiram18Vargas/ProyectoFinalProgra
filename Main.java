package chatbot;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.applet.AudioClip;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main extends javax.swing.JFrame {

    String pregunta, respuesta, preguntagenerada;

    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        enviar = new javax.swing.JButton();
        texto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        pantalla = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        enviar.setBackground(new java.awt.Color(255, 255, 255));
        enviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/charlar.png"))); // NOI18N
        enviar.setBorderPainted(false);
        enviar.setContentAreaFilled(false);
        enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoActionPerformed(evt);
            }
        });
        texto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoKeyPressed(evt);
            }
        });

        pantalla.setEditable(false);
        pantalla.setColumns(20);
        pantalla.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        pantalla.setRows(5);
        jScrollPane1.setViewportView(pantalla);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ayudar.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pierna-de-pollo (1).png"))); // NOI18N
        jLabel1.setText("Pollo hermanos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 402, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(texto)
                        .addGap(18, 18, 18)
                        .addComponent(enviar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enviar))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        // TODO add your handling code here:
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pregunta = texto.getText();
                    respuesta = (new BuscaDatos().translate(texto.getText()));
                    preguntagenerada = (new BuscaDatos().translate(generarpregunta()));
                    pantalla.append("" + texto.getText() + "\n");
        //if (respuesta.equalsIgnoreCase("ok")){
                    //pantalla.append("Bot: Podrias enseñarme que debo responder si me dicen: '"+pregunta+"' por favor (si/no)\n");
                    //String respuestUsuario= JOptionPane.showInputDialog("Deseas enseñarle?(si/no)");
       /* if (respuestUsuario.equalsIgnoreCase("si")){
                     String respuestUsuarioPregunta= JOptionPane.showInputDialog("Que responder a '"+pregunta+"'");
                     Leer aprender =new Leer();
                     String nuevapalabra=aprender.preguntanueva(pregunta,respuestUsuarioPregunta);
                     aprender.guardar(aprender.leertxt("datos.txt"), nuevapalabra);   
                     }*/
                    // }
                    texto.setText("");
                    animacionEscribir(respuesta);
                    int probabilidad = mitadProbabilidad();
                    //System.out.println(probabilidad);
                    if (probabilidad > 5) {
                        //  System.out.println("entra");
                        animacionpregunta(preguntagenerada);

                    }
                } catch (Exception e) {
                }
            }
        });
        hilo.start();

    }//GEN-LAST:event_enviarActionPerformed

    public String generarpregunta() {
        int numero;
        numero = (int) (Math.random() * 9) + 1;
        String preguntaAleatoria = Integer.toString(numero);
        String preguntacompletada = preguntaAleatoria + "p";
        return preguntacompletada;
    }

    public int mitadProbabilidad() {
        int numero;
        numero = (int) (Math.random() * 9) + 1;
        return numero;
    }

    public void animacionEscribir(String respuestaxd) throws InterruptedException, URISyntaxException, IOException {
        Thread.sleep(generarRandom());
        pantalla.append("Cajero: " + respuestaxd + "\n");

        //  System.out.println(generarRandom());
    }

    public void animacionpregunta(String respuestaxd) throws InterruptedException {

    }

    public int generarRandom() {
        int numero;
        numero = (int) (Math.random() * 100) + 10;
        return numero;

    }

    public void fijarTexto() {
        pantalla.append("Maquina: " + respuesta + "\n");
        texto.setText("");
    }
    private void textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_textoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String UsuarioPregunta = JOptionPane.showInputDialog("Ingrese pregunta");
        String respuestUsuarioPregunta = JOptionPane.showInputDialog("Que responder a '" + UsuarioPregunta + "'");
        Leer aprender = new Leer();
        String nuevapalabra = aprender.preguntanueva(UsuarioPregunta, respuestUsuarioPregunta);
        aprender.guardar(aprender.leertxt("datos.txt"), nuevapalabra);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoKeyPressed


    }//GEN-LAST:event_textoKeyPressed

    public JButton enviarPresionado() {
        return enviar;
    }

    public void setPanatalla() {
        pantalla.append("Maquina: " + respuesta + "\n");
    }

    public JTextArea regresaPantalla() {
        return pantalla;
    }

    public JTextField regresaTexto() {
        return texto;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enviar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea pantalla;
    private javax.swing.JTextField texto;
    // End of variables declaration//GEN-END:variables
}

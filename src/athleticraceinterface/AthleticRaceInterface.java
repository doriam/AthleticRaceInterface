/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athleticraceinterface;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.lang.Math;
/**
 *
 * @author emili
 */
public class AthleticRaceInterface extends JFrame {
    private JPanel panelP;
    private JPanel panelA;
    private JLabel lblRegistrar;
    private JTextField txtName;
    private JButton btnRegistrar;
    
    
    private JPanel panelB;
    private JLabel lblCorredor;
    private JTextArea txtAC;
    
    private JPanel panelC;
    private JLabel lblResults;
    private JTextArea txtResult;
    private JButton btnIniciar;
    private JButton btnReiniciar;
    private JButton btnTerminar;
    private ListenButton listenButton;

    private GridBagConstraints cst;
    private int contador = 0;
    
    private Runner runner[];
    
    public AthleticRaceInterface(){
        setTitle("Carrera atlética");
        setSize(600,600);
        getContentPane().setLayout(new FlowLayout());
        getContentPane().setBackground(new Color (135, 206, 235));
        setLocationRelativeTo(null);

        
        panelP=new JPanel();
        panelP.setLayout(new GridLayout(3,1));
        
        panelA=new JPanel();
        panelA.setLayout(new GridBagLayout()); 
        panelA.setBackground(new Color (135, 206, 235));
        
        cst = new GridBagConstraints();
        cst.insets = new Insets(0, 10, 10, 0);
        lblRegistrar = new JLabel("Registrar corredor");
        
        
        txtName= new JTextField("");
        txtName.setBounds(0, 0, 200, 40);
        btnRegistrar=new JButton("Registrar");
        
        //Add lblRegistrar
        cst.fill = GridBagConstraints.HORIZONTAL;
	cst.gridwidth = 2;
	cst.gridx = 0;
	cst.gridy = 0;
        panelA.add(lblRegistrar,cst);
        
        //Add txtName
        cst.fill = GridBagConstraints.HORIZONTAL;
	cst.gridx = 0;
	cst.gridy = 1;
        cst.weightx=20;
        panelA.add(txtName,cst);
        
        //Add btnRegistrar
        cst.fill = GridBagConstraints.HORIZONTAL;
	cst.gridx = 2;
	cst.gridy = 1;
        panelA.add(btnRegistrar,cst);
     
 
        panelB=new JPanel();
        panelB.setLayout(new GridBagLayout());
        panelB.setBackground(new Color (135, 206, 235));
        
        lblCorredor=new JLabel("Corredores registrados");
        txtAC=new JTextArea(8,40);
         
        
        //Add lblCorredor
        cst.fill = GridBagConstraints.HORIZONTAL;
        
	cst.gridx = 1;
	cst.gridy = 0;
        panelB.add(lblCorredor,cst);
        
        
        //Add txtAC
        cst.fill = GridBagConstraints.HORIZONTAL;
	cst.gridx = 2;
	cst.gridy = 1;
        panelB.add(txtAC,cst);
        
        
        panelC=new JPanel();
        panelC.setLayout(new GridBagLayout());
        panelC.setBackground(new Color (135, 206, 235));
        
        lblResults=new JLabel("Resultados");
        txtResult=new JTextArea(8,40);
        
        btnIniciar=new JButton("Iniciar");
        btnReiniciar=new JButton("Reiniciar");
        btnTerminar=new JButton("Terminar");

                //Add lblRegistrar
        cst.fill = GridBagConstraints.HORIZONTAL;
	cst.gridwidth = 2;
	cst.gridx = 0;
	cst.gridy = 0;
        panelC.add(lblResults,cst);
        
        //Add txtResult
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridheight=3;
	cst.gridx = 0;
	cst.gridy = 1;
        panelC.add(txtResult,cst);
        
        //Add btnIniciar
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridheight=1;
	cst.gridx = 2;
	cst.gridy = 1;
        panelC.add(btnIniciar,cst);

        //Add btnReiniciar
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridheight=1;
	cst.gridx = 2;
	cst.gridy = 2;
        panelC.add(btnReiniciar,cst);
        
        //Add btnTerminar
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridheight=1;
	cst.gridx = 2;
	cst.gridy = 3;
        panelC.add(btnTerminar,cst);

        
        panelP.add(panelA);
        panelP.add(panelB);
        panelP.add(panelC);
        getContentPane().add(panelP);

        //Instanciación de la Clase runner con 5 arrays
        //Runner runner=new Runner();
        runner=new Runner[5];
        
          
        
        listenButton = new ListenButton();
        btnRegistrar.addActionListener(listenButton);
        btnIniciar.addActionListener(listenButton);
        btnReiniciar.addActionListener(listenButton);
        btnTerminar.addActionListener(listenButton);
            
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AthleticRaceInterface a=new AthleticRaceInterface();
       
    }
    
    public class Runner {
        private String name;
        private double speed;
        
        
        public Runner (String name, double speed){
            this.name=name;
            this.speed=speed;
        }
        public String getName(){
            return this.name;
        }
        public void setName(String newname){
            this.name=newname;
        }        
        
        public double getSpeed(){
            return this.speed;
        }
        public void setSpeed(double newspeed){
            this.speed=newspeed;
        }
        
    }
    
    public class ListenButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == btnRegistrar){
                
                if (txtName.getText().equals("") || contador>runner.length){
                    JOptionPane.showMessageDialog(null, "Es obligatorio ingresar el nombre del corredor");
                    contador=contador-1;
                    
                } else{
                    //System.out.println(runner[0].getName());
                    //runner[contador].setName(txtName.getText());
                    //runner[contador].setSpeed(Math.random()*30);
                    runner[contador]=new Runner(txtName.getText(),Math.round(Math.random()*30));
                    txtAC.append(contador+1+ " - "+runner[contador].getName());
                    txtAC.append(System.getProperty("line.separator")); 
                    txtName.setText("");
                    contador=contador+1;
                }
            }
            if (e.getSource() == btnIniciar){
                for(int i = 0; i<runner.length; i++) {
			if(runner[i] == null) {
                                JOptionPane.showMessageDialog(null, "Es obligatorio ingresar al menos 5 corredores para iniciar la carrera");
				break;
			}
                        //System.out.println(runner[i].name);
                        else{
                            txtResult.append(i +" - " + runner[i].getName() + " - Tiempo: " + runner[i].getSpeed() + " segundos");
                            txtResult.append(System.getProperty("line.separator")); 
                        }
		}
            }
            if (e.getSource() == btnReiniciar){
                txtName.setText("");
                txtAC.setText("");
                txtResult.setText("");
            }
            if (e.getSource() == btnTerminar){
                System.exit(0);
            }
        }
    }
    
}

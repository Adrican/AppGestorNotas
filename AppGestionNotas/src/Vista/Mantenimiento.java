package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import Modelo.BaseDatos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class Mantenimiento extends JFrame {
	
	private Controlador ctrl;
	private BaseDatos bd;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel;
	private JLabel lblApellidos_1;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JComboBox comboBox_1;
	private JPanel panel_2;
	private JTable table_2;
	private JButton btnAñadirProfe;
	private JLabel lblApellidos;
	private JLabel lblNombreProfesor;
	private JLabel lblModulo;
	private JButton btnAñadirAlum;
	private JButton btnEliminar;
	private DefaultTableModel dtm;
	private DefaultTableModel dtm2;
	private JButton btnEliminar_1;
	private JScrollPane scrollPane_2;
	private JTextField textField_5;
	private JLabel lblModulo_1;
	private Principal princ;


	/**
	 * Create the frame.
	 */
	public Mantenimiento() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				ctrl.cargarMateriales();
				ctrl.cargarNotas();
				
			}
		});
		setTitle("GestorNotas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 810, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		tabbedPane.addTab("Profesores", null, panel, null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		lblNombreProfesor = new JLabel("Nombre Profesor");
		lblNombreProfesor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreProfesor.setForeground(new Color(255, 255, 255));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidos.setForeground(new Color(255, 255, 255));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		lblModulo = new JLabel("Modulo");
		lblModulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModulo.setForeground(Color.WHITE);
		
		btnAñadirProfe = new JButton("A\u00F1adir");
		btnAñadirProfe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonInsertar(btnAñadirProfe, "PROFESORES", "NOM_PROFE, APELLIDOS_PROFE", textField.getText()+"','"+textField_1.getText());
				botonInsertar(btnAñadirProfe, "MODULOS", "MODULO", textField_2.getText());
				Object [] fila = {textField.getText(), textField_1.getText(), textField_2.getText()};
				dtm.addRow(fila);
				table.setModel(dtm);
			
			}
		});
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.removeRow(table.getSelectedRow());
			}
		});
		
		JLabel lblProfesores = new JLabel("Profesores");
		lblProfesores.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblProfesores.setForeground(new Color(255, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(113)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(392)
							.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNombreProfesor)
							.addGap(124)
							.addComponent(lblApellidos)
							.addPreferredGap(ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
							.addComponent(lblModulo)
							.addGap(22)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEliminar)
					.addGap(29))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(332)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAñadirProfe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
						.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
					.addGap(387))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(266)
					.addComponent(lblProfesores)
					.addContainerGap(303, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblProfesores)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnEliminar)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNombreProfesor)
										.addComponent(lblApellidos))
									.addGap(18))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblModulo)
									.addGap(19)))
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(24)
							.addComponent(btnAñadirProfe)
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
					.addGap(65))
		);
		
		table = new JTable();
		dtm = new DefaultTableModel(new Object[][] {

		}, new String[] { "Nombre", "Apellidos", "Modulo" });
		
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		tabbedPane.addTab("Alumnos", null, panel_1, null);
		
		scrollPane_1 = new JScrollPane();
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblApellidos_1 = new JLabel("Apellidos");
		lblApellidos_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidos_1.setForeground(new Color(255, 255, 255));
		
		lblNewLabel_1 = new JLabel("Modulo");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Programacion", "Entornos de Desarrollo"}));
	
		
		
		btnAñadirAlum = new JButton("A\u00F1adir");
		btnAñadirAlum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonInsertar(btnAñadirAlum, "ALUMNOS", "NOM_ALUMNO, APELLIDOS_ALUMNO", textField_3.getText()+"','"+textField_4.getText());
				botonInsertar(btnAñadirAlum, "NOTAS", "NOTA", textField_5.getText());
				Object [] fila = {textField_3.getText(), textField_4.getText(), comboBox_1.getSelectedItem(), textField_5.getText()};
				dtm2.addRow(fila);
				table_1.setModel(dtm2);
			
			
			}
		});
		
		JLabel lblNota = new JLabel("Nota");
		lblNota.setForeground(new Color(255, 255, 255));
		lblNota.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnEliminar_1 = new JButton("Eliminar");
		btnEliminar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm2.removeRow(table_1.getSelectedRow());
			}
		});
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblAlumnos = new JLabel("Alumnos");
		lblAlumnos.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblAlumnos.setForeground(new Color(255, 255, 255));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(72)
											.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(104)
											.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(12))))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addContainerGap()
											.addComponent(lblAlumnos))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(98)
											.addComponent(lblNewLabel)
											.addGap(121)
											.addComponent(lblApellidos_1)
											.addPreferredGap(ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
											.addComponent(lblNewLabel_1)))
									.addGap(143)
									.addComponent(lblNota)
									.addGap(42)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEliminar_1))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(356)
							.addComponent(btnAñadirAlum)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addComponent(lblAlumnos)
					.addGap(43)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnEliminar_1)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(lblApellidos_1)
								.addComponent(lblNota)
								.addComponent(lblNewLabel_1))
							.addGap(11)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAñadirAlum)
							.addGap(28)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
					.addGap(58))
		);
		
		table_1 = new JTable();
		dtm2 = new DefaultTableModel(new Object[][] {

		}, new String[] { "Nombre", "Apellidos", "Nota", "Modulo" });

		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Adrian", "Canas", "10", "Entornos de desarrollo"},
			},
			new String[] {
				"Nombre", "Apellidos", "Nota", "Modulo"
			}
		));
		scrollPane_1.setViewportView(table_1);
		panel_1.setLayout(gl_panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 128));
		tabbedPane.addTab("Modulos", null, panel_2, null);
		
		lblModulo_1 = new JLabel("Modulos");
		lblModulo_1.setForeground(new Color(255, 255, 255));
		lblModulo_1.setFont(new Font("Tahoma", Font.BOLD, 54));
		
		scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(134)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(143, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(461, Short.MAX_VALUE)
					.addComponent(lblModulo_1)
					.addGap(305))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(28)
					.addComponent(lblModulo_1)
					.addGap(97)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(89, Short.MAX_VALUE))
		);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{"Programacion", "Antonio", "Zurita", "10" },
			},
			new String[] {
				"Modulo", "Nombre", "Apellidos", "Nota"
			}
		));
		scrollPane_2.setViewportView(table_2);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
	public void setCtrl(Controlador ctrl) {
		this.ctrl = ctrl;
	}
	public void setBd(BaseDatos bd) {
		this.bd = bd;
	}
	public void rellenarTabla (){
		String [][] tabla  = bd.getMateriales();
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		for (int i = 0; i < tabla.length; i++) {
			modelo.addRow(tabla[i]);	
		}	
		
	}
	public void rellenarTabla2 (){
		String [][] tabla  = bd.getNotas();
		DefaultTableModel modelo = (DefaultTableModel) table_2.getModel();
		for (int i = 0; i < tabla.length; i++) {
			modelo.addRow(tabla[i]);	
		}	
	}
	public void botonInsertar(JButton btn,String tablas, String columnas, String valores) {
			if (ctrl.Insert(tablas,columnas,valores.trim())) {
				System.out.println(tablas +" " +columnas +" "+valores);
		} else {
			JOptionPane.showMessageDialog(null, "Datos ya existentes", null, JOptionPane.ERROR_MESSAGE);
		}


}
	public void selectCombo(String tabla, String columna) {
		ctrl.SELECT(tabla, columna);
		
}
	public void setPrinc(Principal princ) {
		this.princ = princ;
	}
}
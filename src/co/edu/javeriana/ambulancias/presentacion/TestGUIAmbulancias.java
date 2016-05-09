package co.edu.javeriana.ambulancias.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class TestGUIAmbulancias extends JFrame {

	private JPanel contentPane;
	private JTextField calle;
	private JTextField carrera;
	private JTextField paciente;
	private JTextField telefono;
	private JTextField calleServicio;
	private JTextField carreraServicio;
	private JTextField numeroServicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUIAmbulancias frame = new TestGUIAmbulancias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestGUIAmbulancias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 906, 540);
		contentPane.add(tabbedPane);
		
		JPanel registrarServicio = new JPanel();
		tabbedPane.addTab("Registrar un Servicio", null, registrarServicio, null);
		registrarServicio.setLayout(null);
		
		JLabel lblDatosDelNuevo = new JLabel("Datos del nuevo servicio");
		lblDatosDelNuevo.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 38));
		lblDatosDelNuevo.setBounds(10, 11, 518, 55);
		registrarServicio.add(lblDatosDelNuevo);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(81, 116, 46, 14);
		registrarServicio.add(lblPaciente);
		
		JLabel lblTipoDeServicio = new JLabel("Tipo de servicio");
		lblTipoDeServicio.setBounds(81, 141, 46, 14);
		registrarServicio.add(lblTipoDeServicio);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(81, 196, 46, 14);
		registrarServicio.add(lblTelefono);
		
		JLabel lblTipoDeDireccion = new JLabel("Tipo de direccion");
		lblTipoDeDireccion.setBounds(81, 221, 46, 14);
		registrarServicio.add(lblTipoDeDireccion);
		
		JLabel lblCalle_1 = new JLabel("Calle");
		lblCalle_1.setBounds(81, 246, 46, 14);
		registrarServicio.add(lblCalle_1);
		
		JLabel lblCarrera_1 = new JLabel("Carrera");
		lblCarrera_1.setBounds(81, 271, 46, 14);
		registrarServicio.add(lblCarrera_1);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(81, 296, 46, 14);
		registrarServicio.add(lblNumero);
		
		paciente = new JTextField();
		paciente.setBounds(188, 101, 86, 20);
		registrarServicio.add(paciente);
		paciente.setColumns(10);
		
		telefono = new JTextField();
		telefono.setBounds(188, 193, 86, 20);
		registrarServicio.add(telefono);
		telefono.setColumns(10);
		
		calleServicio = new JTextField();
		calleServicio.setBounds(188, 243, 86, 20);
		registrarServicio.add(calleServicio);
		calleServicio.setColumns(10);
		
		carreraServicio = new JTextField();
		carreraServicio.setBounds(198, 268, 86, 20);
		registrarServicio.add(carreraServicio);
		carreraServicio.setColumns(10);
		
		numeroServicio = new JTextField();
		numeroServicio.setBounds(188, 293, 86, 20);
		registrarServicio.add(numeroServicio);
		numeroServicio.setColumns(10);
		
		JPanel reporteServicios = new JPanel();
		tabbedPane.addTab("Reporte Servicios con IPS y ambulancias asignados", null, reporteServicios, null);
		reporteServicios.setLayout(null);
		
		JPanel asignarServicio = new JPanel();
		tabbedPane.addTab("Asignar un Servicio a una Ambulancia y una IPS", null, asignarServicio, null);
		asignarServicio.setLayout(null);
		
		JPanel registrarPosicionAmbulancia = new JPanel();
		tabbedPane.addTab("Registrar Posicion Ambulancia", null, registrarPosicionAmbulancia, null);
		registrarPosicionAmbulancia.setLayout(null);
		
		JLabel lblAmbulancias = new JLabel("Ambulancias");
		lblAmbulancias.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmbulancias.setToolTipText("");
		lblAmbulancias.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 38));
		lblAmbulancias.setBounds(0, 11, 291, 34);
		registrarPosicionAmbulancia.add(lblAmbulancias);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 31));
		lblCalle.setBounds(283, 313, 109, 34);
		registrarPosicionAmbulancia.add(lblCalle);
		
		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 31));
		lblCarrera.setBounds(283, 362, 109, 34);
		registrarPosicionAmbulancia.add(lblCarrera);
		
		calle = new JTextField();
		calle.setEditable(false);
		calle.setBounds(408, 313, 109, 34);
		registrarPosicionAmbulancia.add(calle);
		calle.setColumns(10);
		
		carrera = new JTextField();
		carrera.setEditable(false);
		carrera.setBounds(408, 362, 109, 34);
		registrarPosicionAmbulancia.add(carrera);
		carrera.setColumns(10);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Script MT Bold", Font.ITALIC, 35));
		btnActualizar.setBounds(327, 435, 200, 50);
		registrarPosicionAmbulancia.add(btnActualizar);
		
		JButton btnRegresar_1 = new JButton("Regresar");
		btnRegresar_1.setBounds(760, 435, 131, 50);
		registrarPosicionAmbulancia.add(btnRegresar_1);
		
		JPanel menuServicios = new JPanel();
		tabbedPane.addTab("Menu Servicios", null, menuServicios, null);
		menuServicios.setLayout(null);
		
		JButton btnRegistrarLaPosicion = new JButton("Registrar la posicion actual de una ambulancia");
		btnRegistrarLaPosicion.setBounds(80, 115, 363, 55);
		menuServicios.add(btnRegistrarLaPosicion);
		
		JButton btnRegistrarUnServicio = new JButton("Registrar un servicio ");
		btnRegistrarUnServicio.setBounds(80, 181, 363, 55);
		menuServicios.add(btnRegistrarUnServicio);
		
		JButton btnAsignarUnServicio = new JButton("Asignar a un servicio una ambulancia y una IPS");
		btnAsignarUnServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAsignarUnServicio.setBounds(80, 248, 363, 55);
		menuServicios.add(btnAsignarUnServicio);
		
		JButton btnFinalizarUnServicio = new JButton("Finalizar un servicio");
		btnFinalizarUnServicio.setBounds(472, 115, 363, 55);
		menuServicios.add(btnFinalizarUnServicio);
		
		JButton btnReporteServicios = new JButton("Reporte de servicios con IPS y ambulancias asignados");
		btnReporteServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReporteServicios.setBounds(472, 181, 363, 55);
		menuServicios.add(btnReporteServicios);
		
		JButton btnReporteDeLa = new JButton("Reporte de la IPS con servicios asociados");
		btnReporteDeLa.setBounds(472, 248, 363, 55);
		menuServicios.add(btnReporteDeLa);
		
		JPanel finalizarServicio = new JPanel();
		tabbedPane.addTab("Finalizar un Servicio", null, finalizarServicio, null);
		finalizarServicio.setLayout(null);
		
		JPanel ingresarIPSyAmbulancias = new JPanel();
		tabbedPane.addTab("Ingresar IPS y Ambulancias", null, ingresarIPSyAmbulancias, null);
		ingresarIPSyAmbulancias.setLayout(null);
		
		JButton btnSeleccionarArchivoDe = new JButton("Seleccionar archivo de IPS");
		btnSeleccionarArchivoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSeleccionarArchivoDe.setBounds(274, 123, 337, 84);
		ingresarIPSyAmbulancias.add(btnSeleccionarArchivoDe);
		
		JButton btnSeleccionarArchivoDe_1 = new JButton("Seleccionar archivo de ambulancias");
		btnSeleccionarArchivoDe_1.setBounds(274, 218, 337, 84);
		ingresarIPSyAmbulancias.add(btnSeleccionarArchivoDe_1);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(732, 419, 159, 66);
		ingresarIPSyAmbulancias.add(btnRegresar);
		
		JLabel lblIngresarIpsY = new JLabel("Ingresar IPS y ambulancias");
		lblIngresarIpsY.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarIpsY.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 50));
		lblIngresarIpsY.setBounds(0, 11, 912, 52);
		ingresarIPSyAmbulancias.add(lblIngresarIpsY);
		
		JPanel reporteIPS = new JPanel();
		tabbedPane.addTab("Reporte de IPS con servicios asociados", null, reporteIPS, null);
		reporteIPS.setLayout(null);
	}
}

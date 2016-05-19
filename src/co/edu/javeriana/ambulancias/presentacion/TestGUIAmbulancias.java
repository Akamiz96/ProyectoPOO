package co.edu.javeriana.ambulancias.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableModel;

import co.edu.javeriana.ambulancias.negocio.Ambulancia;
import co.edu.javeriana.ambulancias.negocio.AmbulanciaBasica;
import co.edu.javeriana.ambulancias.negocio.AmbulanciaMedicalizada;
import co.edu.javeriana.ambulancias.negocio.AmbulanciaNoMedicalizada;
import co.edu.javeriana.ambulancias.negocio.AmbulanciaUCI;
import co.edu.javeriana.ambulancias.negocio.CodigoComparator;
import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.negocio.EstadoServicio;
import co.edu.javeriana.ambulancias.negocio.HoraSolicitudComparator;
import co.edu.javeriana.ambulancias.negocio.IPS;
import co.edu.javeriana.ambulancias.negocio.IServiciosAmbulancias;
import co.edu.javeriana.ambulancias.negocio.Servicio;
import co.edu.javeriana.ambulancias.negocio.TipoDireccion;
import co.edu.javeriana.ambulancias.negocio.TipoServicio;
import co.edu.javeriana.ambulancias.persistencia.ManejoArchivos;
import co.edu.javeriana.ambulancias.persistencia.PersistenceException;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TestGUIAmbulancias extends JFrame {

	/*
	 * Atributo que indica el tab en cual se encuentra el menu de servicios
	 */
	private final static int menuServicios = 0;
	/*
	 * Atributo que indica el tab en cual se encuentra Registrar la posicion de
	 * la ambulancia
	 */
	private final static int registrarPosicion = 2;
	/*
	 * Atributo que indica el tab en cual se encuentra Registrar un servicio
	 */
	private final static int registrarServicio = 4;
	/*
	 * Atributo que indica el tab en cual se encuentra Asignar un servicio
	 */
	private final static int asignarServicio = 6;
	/*
	 * Atributo que indica el tab en cual se encuentra Finalizar un servicio
	 */
	private final static int finalizarServicio = 3;
	/*
	 * Atributo que indica el tab en cual se encuentra Reporte de Servicios con
	 * IPS y Ambulancias asociados
	 */
	private final static int reporteServicios = 5;
	/*
	 * Atributo que indica el tab en cual se encuentra Reporte de IPS con
	 * Servicios Asociados
	 */
	private final static int reporteIPS = 7;
	/*
	 * Atributo que indica el tab en cual se encuentra Ingresar IPS y
	 * Ambulancias
	 */
	private final static int ingresarIPSAmbulancias = 1;
	/*
	 * Nombres de los encabezados para registrar la posicion de una ambulancia
	 */
	private String[] nombreColumAmbulancias = { "codigo", "tipo", "placa", "medico/enfermero", "tipo UCI",
			"hora posicion", "calle", "carrera" };
	/*
	 * Nombres de los encabezados para registrar la posicion de una ambulancia
	 */
	private Vector nombreColumAmbulanciasV;
	/*
	 * Vector de vectores de datos para registrar la posicion de una ambulancia
	 */
	private Vector filaDatosAmbulancias;
	/*
	 * Nombres de los encabezados para finalizar un servicio
	 */
	private String[] nombreColumServicios = { "codigo", "hora sol.", "paciente", "tipo servicio", "telefono",
			"direccion", "estado", "IPS", "ambul." };
	/*
	 * Nombres de los encabezados para finalizar un servicio
	 */
	private Vector nombreColumServiciosV;
	/*
	 * Vector de vectores de datos para finalizar un servicio
	 */
	private Vector filaDatosServicios;
	/*
	 * Nombres de los encabezados para reporte Servicios con IPS y Ambulancias
	 * asignados
	 */
	private String[] nombreColumServicios1 = { "codigo", "hora sol.", "paciente", "tipo servicio", "telefono",
			"direccion", "estado", "valor" };
	/*
	 * Nombres de los encabezados para reporte Servicios con IPS y Ambulancias
	 * asignados
	 */
	private Vector nombreColumServiciosV1;
	/*
	 * Vector de vectores de datos para reporte Servicios con IPS y Ambulancias
	 * asignados
	 */
	private Vector filaDatosServicios1;
	/*
	 * Nombres de los encabezados para reporte IPS con servicios asociados
	 */
	private String[] nombreColumServicios2 = { "codigo", "hora sol.", "paciente", "tipo servicio", "telefono",
			"direccion", "estado", "IPS", "ambul." };
	/*
	 * Nombres de los encabezados para reporte IPS con servicios asociados
	 */
	private Vector nombreColumServiciosV2;
	/*
	 * Vector de vectores de datos para reporte IPS con servicios asociados
	 */
	private Vector filaDatosServicios2;
	/*
	 * Nombres de los encabezados para Asignar un Servicio a una IPS y a una
	 * Ambulancia
	 */
	private String[] nombreColumServicios3 = { "codigo", "hora sol.", "paciente", "tipo servicio", "telefono",
			"direccion", "estado", "IPS", "ambul." };
	/*
	 * Nombres de los encabezados para Asignar un Servicio a una IPS y a una
	 * Ambulancia
	 */
	private Vector nombreColumServiciosV3;
	/*
	 * Vector de vectores de datos para Asignar un Servicio a una IPS y a una
	 * Ambulancia
	 */
	private Vector filaDatosServicios3;
	/*
	 * Nombres de los encabezados para Asignar un Servicio a una IPS y a una
	 * Ambulancia
	 */
	private String[] nombreColumIPS = { "nombre", "tipo de atencion", "direccion" };
	/*
	 * Nombres de los encabezados para Asignar un Servicio a una IPS y a una
	 * Ambulancia
	 */
	private Vector nombreColumIPSV;
	/*
	 * Vector de vectores de datos para Asignar un Servicio a una IPS y a una
	 * Ambulancia
	 */
	private Vector filaDatosIPS;
	/*
	 * Nombres de los encabezados para reporte Servicios con IPS y Ambulancias
	 * asignados
	 */
	private String[] nombreColumAmbulancias3 = { "codigo", "tipo", "placa", "medico/enfermero", "Tipo UCI",
			"hora posicion", "calle", "carrera" };
	/*
	 * Nombres de los encabezados para reporte Servicios con IPS y Ambulancias
	 * asignados
	 */
	private Vector nombreColumAmbulancias3V;
	/*
	 * Vector de vectores de datos para reporte Servicios con IPS y Ambulancias
	 * asignados
	 */
	private Vector filaDatosAmbulancias3V;

	private IServiciosAmbulancias empresaAmbulancias = new EmpresaAmbulancias("AAA");
	private JPanel contentPane;
	private JTextField calle;
	private JTextField carrera;
	private JTextField paciente;
	private JTextField telefono;
	private JTextField calleServicio;
	private JTextField carreraServicio;
	private JTextField numeroServicio;
	private JComboBox comboBoxTipo;
	private JComboBox comboBoxDireccion;
	private JTabbedPane tabbedPane;
	private JTable tablaAmbulancias;
	private JTable tablaServicios;
	private JTable tablaServicios1;
	private JTable tablaServicios2;
	private JTable tablaServicios3;
	private JTable tablaIPS;
	private JTable tablaAmbulancias3;
	private JButton btnRegresar_5;
	private JButton btnRegresar_4;
	private JButton btnRegresar_3;
	private JButton btnRegresar_6;
	private JButton btnRegresar_1;
	private JButton btnRegresar;
	private JButton btnRegistrarLaPosicion;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_5;
	private JComboBox comboBoxIPS;
	private JScrollPane scrollPane_2;
	private JButton btnActualizar;
	private JScrollPane scrollPane_6;
	private JScrollPane scrollPane_7;
	private JScrollPane scrollPane_8;
	private JTextField txtNombre;
	private JTextField txtTipoAtencion;
	private JTextField txtDireccion;
	private JTextField txtCodigo;
	private JTextField txtTipo;
	private JTextField txtPlaca;
	private JTextField txtMedicoEnfermero;
	private JTextField txtHoraSolicitud;
	private JTextField txtCalle;
	private JTextField txtCarrera;
	private JTextField txtTarifa;
	private JTextField nombreIPS;
	private JTextField tipoAtencionIPS;
	private JTextField DireccionIPS;
	private JTextField codigoAmbulancia;
	private JTextField tipoAmbulancia;
	private JTextField placaAmbulancia;
	private JTextField medicoAmbulancia;
	private JTextField horaAmbulancia;
	private JTextField calleAmbulancia;
	private JTextField carreraAmbulancia;
	private JTextField tarifaAmbulancia;
	private JTextField txtTipoUci;
	private JTextField tipoUCIAmbulancia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUIAmbulancias frame = new TestGUIAmbulancias();
					frame.setVisible(true);
					frame.getTabbedPane().setSelectedIndex(menuServicios);
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
		setBounds(100, 100, 964, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 948, 578);
		contentPane.add(tabbedPane);

		JPanel menuServicios_1 = new JPanel();
		tabbedPane.addTab("Menu Servicios", null, menuServicios_1, null);

		btnRegistrarLaPosicion = new JButton("Registrar la posicion actual de una ambulancia");
		btnRegistrarLaPosicion.setBounds(80, 115, 363, 55);
		btnRegistrarLaPosicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irRegistrarPosicion(e);
			}
		});
		menuServicios_1.setLayout(null);
		menuServicios_1.add(btnRegistrarLaPosicion);

		JButton btnRegistrarUnServicio = new JButton("Registrar un servicio ");
		btnRegistrarUnServicio.setBounds(80, 181, 363, 55);
		btnRegistrarUnServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarRegistroServicio(e);
			}
		});
		menuServicios_1.add(btnRegistrarUnServicio);

		JButton btnAsignarUnServicio = new JButton("Asignar a un servicio una ambulancia y una IPS");
		btnAsignarUnServicio.setBounds(80, 248, 363, 55);
		btnAsignarUnServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irAsignarServicio(e);
			}
		});
		menuServicios_1.add(btnAsignarUnServicio);

		JButton btnFinalizarUnServicio = new JButton("Finalizar un servicio");
		btnFinalizarUnServicio.setBounds(472, 115, 363, 55);
		btnFinalizarUnServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irFinalizarServicio(e);
			}
		});
		menuServicios_1.add(btnFinalizarUnServicio);

		JButton btnReporteServicios = new JButton("Reporte de servicios con IPS y ambulancias asignados");
		btnReporteServicios.setBounds(472, 181, 363, 55);
		btnReporteServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irReporteServicios(e);
			}
		});
		menuServicios_1.add(btnReporteServicios);

		JButton btnReporteDeLa = new JButton("Reporte de la IPS con servicios asociados");
		btnReporteDeLa.setBounds(472, 248, 363, 55);
		btnReporteDeLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irReporteIPS(e);
			}
		});
		menuServicios_1.add(btnReporteDeLa);

		JButton ingresarIPSAmbulancias = new JButton("Ingresar IPS y Ambulancias");
		ingresarIPSAmbulancias.setBounds(148, 351, 242, 73);
		ingresarIPSAmbulancias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				irIngresarIPSAmbulancias(arg0);
			}
		});
		menuServicios_1.add(ingresarIPSAmbulancias);

		JButton btnSalvarSi = new JButton("Salvar datos del sistema");
		btnSalvarSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarArchivo(e);
			}
		});
		btnSalvarSi.setBounds(548, 333, 225, 62);
		menuServicios_1.add(btnSalvarSi);

		JButton btnCargarDatosDel = new JButton("Cargar datos del sistema");
		btnCargarDatosDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatos(e);
			}
		});
		btnCargarDatosDel.setBounds(548, 413, 225, 62);
		menuServicios_1.add(btnCargarDatosDel);

		JPanel ingresarIPSyAmbulancias = new JPanel();
		tabbedPane.addTab("Ingresar IPS y Ambulancias", null, ingresarIPSyAmbulancias, null);
		ingresarIPSyAmbulancias.setLayout(null);

		JButton btnSeleccionarArchivoDe = new JButton("Seleccionar archivo de IPS");
		btnSeleccionarArchivoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					seleccionarIPS(e);
				} catch (PersistenceException exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage());
				}
			}
		});
		btnSeleccionarArchivoDe.setBounds(274, 123, 337, 84);
		ingresarIPSyAmbulancias.add(btnSeleccionarArchivoDe);

		JButton btnSeleccionarArchivoDe_1 = new JButton("Seleccionar archivo de ambulancias");
		btnSeleccionarArchivoDe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					seleccionarAmbulancias(arg0);
				} catch (PersistenceException exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage());
				}
			}
		});
		btnSeleccionarArchivoDe_1.setBounds(274, 218, 337, 84);
		ingresarIPSyAmbulancias.add(btnSeleccionarArchivoDe_1);

		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresar(e);
			}
		});
		btnRegresar.setBounds(712, 403, 159, 66);
		ingresarIPSyAmbulancias.add(btnRegresar);

		JLabel lblIngresarIpsY = new JLabel("Ingresar IPS y ambulancias");
		lblIngresarIpsY.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarIpsY.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 50));
		lblIngresarIpsY.setBounds(0, 11, 912, 52);
		ingresarIPSyAmbulancias.add(lblIngresarIpsY);

		JPanel registrarPosicionAmbulancia = new JPanel();
		tabbedPane.addTab("Registrar Posicion Ambulancia", null, registrarPosicionAmbulancia, null);
		registrarPosicionAmbulancia.setLayout(null);

		JLabel lblAmbulancias = new JLabel("Ambulancias");
		lblAmbulancias.setBounds(0, 11, 291, 34);
		lblAmbulancias.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmbulancias.setToolTipText("");
		lblAmbulancias.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 38));
		registrarPosicionAmbulancia.add(lblAmbulancias);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(283, 313, 109, 34);
		lblCalle.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 31));
		registrarPosicionAmbulancia.add(lblCalle);

		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setBounds(283, 362, 109, 34);
		lblCarrera.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 31));
		registrarPosicionAmbulancia.add(lblCarrera);

		calle = new JTextField();
		calle.setBounds(408, 313, 109, 34);
		registrarPosicionAmbulancia.add(calle);
		calle.setColumns(10);

		carrera = new JTextField();
		carrera.setBounds(408, 362, 109, 34);
		registrarPosicionAmbulancia.add(carrera);
		carrera.setColumns(10);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarPosicionActual(e);
			}
		});
		btnActualizar.setBounds(327, 435, 200, 50);
		btnActualizar.setFont(new Font("Script MT Bold", Font.ITALIC, 35));
		registrarPosicionAmbulancia.add(btnActualizar);

		btnRegresar_1 = new JButton("Regresar");
		btnRegresar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresar(e);
			}
		});
		btnRegresar_1.setBounds(760, 435, 131, 50);
		registrarPosicionAmbulancia.add(btnRegresar_1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 918, 234);
		registrarPosicionAmbulancia.add(scrollPane);

		tablaAmbulancias = getTablaAmbulancias();
		scrollPane.setViewportView(tablaAmbulancias);

		JPanel finalizarServicio = new JPanel();
		tabbedPane.addTab("Finalizar un Servicio", null, finalizarServicio, null);
		finalizarServicio.setLayout(null);

		JLabel lblFinalizarUnServicio = new JLabel("Finalizar un servicio");
		lblFinalizarUnServicio.setBounds(10, 11, 401, 45);
		lblFinalizarUnServicio.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 38));
		finalizarServicio.add(lblFinalizarUnServicio);

		JLabel lblServicios_1 = new JLabel("Servicios");
		lblServicios_1.setBounds(20, 67, 129, 61);
		lblServicios_1.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		finalizarServicio.add(lblServicios_1);

		btnRegresar_4 = new JButton("Regresar");
		btnRegresar_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresar(e);
			}
		});
		btnRegresar_4.setBounds(750, 424, 141, 61);
		finalizarServicio.add(btnRegresar_4);

		JButton btnFinalizarServicioSeleccionado = new JButton("Finalizar servicio seleccionado");
		btnFinalizarServicioSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizarServicio(e);
			}
		});
		btnFinalizarServicioSeleccionado.setBounds(262, 413, 241, 72);
		finalizarServicio.add(btnFinalizarServicioSeleccionado);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 125, 918, 262);
		finalizarServicio.add(scrollPane_1);

		tablaServicios = getTablaServicios();
		scrollPane_1.setViewportView(tablaServicios);

		JPanel registrarServicio = new JPanel();
		tabbedPane.addTab("Registrar un Servicio", null, registrarServicio, null);
		registrarServicio.setLayout(null);

		JLabel lblDatosDelNuevo = new JLabel("Datos del nuevo servicio");
		lblDatosDelNuevo.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 38));
		lblDatosDelNuevo.setBounds(10, 11, 518, 55);
		registrarServicio.add(lblDatosDelNuevo);

		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Stencil", Font.ITALIC, 32));
		lblPaciente.setBounds(81, 77, 316, 47);
		registrarServicio.add(lblPaciente);

		JLabel lblTipoDeServicio = new JLabel("Tipo de servicio");
		lblTipoDeServicio.setFont(new Font("Stencil", Font.ITALIC, 32));
		lblTipoDeServicio.setBounds(81, 134, 316, 47);
		registrarServicio.add(lblTipoDeServicio);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Stencil", Font.ITALIC, 32));
		lblTelefono.setBounds(81, 190, 316, 47);
		registrarServicio.add(lblTelefono);

		JLabel lblTipoDeDireccion = new JLabel("Tipo de direccion");
		lblTipoDeDireccion.setFont(new Font("Stencil", Font.ITALIC, 32));
		lblTipoDeDireccion.setBounds(81, 248, 316, 47);
		registrarServicio.add(lblTipoDeDireccion);

		JLabel lblCalle_1 = new JLabel("Calle");
		lblCalle_1.setFont(new Font("Stencil", Font.ITALIC, 32));
		lblCalle_1.setBounds(81, 306, 316, 47);
		registrarServicio.add(lblCalle_1);

		JLabel lblCarrera_1 = new JLabel("Carrera");
		lblCarrera_1.setFont(new Font("Stencil", Font.ITALIC, 32));
		lblCarrera_1.setBounds(81, 364, 316, 47);
		registrarServicio.add(lblCarrera_1);

		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Stencil", Font.ITALIC, 32));
		lblNumero.setBounds(81, 422, 316, 47);
		registrarServicio.add(lblNumero);

		paciente = new JTextField();
		paciente.setBounds(418, 81, 316, 47);
		registrarServicio.add(paciente);
		paciente.setColumns(10);

		telefono = new JTextField();
		telefono.setBounds(418, 194, 316, 47);
		registrarServicio.add(telefono);
		telefono.setColumns(10);

		calleServicio = new JTextField();
		calleServicio.setBounds(418, 310, 316, 47);
		registrarServicio.add(calleServicio);
		calleServicio.setColumns(10);

		carreraServicio = new JTextField();
		carreraServicio.setBounds(418, 368, 316, 47);
		registrarServicio.add(carreraServicio);
		carreraServicio.setColumns(10);

		numeroServicio = new JTextField();
		numeroServicio.setBounds(418, 426, 316, 47);
		registrarServicio.add(numeroServicio);
		numeroServicio.setColumns(10);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarServicio(e);
			}
		});
		btnRegistrar.setBounds(763, 11, 128, 76);
		registrarServicio.add(btnRegistrar);

		JButton btnRegresar_2 = new JButton("Regresar");
		btnRegresar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresar(e);
			}
		});
		btnRegresar_2.setBounds(763, 409, 128, 76);
		registrarServicio.add(btnRegresar_2);

		comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(418, 138, 316, 47);
		registrarServicio.add(comboBoxTipo);

		comboBoxDireccion = new JComboBox();
		comboBoxDireccion.setBounds(418, 252, 316, 47);
		registrarServicio.add(comboBoxDireccion);

		JPanel reporteServicios = new JPanel();
		tabbedPane.addTab("Reporte Servicios con IPS y ambulancias asignados", null, reporteServicios, null);
		reporteServicios.setLayout(null);

		JLabel lblReporteDeServicios = new JLabel("Reporte de servicios con IPS y ambulancias asignados ");
		lblReporteDeServicios.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 30));
		lblReporteDeServicios.setBounds(10, 11, 881, 51);
		reporteServicios.add(lblReporteDeServicios);

		JLabel lblServicios_2 = new JLabel("Servicios");
		lblServicios_2.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 29));
		lblServicios_2.setBounds(10, 60, 228, 35);
		reporteServicios.add(lblServicios_2);

		JLabel lblIpsAsignada = new JLabel("IPS asignada");
		lblIpsAsignada.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 29));
		lblIpsAsignada.setBounds(10, 212, 228, 35);
		reporteServicios.add(lblIpsAsignada);

		JLabel lblAmbulanciaAsignada = new JLabel("Ambulancia asignada");
		lblAmbulanciaAsignada.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 29));
		lblAmbulanciaAsignada.setBounds(10, 366, 293, 35);
		reporteServicios.add(lblAmbulanciaAsignada);

		btnRegresar_5 = new JButton("Regresar");
		btnRegresar_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regresar(arg0);
			}
		});
		btnRegresar_5.setBounds(729, 483, 199, 35);
		reporteServicios.add(btnRegresar_5);

		JButton btnMostrar = new JButton("Mostrar IPS y ambulancia asignadas");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarIpsAmbulancia(e);
			}
		});
		btnMostrar.setBounds(668, 207, 260, 51);
		reporteServicios.add(btnMostrar);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 89, 918, 112);
		reporteServicios.add(scrollPane_2);

		tablaServicios1 = getTablaServicios1();
		scrollPane_2.setViewportView(tablaServicios1);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setText("Nombre");
		txtNombre.setBounds(20, 258, 86, 20);
		reporteServicios.add(txtNombre);
		txtNombre.setColumns(10);

		txtTipoAtencion = new JTextField();
		txtTipoAtencion.setEditable(false);
		txtTipoAtencion.setText("Tipo atencion");
		txtTipoAtencion.setBounds(152, 258, 86, 20);
		reporteServicios.add(txtTipoAtencion);
		txtTipoAtencion.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setText("Direccion ");
		txtDireccion.setBounds(289, 258, 86, 20);
		reporteServicios.add(txtDireccion);
		txtDireccion.setColumns(10);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setText("Codigo");
		txtCodigo.setBounds(20, 412, 86, 20);
		reporteServicios.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		txtTipo.setText("Tipo");
		txtTipo.setBounds(152, 412, 86, 20);
		reporteServicios.add(txtTipo);
		txtTipo.setColumns(10);

		txtPlaca = new JTextField();
		txtPlaca.setEditable(false);
		txtPlaca.setText("Placa");
		txtPlaca.setBounds(289, 412, 86, 20);
		reporteServicios.add(txtPlaca);
		txtPlaca.setColumns(10);

		txtMedicoEnfermero = new JTextField();
		txtMedicoEnfermero.setEditable(false);
		txtMedicoEnfermero.setText("Medico/ enfermero");
		txtMedicoEnfermero.setBounds(428, 412, 86, 20);
		reporteServicios.add(txtMedicoEnfermero);
		txtMedicoEnfermero.setColumns(10);

		txtHoraSolicitud = new JTextField();
		txtHoraSolicitud.setEditable(false);
		txtHoraSolicitud.setText("Hora solicitud");
		txtHoraSolicitud.setBounds(581, 412, 86, 20);
		reporteServicios.add(txtHoraSolicitud);
		txtHoraSolicitud.setColumns(10);

		txtCalle = new JTextField();
		txtCalle.setEditable(false);
		txtCalle.setText("Calle");
		txtCalle.setBounds(716, 412, 86, 20);
		reporteServicios.add(txtCalle);
		txtCalle.setColumns(10);

		txtCarrera = new JTextField();
		txtCarrera.setEditable(false);
		txtCarrera.setText("Carrera");
		txtCarrera.setBounds(830, 412, 86, 20);
		reporteServicios.add(txtCarrera);
		txtCarrera.setColumns(10);

		txtTarifa = new JTextField();
		txtTarifa.setEditable(false);
		txtTarifa.setText("Tarifa");
		txtTarifa.setBounds(20, 471, 86, 20);
		reporteServicios.add(txtTarifa);
		txtTarifa.setColumns(10);

		nombreIPS = new JTextField();
		nombreIPS.setEditable(false);
		nombreIPS.setBounds(10, 289, 86, 20);
		reporteServicios.add(nombreIPS);
		nombreIPS.setColumns(10);

		tipoAtencionIPS = new JTextField();
		tipoAtencionIPS.setEditable(false);
		tipoAtencionIPS.setBounds(152, 289, 86, 20);
		reporteServicios.add(tipoAtencionIPS);
		tipoAtencionIPS.setColumns(10);

		DireccionIPS = new JTextField();
		DireccionIPS.setEditable(false);
		DireccionIPS.setBounds(289, 289, 86, 20);
		reporteServicios.add(DireccionIPS);
		DireccionIPS.setColumns(10);

		codigoAmbulancia = new JTextField();
		codigoAmbulancia.setEditable(false);
		codigoAmbulancia.setBounds(20, 440, 86, 20);
		reporteServicios.add(codigoAmbulancia);
		codigoAmbulancia.setColumns(10);

		tipoAmbulancia = new JTextField();
		tipoAmbulancia.setEditable(false);
		tipoAmbulancia.setBounds(152, 440, 86, 20);
		reporteServicios.add(tipoAmbulancia);
		tipoAmbulancia.setColumns(10);

		placaAmbulancia = new JTextField();
		placaAmbulancia.setEditable(false);
		placaAmbulancia.setBounds(289, 440, 86, 20);
		reporteServicios.add(placaAmbulancia);
		placaAmbulancia.setColumns(10);

		medicoAmbulancia = new JTextField();
		medicoAmbulancia.setEditable(false);
		medicoAmbulancia.setBounds(428, 440, 86, 20);
		reporteServicios.add(medicoAmbulancia);
		medicoAmbulancia.setColumns(10);

		horaAmbulancia = new JTextField();
		horaAmbulancia.setEditable(false);
		horaAmbulancia.setBounds(581, 443, 86, 20);
		reporteServicios.add(horaAmbulancia);
		horaAmbulancia.setColumns(10);

		calleAmbulancia = new JTextField();
		calleAmbulancia.setEditable(false);
		calleAmbulancia.setBounds(726, 440, 86, 20);
		reporteServicios.add(calleAmbulancia);
		calleAmbulancia.setColumns(10);

		carreraAmbulancia = new JTextField();
		carreraAmbulancia.setEditable(false);
		carreraAmbulancia.setBounds(830, 443, 86, 20);
		reporteServicios.add(carreraAmbulancia);
		carreraAmbulancia.setColumns(10);

		tarifaAmbulancia = new JTextField();
		tarifaAmbulancia.setEditable(false);
		tarifaAmbulancia.setBounds(20, 498, 86, 20);
		reporteServicios.add(tarifaAmbulancia);
		tarifaAmbulancia.setColumns(10);

		txtTipoUci = new JTextField();
		txtTipoUci.setEditable(false);
		txtTipoUci.setText("Tipo UCI");
		txtTipoUci.setBounds(152, 471, 86, 20);
		reporteServicios.add(txtTipoUci);
		txtTipoUci.setColumns(10);

		tipoUCIAmbulancia = new JTextField();
		tipoUCIAmbulancia.setEditable(false);
		tipoUCIAmbulancia.setBounds(152, 498, 86, 20);
		reporteServicios.add(tipoUCIAmbulancia);
		tipoUCIAmbulancia.setColumns(10);

		JPanel asignarServicio = new JPanel();
		tabbedPane.addTab("Asignar un Servicio a una Ambulancia y una IPS", null, asignarServicio, null);
		asignarServicio.setLayout(null);

		JLabel lblAsignarUnServicio = new JLabel("Asignar un servicio a una ambulancia y una IPS");
		lblAsignarUnServicio.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 31));
		lblAsignarUnServicio.setBounds(10, 11, 800, 51);
		asignarServicio.add(lblAsignarUnServicio);

		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setFont(new Font("Yu Gothic Light", Font.BOLD, 26));
		lblServicios.setBounds(10, 54, 146, 31);
		asignarServicio.add(lblServicios);

		JLabel lblIps = new JLabel("IPS");
		lblIps.setFont(new Font("Yu Gothic Light", Font.BOLD, 26));
		lblIps.setBounds(10, 226, 61, 31);
		asignarServicio.add(lblIps);

		JLabel lblAmbulancias_1 = new JLabel("Ambulancias");
		lblAmbulancias_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 26));
		lblAmbulancias_1.setBounds(10, 345, 189, 31);
		asignarServicio.add(lblAmbulancias_1);

		btnRegresar_3 = new JButton("Regresar");
		btnRegresar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresar(e);
			}
		});
		btnRegresar_3.setBounds(739, 487, 189, 31);
		asignarServicio.add(btnRegresar_3);

		JButton btnAsignarServicioSeleccionado = new JButton("Asignar servicio seleccionado");
		btnAsignarServicioSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignarServicio(e);
			}
		});
		btnAsignarServicioSeleccionado.setBounds(695, 228, 233, 36);
		asignarServicio.add(btnAsignarServicioSeleccionado);

		scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 93, 918, 134);
		asignarServicio.add(scrollPane_6);

		tablaServicios3 = getTablaServicios3();
		scrollPane_6.setViewportView(tablaServicios3);

		scrollPane_7 = new JScrollPane();
		scrollPane_7.setEnabled(false);
		scrollPane_7.setBounds(10, 268, 918, 74);
		asignarServicio.add(scrollPane_7);

		tablaIPS = getTablaIPS();
		scrollPane_7.setViewportView(tablaIPS);

		scrollPane_8 = new JScrollPane();
		scrollPane_8.setEnabled(false);
		scrollPane_8.setBounds(10, 374, 918, 102);
		asignarServicio.add(scrollPane_8);

		tablaAmbulancias3 = getTablaAmbulancias3();
		scrollPane_8.setViewportView(tablaAmbulancias3);

		JPanel reporteIPS = new JPanel();
		tabbedPane.addTab("Reporte de IPS con servicios asociados", null, reporteIPS, null);
		reporteIPS.setLayout(null);

		JLabel lblReporteDeIps = new JLabel("Reporte de IPS con servicios asociados");
		lblReporteDeIps.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 32));
		lblReporteDeIps.setBounds(10, 11, 691, 46);
		reporteIPS.add(lblReporteDeIps);

		JLabel lblIps_1 = new JLabel("IPS");
		lblIps_1.setFont(new Font("Sylfaen", Font.ITALIC, 38));
		lblIps_1.setBounds(10, 68, 128, 46);
		reporteIPS.add(lblIps_1);

		JLabel lblServiciosAsociados = new JLabel("Servicios asociados");
		lblServiciosAsociados.setFont(new Font("Sylfaen", Font.ITALIC, 38));
		lblServiciosAsociados.setBounds(10, 231, 338, 46);
		reporteIPS.add(lblServiciosAsociados);

		comboBoxIPS = new JComboBox();
		comboBoxIPS.setBounds(362, 68, 505, 46);
		reporteIPS.add(comboBoxIPS);

		JButton btnMostrarServiciosAsociados = new JButton("Mostrar servicios asociados");
		btnMostrarServiciosAsociados.setBounds(121, 163, 254, 56);
		reporteIPS.add(btnMostrarServiciosAsociados);

		btnRegresar_6 = new JButton("Regresar");
		btnRegresar_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresar(e);
			}
		});
		btnRegresar_6.setBounds(780, 462, 148, 56);
		reporteIPS.add(btnRegresar_6);

		this.getTabbedPane().setSelectedIndex(5);

		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 288, 918, 161);
		reporteIPS.add(scrollPane_5);

		tablaServicios2 = this.getTablaServicios2();
		scrollPane_5.setViewportView(tablaServicios2);
		/*
		 * Reaccion al cambio de tabs dentro de la interfaz
		 */
		ChangeListener changeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {
				JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
				int index = sourceTabbedPane.getSelectedIndex();
				switch (index) {
				case 2:
					irRegistrarPosicion(null);
					break;
				case 3:
					irFinalizarServicio(null);
					break;
				case 4:
					mostrarRegistroServicio(null);
					break;
				case 5:
					irReporteServicios(null);
					break;
				case 6:
					irAsignarServicio(null);
					break;
				case 7:
					irReporteIPS(null);
					break;
				}
			}
		};
		tabbedPane.addChangeListener(changeListener);
	}

	public JTextField getPaciente() {
		return paciente;
	}

	public JComboBox getComboBoxTipo() {
		return comboBoxTipo;
	}

	public JTextField getTelefono() {
		return telefono;
	}

	public JComboBox getComboBoxDireccion() {
		return comboBoxDireccion;
	}

	public JTextField getCalleServicio() {
		return calleServicio;
	}

	public JTextField getCarreraServicio() {
		return carreraServicio;
	}

	public JTextField getNumeroServicio() {
		return numeroServicio;
	}

	private void mostrarRegistroServicio(ActionEvent e) {
		this.getTabbedPane().setSelectedIndex(this.registrarServicio);
		comboBoxDireccion.removeAllItems();
		comboBoxTipo.removeAllItems();
		String elemento = String.valueOf(TipoDireccion.CALLE);
		this.comboBoxDireccion.addItem(elemento);
		elemento = String.valueOf(TipoDireccion.CARRERA);
		this.comboBoxDireccion.addItem(elemento);
		elemento = String.valueOf(TipoServicio.DOMICILIO);
		this.comboBoxTipo.addItem(elemento);
		elemento = String.valueOf(TipoServicio.EMERGENCIA);
		this.comboBoxTipo.addItem(elemento);
		elemento = String.valueOf(TipoServicio.URGENCIA);
		this.comboBoxTipo.addItem(elemento);
	}

	private void registrarServicio(ActionEvent e) {
		int calle;
		int carrera;
		long codigoServicio;
		String paciente = this.paciente.getText();
		String tipoServicio = (String) this.comboBoxTipo.getSelectedItem();
		String telefono = this.telefono.getText();
		String tipoDireccion = (String) this.comboBoxDireccion.getSelectedItem();
		calle = Integer.parseInt(this.calleServicio.getText());
		carrera = Integer.parseInt(this.carreraServicio.getText());
		int numero = Integer.parseInt(this.numeroServicio.getText());
		if ((tipoServicio.equals("URGENCIA") || tipoServicio.equals("EMERGENCIA") || tipoServicio.equals("DOMICILIO"))
				&& (tipoDireccion.equals("CALLE") || tipoDireccion.equals("CARRERA"))) {
			if (tipoServicio.equals("URGENCIA")) {
				if (tipoDireccion.equals("CALLE")) {
					codigoServicio = empresaAmbulancias.registrarServicio(paciente, TipoServicio.URGENCIA, telefono,
							TipoDireccion.CALLE, calle, carrera, numero);
					JOptionPane.showMessageDialog(null,
							"El nuevo Servicio tiene codigo: " + String.valueOf(codigoServicio));
				} else {
					codigoServicio = empresaAmbulancias.registrarServicio(paciente, TipoServicio.URGENCIA, telefono,
							TipoDireccion.CARRERA, calle, carrera, numero);
					JOptionPane.showMessageDialog(null,
							"El nuevo Servicio tiene codigo: " + String.valueOf(codigoServicio));
				}
			} else if (tipoServicio.equals("EMERGENCIA")) {
				if (tipoDireccion.equals("CALLE")) {
					codigoServicio = empresaAmbulancias.registrarServicio(paciente, TipoServicio.URGENCIA, telefono,
							TipoDireccion.CALLE, calle, carrera, numero);
					JOptionPane.showMessageDialog(null,
							"El nuevo Servicio tiene codigo: " + String.valueOf(codigoServicio));
				} else {
					codigoServicio = empresaAmbulancias.registrarServicio(paciente, TipoServicio.URGENCIA, telefono,
							TipoDireccion.CARRERA, calle, carrera, numero);
					JOptionPane.showMessageDialog(null,
							"El nuevo Servicio tiene codigo: " + String.valueOf(codigoServicio));
				}
			} else if (tipoServicio.equals("DOMICILIO")) {
				if (tipoDireccion.equals("CALLE")) {
					codigoServicio = empresaAmbulancias.registrarServicio(paciente, TipoServicio.URGENCIA, telefono,
							TipoDireccion.CALLE, calle, carrera, numero);
					JOptionPane.showMessageDialog(null,
							"El nuevo Servicio tiene codigo: " + String.valueOf(codigoServicio));
				} else {
					codigoServicio = empresaAmbulancias.registrarServicio(paciente, TipoServicio.URGENCIA, telefono,
							TipoDireccion.CARRERA, calle, carrera, numero);
					JOptionPane.showMessageDialog(null,
							"El nuevo Servicio tiene codigo: " + String.valueOf(codigoServicio));
				}
			}
		} else
			JOptionPane.showMessageDialog(null, "Fallo en el registro del servicio");
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	private void regresar(ActionEvent e) {
		this.getTabbedPane().setSelectedIndex(this.menuServicios);
	}

	private void irRegistrarPosicion(ActionEvent e) {
		this.getTabbedPane().setSelectedIndex(this.registrarPosicion);
		if (!empresaAmbulancias.getAmbulancias().isEmpty()) {
			filaDatosAmbulancias = new Vector();
			Set<Integer> llaves = empresaAmbulancias.getAmbulancias().keySet();
			List<Integer> orLlaves = new ArrayList<Integer>(llaves);
			Collections.sort(orLlaves, new CodigoComparator());
			llenarFilasAmbulancias(orLlaves, filaDatosAmbulancias);
			tablaAmbulancias = new JTable(filaDatosAmbulancias, nombreColumAmbulanciasV);
			scrollPane.setViewportView(getTablaAmbulancias());
		}
	}

	/**
	 * 
	 */
	private void registrarPosicionActual(ActionEvent e) {
		int indexFilaSeleccionada = tablaAmbulancias.getSelectedRow();
		if (indexFilaSeleccionada != -1) {
			TableModel model = tablaAmbulancias.getModel();
			int codigo = (Integer) model.getValueAt(indexFilaSeleccionada, 0);
			String nuevaCalleS = this.calle.getText();
			String nuevaCarreraS = this.carrera.getText();
			if (nuevaCalleS.length() != 0 && nuevaCarreraS.length() != 0) {
				int nuevaCalle = Integer.parseInt(nuevaCalleS);
				int nuevaCarrera = Integer.parseInt(nuevaCarreraS);
				if (empresaAmbulancias.registrarPosicionAmbulancia(codigo, nuevaCalle, nuevaCarrera)) {
					Vector fila = (Vector) filaDatosAmbulancias.get(indexFilaSeleccionada);
					fila.set(5, Utils.convertirFechaHoraString(
							empresaAmbulancias.getAmbulancias().get(codigo).getHoraPosicion()));
					fila.set(6, nuevaCalle);
					fila.set(7, nuevaCarrera);

					tablaAmbulancias = new JTable(filaDatosAmbulancias, nombreColumAmbulanciasV);
					scrollPane.setViewportView(getTablaAmbulancias());
				}
				this.calle.setText(null);
				this.carrera.setText(null);
			} else {
				JOptionPane.showMessageDialog(this, "No se ha escrito la calle o la carrera", "Escritura de datos",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "No se ha seleccionado una Ambulancia", "Seleccion de ambulancia",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void irAsignarServicio(ActionEvent e) {
		this.getTabbedPane().setSelectedIndex(this.asignarServicio);
		if (!empresaAmbulancias.getAmbulancias().isEmpty()) {
			filaDatosAmbulancias3V = new Vector();
			Set<Integer> llaves = empresaAmbulancias.getAmbulancias().keySet();
			List<Integer> orLlaves = new ArrayList<Integer>(llaves);
			Collections.sort(orLlaves, new CodigoComparator());
			llenarFilasAmbulancias(orLlaves, filaDatosAmbulancias3V);
			// refrescar el Jtable dentro del JScrollPane
			tablaAmbulancias3 = new JTable(filaDatosAmbulancias3V, nombreColumAmbulancias3V);
			scrollPane_8.setViewportView(getTablaAmbulancias3());
		}
		if (!empresaAmbulancias.getLasIPS().isEmpty()) {
			filaDatosIPS = new Vector();
			Set<String> llaves = empresaAmbulancias.getLasIPS().keySet();
			List<String> orLlaves = new ArrayList<String>(llaves);
			Collections.sort(orLlaves);
			for (String llave : orLlaves) {
				IPS ips = empresaAmbulancias.getLasIPS().get(llave);
				Vector fila = new Vector();
				fila.add(ips.getNombre());
				fila.add(ips.getTipoAtencion());
				fila.add(ips.getDireccion());
				filaDatosIPS.add(fila);
			}
			tablaIPS = new JTable(filaDatosIPS, nombreColumIPSV);
			scrollPane_7.setViewportView(getTablaIPS());
		}
		if (!empresaAmbulancias.getServicios().isEmpty()) {
			filaDatosServicios3 = new Vector();
			List<Servicio> items = empresaAmbulancias.getServicios();
			llenarFilasServicio(items, filaDatosServicios3);
			tablaServicios3 = new JTable(filaDatosServicios3, nombreColumServiciosV3);
			scrollPane_6.setViewportView(getTablaServicios3());
		}
	}

	/**
	 * @param orLlaves
	 */
	private void llenarFilasAmbulancias(List<Integer> orLlaves, Vector filasDatos) {
		for (Integer llave : orLlaves) {
			Ambulancia ambulancia = empresaAmbulancias.getAmbulancias().get(llave);
			Vector fila = new Vector();
			if (ambulancia instanceof AmbulanciaUCI) {
				fila.add(ambulancia.getCodigo());
				fila.add("UCI");
				fila.add(ambulancia.getPlaca());
				fila.add(((AmbulanciaUCI) ambulancia).getMedico());
				fila.add(((AmbulanciaUCI) ambulancia).getTipoUCI());
				if (ambulancia.getHoraPosicion() != null) {
					fila.add(Utils.convertirFechaHoraString(ambulancia.getHoraPosicion()));
					fila.add(ambulancia.getPosicionCalle());
					fila.add(ambulancia.getPosicionCarrera());
				}
			} else if (ambulancia instanceof AmbulanciaBasica) {
				fila.add(ambulancia.getCodigo());
				fila.add("Basica");
				fila.add(ambulancia.getPlaca());
				fila.add(((AmbulanciaBasica) ambulancia).getMedico());
				fila.add("");
				if (ambulancia.getHoraPosicion() != null) {
					fila.add(Utils.convertirFechaHoraString(ambulancia.getHoraPosicion()));
					fila.add(ambulancia.getPosicionCalle());
					fila.add(ambulancia.getPosicionCarrera());
				}
			} else if (ambulancia instanceof AmbulanciaNoMedicalizada) {
				fila.add(ambulancia.getCodigo());
				fila.add("No Medicalizada");
				fila.add(ambulancia.getPlaca());
				fila.add(((AmbulanciaNoMedicalizada) ambulancia).getEnfermero());
				fila.add("");
				if (ambulancia.getHoraPosicion() != null) {
					fila.add(Utils.convertirFechaHoraString(ambulancia.getHoraPosicion()));
					fila.add(ambulancia.getPosicionCalle());
					fila.add(ambulancia.getPosicionCarrera());
				}
			}
			// agregar fila al vector de datos del JTable:
			filasDatos.add(fila);
		}
	}

	private void irFinalizarServicio(ActionEvent e) {
		this.getTabbedPane().setSelectedIndex(this.finalizarServicio);
		filaDatosServicios = new Vector(); // obtener items de venta actual:
		List<Servicio> items = empresaAmbulancias.getServicios(); // llenar el
																	// vector de
																	// datos del
																	// JTable
																	// datosNegocio
		Collections.sort(items, new HoraSolicitudComparator());
		llenarFilasServicio(items, filaDatosServicios);
		// refrescar visualmente el JTable dentro del scroll:
		tablaServicios = new JTable(filaDatosServicios, nombreColumServiciosV);
		scrollPane_1.setViewportView(getTablaServicios());
	}

	/**
	 * @param items
	 */
	private void llenarFilasServicio(List<Servicio> items, Vector filasDatos) {
		for (Servicio servicio : items) {
			Vector fila = new Vector();
			fila.add(servicio.getCodigo());
			fila.add(Utils.convertirFechaHoraString(servicio.getHoraSolicitud()));
			fila.add(servicio.getPaciente());
			fila.add(servicio.getTipoServicio());
			fila.add(servicio.getTelefono());
			fila.add(servicio.getDireccion().toString());
			fila.add(servicio.getEstado().toString());
			if (servicio.getIps() != null)
				fila.add(servicio.getIps().getNombre());
			else
				fila.add("");
			if (servicio.getAmbulancia() != null)
				fila.add(servicio.getAmbulancia().getCodigo());
			else
				fila.add("");
			filasDatos.add(fila);
		}
	}

	private void irReporteServicios(ActionEvent e) {
		this.getTabbedPane().setSelectedIndex(this.reporteServicios);
		filaDatosServicios1 = new Vector(); // obtener items de venta actual:
		int indexVentaActual = empresaAmbulancias.getServicios().size() - 1;
		List<Servicio> items = empresaAmbulancias.getServicios(); // llenar el
																	// vector de
																	// datos del
																	// JTable
																	// datosNegocio
		Collections.sort(items, new HoraSolicitudComparator());
		llenarFilasServicio(items, filaDatosServicios1);
		// refrescar visualmente el JTable dentro del scroll:
		tablaServicios1 = new JTable(filaDatosServicios1, nombreColumServiciosV1);
		scrollPane_2.setViewportView(getTablaServicios1());
	}

	private void irReporteIPS(ActionEvent e) {
		this.getTabbedPane().setSelectedIndex(this.reporteIPS);
		comboBoxIPS.removeAllItems();
		Set<String> llaves1 = empresaAmbulancias.getLasIPS().keySet();
		List<String> llaves = new ArrayList<String>(llaves1);
		for (String llave : llaves) {
			IPS ips = empresaAmbulancias.getLasIPS().get(llave);
			String item = ips.getNombre() + "-" + ips.getDireccion().toString();
			comboBoxIPS.addItem(item);
		}
	}

	private void irIngresarIPSAmbulancias(ActionEvent arg0) {
		this.getTabbedPane().setSelectedIndex(this.ingresarIPSAmbulancias);
	}

	private void seleccionarIPS(ActionEvent e) throws PersistenceException {
		// muestra otra ventana proponiendo directorio ./data:
		JFileChooser chooser = new JFileChooser("./");
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// captura selección del usuario
			String pathArchivo = chooser.getSelectedFile().getParent();
			String nombreArchivo = chooser.getSelectedFile().getName();
			try { // cargar el archivo como ObjectInputStream
				ManejoArchivos.cargarLasIPS(empresaAmbulancias, pathArchivo, nombreArchivo);
				JOptionPane.showMessageDialog(this, "IPS cargadas con exito", "Informacion",
						JOptionPane.WARNING_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(), "problema archivo", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void seleccionarAmbulancias(ActionEvent arg0) throws PersistenceException {
		// muestra otra ventana proponiendo directorio ./data:
		JFileChooser chooser = new JFileChooser("./");
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// captura selección del usuario
			String pathArchivo = chooser.getSelectedFile().getParent();
			String nombreArchivo = chooser.getSelectedFile().getName();
			try { // cargar el archivo como ObjectInputStream
				ManejoArchivos.cargarLasAmbulancias(empresaAmbulancias, pathArchivo, nombreArchivo);
				JOptionPane.showMessageDialog(this, "Ambulancias cargadas con exito", "Informacion",
						JOptionPane.WARNING_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(), "problema archivo", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTable getTablaAmbulancias() {
		if (tablaAmbulancias == null) {
			filaDatosAmbulancias = new Vector();
			nombreColumAmbulanciasV = new Vector(Arrays.asList(this.nombreColumAmbulancias));
			tablaAmbulancias = new JTable(filaDatosAmbulancias, nombreColumAmbulanciasV);
		}
		return tablaAmbulancias;

	}

	public JScrollPane getScrollPane_1() {
		return scrollPane_1;
	}

	public JTable getTablaServicios() {
		if (tablaServicios == null) {
			filaDatosServicios = new Vector();
			nombreColumServiciosV = new Vector(Arrays.asList(this.nombreColumServicios));
			tablaServicios = new JTable(filaDatosServicios, nombreColumServiciosV);
		}
		return tablaServicios;
	}

	public JScrollPane getScrollPane_5() {
		return scrollPane_5;
	}

	public JTable getTablaServicios2() {
		if (tablaServicios2 == null) {
			filaDatosServicios2 = new Vector();
			nombreColumServiciosV2 = new Vector(Arrays.asList(this.nombreColumServicios2));
			tablaServicios2 = new JTable(filaDatosServicios2, nombreColumServiciosV2);
		}
		return tablaServicios2;
	}

	public JComboBox getComboBoxIPS() {
		return comboBoxIPS;
	}

	public JScrollPane getScrollPane_2() {
		return scrollPane_2;
	}

	public JTable getTablaServicios1() {
		if (tablaServicios1 == null) {
			filaDatosServicios1 = new Vector();
			nombreColumServiciosV1 = new Vector(Arrays.asList(this.nombreColumServicios1));
			tablaServicios1 = new JTable(filaDatosServicios1, nombreColumServiciosV1);
		}
		return tablaServicios1;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public JScrollPane getScrollPane_6() {
		return scrollPane_6;
	}

	public JTable getTablaServicios3() {
		if (tablaServicios3 == null) {
			filaDatosServicios3 = new Vector();
			nombreColumServiciosV3 = new Vector(Arrays.asList(this.nombreColumServicios3));
			tablaServicios3 = new JTable(filaDatosServicios3, nombreColumServiciosV3);
		}
		return tablaServicios3;
	}

	public JScrollPane getScrollPane_7() {
		return scrollPane_7;
	}

	public JTable getTablaIPS() {
		if (tablaIPS == null) {
			filaDatosIPS = new Vector();
			nombreColumIPSV = new Vector(Arrays.asList(this.nombreColumIPS));
			tablaIPS = new JTable(filaDatosIPS, nombreColumIPSV);
			tablaIPS.setEnabled(false);
			tablaIPS.setRowSelectionAllowed(false);
		}
		return tablaIPS;
	}

	public JScrollPane getScrollPane_8() {
		return scrollPane_8;
	}

	public JTable getTablaAmbulancias3() {
		if (tablaAmbulancias3 == null) {
			filaDatosAmbulancias3V = new Vector();
			nombreColumAmbulancias3V = new Vector(Arrays.asList(this.nombreColumAmbulancias3));
			tablaAmbulancias3 = new JTable(filaDatosAmbulancias3V, nombreColumAmbulancias3V);
			tablaAmbulancias3.setEnabled(false);
		}
		return tablaAmbulancias3;
	}

	private void guardarArchivo(ActionEvent e) {
		// muestra otra ventana proponiendo directorio ./data:
		JFileChooser chooser = new JFileChooser("./data");
		int returnVal = chooser.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// captura selección del usuario:
			String pathArchivo = chooser.getSelectedFile().getParent();
			String nombreArchivo = chooser.getSelectedFile().getName();
			try { // guardar el archivo como ObjectOutputStream
				ManejoArchivos.guardarDatos(this.empresaAmbulancias, pathArchivo, nombreArchivo);
				JOptionPane.showMessageDialog(this, "Sistema guardado con exito", "Informacion",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(), "problema archivo ", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void cargarDatos(ActionEvent e) {
		// muestra otra ventana proponiendo directorio ./data:
		JFileChooser chooser = new JFileChooser("./data");
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// captura selección del usuario
			String pathArchivo = chooser.getSelectedFile().getParent();
			String nombreArchivo = chooser.getSelectedFile().getName();
			try { // cargar el archivo como ObjectInputStream
				empresaAmbulancias = ManejoArchivos.cargarDatos(pathArchivo, nombreArchivo);
				JOptionPane.showMessageDialog(this, "Sistema cargado con exito", "Informacion",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(), "problema archivo", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void finalizarServicio(ActionEvent e) {
		int indexFilaSeleccionada = tablaServicios.getSelectedRow();
		TableModel model = tablaServicios.getModel();
		long codigo = (long) model.getValueAt(indexFilaSeleccionada, 0);
		if (empresaAmbulancias.finalizarServicio(codigo)) {
			Vector fila = (Vector) filaDatosServicios.get(indexFilaSeleccionada);
			fila.set(6, EstadoServicio.FINALIZADO);
			tablaServicios = new JTable(filaDatosServicios, nombreColumServiciosV);
			scrollPane_1.setViewportView(getTablaServicios());
		} else {
			JOptionPane.showMessageDialog(this, "No pudo ser finalizado el servicio exitosamente", "fallo finalizacion",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void asignarServicio(ActionEvent e) {
		int indexFilaSeleccionada = tablaServicios3.getSelectedRow();
		TableModel model = tablaServicios3.getModel();
		long codigo = (long) model.getValueAt(indexFilaSeleccionada, 0);
		Servicio servicio = ((EmpresaAmbulancias) empresaAmbulancias).buscarServicio(codigo);
		if (empresaAmbulancias.asignarServicio(codigo)) {
			Vector fila = (Vector) filaDatosServicios3.get(indexFilaSeleccionada);
			fila.set(6, EstadoServicio.ASIGNADO);
			if (servicio.getTipoServicio() != TipoServicio.DOMICILIO)
				fila.set(7, servicio.getIps().getNombre());
			fila.set(8, servicio.getAmbulancia().getCodigo());
			tablaServicios3 = new JTable(filaDatosServicios3, nombreColumServiciosV3);
			scrollPane_6.setViewportView(getTablaServicios3());
		} else {
			JOptionPane.showMessageDialog(this, "No pudo ser finalizado el servicio exitosamente", "fallo finalizacion",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void mostrarIpsAmbulancia(ActionEvent e) {
		int indexFilaSeleccionada = tablaServicios.getSelectedRow();
		TableModel model = tablaServicios.getModel();
		int codigo = (int) model.getValueAt(indexFilaSeleccionada, 0);
		Servicio servicio = ((EmpresaAmbulancias) empresaAmbulancias).buscarServicio(codigo);
		if (servicio.getEstado() == EstadoServicio.ASIGNADO || servicio.getEstado() == EstadoServicio.FINALIZADO) {
			codigoAmbulancia.setText(String.valueOf(servicio.getAmbulancia().getCodigo()));
			horaAmbulancia.setText(Utils.convertirFechaHoraString(servicio.getAmbulancia().getHoraPosicion()));
			carreraAmbulancia.setText(String.valueOf(servicio.getAmbulancia().getPosicionCarrera()));
			calleAmbulancia.setText(String.valueOf(servicio.getAmbulancia().getPosicionCalle()));
			tarifaAmbulancia.setText(String.valueOf(servicio.getAmbulancia().calcularTarifa()));
			placaAmbulancia.setText(servicio.getAmbulancia().getPlaca());
			nombreIPS.setText(servicio.getIps().getNombre());
			DireccionIPS.setText(servicio.getIps().getDireccion().toString());
			tipoAtencionIPS.setText(servicio.getIps().getTipoAtencion());
			if (servicio.getAmbulancia() instanceof AmbulanciaBasica) {
				tipoAmbulancia.setText("BASICA");
				tipoUCIAmbulancia.setText("");
				medicoAmbulancia.setText("");
			}
			if (servicio.getAmbulancia() instanceof AmbulanciaUCI) {
				tipoAmbulancia.setText("UCI");
				tipoUCIAmbulancia.setText(((AmbulanciaUCI) servicio.getAmbulancia()).getTipoUCI().toString());
				medicoAmbulancia.setText(((AmbulanciaMedicalizada) servicio.getAmbulancia()).getMedico());
			}
			if (servicio.getAmbulancia() instanceof AmbulanciaNoMedicalizada) {
				tipoAmbulancia.setText("NO MEDICALIZADA");
				tipoUCIAmbulancia.setText("");
				medicoAmbulancia.setText(((AmbulanciaMedicalizada) servicio.getAmbulancia()).getMedico());
			}
		}
	}

	public JTextField getCarreraAmbulancia() {
		return carreraAmbulancia;
	}

	public JTextField getTipoAmbulancia() {
		return tipoAmbulancia;
	}

	public JTextField getMedicoAmbulancia() {
		return medicoAmbulancia;
	}

	public JTextField getPlacaAmbulancia() {
		return placaAmbulancia;
	}

	public JTextField getTarifaAmbulancia() {
		return tarifaAmbulancia;
	}

	public JTextField getNombreIPS() {
		return nombreIPS;
	}

	public JTextField getHoraAmbulancia() {
		return horaAmbulancia;
	}

	public JTextField getDireccionIPS() {
		return DireccionIPS;
	}

	public JTextField getCodigoAmbulancia() {
		return codigoAmbulancia;
	}

	public JTextField getCalleAmbulancia() {
		return calleAmbulancia;
	}

	public JTextField getTipoAtencionIPS() {
		return tipoAtencionIPS;
	}

	public JTextField getTipoUCIAmbulancia() {
		return tipoUCIAmbulancia;
	}
}

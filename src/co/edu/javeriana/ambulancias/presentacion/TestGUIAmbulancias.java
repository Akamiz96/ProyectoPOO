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
import java.util.StringTokenizer;
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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

/**
 * Clase para la Interfaz Grafica del sistema
 * 
 * @author Pablo Ariza y Alejandro Castro
 * 
 */
public class TestGUIAmbulancias extends JFrame {

	/**
	 * Atributo que indica el tab en cual se encuentra el menu de servicios
	 */
	private final static int menuServicios = 0;
	/**
	 * Atributo que indica el tab en cual se encuentra Registrar la posicion de
	 * la ambulancia
	 */
	private final static int registrarPosicion = 2;
	/**
	 * Atributo que indica el tab en cual se encuentra Registrar un servicio
	 */
	private final static int registrarServicio = 4;
	/**
	 * Atributo que indica el tab en cual se encuentra Asignar un servicio
	 */
	private final static int asignarServicio = 7;
	/**
	 * Atributo que indica el tab en cual se encuentra Finalizar un servicio
	 */
	private final static int finalizarServicio = 3;
	/**
	 * Atributo que indica el tab en cual se encuentra Reporte de Servicios con
	 * IPS y Ambulancias asociados
	 */
	private final static int reporteServicios = 6;
	/**
	 * Atributo que indica el tab en cual se encuentra Reporte de IPS con
	 * Servicios Asociados
	 */
	private final static int reporteIPS = 8;
	/**
	 * Atributo que indica el tab en cual se encuentra Ingresar IPS y
	 * Ambulancias
	 */
	private final static int ingresarIPSAmbulancias = 1;
	/**
	 * Atributo que indica el tab en cual se encuentra Reporte de IPS con
	 * Servicios Asociados
	 */
	private final static int reporteServiciosFinalizados = 5;
	/**
	 * Nombres de los encabezados para registrar la posicion de una ambulancia
	 */
	private String[] nombreColumAmbulancias = { "codigo", "tipo", "placa", "medico/enfermero", "tipo UCI",
			"hora posicion", "calle", "carrera" };
	/**
	 * Nombres de los encabezados para registrar la posicion de una ambulancia
	 */
	private Vector nombreColumAmbulanciasV;
	/**
	 * Vector de vectores de datos para registrar la posicion de una ambulancia
	 */
	private Vector filaDatosAmbulancias;
	/**
	 * Nombres de los encabezados para finalizar un servicio
	 */
	private String[] nombreColumServicios = { "codigo", "hora sol.", "paciente", "tipo servicio", "telefono",
			"direccion", "estado", "IPS", "ambul." };
	/**
	 * Nombres de los encabezados para finalizar un servicio
	 */
	private Vector nombreColumServiciosV;
	/**
	 * Vector de vectores de datos para finalizar un servicio
	 */
	private Vector filaDatosServicios;
	/**
	 * Nombres de los encabezados para reporte Servicios con IPS y Ambulancias
	 * asignados
	 */
	private String[] nombreColumServicios1 = { "codigo", "hora sol.", "paciente", "tipo servicio", "telefono",
			"direccion", "estado", "valor" };
	/**
	 * Nombres de los encabezados para reporte Servicios con IPS y Ambulancias
	 * asignados
	 */
	private Vector nombreColumServiciosV1;
	/**
	 * Vector de vectores de datos para reporte Servicios con IPS y Ambulancias
	 * asignados
	 */
	private Vector filaDatosServicios1;
	/**
	 * Nombres de los encabezados para reporte IPS con servicios asociados
	 */
	private String[] nombreColumServicios2 = { "codigo", "hora sol.", "paciente", "tipo servicio", "telefono",
			"direccion", "estado", "IPS", "ambul." };
	/**
	 * Nombres de los encabezados para reporte IPS con servicios asociados
	 */
	private Vector nombreColumServiciosV2;
	/**
	 * Vector de vectores de datos para reporte IPS con servicios asociados
	 */
	private Vector filaDatosServicios2;
	/**
	 * Nombres de los encabezados para Asignar un Servicio a una IPS y a una
	 * Ambulancia
	 */
	private String[] nombreColumServicios3 = { "codigo", "hora sol.", "paciente", "tipo servicio", "telefono",
			"direccion", "estado", "IPS", "ambul." };
	/**
	 * Nombres de los encabezados para Asignar un Servicio a una IPS y a una
	 * Ambulancia
	 */
	private Vector nombreColumServiciosV3;
	/**
	 * Vector de vectores de datos para Asignar un Servicio a una IPS y a una
	 * Ambulancia
	 */
	private Vector filaDatosServicios3;
	/**
	 * Nombres de los encabezados para Asignar un Servicio a una IPS y a una
	 * Ambulancia
	 */
	private String[] nombreColumIPS = { "nombre", "tipo de atencion", "direccion" };
	/**
	 * Nombres de los encabezados para Asignar un Servicio a una IPS y a una
	 * Ambulancia
	 */
	private Vector nombreColumIPSV;
	/**
	 * Vector de vectores de datos para Asignar un Servicio a una IPS y a una
	 * Ambulancia
	 */
	private Vector filaDatosIPS;
	/**
	 * Nombres de los encabezados para reporte Servicios con IPS y Ambulancias
	 * asignados
	 */
	private String[] nombreColumAmbulancias3 = { "codigo", "tipo", "placa", "medico/enfermero", "Tipo UCI",
			"hora posicion", "calle", "carrera" };
	/**
	 * Nombres de los encabezados para reporte Servicios con IPS y Ambulancias
	 * asignados
	 */
	private Vector nombreColumAmbulancias3V;
	/**
	 * Vector de vectores de datos para reporte Servicios con IPS y Ambulancias
	 * asignados
	 */
	private Vector filaDatosAmbulancias3V;
	/**
	 * Nombres de los encabezados para Reporte del valor de servicios
	 * finalizados
	 */
	private String[] nombreColumServicios4 = { "codigo", "hora sol.", "paciente", "tipo servicio", "telefono",
			"direccion", "estado", "valor" };
	/**
	 * Nombres de los encabezados para Reporte del valor de servicios
	 * finalizados
	 */
	private Vector nombreColumServiciosV4;
	/**
	 * Vector de vectores de datos para Reporte del valor de servicios
	 * finalizados
	 */
	private Vector filaDatosServicios4;
	/**
	 * Atributo EmpresaAmbulancias que representa el sistema.
	 */
	private IServiciosAmbulancias empresaAmbulancias = new EmpresaAmbulancias("AAA");
	/**
	 * Panel en el cual se encuentran todas las ventanas. (Tabs)
	 */
	private JPanel contentPane;
	/**
	 * TextField donde se escribe la calle para registrar la calle de una
	 * ambulancia
	 */
	private JTextField calle;
	/**
	 * TextField donde se escribe la carrera para registrar la carrera de una
	 * ambulancia
	 */
	private JTextField carrera;
	/**
	 * TextField donde se escribe el nombre del paciente para registrar un
	 * paciente
	 */
	private JTextField paciente;
	/**
	 * TextField donde se escribe el numero para registrar un paciente
	 */
	private JTextField telefono;
	/**
	 * TextField donde se escribe la calle para registrar un paciente
	 */
	private JTextField calleServicio;
	/**
	 * TextField donde se escribe la carrera para registrar un paciente
	 */
	private JTextField carreraServicio;
	/**
	 * TextField donde se escribe el numero para registrar un paciente
	 */
	private JTextField numeroServicio;
	/**
	 * Combobox para el tipo de servicio a registrar
	 * 
	 * @see TipoServicio
	 */
	private JComboBox comboBoxTipo;
	/**
	 * Combobox para el tipo de direccion a registrar
	 * 
	 * @see TipoDireccion
	 */
	private JComboBox comboBoxDireccion;
	/**
	 * Tab de servicios
	 */
	private JTabbedPane tabbedPane;
	/**
	 * Tabla de ambulancias para registrar su posicion actual
	 */
	private JTable tablaAmbulancias;
	/**
	 * Tabla de servicios para Finalizar un servicio
	 */
	private JTable tablaServicios;
	/**
	 * Tabla de servicios para Reporte de servicios con IPS Y ambulancia
	 * asignados
	 */
	private JTable tablaServicios1;
	/**
	 * Tabla de servicios para Reporte de IPS con servicios Asociados
	 */
	private JTable tablaServicios2;
	/**
	 * Tabla de servicios para Asignar un servicio
	 */
	private JTable tablaServicios3;
	/**
	 * Tabla de IPS para Asignar un servicio
	 */
	private JTable tablaIPS;
	/**
	 * Tabla de ambulancias para asignar un servicio
	 */
	private JTable tablaAmbulancias3;
	/**
	 * Boton para regresar al menu principal
	 */
	private JButton btnRegresar_5;
	/**
	 * Boton para regresar al menu principal
	 */
	private JButton btnRegresar_4;
	/**
	 * Boton para regresar al menu principal
	 */
	private JButton btnRegresar_3;
	/**
	 * Boton para regresar al menu principal
	 */
	private JButton btnRegresar_6;
	/**
	 * Boton para regresar al menu principal
	 */
	private JButton btnRegresar_1;
	/**
	 * Boton para regresar al menu principal
	 */
	private JButton btnRegresar;
	/**
	 * Boton del menu principal para actualizar la posicion de una ambulancia
	 */
	private JButton btnRegistrarLaPosicion;
	/**
	 * scrollPane donde se inserta una tabla
	 */
	private JScrollPane scrollPane;
	/**
	 * scrollPane donde se inserta una tabla
	 */
	private JScrollPane scrollPane_1;
	/**
	 * scrollPane donde se inserta una tabla
	 */
	private JScrollPane scrollPane_5;
	/**
	 * Combobox del reporte de IPS con servicios asociados en donde van las IPS
	 */
	private JComboBox comboBoxIPS;
	/**
	 * scrollPane donde se inserta una tabla
	 */
	private JScrollPane scrollPane_2;
	/**
	 * Boton para actualizar la posicion de una ambulancia
	 */
	private JButton btnActualizar;
	/**
	 * scrollPane donde se inserta una tabla
	 */
	private JScrollPane scrollPane_6;
	/**
	 * scrollPane donde se inserta una tabla
	 */
	private JScrollPane scrollPane_7;
	/**
	 * scrollPane donde se inserta una tabla
	 */
	private JScrollPane scrollPane_8;
	/**
	 * Campo par registrar el nombre de la IPS (Reporte Servicios)(TITULO)
	 */
	private JTextField txtNombre;
	/**
	 * Campo par registrar el tipo de atencion de la IPS (Reporte Servicios)
	 * (TITULO)
	 */
	private JTextField txtTipoAtencion;
	/**
	 * Campo par registrar la direccion de la IPS (Reporte Servicios)(TITULO)
	 */
	private JTextField txtDireccion;
	/**
	 * Campo par registrar el codigo de la ambulancia (Reporte
	 * Servicios)(TITULO)
	 */
	private JTextField txtCodigo;
	/**
	 * Campo par registrar el tipo de la ambulancia (Reporte Servicios)(TITULO)
	 */
	private JTextField txtTipo;
	/**
	 * Campo par registrar la placa de la ambulancia (Reporte Servicios)(TITULO)
	 */
	private JTextField txtPlaca;
	/**
	 * Campo par registrar el nombre del enfermero/medico de la ambulancia
	 * (Reporte Servicios)(TITULO)
	 */
	private JTextField txtMedicoEnfermero;
	/**
	 * Campo par registrar la hora de registro de la Ambulancia (Reporte
	 * Servicios)(TITULO)
	 */
	private JTextField txtHoraSolicitud;
	/**
	 * Campo par registrar la calle de la ambulancia (Reporte Servicios)(TITULO)
	 */
	private JTextField txtCalle;
	/**
	 * Campo par registrar la carrera de la ambulancia (Reporte
	 * Servicios)(TITULO)
	 */
	private JTextField txtCarrera;
	/**
	 * Campo par registrar la tarifa del servicio (Reporte Servicios)(TITULO)
	 */
	private JTextField txtTarifa;
	/**
	 * Campo par registrar el nombre de la IPS (Reporte Servicios)
	 */
	private JTextField nombreIPS;
	/**
	 * Campo par registrar el Tipo de atencion de la IPS (Reporte Servicios)
	 */
	private JTextField tipoAtencionIPS;
	/**
	 * Campo par registrar la direccion de la IPS (Reporte Servicios)
	 */
	private JTextField DireccionIPS;
	/**
	 * Campo par registrar el codigo de la Ambulancia (Reporte Servicios)
	 */
	private JTextField codigoAmbulancia;
	/**
	 * Campo par registrar el tipo de la ambulancia asignada (Reporte Servicios)
	 */
	private JTextField tipoAmbulancia;
	/**
	 * Campo par registrar la placa de la Ambulancia (Reporte Servicios)
	 */
	private JTextField placaAmbulancia;
	/**
	 * Campo par registrar el nombre del medico de la Ambulancia (Reporte
	 * Servicios)
	 */
	private JTextField medicoAmbulancia;
	/**
	 * Campo par registrar la hora de registro de la posicion de la ambulancia
	 * (Reporte Servicios)
	 */
	private JTextField horaAmbulancia;
	/**
	 * Campo par registrar la calle de la ambulancia (Reporte Servicios)
	 */
	private JTextField calleAmbulancia;
	/**
	 * Campo par registrar la carrera de la ambulancia (Reporte Servicios)
	 */
	private JTextField carreraAmbulancia;
	/**
	 * Campo par registrar la tarifa de la ambulancia (Reporte Servicios)
	 */
	private JTextField tarifaAmbulancia;
	/**
	 * Campo par registrar el tipo UCI de la ambulancia (Reporte
	 * Servicios)(TITULO)
	 */
	private JTextField txtTipoUci;
	/**
	 * Campo par registrar el tipo UCI de la ambulancia (Reporte Servicios)
	 */
	private JTextField tipoUCIAmbulancia;
	/**
	 * Menu auxiliar para la parte superior de la ventana
	 */
	private JMenuBar menuBar;
	private JTextField domicilio;
	private JTextField emergencia;
	private JTextField urgencia;
	private JTable tablaServicios4;
	private JTextField total;
	private JScrollPane scrollPane_3;

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
	 * Creador de la interfaz grafica
	 */
	public TestGUIAmbulancias() {
		setResizable(false);
		setFont(new Font("Brush Script Std", Font.PLAIN, 37));
		setTitle("Sis-Salud");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TestGUIAmbulancias.class.getResource("/Images/Icono Salud.jpg")));
		setForeground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 964, 617);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenuItem mntmMenuPrincipal = new JMenuItem("Menu Principal");
		mntmMenuPrincipal.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/kmenuedit_opt.png")));
		mntmMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irMenuPrincipal(e);
			}
		});
		mnMenu.add(mntmMenuPrincipal);

		JMenu mnCargarsalvarSistema = new JMenu("Cargar/Salvar Sistema");
		menuBar.add(mnCargarsalvarSistema);

		JMenuItem mntmCargarDatosDel = new JMenuItem("Cargar datos del sistema");
		mntmCargarDatosDel.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/Load Icon.png")));
		mntmCargarDatosDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatos(e);
			}
		});
		mnCargarsalvarSistema.add(mntmCargarDatosDel);

		JMenuItem mntmSalvarDatosDel = new JMenuItem("Salvar datos del sistema");
		mntmSalvarDatosDel.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/Guardar Icon_opt.png")));
		mntmSalvarDatosDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarArchivo(e);
			}
		});
		mnCargarsalvarSistema.add(mntmSalvarDatosDel);

		JMenu mnIngresarIpsY = new JMenu("Ingresar IPS y ambulancias");
		menuBar.add(mnIngresarIpsY);

		JMenuItem mntmIngresarIpsY = new JMenuItem("Ingresar IPS y ambulancias");
		mntmIngresarIpsY.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/ambulance_icon_opt.jpg")));
		mntmIngresarIpsY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irIngresarIPSAmbulancias(e);
			}
		});
		mnIngresarIpsY.add(mntmIngresarIpsY);

		JMenu mnNewMenu = new JMenu("Registrar");
		menuBar.add(mnNewMenu);

		JMenuItem mntmPosicionAmbulancia = new JMenuItem("Posicion ambulancia");
		mntmPosicionAmbulancia
				.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/registrationIcon_opt.png")));
		mntmPosicionAmbulancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irRegistrarPosicion(e);
			}
		});
		mnNewMenu.add(mntmPosicionAmbulancia);

		JMenuItem mntmServicio = new JMenuItem("Servicio");
		mntmServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irRegistrarServicio(e);
			}
		});
		mntmServicio.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/registrationIcon_opt.png")));
		mnNewMenu.add(mntmServicio);

		JMenu mnServicio = new JMenu("Servicio");
		menuBar.add(mnServicio);

		JMenuItem mntmFinalizarServicio = new JMenuItem("Finalizar servicio");
		mntmFinalizarServicio
				.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/unit-completed-icon_opt.png")));
		mntmFinalizarServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irFinalizarServicio(e);
			}
		});
		mnServicio.add(mntmFinalizarServicio);

		JMenuItem mntmRegistrarServicio = new JMenuItem("Registrar servicio");
		mntmRegistrarServicio
				.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/registrationIcon_opt.png")));
		mntmRegistrarServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irRegistrarServicio(e);
			}
		});
		mnServicio.add(mntmRegistrarServicio);

		JMenuItem mntmAsignarServicio = new JMenuItem("Asignar servicio");
		mntmAsignarServicio
				.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/checked_user_opt.png")));
		mntmAsignarServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irAsignarServicio(e);
			}
		});
		mnServicio.add(mntmAsignarServicio);

		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);

		JMenuItem mntmReporteDeServicios = new JMenuItem("Reporte de servicios con IPS y ambulancias");
		mntmReporteDeServicios
				.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/report_icon_opt.jpg")));
		mntmReporteDeServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irReporteServicios(e);
			}
		});
		mnReportes.add(mntmReporteDeServicios);

		JMenuItem mntmReporteDeIps = new JMenuItem("Reporte de IPS con servicios asociados");
		mntmReporteDeIps.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/report_icon_opt.jpg")));
		mntmReporteDeIps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irReporteIPS(e);
			}
		});
		mnReportes.add(mntmReporteDeIps);
		
		JMenuItem mntmReporteDelValor = new JMenuItem("Reporte del valor de servicios finalizados");
		mntmReporteDelValor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irReporteServiciosFinalizados(e);
			}
		});
		mntmReporteDelValor.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/report_icon_opt.jpg")));
		mnReportes.add(mntmReporteDelValor);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 958, 567);
		contentPane.add(tabbedPane);

		JPanel menuServicios_1 = new JPanel();
		tabbedPane.addTab("Menu Servicios", null, menuServicios_1, null);

		btnRegistrarLaPosicion = new JButton("Registrar la posicion actual de una ambulancia");
		btnRegistrarLaPosicion
				.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/registrationIcon_opt.png")));
		btnRegistrarLaPosicion.setBounds(79, 67, 363, 55);
		btnRegistrarLaPosicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irRegistrarPosicion(e);
			}
		});
		menuServicios_1.setLayout(null);
		menuServicios_1.add(btnRegistrarLaPosicion);

		JButton btnRegistrarUnServicio = new JButton("Registrar un servicio ");
		btnRegistrarUnServicio
				.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/registrationIcon_opt.png")));
		btnRegistrarUnServicio.setBounds(79, 133, 363, 55);
		btnRegistrarUnServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarRegistroServicio(e);
			}
		});
		menuServicios_1.add(btnRegistrarUnServicio);

		JButton btnAsignarUnServicio = new JButton("Asignar a un servicio una ambulancia y una IPS");
		btnAsignarUnServicio
				.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/checked_user_opt.png")));
		btnAsignarUnServicio.setBounds(79, 200, 363, 55);
		btnAsignarUnServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irAsignarServicio(e);
			}
		});
		menuServicios_1.add(btnAsignarUnServicio);

		JButton btnFinalizarUnServicio = new JButton("Finalizar un servicio");
		btnFinalizarUnServicio
				.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/unit-completed-icon_opt.png")));
		btnFinalizarUnServicio.setBounds(471, 67, 363, 55);
		btnFinalizarUnServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irFinalizarServicio(e);
			}
		});
		menuServicios_1.add(btnFinalizarUnServicio);

		JButton btnReporteServicios = new JButton("Reporte de servicios con IPS y ambulancias asignados");
		btnReporteServicios.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/report_icon_opt.jpg")));
		btnReporteServicios.setBounds(471, 133, 363, 55);
		btnReporteServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irReporteServicios(e);
			}
		});
		menuServicios_1.add(btnReporteServicios);

		JButton btnReporteDeLa = new JButton("Reporte de la IPS con servicios asociados");
		btnReporteDeLa.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/report_icon_opt.jpg")));
		btnReporteDeLa.setBounds(471, 200, 363, 55);
		btnReporteDeLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irReporteIPS(e);
			}
		});
		menuServicios_1.add(btnReporteDeLa);

		JButton ingresarIPSAmbulancias = new JButton("<html><p>Ingresar IPS y </p><p>Ambulancias</p></html>");
		ingresarIPSAmbulancias
				.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/ambulance_icon_opt.jpg")));
		ingresarIPSAmbulancias.setBounds(150, 368, 242, 73);
		ingresarIPSAmbulancias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				irIngresarIPSAmbulancias(arg0);
			}
		});
		menuServicios_1.add(ingresarIPSAmbulancias);

		JButton btnSalvarSi = new JButton("<html><p>Salvar datos del </p><p>sistema</p></html>");
		btnSalvarSi.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/Guardar Icon_opt.png")));
		btnSalvarSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarArchivo(e);
			}
		});
		btnSalvarSi.setBounds(550, 350, 225, 62);
		menuServicios_1.add(btnSalvarSi);

		JButton btnCargarDatosDel = new JButton("<html><p>Cargar datos del </p><p>sistema</p></html>");
		btnCargarDatosDel.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/Load Icon.png")));
		btnCargarDatosDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatos(e);
			}
		});
		btnCargarDatosDel.setBounds(550, 430, 225, 62);
		menuServicios_1.add(btnCargarDatosDel);

		JButton btnReporteDelValor = new JButton("Reporte del valor de servicios finalizados");
		btnReporteDelValor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irReporteServiciosFinalizados(e);
			}
		});
		btnReporteDelValor.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/report_icon_opt.jpg")));
		btnReporteDelValor.setBounds(471, 266, 363, 55);
		menuServicios_1.add(btnReporteDelValor);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/heart-health-main.jpg")));
		label.setBounds(0, 0, 953, 523);
		menuServicios_1.add(label);

		JPanel ingresarIPSyAmbulancias = new JPanel();
		tabbedPane.addTab("Ingresar IPS y Ambulancias", null, ingresarIPSyAmbulancias, null);
		ingresarIPSyAmbulancias.setLayout(null);

		JButton btnSeleccionarArchivoDe = new JButton("Seleccionar archivo de IPS");
		btnSeleccionarArchivoDe
				.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/hospital_icon_opt.jpg")));
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
		btnSeleccionarArchivoDe_1
				.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/ambulance_icon_opt.jpg")));
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
		btnRegresar.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/go-back-icon_opt.png")));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresar(e);
			}
		});
		btnRegresar.setBounds(712, 403, 200, 84);
		ingresarIPSyAmbulancias.add(btnRegresar);

		JLabel lblIngresarIpsY = new JLabel("Ingresar IPS y ambulancias");
		lblIngresarIpsY.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarIpsY.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 50));
		lblIngresarIpsY.setBounds(0, 11, 912, 52);
		ingresarIPSyAmbulancias.add(lblIngresarIpsY);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/Icono Salud.jpg")));
		label_1.setBounds(0, 0, 953, 523);
		ingresarIPSyAmbulancias.add(label_1);

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
		btnActualizar.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/Actualizar Icon.png")));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarPosicionActual(e);
			}
		});
		btnActualizar.setBounds(274, 432, 257, 72);
		btnActualizar.setFont(new Font("Script MT Bold", Font.ITALIC, 35));
		registrarPosicionAmbulancia.add(btnActualizar);

		btnRegresar_1 = new JButton("Regresar");
		btnRegresar_1.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/go-back-icon_opt.png")));
		btnRegresar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresar(e);
			}
		});
		btnRegresar_1.setBounds(739, 435, 168, 69);
		registrarPosicionAmbulancia.add(btnRegresar_1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 918, 234);
		registrarPosicionAmbulancia.add(scrollPane);

		tablaAmbulancias = getTablaAmbulancias();
		scrollPane.setViewportView(tablaAmbulancias);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/disruptive-health-care.jpg")));
		label_2.setBounds(0, 0, 953, 523);
		registrarPosicionAmbulancia.add(label_2);

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
		btnRegresar_4.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/go-back-icon_opt.png")));
		btnRegresar_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresar(e);
			}
		});
		btnRegresar_4.setBounds(750, 424, 156, 72);
		finalizarServicio.add(btnRegresar_4);

		JButton btnFinalizarServicioSeleccionado = new JButton("Finalizar servicio seleccionado");
		btnFinalizarServicioSeleccionado
				.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/unit-completed-icon_opt.png")));
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

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/disruptive-health-care.jpg")));
		label_3.setBounds(0, 0, 953, 523);
		finalizarServicio.add(label_3);

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
		btnRegistrar.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/registrationIcon_opt.png")));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarServicio(e);
			}
		});
		btnRegistrar.setBounds(763, 11, 180, 76);
		registrarServicio.add(btnRegistrar);

		JButton btnRegresar_2 = new JButton("Regresar");
		btnRegresar_2.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/go-back-icon_opt.png")));
		btnRegresar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresar(e);
			}
		});
		btnRegresar_2.setBounds(763, 409, 156, 76);
		registrarServicio.add(btnRegresar_2);

		comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(418, 138, 316, 47);
		registrarServicio.add(comboBoxTipo);

		comboBoxDireccion = new JComboBox();
		comboBoxDireccion.setBounds(418, 252, 316, 47);
		registrarServicio.add(comboBoxDireccion);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/heart-health-main.jpg")));
		label_4.setBounds(0, 0, 953, 523);
		registrarServicio.add(label_4);

		JPanel reporteValorFinalizados = new JPanel();
		tabbedPane.addTab("<html><p>Reporte del valor</p><p> de servicios finalizados</p></html>", null, reporteValorFinalizados, null);
		reporteValorFinalizados.setLayout(null);

		JLabel lblReporteDelValor = new JLabel("Reporte del valor de servicios finalizados");
		lblReporteDelValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporteDelValor.setFont(new Font("Traditional Arabic", Font.PLAIN, 36));
		lblReporteDelValor.setBounds(10, 11, 675, 54);
		reporteValorFinalizados.add(lblReporteDelValor);

		JLabel lblValorServiciosDomicilio = new JLabel("Valor servicios DOMICILIO");
		lblValorServiciosDomicilio.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorServiciosDomicilio.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		lblValorServiciosDomicilio.setBounds(196, 303, 343, 36);
		reporteValorFinalizados.add(lblValorServiciosDomicilio);

		JLabel lblValorServiciosEmergencia = new JLabel("Valor servicios EMERGENCIA");
		lblValorServiciosEmergencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorServiciosEmergencia.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		lblValorServiciosEmergencia.setBounds(196, 350, 343, 36);
		reporteValorFinalizados.add(lblValorServiciosEmergencia);

		JLabel lblValorServiciosUrgencia = new JLabel("Valor servicios URGENCIA ");
		lblValorServiciosUrgencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorServiciosUrgencia.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		lblValorServiciosUrgencia.setBounds(196, 399, 343, 36);
		reporteValorFinalizados.add(lblValorServiciosUrgencia);

		domicilio = new JTextField();
		domicilio.setEditable(false);
		domicilio.setBounds(592, 303, 127, 36);
		reporteValorFinalizados.add(domicilio);
		domicilio.setColumns(10);

		emergencia = new JTextField();
		emergencia.setEditable(false);
		emergencia.setBounds(592, 350, 127, 36);
		reporteValorFinalizados.add(emergencia);
		emergencia.setColumns(10);

		urgencia = new JTextField();
		urgencia.setEditable(false);
		urgencia.setBounds(592, 399, 127, 36);
		reporteValorFinalizados.add(urgencia);
		urgencia.setColumns(10);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 57, 933, 235);
		reporteValorFinalizados.add(scrollPane_3);

		tablaServicios4 = getTablaServicios4();
		scrollPane_3.setViewportView(tablaServicios4);

		JLabel lblGranTotal = new JLabel("Gran total");
		lblGranTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGranTotal.setFont(new Font("Haettenschweiler", Font.PLAIN, 42));
		lblGranTotal.setBounds(196, 446, 343, 36);
		reporteValorFinalizados.add(lblGranTotal);

		total = new JTextField();
		total.setEditable(false);
		total.setBounds(592, 446, 127, 36);
		reporteValorFinalizados.add(total);
		total.setColumns(10);
		
		JButton btnRegresar_7 = new JButton("Regresar");
		btnRegresar_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irMenuPrincipal(e);
			}
		});
		btnRegresar_7.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/go-back-icon_opt.png")));
		btnRegresar_7.setBounds(771, 399, 172, 83);
		reporteValorFinalizados.add(btnRegresar_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/heart-health-main.jpg")));
		label_8.setBounds(0, 0, 953, 495);
		reporteValorFinalizados.add(label_8);

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
		lblAmbulanciaAsignada.setBounds(10, 296, 293, 35);
		reporteServicios.add(lblAmbulanciaAsignada);

		btnRegresar_5 = new JButton("Regresar");
		btnRegresar_5.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/go-back-icon_opt.png")));
		btnRegresar_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regresar(arg0);
			}
		});
		btnRegresar_5.setBounds(777, 424, 156, 93);
		reporteServicios.add(btnRegresar_5);

		JButton btnMostrar = new JButton("<html><p>Mostrar </p><p>IPS y</p><p>ambulancia asignadas</p></html>");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarIpsAmbulancia(e);
			}
		});
		btnMostrar.setBounds(830, 207, 98, 124);
		reporteServicios.add(btnMostrar);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 89, 918, 112);
		reporteServicios.add(scrollPane_2);

		tablaServicios1 = getTablaServicios1();
		scrollPane_2.setViewportView(tablaServicios1);

		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		txtNombre.setEditable(false);
		txtNombre.setText("Nombre");
		txtNombre.setBounds(189, 212, 219, 30);
		reporteServicios.add(txtNombre);
		txtNombre.setColumns(10);

		txtTipoAtencion = new JTextField();
		txtTipoAtencion.setHorizontalAlignment(SwingConstants.CENTER);
		txtTipoAtencion.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		txtTipoAtencion.setEditable(false);
		txtTipoAtencion.setText("Tipo atencion");
		txtTipoAtencion.setBounds(418, 212, 223, 30);
		reporteServicios.add(txtTipoAtencion);
		txtTipoAtencion.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		txtDireccion.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		txtDireccion.setEditable(false);
		txtDireccion.setText("Direccion ");
		txtDireccion.setBounds(651, 212, 169, 30);
		reporteServicios.add(txtDireccion);
		txtDireccion.setColumns(10);

		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		txtCodigo.setEditable(false);
		txtCodigo.setText("Codigo");
		txtCodigo.setBounds(20, 342, 86, 30);
		reporteServicios.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtTipo = new JTextField();
		txtTipo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTipo.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		txtTipo.setEditable(false);
		txtTipo.setText("Tipo");
		txtTipo.setBounds(121, 342, 229, 30);
		reporteServicios.add(txtTipo);
		txtTipo.setColumns(10);

		txtPlaca = new JTextField();
		txtPlaca.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlaca.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		txtPlaca.setEditable(false);
		txtPlaca.setText("Placa");
		txtPlaca.setBounds(360, 342, 86, 30);
		reporteServicios.add(txtPlaca);
		txtPlaca.setColumns(10);

		txtMedicoEnfermero = new JTextField();
		txtMedicoEnfermero.setText("Medico\r\nEnfermero");
		txtMedicoEnfermero.setHorizontalAlignment(SwingConstants.CENTER);
		txtMedicoEnfermero.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		txtMedicoEnfermero.setEditable(false);
		txtMedicoEnfermero.setBounds(456, 342, 186, 30);
		reporteServicios.add(txtMedicoEnfermero);
		txtMedicoEnfermero.setColumns(10);

		txtHoraSolicitud = new JTextField();
		txtHoraSolicitud.setHorizontalAlignment(SwingConstants.CENTER);
		txtHoraSolicitud.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		txtHoraSolicitud.setEditable(false);
		txtHoraSolicitud.setText("Hora solicitud");
		txtHoraSolicitud.setBounds(652, 342, 168, 30);
		reporteServicios.add(txtHoraSolicitud);
		txtHoraSolicitud.setColumns(10);

		txtCalle = new JTextField();
		txtCalle.setHorizontalAlignment(SwingConstants.CENTER);
		txtCalle.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		txtCalle.setEditable(false);
		txtCalle.setText("Calle");
		txtCalle.setBounds(20, 424, 86, 30);
		reporteServicios.add(txtCalle);
		txtCalle.setColumns(10);

		txtCarrera = new JTextField();
		txtCarrera.setHorizontalAlignment(SwingConstants.CENTER);
		txtCarrera.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		txtCarrera.setEditable(false);
		txtCarrera.setText("Carrera");
		txtCarrera.setBounds(116, 424, 86, 30);
		reporteServicios.add(txtCarrera);
		txtCarrera.setColumns(10);

		txtTarifa = new JTextField();
		txtTarifa.setHorizontalAlignment(SwingConstants.CENTER);
		txtTarifa.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		txtTarifa.setEditable(false);
		txtTarifa.setText("Tarifa");
		txtTarifa.setBounds(217, 424, 86, 30);
		reporteServicios.add(txtTarifa);
		txtTarifa.setColumns(10);

		nombreIPS = new JTextField();
		nombreIPS.setHorizontalAlignment(SwingConstants.CENTER);
		nombreIPS.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		nombreIPS.setEditable(false);
		nombreIPS.setBounds(189, 255, 219, 30);
		reporteServicios.add(nombreIPS);
		nombreIPS.setColumns(10);

		tipoAtencionIPS = new JTextField();
		tipoAtencionIPS.setHorizontalAlignment(SwingConstants.CENTER);
		tipoAtencionIPS.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		tipoAtencionIPS.setEditable(false);
		tipoAtencionIPS.setBounds(418, 255, 223, 30);
		reporteServicios.add(tipoAtencionIPS);
		tipoAtencionIPS.setColumns(10);

		DireccionIPS = new JTextField();
		DireccionIPS.setHorizontalAlignment(SwingConstants.CENTER);
		DireccionIPS.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		DireccionIPS.setEditable(false);
		DireccionIPS.setBounds(651, 255, 169, 30);
		reporteServicios.add(DireccionIPS);
		DireccionIPS.setColumns(10);

		codigoAmbulancia = new JTextField();
		codigoAmbulancia.setHorizontalAlignment(SwingConstants.CENTER);
		codigoAmbulancia.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		codigoAmbulancia.setEditable(false);
		codigoAmbulancia.setBounds(20, 383, 86, 30);
		reporteServicios.add(codigoAmbulancia);
		codigoAmbulancia.setColumns(10);

		tipoAmbulancia = new JTextField();
		tipoAmbulancia.setHorizontalAlignment(SwingConstants.CENTER);
		tipoAmbulancia.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		tipoAmbulancia.setEditable(false);
		tipoAmbulancia.setBounds(121, 383, 229, 30);
		reporteServicios.add(tipoAmbulancia);
		tipoAmbulancia.setColumns(10);

		placaAmbulancia = new JTextField();
		placaAmbulancia.setHorizontalAlignment(SwingConstants.CENTER);
		placaAmbulancia.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		placaAmbulancia.setEditable(false);
		placaAmbulancia.setBounds(360, 383, 86, 30);
		reporteServicios.add(placaAmbulancia);
		placaAmbulancia.setColumns(10);

		medicoAmbulancia = new JTextField();
		medicoAmbulancia.setHorizontalAlignment(SwingConstants.CENTER);
		medicoAmbulancia.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		medicoAmbulancia.setEditable(false);
		medicoAmbulancia.setBounds(456, 383, 186, 30);
		reporteServicios.add(medicoAmbulancia);
		medicoAmbulancia.setColumns(10);

		horaAmbulancia = new JTextField();
		horaAmbulancia.setHorizontalAlignment(SwingConstants.CENTER);
		horaAmbulancia.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		horaAmbulancia.setEditable(false);
		horaAmbulancia.setBounds(652, 383, 168, 30);
		reporteServicios.add(horaAmbulancia);
		horaAmbulancia.setColumns(10);

		calleAmbulancia = new JTextField();
		calleAmbulancia.setHorizontalAlignment(SwingConstants.CENTER);
		calleAmbulancia.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		calleAmbulancia.setEditable(false);
		calleAmbulancia.setBounds(20, 465, 86, 30);
		reporteServicios.add(calleAmbulancia);
		calleAmbulancia.setColumns(10);

		carreraAmbulancia = new JTextField();
		carreraAmbulancia.setHorizontalAlignment(SwingConstants.CENTER);
		carreraAmbulancia.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		carreraAmbulancia.setEditable(false);
		carreraAmbulancia.setBounds(116, 465, 86, 30);
		reporteServicios.add(carreraAmbulancia);
		carreraAmbulancia.setColumns(10);

		tarifaAmbulancia = new JTextField();
		tarifaAmbulancia.setHorizontalAlignment(SwingConstants.CENTER);
		tarifaAmbulancia.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		tarifaAmbulancia.setEditable(false);
		tarifaAmbulancia.setBounds(217, 465, 86, 30);
		reporteServicios.add(tarifaAmbulancia);
		tarifaAmbulancia.setColumns(10);

		txtTipoUci = new JTextField();
		txtTipoUci.setHorizontalAlignment(SwingConstants.CENTER);
		txtTipoUci.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		txtTipoUci.setEditable(false);
		txtTipoUci.setText("Tipo UCI");
		txtTipoUci.setBounds(318, 424, 194, 30);
		reporteServicios.add(txtTipoUci);
		txtTipoUci.setColumns(10);

		tipoUCIAmbulancia = new JTextField();
		tipoUCIAmbulancia.setHorizontalAlignment(SwingConstants.CENTER);
		tipoUCIAmbulancia.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		tipoUCIAmbulancia.setEditable(false);
		tipoUCIAmbulancia.setBounds(318, 465, 194, 30);
		reporteServicios.add(tipoUCIAmbulancia);
		tipoUCIAmbulancia.setColumns(10);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/heart-health-main.jpg")));
		label_5.setBounds(0, 0, 953, 523);
		reporteServicios.add(label_5);

		JPanel asignarServicio = new JPanel();
		tabbedPane.addTab("Asignar un Servicio a una Ambulancia y una IPS", null, asignarServicio, null);
		asignarServicio.setLayout(null);

		JLabel lblAsignarUnServicio = new JLabel("Asignar un servicio a una ambulancia y una IPS");
		lblAsignarUnServicio.setFont(new Font("MV Boli", Font.BOLD, 33));
		lblAsignarUnServicio.setBounds(10, 0, 870, 51);
		asignarServicio.add(lblAsignarUnServicio);

		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setFont(new Font("Source Sans Pro", Font.BOLD, 31));
		lblServicios.setBounds(10, 43, 146, 31);
		asignarServicio.add(lblServicios);

		JLabel lblIps = new JLabel("IPS");
		lblIps.setFont(new Font("Source Sans Pro", Font.BOLD, 31));
		lblIps.setBounds(10, 222, 61, 31);
		asignarServicio.add(lblIps);

		JLabel lblAmbulancias_1 = new JLabel("Ambulancias");
		lblAmbulancias_1.setFont(new Font("Source Sans Pro", Font.BOLD, 31));
		lblAmbulancias_1.setBounds(10, 335, 189, 31);
		asignarServicio.add(lblAmbulancias_1);

		btnRegresar_3 = new JButton("Regresar");
		btnRegresar_3.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/go-back-icon_opt1.png")));
		btnRegresar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresar(e);
			}
		});
		btnRegresar_3.setBounds(743, 469, 189, 43);
		asignarServicio.add(btnRegresar_3);

		JButton btnAsignarServicioSeleccionado = new JButton("Asignar servicio seleccionado");
		btnAsignarServicioSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignarServicio(e);
			}
		});
		btnAsignarServicioSeleccionado.setBounds(700, 206, 233, 36);
		asignarServicio.add(btnAsignarServicioSeleccionado);

		scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 70, 918, 134);
		asignarServicio.add(scrollPane_6);

		tablaServicios3 = getTablaServicios3();
		scrollPane_6.setViewportView(tablaServicios3);

		scrollPane_7 = new JScrollPane();
		scrollPane_7.setEnabled(false);
		scrollPane_7.setBounds(10, 253, 918, 74);
		asignarServicio.add(scrollPane_7);

		tablaIPS = getTablaIPS();
		scrollPane_7.setViewportView(tablaIPS);

		scrollPane_8 = new JScrollPane();
		scrollPane_8.setEnabled(false);
		scrollPane_8.setBounds(10, 362, 918, 102);
		asignarServicio.add(scrollPane_8);

		tablaAmbulancias3 = getTablaAmbulancias3();
		scrollPane_8.setViewportView(tablaAmbulancias3);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/heart-health-main.jpg")));
		label_6.setBounds(0, 0, 953, 523);
		asignarServicio.add(label_6);

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
		lblServiciosAsociados.setBounds(10, 192, 338, 46);
		reporteIPS.add(lblServiciosAsociados);

		comboBoxIPS = new JComboBox();
		comboBoxIPS.setBounds(362, 68, 505, 46);
		reporteIPS.add(comboBoxIPS);

		JButton btnMostrarServiciosAsociados = new JButton("Mostrar servicios asociados");
		btnMostrarServiciosAsociados
				.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/Show Icon.png")));
		btnMostrarServiciosAsociados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarServiciosAsociados(e);
			}
		});
		btnMostrarServiciosAsociados.setBounds(119, 125, 254, 56);
		reporteIPS.add(btnMostrarServiciosAsociados);

		btnRegresar_6 = new JButton("Regresar");
		btnRegresar_6.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/go-back-icon_opt.png")));
		btnRegresar_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresar(e);
			}
		});
		btnRegresar_6.setBounds(753, 443, 175, 61);
		reporteIPS.add(btnRegresar_6);

		this.getTabbedPane().setSelectedIndex(5);

		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 249, 918, 183);
		reporteIPS.add(scrollPane_5);

		tablaServicios2 = this.getTablaServicios2();
		scrollPane_5.setViewportView(tablaServicios2);

		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(TestGUIAmbulancias.class.getResource("/Images/heart-health-main.jpg")));
		label_7.setBounds(0, 0, 953, 523);
		reporteIPS.add(label_7);
		/**
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
					irReporteServiciosFinalizados(null);
					break;
				case 6:
					irReporteServicios(null);
					break;
				case 7:
					irAsignarServicio(null);
					break;
				case 8:
					irReporteIPS(null);
					break;
				}
			}
		};
		tabbedPane.addChangeListener(changeListener);
	}

	/**
	 * Metodo para ir a la ventana del menu principal
	 * 
	 * @param e
	 *            : Evento relacionado a presionar el boton
	 */
	private void irMenuPrincipal(ActionEvent e) {
		this.getTabbedPane().setSelectedIndex(this.menuServicios);
	}

	/**
	 * Metodo para ir a la ventana de registrar un servicio
	 * 
	 * @param e
	 *            : Evento relacionado a presionar el boton
	 */
	private void irRegistrarServicio(ActionEvent e) {
		this.getTabbedPane().setSelectedIndex(this.registrarServicio);
	}

	/**
	 * Obtener el paciente
	 * 
	 * @return JTextField
	 */
	public JTextField getPaciente() {
		return paciente;
	}

	/**
	 * Obtener combobox del tipo
	 * 
	 * @return JComboBox
	 */
	public JComboBox getComboBoxTipo() {
		return comboBoxTipo;
	}

	/**
	 * Obtener telefono
	 * 
	 * @return JTextField
	 */
	public JTextField getTelefono() {
		return telefono;
	}

	/**
	 * Otener ComboBox de tipo de direccion
	 * 
	 * @return JComboBox
	 */
	public JComboBox getComboBoxDireccion() {
		return comboBoxDireccion;
	}

	/**
	 * Obtener Calle del servicio
	 * 
	 * @return JTetField
	 */
	public JTextField getCalleServicio() {
		return calleServicio;
	}

	/**
	 * Obtener Carrera del servicio
	 * 
	 * @return JTextField
	 */
	public JTextField getCarreraServicio() {
		return carreraServicio;
	}

	/**
	 * Obtener el numero de calle/carrera del servicio
	 * 
	 * @return JTextField
	 */
	public JTextField getNumeroServicio() {
		return numeroServicio;
	}

	/**
	 * Metodo para mostrar los componentes de la pestania de registrar un
	 * servicio
	 * 
	 * @param e
	 *            : Evento relacionado a presionar un boton
	 */
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
		this.paciente.setText(null);
		this.telefono.setText(null);
		this.calleServicio.setText(null);
		this.carreraServicio.setText(null);
		this.numeroServicio.setText(null);
	}

	/**
	 * Metodo relcaionado a registrar un servicio cuando se presiona un boton
	 * 
	 * @param e
	 *            : Evento relacionado a presionar un boton
	 */
	private void registrarServicio(ActionEvent e) {
		int calle;
		int carrera;
		long codigoServicio;
		String paciente = this.paciente.getText();
		String tipoServicio = (String) this.comboBoxTipo.getSelectedItem();
		String telefono = this.telefono.getText();
		String tipoDireccion = (String) this.comboBoxDireccion.getSelectedItem();
		String calleS = this.calleServicio.getText();
		String carreraS = this.carreraServicio.getText();
		String numeroS = this.numeroServicio.getText();
		if (paciente.length() != 0 && telefono.length() != 0 && calleS.length() != 0 && carreraS.length() != 0
				&& carreraS.length() != 0) {
			calle = Integer.parseInt(calleS);
			carrera = Integer.parseInt(carreraS);
			int numero = Integer.parseInt(numeroS);
			if ((tipoServicio.equals("URGENCIA") || tipoServicio.equals("EMERGENCIA")
					|| tipoServicio.equals("DOMICILIO"))
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
						codigoServicio = empresaAmbulancias.registrarServicio(paciente, TipoServicio.EMERGENCIA,
								telefono, TipoDireccion.CALLE, calle, carrera, numero);
						JOptionPane.showMessageDialog(null,
								"El nuevo Servicio tiene codigo: " + String.valueOf(codigoServicio));
					} else {
						codigoServicio = empresaAmbulancias.registrarServicio(paciente, TipoServicio.EMERGENCIA,
								telefono, TipoDireccion.CARRERA, calle, carrera, numero);
						JOptionPane.showMessageDialog(null,
								"El nuevo Servicio tiene codigo: " + String.valueOf(codigoServicio));
					}
				} else if (tipoServicio.equals("DOMICILIO")) {
					if (tipoDireccion.equals("CALLE")) {
						codigoServicio = empresaAmbulancias.registrarServicio(paciente, TipoServicio.DOMICILIO,
								telefono, TipoDireccion.CALLE, calle, carrera, numero);
						JOptionPane.showMessageDialog(null,
								"El nuevo Servicio tiene codigo: " + String.valueOf(codigoServicio));
					} else {
						codigoServicio = empresaAmbulancias.registrarServicio(paciente, TipoServicio.DOMICILIO,
								telefono, TipoDireccion.CARRERA, calle, carrera, numero);
						JOptionPane.showMessageDialog(null,
								"El nuevo Servicio tiene codigo: " + String.valueOf(codigoServicio));
					}
				}
				this.paciente.setText(null);
				this.telefono.setText(null);
				this.calleServicio.setText(null);
				this.carreraServicio.setText(null);
				this.numeroServicio.setText(null);
			} else
				JOptionPane.showMessageDialog(null, "Fallo en el registro del servicio");
		} else
			JOptionPane.showMessageDialog(this, "No se han digitado los datos necesarios para registrar un servicio",
					"Escritura de datos", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Obtener el tab
	 * 
	 * @return JTabbedPane
	 */
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	/**
	 * Metodo para regresar al menu de servicios cuando un boton es oprimido
	 * 
	 * @param e
	 *            : Evento relacionado a presionar un boton
	 */
	private void regresar(ActionEvent e) {
		this.getTabbedPane().setSelectedIndex(this.menuServicios);
	}

	/**
	 * Metodo para ir a la pestania de Registrar la posicion de una ambulancia
	 * 
	 * @param e
	 *            : Evento relacionado a presionar un boton
	 */
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
		this.calle.setText(null);
		this.carrera.setText(null);
	}

	/**
	 * Metodo para registrar la nueva posicion de una ambulancia cuando se
	 * presiona un boton
	 * 
	 * @param e
	 *            : Evento relacionado a presionar un boton
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

	/**
	 * Ir a la pestania de Asignar un servicio a una ambulancia y a una IPS
	 * 
	 * @param e
	 *            : Evento relacionado a presionar un boton
	 */
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
	 * Metodo para llenar lel Vector dado de datos de ambulancias
	 * 
	 * @param orLlaves
	 *            : Lista de Enteros que son los codigos de la ambulancias
	 * @param filasDatos
	 *            : Vector que contiene los datos para la tabla
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

	/**
	 * Metodo para ir a la pestania de Finalizar un servicio
	 * 
	 * @param e
	 *            : Evento relacionado a presionar un boton
	 */
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
	 * Metodo para llenar el Vector de datos de los datos de los servicios.
	 * 
	 * @param items
	 *            : Lista que significa los servicios del sistema a agregar al
	 *            vector de datos
	 * @param filasDatos
	 *            : Vector a llenar
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

	/**
	 * Metodo para ir a la pestania de Reporte de seervicios con IPS y
	 * ambulancia asignados
	 * 
	 * @param e
	 *            : Evento relacionado a presionar un boton
	 */
	private void irReporteServicios(ActionEvent e) {
		this.getTabbedPane().setSelectedIndex(this.reporteServicios);
		this.nombreIPS.setText(null);
		this.tipoAtencionIPS.setText(null);
		this.DireccionIPS.setText(null);
		this.codigoAmbulancia.setText(null);
		this.tipoAmbulancia.setText(null);
		this.placaAmbulancia.setText(null);
		this.medicoAmbulancia.setText(null);
		this.horaAmbulancia.setText(null);
		this.calleAmbulancia.setText(null);
		this.carreraAmbulancia.setText(null);
		this.tarifaAmbulancia.setText(null);
		this.tipoUCIAmbulancia.setText(null);
		filaDatosServicios1 = new Vector(); // obtener items de venta actual:
		int indexVentaActual = empresaAmbulancias.getServicios().size() - 1;
		List<Servicio> items = empresaAmbulancias.getServicios(); // llenar el
																	// vector de
																	// datos del
																	// JTable
																	// datosNegocio
		Collections.sort(items, new HoraSolicitudComparator());
		llenarFilasServicioReporte(items, filaDatosServicios1);
		// refrescar visualmente el JTable dentro del scroll:
		tablaServicios1 = new JTable(filaDatosServicios1, nombreColumServiciosV1);
		scrollPane_2.setViewportView(getTablaServicios1());
	}

	/**
	 * Metodo para llenar el vector dado de datos de servicios
	 * 
	 * @param items
	 *            : Lista que significa los servicios del sistema
	 * @param filasDatos
	 *            : Vector a llenar de datos
	 */
	private void llenarFilasServicioReporte(List<Servicio> items, Vector filasDatos) {
		for (Servicio servicio : items) {
			Vector fila = new Vector();
			fila.add(servicio.getCodigo());
			fila.add(Utils.convertirFechaHoraString(servicio.getHoraSolicitud()));
			fila.add(servicio.getPaciente());
			fila.add(servicio.getTipoServicio());
			fila.add(servicio.getTelefono());
			fila.add(servicio.getDireccion().toString());
			fila.add(servicio.getEstado().toString());
			if (servicio.getAmbulancia() != null)
				fila.add(servicio.getAmbulancia().calcularTarifa());
			else
				fila.add("");
			filasDatos.add(fila);
		}
	}

	/**
	 * Metodo para ir a la pestania de Reporte de IPS con servicios asociados
	 * 
	 * @param e
	 *            : Evento relacionado a presionar un boton
	 */
	private void irReporteIPS(ActionEvent e) {
		filaDatosServicios2.removeAllElements();
		tablaServicios2.removeAll();
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

	/**
	 * Metodo para ir a la pestania de Ingresar IPS y ambulancias al sistema por
	 * medio de archivos
	 * 
	 * @param arg0
	 *            : Evento relacionado a presionar un boton
	 */
	private void irIngresarIPSAmbulancias(ActionEvent arg0) {
		this.getTabbedPane().setSelectedIndex(this.ingresarIPSAmbulancias);
	}

	/**
	 * Metodo para seleccionar el archivo que contiene las IPS del sistema
	 * 
	 * @param e
	 *            : Evento relacionado a presionar un boton
	 * @throws PersistenceException
	 *             : Excepcion de persistencia (Lectura de archivo)
	 */
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

	/**
	 * Metodo para seleccionar el archivo que contiene las ambulancias del
	 * sistema
	 * 
	 * @param e
	 *            : Evento relacionado a presionar un boton
	 * @throws PersistenceException
	 *             : Excepcion de persistencia (Lectura de archivo)
	 */
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

	/**
	 * Obtener ScrollPane
	 * 
	 * @return scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	/**
	 * Obtener tabla de ambulancias para registrar su posicion actual
	 * 
	 * @return JTable
	 */
	public JTable getTablaAmbulancias() {
		if (tablaAmbulancias == null) {
			filaDatosAmbulancias = new Vector();
			nombreColumAmbulanciasV = new Vector(Arrays.asList(this.nombreColumAmbulancias));
			tablaAmbulancias = new JTable(filaDatosAmbulancias, nombreColumAmbulanciasV);
		}
		return tablaAmbulancias;

	}

	/**
	 * Obtener ScrollPane
	 * 
	 * @return scrollPane
	 */
	public JScrollPane getScrollPane_1() {
		return scrollPane_1;
	}

	/**
	 * Obtener tabla de servicios para finalizar
	 * 
	 * @return JTable
	 */
	public JTable getTablaServicios() {
		if (tablaServicios == null) {
			filaDatosServicios = new Vector();
			nombreColumServiciosV = new Vector(Arrays.asList(this.nombreColumServicios));
			tablaServicios = new JTable(filaDatosServicios, nombreColumServiciosV);
		}
		return tablaServicios;
	}

	/**
	 * Obtener ScrollPane
	 * 
	 * @return scrollPane
	 */
	public JScrollPane getScrollPane_5() {
		return scrollPane_5;
	}

	/**
	 * Obtener tabla de servicios para Reporte de Servicios
	 * 
	 * @return JTable
	 */
	public JTable getTablaServicios2() {
		if (tablaServicios2 == null) {
			filaDatosServicios2 = new Vector();
			nombreColumServiciosV2 = new Vector(Arrays.asList(this.nombreColumServicios2));
			tablaServicios2 = new JTable(filaDatosServicios2, nombreColumServiciosV2);
		}
		return tablaServicios2;
	}

	/**
	 * Obtener ComboBox de la IPS (Reporte IPS)
	 * 
	 * @return JComboBox
	 */
	public JComboBox getComboBoxIPS() {
		return comboBoxIPS;
	}

	/**
	 * Obtener ScrollPane
	 * 
	 * @return scrollPane
	 */
	public JScrollPane getScrollPane_2() {
		return scrollPane_2;
	}

	/**
	 * Obtener tabla de servicios para Reporte de IPS
	 * 
	 * @return JTable
	 */
	public JTable getTablaServicios1() {
		if (tablaServicios1 == null) {
			filaDatosServicios1 = new Vector();
			nombreColumServiciosV1 = new Vector(Arrays.asList(this.nombreColumServicios1));
			tablaServicios1 = new JTable(filaDatosServicios1, nombreColumServiciosV1);
		}
		return tablaServicios1;
	}

	/**
	 * Obtener boton para actualizar la posicion de una ammbulancia
	 * 
	 * @return
	 */
	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	/**
	 * Obtener ScrollPane
	 * 
	 * @return scrollPane
	 */
	public JScrollPane getScrollPane_6() {
		return scrollPane_6;
	}

	/**
	 * Obtener tabla de servicios para Asignar servicio
	 * 
	 * @return JTable
	 */
	public JTable getTablaServicios3() {
		if (tablaServicios3 == null) {
			filaDatosServicios3 = new Vector();
			nombreColumServiciosV3 = new Vector(Arrays.asList(this.nombreColumServicios3));
			tablaServicios3 = new JTable(filaDatosServicios3, nombreColumServiciosV3);
		}
		return tablaServicios3;
	}

	/**
	 * Obtener ScrollPane
	 * 
	 * @return scrollPane
	 */
	public JScrollPane getScrollPane_7() {
		return scrollPane_7;
	}

	/**
	 * Obtener tabla de IPS para Asignar servicio
	 * 
	 * @return JTable
	 */
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

	/**
	 * Obtener ScrollPane
	 * 
	 * @return scrollPane
	 */
	public JScrollPane getScrollPane_8() {
		return scrollPane_8;
	}

	/**
	 * Obtener tabla de IPS para Asignar Servicio
	 * 
	 * @return JTable
	 */
	public JTable getTablaAmbulancias3() {
		if (tablaAmbulancias3 == null) {
			filaDatosAmbulancias3V = new Vector();
			nombreColumAmbulancias3V = new Vector(Arrays.asList(this.nombreColumAmbulancias3));
			tablaAmbulancias3 = new JTable(filaDatosAmbulancias3V, nombreColumAmbulancias3V);
			tablaAmbulancias3.setEnabled(false);
		}
		return tablaAmbulancias3;
	}

	/**
	 * Metodo para guardar la totalidad del sistema
	 * 
	 * @param e
	 *            : Relacionado al presionar un boton
	 */
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

	/**
	 * Metodo para cargar los datos del sistema
	 * 
	 * @param e
	 *            : Relacionado al presionar un boton
	 */
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

	/**
	 * Metodo para finalizar un servicio al presionar un boton
	 * 
	 * @param e
	 *            : Relacionado al presionar un boton
	 */
	private void finalizarServicio(ActionEvent e) {
		int indexFilaSeleccionada = tablaServicios.getSelectedRow();
		if (indexFilaSeleccionada != -1) {
			TableModel model = tablaServicios.getModel();
			long codigo = (long) model.getValueAt(indexFilaSeleccionada, 0);
			if (empresaAmbulancias.finalizarServicio(codigo)) {
				Vector fila = (Vector) filaDatosServicios.get(indexFilaSeleccionada);
				fila.set(6, EstadoServicio.FINALIZADO);
				tablaServicios = new JTable(filaDatosServicios, nombreColumServiciosV);
				scrollPane_1.setViewportView(getTablaServicios());
				JOptionPane.showMessageDialog(this, "El servicio se ha finalizado exitosamente", "finalizacion exitosa",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "No pudo ser finalizado el servicio exitosamente",
						"fallo finalizacion", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "No se ha seleccionado un servicio para finalizar",
					"fallo finalizacion", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo para Asignar un servicio al presionar un boton
	 * 
	 * @param e
	 *            : Relacionado al presionar un boton
	 */
	private void asignarServicio(ActionEvent e) {
		int indexFilaSeleccionada = tablaServicios3.getSelectedRow();
		if (indexFilaSeleccionada != -1) {
			TableModel model = tablaServicios3.getModel();
			long codigo = (long) model.getValueAt(indexFilaSeleccionada, 0);
			Servicio servicio = ((EmpresaAmbulancias) empresaAmbulancias).buscarServicio(codigo);
			try {
				Vector fila = (Vector) filaDatosServicios3.get(indexFilaSeleccionada);
				if (fila.get(6).equals("ASIGNADO")) {
					JOptionPane.showMessageDialog(this, "El servicio ya ha sido asignado", "Asignacion erronea",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (fila.get(6).equals("FINALIZADO")) {
						JOptionPane.showMessageDialog(this, "El servicio ya ha sido asignado y finalizado",
								"Asignacion erronea", JOptionPane.ERROR_MESSAGE);
					} else {
						if (empresaAmbulancias.asignarServicio(codigo)) {

							fila.set(6, EstadoServicio.ASIGNADO);
							if (servicio.getTipoServicio() != TipoServicio.DOMICILIO)
								fila.set(7, servicio.getIps().getNombre());
							fila.set(8, servicio.getAmbulancia().getCodigo());
							tablaServicios3 = new JTable(filaDatosServicios3, nombreColumServiciosV3);
							scrollPane_6.setViewportView(getTablaServicios3());
							int numFila;
							for (numFila = 0; numFila < tablaAmbulancias3.getRowCount(); numFila++) {
								Vector auxFila = (Vector) filaDatosAmbulancias3V.get(numFila);
								if ((Integer) auxFila.get(0) == servicio.getAmbulancia().getCodigo())
									break;
							}
							tablaAmbulancias3.changeSelection(numFila, 0, false, false);
							if (servicio.getTipoServicio() != TipoServicio.DOMICILIO) {
								for (numFila = 0; numFila < tablaIPS.getRowCount(); numFila++) {
									Vector auxFila = (Vector) filaDatosIPS.get(numFila);
									if (auxFila.get(0).equals(servicio.getIps().getNombre()))
										break;
								}
								tablaIPS.changeSelection(numFila, 0, false, false);
							}
						} else {
							JOptionPane.showMessageDialog(this, "No pudo ser asignado el servicio", "fallo asignacion",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			} catch (Exception excepcion) {
				JOptionPane.showMessageDialog(this,
						"No pudo ser asignado el servicio. Revisar la asignacion de la posicion de ambulancias",
						"fallo finalizacion", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Favor seleccionar una fila valida", "Seleccion invalida",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Metodo para mostrar la IPS y ambulancia asignados a un servicio dado
	 * 
	 * @param e
	 *            : Relacionado al presionar un boton
	 */
	private void mostrarIpsAmbulancia(ActionEvent e) {
		long indexFilaSeleccionada = tablaServicios1.getSelectedRow();
		if (indexFilaSeleccionada != -1) {
			TableModel model = tablaServicios1.getModel();
			long codigo = (long) model.getValueAt((int) indexFilaSeleccionada, 0);
			Servicio servicio = ((EmpresaAmbulancias) empresaAmbulancias).buscarServicio(codigo);
			if (servicio.getEstado() == EstadoServicio.ASIGNADO || servicio.getEstado() == EstadoServicio.FINALIZADO) {
				codigoAmbulancia.setText(String.valueOf(servicio.getAmbulancia().getCodigo()));
				horaAmbulancia.setText(Utils.convertirFechaHoraString(servicio.getAmbulancia().getHoraPosicion()));
				carreraAmbulancia.setText(String.valueOf(servicio.getAmbulancia().getPosicionCarrera()));
				calleAmbulancia.setText(String.valueOf(servicio.getAmbulancia().getPosicionCalle()));
				tarifaAmbulancia.setText(String.valueOf(servicio.getAmbulancia().calcularTarifa()));
				placaAmbulancia.setText(servicio.getAmbulancia().getPlaca());
				if (servicio.getIps() != null) {
					nombreIPS.setText(servicio.getIps().getNombre());
					DireccionIPS.setText(servicio.getIps().getDireccion().toString());
					tipoAtencionIPS.setText(servicio.getIps().getTipoAtencion());
				} else {
					nombreIPS.setText(null);
					DireccionIPS.setText(null);
					tipoAtencionIPS.setText(null);
				}
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
					medicoAmbulancia.setText(((AmbulanciaNoMedicalizada) servicio.getAmbulancia()).getEnfermero());
				}
			} else {
				JOptionPane.showMessageDialog(this, "El servicio no se ha asignado a una ambulancia y a una Ips",
						"Asignacion de servicio", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "No se ha seleccionado un servicio", "Seleccion de servicio",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Obtener el JTextField Carrera ambulancia
	 * 
	 * @return JTextField
	 */
	public JTextField getCarreraAmbulancia() {
		return carreraAmbulancia;
	}

	/**
	 * Obtener el JTextField Tipo ambulancia
	 * 
	 * @return JTextField
	 */
	public JTextField getTipoAmbulancia() {
		return tipoAmbulancia;
	}

	/**
	 * Obtener el JTextField medico/Enfermero ambulancia
	 * 
	 * @return JTextField
	 */
	public JTextField getMedicoAmbulancia() {
		return medicoAmbulancia;
	}

	/**
	 * Obtener el JTextField placa ambulancia
	 * 
	 * @return JTextField
	 */
	public JTextField getPlacaAmbulancia() {
		return placaAmbulancia;
	}

	/**
	 * Obtener el JTextField tarifa ambulancia
	 * 
	 * @return JTextField
	 */
	public JTextField getTarifaAmbulancia() {
		return tarifaAmbulancia;
	}

	/**
	 * Obtener el JTextField nombre IPS
	 * 
	 * @return JTextField
	 */
	public JTextField getNombreIPS() {
		return nombreIPS;
	}

	/**
	 * Obtener el JTextField Hora solicitud ambulancia
	 * 
	 * @return JTextField
	 */
	public JTextField getHoraAmbulancia() {
		return horaAmbulancia;
	}

	/**
	 * Obtener el JTextField direccion IPS
	 * 
	 * @return JTextField
	 */
	public JTextField getDireccionIPS() {
		return DireccionIPS;
	}

	/**
	 * Obtener el JTextField Codigo ambulancia
	 * 
	 * @return JTextField
	 */
	public JTextField getCodigoAmbulancia() {
		return codigoAmbulancia;
	}

	/**
	 * Obtener el JTextField Calle ambulancia
	 * 
	 * @return JTextField
	 */
	public JTextField getCalleAmbulancia() {
		return calleAmbulancia;
	}

	/**
	 * Obtener el JTextField Tipo IPS
	 * 
	 * @return JTextField
	 */
	public JTextField getTipoAtencionIPS() {
		return tipoAtencionIPS;
	}

	/**
	 * Obtener el JTextField Tipo UCI ambulancia
	 * 
	 * @return JTextField
	 */
	public JTextField getTipoUCIAmbulancia() {
		return tipoUCIAmbulancia;
	}

	/**
	 * Metodo para mostrar los servicios asociados a una IPS
	 * 
	 * @param e
	 *            : Relacionado al presionar un boton
	 */
	private void mostrarServiciosAsociados(ActionEvent e) {
		filaDatosServicios2.removeAllElements();
		String comboIps = (String) comboBoxIPS.getSelectedItem();
		StringTokenizer token = new StringTokenizer(comboIps, "-");
		String nombreCombo = token.nextToken().trim();
		List<Servicio> servicios = empresaAmbulancias.getLasIPS().get(nombreCombo).getServicios();
		if (!servicios.isEmpty()) {
			llenarFilasServicio(servicios, filaDatosServicios2);
			tablaServicios2 = new JTable(filaDatosServicios2, nombreColumServiciosV2);
			scrollPane_5.setViewportView(getTablaServicios2());
		} else {
			JOptionPane.showMessageDialog(this, "No hay servicios asociados a la IPS seleccionada",
					"Sin servicios asociados", JOptionPane.INFORMATION_MESSAGE);
			tablaServicios2 = new JTable(filaDatosServicios2, nombreColumServiciosV2);
			scrollPane_5.setViewportView(getTablaServicios2());
		}
	}

	public JTable getTablaServicios4() {
		if (tablaServicios4 == null) {
			filaDatosServicios4 = new Vector();
			nombreColumServiciosV4 = new Vector(Arrays.asList(this.nombreColumServicios4));
			tablaServicios4 = new JTable(filaDatosServicios4, nombreColumServiciosV4);
		}
		return tablaServicios4;
	}

	private void irReporteServiciosFinalizados(ActionEvent e) {
		this.getTabbedPane().setSelectedIndex(this.reporteServiciosFinalizados);
		domicilio.setText(null);
		urgencia.setText(null);
		emergencia.setText(null);
		total.setText(null);
		if (!empresaAmbulancias.getServicios().isEmpty()) {
			long valorDomicilio = 0;
			long valorEmergencia = 0;
			long valorUrgencia = 0;
			List<Servicio> serviciosFinalizados = new ArrayList<Servicio>();
			filaDatosServicios4 = new Vector();
			for (Servicio servicio : empresaAmbulancias.getServicios()) {
				if (servicio.getEstado() == EstadoServicio.FINALIZADO) {
					serviciosFinalizados.add(servicio);
					if (servicio.getTipoServicio() == TipoServicio.DOMICILIO)
						valorDomicilio += servicio.getAmbulancia().calcularTarifa();
					if (servicio.getTipoServicio() == TipoServicio.EMERGENCIA)
						valorEmergencia += servicio.getAmbulancia().calcularTarifa();
					if (servicio.getTipoServicio() == TipoServicio.URGENCIA)
						valorUrgencia += servicio.getAmbulancia().calcularTarifa();
				}
			}
			Collections.sort(serviciosFinalizados, new HoraSolicitudComparator());
			llenarFilasServicioReporte(serviciosFinalizados, filaDatosServicios4);
			tablaServicios4 = new JTable(filaDatosServicios4, nombreColumServiciosV4);
			scrollPane_3.setViewportView(getTablaServicios4());
			domicilio.setText(String.valueOf(valorDomicilio));
			emergencia.setText(String.valueOf(valorEmergencia));
			urgencia.setText(String.valueOf(valorUrgencia));
			total.setText(String.valueOf(valorDomicilio + valorEmergencia + valorUrgencia));
		}
	}

	public JScrollPane getScrollPane_3() {
		return scrollPane_3;
	}

	public JTextField getDomicilio() {
		return domicilio;
	}

	public JTextField getUrgencia() {
		return urgencia;
	}

	public JTextField getEmergencia() {
		return emergencia;
	}

	public JTextField getTotal() {
		return total;
	}
}

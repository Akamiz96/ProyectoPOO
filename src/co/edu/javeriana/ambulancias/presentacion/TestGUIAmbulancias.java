package co.edu.javeriana.ambulancias.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.negocio.TipoDireccion;
import co.edu.javeriana.ambulancias.negocio.TipoServicio;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class TestGUIAmbulancias extends JFrame {

	private EmpresaAmbulancias empresaAmbulancias = new EmpresaAmbulancias("AAA");
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
		setBounds(100, 100, 964, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 943, 573);
		contentPane.add(tabbedPane);

		JPanel reporteServicios = new JPanel();
		tabbedPane.addTab("Reporte Servicios con IPS y ambulancias asignados", null, reporteServicios, null);
		reporteServicios.setLayout(null);

		JLabel lblReporteDeServicios = new JLabel("Reporte de servicios con IPS y ambulancias asignados ");
		lblReporteDeServicios.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 30));
		lblReporteDeServicios.setBounds(10, 11, 881, 51);
		reporteServicios.add(lblReporteDeServicios);

		JLabel lblServicios_2 = new JLabel("Servicios");
		lblServicios_2.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 29));
		lblServicios_2.setBounds(10, 73, 228, 35);
		reporteServicios.add(lblServicios_2);

		JLabel lblIpsAsignada = new JLabel("IPS asignada");
		lblIpsAsignada.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 29));
		lblIpsAsignada.setBounds(10, 189, 228, 35);
		reporteServicios.add(lblIpsAsignada);

		JLabel lblAmbulanciaAsignada = new JLabel("Ambulancia asignada");
		lblAmbulanciaAsignada.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 29));
		lblAmbulanciaAsignada.setBounds(10, 299, 293, 35);
		reporteServicios.add(lblAmbulanciaAsignada);

		JButton btnRegresar_5 = new JButton("Regresar");
		btnRegresar_5.setBounds(772, 434, 119, 51);
		reporteServicios.add(btnRegresar_5);

		JButton btnMostrar = new JButton("Mostrar IPS y ambulancia asignadas");
		btnMostrar.setBounds(589, 114, 249, 35);
		reporteServicios.add(btnMostrar);

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

		JPanel asignarServicio = new JPanel();
		tabbedPane.addTab("Asignar un Servicio a una Ambulancia y una IPS", null, asignarServicio, null);
		asignarServicio.setLayout(null);

		JLabel lblAsignarUnServicio = new JLabel("Asignar un servicio a una ambulancia y una IPS");
		lblAsignarUnServicio.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 31));
		lblAsignarUnServicio.setBounds(10, 11, 800, 51);
		asignarServicio.add(lblAsignarUnServicio);

		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setFont(new Font("Yu Gothic Light", Font.BOLD, 30));
		lblServicios.setBounds(10, 85, 146, 51);
		asignarServicio.add(lblServicios);

		JLabel lblIps = new JLabel("IPS");
		lblIps.setFont(new Font("Yu Gothic Light", Font.BOLD, 30));
		lblIps.setBounds(10, 162, 61, 51);
		asignarServicio.add(lblIps);

		JLabel lblAmbulancias_1 = new JLabel("Ambulancias");
		lblAmbulancias_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 30));
		lblAmbulancias_1.setBounds(10, 248, 189, 51);
		asignarServicio.add(lblAmbulancias_1);

		JButton btnRegresar_3 = new JButton("Regresar");
		btnRegresar_3.setBounds(768, 428, 123, 57);
		asignarServicio.add(btnRegresar_3);

		JButton btnAsignarServicioSeleccionado = new JButton("Asignar servicio seleccionado");
		btnAsignarServicioSeleccionado.setBounds(318, 378, 171, 51);
		asignarServicio.add(btnAsignarServicioSeleccionado);

		JPanel finalizarServicio = new JPanel();
		tabbedPane.addTab("Finalizar un Servicio", null, finalizarServicio, null);
		finalizarServicio.setLayout(null);

		JLabel lblFinalizarUnServicio = new JLabel("Finalizar un servicio");
		lblFinalizarUnServicio.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 38));
		lblFinalizarUnServicio.setBounds(10, 11, 401, 45);
		finalizarServicio.add(lblFinalizarUnServicio);

		JLabel lblServicios_1 = new JLabel("Servicios");
		lblServicios_1.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblServicios_1.setBounds(20, 67, 129, 61);
		finalizarServicio.add(lblServicios_1);

		JButton btnRegresar_4 = new JButton("Regresar");
		btnRegresar_4.setBounds(750, 424, 141, 61);
		finalizarServicio.add(btnRegresar_4);

		JButton btnFinalizarServicioSeleccionado = new JButton("Finalizar servicio seleccionado");
		btnFinalizarServicioSeleccionado.setBounds(536, 116, 202, 39);
		finalizarServicio.add(btnFinalizarServicioSeleccionado);

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
		btnRegistrarUnServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarRegistroServicio(e);
			}
		});
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

		JComboBox comboBoxIPS = new JComboBox();
		comboBoxIPS.setBounds(362, 68, 505, 46);
		reporteIPS.add(comboBoxIPS);

		JButton btnMostrarServiciosAsociados = new JButton("Mostrar servicios asociados");
		btnMostrarServiciosAsociados.setBounds(121, 163, 254, 56);
		reporteIPS.add(btnMostrarServiciosAsociados);

		JButton btnRegresar_6 = new JButton("Regresar");
		btnRegresar_6.setBounds(780, 462, 148, 56);
		reporteIPS.add(btnRegresar_6);
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
		this.getTabbedPane().setSelectedIndex(1);
		comboBoxDireccion.removeAllItems();
		comboBoxTipo.removeAllItems();
		String elemento = String.valueOf(TipoDireccion.CALLE);
		this.comboBoxDireccion.addItem(elemento);
		elemento = String.valueOf(TipoDireccion.CARRERA);
		this.comboBoxDireccion.addItem(elemento);
		elemento = String.valueOf(TipoServicio.DOMICILIO);
		this.comboBoxDireccion.addItem(elemento);
		elemento = String.valueOf(TipoServicio.EMERGENCIA);
		this.comboBoxDireccion.addItem(elemento);
		elemento = String.valueOf(TipoServicio.URGENCIA);
		this.comboBoxDireccion.addItem(elemento);
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
							"El nuevo Servicio tiene codigo %d\n" + String.valueOf(codigoServicio));
				} else {
					codigoServicio = empresaAmbulancias.registrarServicio(paciente, TipoServicio.URGENCIA, telefono,
							TipoDireccion.CARRERA, calle, carrera, numero);
					JOptionPane.showMessageDialog(null,
							"El nuevo Servicio tiene codigo %d\n" + String.valueOf(codigoServicio));
				}
			} else if (tipoServicio.equals("EMERGENCIA")) {
				if (tipoDireccion.equals("CALLE")) {
					codigoServicio = empresaAmbulancias.registrarServicio(paciente, TipoServicio.URGENCIA, telefono,
							TipoDireccion.CALLE, calle, carrera, numero);
					JOptionPane.showMessageDialog(null,
							"El nuevo Servicio tiene codigo %d\n" + String.valueOf(codigoServicio));
				} else {
					codigoServicio = empresaAmbulancias.registrarServicio(paciente, TipoServicio.URGENCIA, telefono,
							TipoDireccion.CARRERA, calle, carrera, numero);
					JOptionPane.showMessageDialog(null,
							"El nuevo Servicio tiene codigo %d\n" + String.valueOf(codigoServicio));
				}
			} else if (tipoServicio.equals("DOMICILIO")) {
				if (tipoDireccion.equals("CALLE")) {
					codigoServicio = empresaAmbulancias.registrarServicio(paciente, TipoServicio.URGENCIA, telefono,
							TipoDireccion.CALLE, calle, carrera, numero);
					JOptionPane.showMessageDialog(null,
							"El nuevo Servicio tiene codigo %d\n" + String.valueOf(codigoServicio));
				} else {
					codigoServicio = empresaAmbulancias.registrarServicio(paciente, TipoServicio.URGENCIA, telefono,
							TipoDireccion.CARRERA, calle, carrera, numero);
					JOptionPane.showMessageDialog(null,
							"El nuevo Servicio tiene codigo %d\n" + String.valueOf(codigoServicio));
				}
			}
		} else
			JOptionPane.showMessageDialog(null, "Fallo en el registro del servicio");
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	private void regresar(ActionEvent e) {
		this.getTabbedPane().setSelectedIndex(5);
	}
}

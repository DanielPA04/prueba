package tema8_ej05;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tienda {

	private JFrame frmTienda;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JTextField txtPrecio;
	private JTextField txtNombre;
	private JTextField txtUnidades;
	private JTextField txtNuevoprecio;
	private JTextField textField;
	private JTextField textField_1;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda window = new Tienda();
					window.frmTienda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tienda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTienda = new JFrame();
		frmTienda.setTitle("Tienda");
		frmTienda.setBounds(100, 100, 854, 670);
		frmTienda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTienda.getContentPane().setLayout(null);

		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMostrar.setBounds(162, 39, 117, 25);
		frmTienda.getContentPane().add(btnMostrar);

		JLabel lblNuevoProducto = new JLabel("Nuevo producto:");
		lblNuevoProducto.setBounds(12, 241, 125, 15);
		frmTienda.getContentPane().add(lblNuevoProducto);

		lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(22, 268, 70, 15);
		frmTienda.getContentPane().add(lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(110, 266, 114, 19);
		frmTienda.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(110, 293, 114, 19);
		frmTienda.getContentPane().add(txtPrecio);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(22, 295, 70, 15);
		frmTienda.getContentPane().add(lblPrecio);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(324, 264, 114, 19);
		frmTienda.getContentPane().add(txtNombre);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(236, 266, 70, 15);
		frmTienda.getContentPane().add(lblNombre);

		txtUnidades = new JTextField();
		txtUnidades.setColumns(10);
		txtUnidades.setBounds(324, 293, 114, 19);
		frmTienda.getContentPane().add(txtUnidades);

		JLabel lblUnidades = new JLabel("Unidades:");
		lblUnidades.setBounds(236, 295, 87, 15);
		frmTienda.getContentPane().add(lblUnidades);

		JButton btnAnyadir = new JButton("Añadir");
		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAnyadir.setBounds(175, 324, 117, 25);
		frmTienda.getContentPane().add(btnAnyadir);

		JLabel lblBorrarProducto = new JLabel("Borrar producto:");
		lblBorrarProducto.setBounds(12, 366, 125, 15);
		frmTienda.getContentPane().add(lblBorrarProducto);

		JLabel lblEligeProductoBorrar = new JLabel("Elige producto:");
		lblEligeProductoBorrar.setBounds(22, 393, 117, 15);
		frmTienda.getContentPane().add(lblEligeProductoBorrar);

		JComboBox comboBoxBorrar = new JComboBox();
		comboBoxBorrar.setBounds(135, 388, 70, 24);
		frmTienda.getContentPane().add(comboBoxBorrar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEliminar.setBounds(217, 388, 117, 25);
		frmTienda.getContentPane().add(btnEliminar);

		JLabel lblActualizarPrecio = new JLabel("Actualizar precio:");
		lblActualizarPrecio.setBounds(485, 76, 136, 15);
		frmTienda.getContentPane().add(lblActualizarPrecio);

		JLabel lblEligeProductoPrecio = new JLabel("Elige producto:");
		lblEligeProductoPrecio.setBounds(495, 103, 117, 15);
		frmTienda.getContentPane().add(lblEligeProductoPrecio);

		JComboBox comboBoxActualizar = new JComboBox();
		comboBoxActualizar.setBounds(604, 98, 58, 24);
		frmTienda.getContentPane().add(comboBoxActualizar);

		JLabel lblNuevoPrecio = new JLabel("Nuevo precio:");
		lblNuevoPrecio.setBounds(495, 142, 97, 15);
		frmTienda.getContentPane().add(lblNuevoPrecio);

		txtNuevoprecio = new JTextField();
		txtNuevoprecio.setBounds(604, 140, 114, 19);
		frmTienda.getContentPane().add(txtNuevoprecio);
		txtNuevoprecio.setColumns(10);

		JButton btnActualizarPrecio = new JButton("Actualizar precio");
		btnActualizarPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnActualizarPrecio.setBounds(690, 98, 164, 25);
		frmTienda.getContentPane().add(btnActualizarPrecio);

		JLabel lblIncrementarStock = new JLabel("Incrementar stock:");
		lblIncrementarStock.setBounds(485, 241, 136, 15);
		frmTienda.getContentPane().add(lblIncrementarStock);

		JLabel lblEligeProductoStock = new JLabel("Elige producto:");
		lblEligeProductoStock.setBounds(495, 267, 117, 15);
		frmTienda.getContentPane().add(lblEligeProductoStock);

		JComboBox comboBoxActualizar_1 = new JComboBox();
		comboBoxActualizar_1.setBounds(604, 262, 58, 24);
		frmTienda.getContentPane().add(comboBoxActualizar_1);

		JLabel lblUnidadesAdquirids = new JLabel("Unidades adquiridas: ");
		lblUnidadesAdquirids.setBounds(495, 306, 193, 15);
		frmTienda.getContentPane().add(lblUnidadesAdquirids);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(646, 304, 79, 19);
		frmTienda.getContentPane().add(textField);

		JButton btnActualizarStock = new JButton("Actualizar stock");
		btnActualizarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnActualizarStock.setBounds(686, 263, 168, 25);
		frmTienda.getContentPane().add(btnActualizarStock);

		JLabel lblProductoAVender = new JLabel("Producto a vender:");
		lblProductoAVender.setBounds(495, 371, 144, 15);
		frmTienda.getContentPane().add(lblProductoAVender);

		JComboBox comboBoxActualizar_2 = new JComboBox();
		comboBoxActualizar_2.setBounds(631, 366, 58, 24);
		frmTienda.getContentPane().add(comboBoxActualizar_2);

		JLabel lblUnidadesAVender = new JLabel("Unidades a vender:");
		lblUnidadesAVender.setBounds(495, 410, 144, 15);
		frmTienda.getContentPane().add(lblUnidadesAVender);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(631, 408, 87, 19);
		frmTienda.getContentPane().add(textField_1);

		JButton btnVender = new JButton("Vender");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVender.setBounds(733, 388, 108, 25);
		frmTienda.getContentPane().add(btnVender);

		JLabel lblVenta = new JLabel("Venta:");
		lblVenta.setBounds(485, 344, 70, 15);
		frmTienda.getContentPane().add(lblVenta);

		JLabel lblGananciasTotales = new JLabel("Ganancias totales:");
		lblGananciasTotales.setForeground(Color.GREEN);
		lblGananciasTotales.setBounds(548, 437, 140, 15);
		frmTienda.getContentPane().add(lblGananciasTotales);

		JLabel labelGanancias = new JLabel("0");
		labelGanancias.setForeground(Color.GREEN);
		labelGanancias.setBounds(699, 437, 53, 15);
		frmTienda.getContentPane().add(labelGanancias);

		JLabel labelEuro = new JLabel("€");
		labelEuro.setForeground(Color.GREEN);
		labelEuro.setBounds(764, 437, 70, 15);
		frmTienda.getContentPane().add(labelEuro);

		try {
			con = ConnectionSingleton.getConnection();

			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Código");
			model.addColumn("Nombre");
			model.addColumn("Precio");
			model.addColumn("Unidades");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM productos");
			while (rs.next()) {
				Object[] row = new Object[4];
				row[0] = rs.getInt("codigo");
				row[1] = rs.getString("nombre");
				row[2] = rs.getDouble("precio");
				row[3] = rs.getInt("unidades");

				model.addRow(row);
			}
			JTable table = new JTable(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setBounds(0, 0, 100, 100);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(22, 76, 445, 153);

			frmTienda.getContentPane().add(scrollPane);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

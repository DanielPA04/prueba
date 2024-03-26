package tema8_ej05;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField txtStock;
	private JTextField textFieldUdVender;
	Connection con;
	int profit = 0;

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

		JLabel lblIncrementarStock = new JLabel("Incrementar stock:");
		lblIncrementarStock.setBounds(485, 241, 136, 15);
		frmTienda.getContentPane().add(lblIncrementarStock);

		JLabel lblEligeProductoStock = new JLabel("Elige producto:");
		lblEligeProductoStock.setBounds(495, 267, 117, 15);
		frmTienda.getContentPane().add(lblEligeProductoStock);

		JComboBox comboBoxStock = new JComboBox();
		comboBoxStock.setBounds(604, 262, 58, 24);
		frmTienda.getContentPane().add(comboBoxStock);

		JLabel lblUnidadesAdquirids = new JLabel("Unidades adquiridas: ");
		lblUnidadesAdquirids.setBounds(495, 306, 193, 15);
		frmTienda.getContentPane().add(lblUnidadesAdquirids);

		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(646, 304, 79, 19);
		frmTienda.getContentPane().add(txtStock);

		JLabel lblProductoAVender = new JLabel("Producto a vender:");
		lblProductoAVender.setBounds(495, 371, 144, 15);
		frmTienda.getContentPane().add(lblProductoAVender);

		JComboBox comboBoxVender = new JComboBox();
		comboBoxVender.setBounds(631, 366, 58, 24);
		frmTienda.getContentPane().add(comboBoxVender);

		JLabel lblUnidadesAVender = new JLabel("Unidades a vender:");
		lblUnidadesAVender.setBounds(495, 410, 144, 15);
		frmTienda.getContentPane().add(lblUnidadesAVender);

		textFieldUdVender = new JTextField();
		textFieldUdVender.setColumns(10);
		textFieldUdVender.setBounds(631, 408, 87, 19);
		frmTienda.getContentPane().add(textFieldUdVender);

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

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		table.setEnabled(false);

		JScrollPane scrollPane;
		try {
			con = ConnectionSingleton.getConnection();

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
			stmt.close();
			rs.close();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setBounds(0, 0, 100, 100);
			scrollPane = new JScrollPane(table);
			scrollPane.setBounds(22, 76, 445, 153);

			frmTienda.getContentPane().add(scrollPane);

			Statement stmt2 = con.createStatement();
			ResultSet rs2 = stmt2.executeQuery("SELECT codigo FROM productos");

			while (rs2.next()) {
				int cod = rs2.getInt("codigo");
				comboBoxActualizar.addItem(cod);
				comboBoxBorrar.addItem(cod);
				comboBoxStock.addItem(cod);
				comboBoxVender.addItem(cod);
			}
			stmt2.close();
			rs2.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frmTienda, "Operacion fallida " + e.getMessage(), null,
					JOptionPane.ERROR_MESSAGE);

		}

		JButton btnMostrar = new JButton("Mostrar");
		JButton btnAnyadir = new JButton("Añadir");
		JButton btnActualizarPrecio = new JButton("Actualizar precio");
		JButton btnActualizarStock = new JButton("Actualizar stock");
		JButton btnVender = new JButton("Vender");

		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					con = ConnectionSingleton.getConnection();

					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM productos");
					model.setRowCount(0);
					while (rs.next()) {
						Object[] row = new Object[4];
						row[0] = rs.getInt("codigo");
						row[1] = rs.getString("nombre");
						row[2] = rs.getDouble("precio");
						row[3] = rs.getInt("unidades");
						model.addRow(row);
					}
					stmt.close();
					rs.close();

					table.setModel(model);

					comboBoxActualizar.removeAllItems();
					comboBoxBorrar.removeAllItems();
					comboBoxStock.removeAllItems();
					comboBoxVender.removeAllItems();

					Statement stmt2 = con.createStatement();
					ResultSet rs2 = stmt2.executeQuery("SELECT codigo FROM productos");

					while (rs2.next()) {
						int cod = rs2.getInt("codigo");
						comboBoxActualizar.addItem(cod);
						comboBoxBorrar.addItem(cod);
						comboBoxStock.addItem(cod);
						comboBoxVender.addItem(cod);
					}
					stmt2.close();
					rs2.close();
					con.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frmTienda, "Operacion fallida " + e.getMessage(), null,
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnMostrar.setBounds(189, 39, 117, 25);
		frmTienda.getContentPane().add(btnMostrar);

		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					con = ConnectionSingleton.getConnection();

					int cod = Integer.valueOf(txtCodigo.getText());
					String nombre = txtNombre.getText();
					double precio = Double.valueOf(txtPrecio.getText());
					int unidades = Integer.valueOf(txtUnidades.getText());

					if (cod < 0 || precio < 0 || unidades < 0) {
						throw new SQLException("Numeros negativos no validos");
					}

					PreparedStatement ps = con.prepareStatement("INSERT INTO productos values (?, ?, ?, ?)");
					ps.setInt(1, cod);
					ps.setString(2, nombre);
					ps.setDouble(3, precio);
					ps.setInt(4, unidades);

					int rowsInserted = ps.executeUpdate();
					ps.close();
					con.close();
					JOptionPane.showMessageDialog(frmTienda, "Operacion realizada");
					btnMostrar.doClick();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frmTienda, "Operacion fallida " + e.getMessage(), null,
							JOptionPane.ERROR_MESSAGE);

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(frmTienda, "Operacion fallida,formato invalido " + e.getMessage(),
							null, JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnAnyadir.setBounds(175, 324, 117, 25);
		frmTienda.getContentPane().add(btnAnyadir);

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					con = ConnectionSingleton.getConnection();

					int cod = Integer.valueOf(comboBoxBorrar.getSelectedItem().toString());

					PreparedStatement dele_pstmt = con.prepareStatement("DELETE FROM productos WHERE codigo = ?");
					dele_pstmt.setInt(1, cod);
					int rowsDeleted = dele_pstmt.executeUpdate();

					dele_pstmt.close();
					con.close();
					JOptionPane.showMessageDialog(frmTienda, "Operacion realizada");
					btnMostrar.doClick();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frmTienda, "Operacion fallida " + e.getMessage(), null,
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		btnEliminar.setBounds(217, 388, 117, 25);
		frmTienda.getContentPane().add(btnEliminar);

		btnActualizarPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					con = ConnectionSingleton.getConnection();
					double precio = Double.valueOf(txtNuevoprecio.getText());
					int cod = Integer.valueOf(comboBoxActualizar.getSelectedItem().toString());

					if (precio < 0) {
						throw new SQLException("Numeros negativos no validos");
					}

					PreparedStatement update_pstmt = con
							.prepareStatement("UPDATE productos SET precio = ? WHERE codigo = ?");

					update_pstmt.setDouble(1, precio);
					update_pstmt.setInt(2, cod);

					int rowsDeleted = update_pstmt.executeUpdate();

					update_pstmt.close();
					con.close();
					JOptionPane.showMessageDialog(frmTienda, "Operacion realizada");
					btnMostrar.doClick();

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frmTienda, "Operacion fallida " + e.getMessage(), null,
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		btnActualizarPrecio.setBounds(690, 98, 164, 25);
		frmTienda.getContentPane().add(btnActualizarPrecio);

		btnActualizarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					con = ConnectionSingleton.getConnection();
					int stock = Integer.valueOf(txtStock.getText());
					int cod = Integer.valueOf(comboBoxActualizar.getSelectedItem().toString());
					int ud = 0;

					if (stock < 0) {
						throw new SQLException("Numeros negativos no validos");
					}

					PreparedStatement ps = con.prepareStatement("SELECT unidades FROM productos WHERE codigo = ?");
					ps.setInt(1, cod);
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						ud = rs.getInt("unidades");
					}

					stock += ud;

					PreparedStatement update_pstmt = con
							.prepareStatement("UPDATE productos SET unidades = ? WHERE codigo = ?");

					update_pstmt.setDouble(1, stock);
					update_pstmt.setInt(2, cod);

					int rowsDeleted = update_pstmt.executeUpdate();

					update_pstmt.close();
					con.close();
					JOptionPane.showMessageDialog(frmTienda, "Operacion realizada");
					btnMostrar.doClick();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frmTienda, "Operacion fallida " + e.getMessage(), null,
							JOptionPane.ERROR_MESSAGE);

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(frmTienda, "Operacion fallida,formato invalido " + e.getMessage(),
							null, JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnActualizarStock.setBounds(686, 263, 168, 25);
		frmTienda.getContentPane().add(btnActualizarStock);

		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					con = ConnectionSingleton.getConnection();
					int udVender = Integer.valueOf(textFieldUdVender.getText());
					int cod = Integer.valueOf(comboBoxVender.getSelectedItem().toString());
					int ud = 0;
					int precio = 0;

					if (udVender < 0) {
						throw new SQLException("Numeros negativos no validos");
					}

					PreparedStatement ps = con.prepareStatement("SELECT * FROM productos WHERE codigo = ?");
					ps.setInt(1, cod);
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						ud = rs.getInt("unidades");
						precio = rs.getInt("precio");
					}

					if (ud < udVender) {
						throw new SQLException("Unidades insuficientes");
					}

					PreparedStatement update_pstmt = con
							.prepareStatement("UPDATE productos SET unidades = ? WHERE codigo = ?");

					ud -= udVender;
					profit += udVender * precio;

					update_pstmt.setDouble(1, ud);
					update_pstmt.setInt(2, cod);

					int rowsDeleted = update_pstmt.executeUpdate();
					update_pstmt.close();
					con.close();

					labelGanancias.setText(String.valueOf(profit));
					rs.close();
					ps.close();
					update_pstmt.close();
					con.close();
					JOptionPane.showMessageDialog(frmTienda, "Operacion realizada");

					btnMostrar.doClick();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frmTienda, "Operacion fallida " + e.getMessage(), null,
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		btnVender.setBounds(733, 388, 108, 25);
		frmTienda.getContentPane().add(btnVender);
	}
}

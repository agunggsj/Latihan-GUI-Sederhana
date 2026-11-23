import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlaylistSederhana extends JFrame implements ActionListener {

    private DefaultListModel<String> modelLagu;
    private JList<String> daftarLagu;
    private JTextField txtJudul, txtArtis;
    private JButton btnTambah, btnPutar, btnHapus, btnKosongkan;
    private JLabel lblSedangDiputar;

    public PlaylistSederhana() {
        setTitle("Playlist Musik");
        setSize(500, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout(5, 5));

        JPanel panelInput = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));
        txtJudul = new JTextField(10);
        txtArtis = new JTextField(10);
        btnTambah = new JButton("Tambah");
        btnTambah.addActionListener(this);
        txtArtis.addActionListener(this); 

        panelInput.add(new JLabel("Judul:"));
        panelInput.add(txtJudul);
        panelInput.add(new JLabel("Artis:"));
        panelInput.add(txtArtis);
        panelInput.add(btnTambah);

        modelLagu = new DefaultListModel<>();
        daftarLagu = new JList<>(modelLagu);
        daftarLagu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        daftarLagu.setFont(new Font("SansSerif", Font.PLAIN, 14));

        daftarLagu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    putarLagu();
                }
            }
        });

        JScrollPane scroll = new JScrollPane(daftarLagu);
        scroll.setBorder(BorderFactory.createTitledBorder("Daftar Lagu"));

        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnPutar = new JButton("Putar");
        btnHapus = new JButton("Hapus");
        btnKosongkan = new JButton("Kosongkan");
        btnPutar.addActionListener(this);
        btnHapus.addActionListener(this);
        btnKosongkan.addActionListener(this);
        panelTombol.add(btnPutar);
        panelTombol.add(btnHapus);
        panelTombol.add(btnKosongkan);

        lblSedangDiputar = new JLabel("Belum ada lagu yang diputar.");
        lblSedangDiputar.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblSedangDiputar.setBorder(BorderFactory.createEmptyBorder(0, 10, 8, 0));

        JPanel panelBawah = new JPanel(new BorderLayout());
        panelBawah.add(panelTombol, BorderLayout.CENTER);
        panelBawah.add(lblSedangDiputar, BorderLayout.SOUTH);

        add(panelInput, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelBawah, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object sumber = e.getSource();
        if (sumber == btnTambah || sumber == txtArtis) {
            tambahLagu();
        } else if (sumber == btnPutar) {
            putarLagu();
        } else if (sumber == btnHapus) {
            hapusLagu();
        } else if (sumber == btnKosongkan) {
            modelLagu.clear();
            lblSedangDiputar.setText("Playlist dikosongkan.");
        }
    }

    private void tambahLagu() {
        String judul = txtJudul.getText().trim();
        String artis = txtArtis.getText().trim();
        if (judul.isEmpty() || artis.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Judul dan artis wajib diisi!",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        modelLagu.addElement(judul + " - " + artis);
        txtJudul.setText("");
        txtArtis.setText("");
        txtJudul.requestFocusInWindow();
    }

    private void putarLagu() {
        String lagu = daftarLagu.getSelectedValue();
        if (lagu == null) {
            JOptionPane.showMessageDialog(this, "Pilih lagu terlebih dahulu.",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        lblSedangDiputar.setText("Sedang diputar: " + lagu);
    }

    private void hapusLagu() {
        int indeks = daftarLagu.getSelectedIndex();
        if (indeks == -1) {
            JOptionPane.showMessageDialog(this, "Pilih lagu yang ingin dihapus.",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        modelLagu.remove(indeks);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PlaylistSederhana().setVisible(true));
    }
}
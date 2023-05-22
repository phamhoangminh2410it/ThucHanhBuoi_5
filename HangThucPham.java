import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;



public class HangThucPham {
	//	private long maHang;
	private String maHang,tenHang;
	private double donGia;
	private GregorianCalendar ngaySanXuat, ngayHetHang;
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {

		this.maHang = maHang;

	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public GregorianCalendar getNgaySanXuat() {
		return ngaySanXuat;
	}
	public void setNgaySanXuat(GregorianCalendar ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}
	public GregorianCalendar getNgayHetHang() {
		return ngayHetHang;
	}
	public void setNgayHetHang(GregorianCalendar ngayHetHang) {
		this.ngayHetHang = ngayHetHang;
	}
	public HangThucPham(String maHang, String tenHang, double donGia, GregorianCalendar ngaySanXuat,
			GregorianCalendar ngayHetHang) {
		super();

		this.maHang = maHang;
		this.tenHang = tenHang;
		this.donGia = donGia;
		this.ngaySanXuat = ngaySanXuat;
		this.ngayHetHang = ngayHetHang;
	}
	public HangThucPham(String maHang) {
		super();

		this.maHang = maHang;

	}
	public HangThucPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean checkHanSuDung() {
		GregorianCalendar ngayHienTai = new GregorianCalendar();
		if(ngayHienTai.getTime().getTime() > this.getNgayHetHang().getTime().getTime()) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		boolean checkHanSuDung = checkHanSuDung();
		String trangThaiHangHoa = (checkHanSuDung == true) ? "Còn hạn sử dụng" : "Hết hạn sử dụng";
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat formatMoney = new DecimalFormat("###,000");
		return String.format("%10s | %-20s | %20s | %-15s | %-15s | %-10s", this.getMaHang(), this.getTenHang(), formatMoney.format(this.getDonGia()), formatDate.format(this.getNgaySanXuat().getTime()), formatDate.format(this.getNgayHetHang().getTime()), trangThaiHangHoa);
	}
}
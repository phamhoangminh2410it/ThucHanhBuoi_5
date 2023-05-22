
public class DanhSachHangThucPham {
	public int soPhanTuThuc;
	private HangThucPham danhSachHangHoa[];
	public DanhSachHangThucPham(int soPhanTuThuc) {
		danhSachHangHoa = new HangThucPham[soPhanTuThuc];
	}
	public void tangMang() {
		HangThucPham danhSachTam[] = new HangThucPham[danhSachHangHoa.length * 2];
		int i = 0;
		for(HangThucPham row : danhSachHangHoa) {
			danhSachTam[i] = row;
			i++;
		}
		danhSachHangHoa = danhSachTam;
	}
	public HangThucPham timHangHoa(String maHangHoa) {
		for(int i = 0 ; i< soPhanTuThuc; i++) {
			if(maHangHoa.equals(danhSachHangHoa[i])) {
				return danhSachHangHoa[i];
			}
		}
		return null;
	}
	
	public boolean addHangHoa(HangThucPham hangHoaMoi) {
		if(timHangHoa(hangHoaMoi.getMaHang()) != null) {
			return false;
		}else {
			if(soPhanTuThuc == danhSachHangHoa.length) {
				tangMang();
			}
			danhSachHangHoa[soPhanTuThuc] = hangHoaMoi;
			soPhanTuThuc++;
			return true;	
		}
	}
	public HangThucPham[] layDanhSach() {
		return danhSachHangHoa;
	}
}
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;



public class TestHangThucPham {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GregorianCalendar dateNSXHangHoa1 = new GregorianCalendar(2015,1-1,1);
		GregorianCalendar dateNHHHangHoa1 = new GregorianCalendar(2021,1-1,2);

		GregorianCalendar dateNSXHangHoa2 = new GregorianCalendar(2017,1-1,1);
		GregorianCalendar dateNHHHangHoa2 = new GregorianCalendar(2018,10-1,31);

		//		SimpleDateFormat sf = new SimpleDateFormat("EEEE");

		HangThucPham hangHoa = new HangThucPham("HH1", "Bim bim khoai tây", 20000, dateNSXHangHoa1, dateNHHHangHoa1);
		HangThucPham hangHoa2 = new HangThucPham("HH2", "Dừa sáp", 50000, dateNSXHangHoa2, dateNHHHangHoa2);

		DanhSachHangThucPham dsHangHoa = new DanhSachHangThucPham(4);
		dsHangHoa.addHangHoa(hangHoa);
		dsHangHoa.addHangHoa(hangHoa2);
	
		menu(dsHangHoa);

	}

	public static void menu(DanhSachHangThucPham dsHangHoa) {
		int chon = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n\tMENU HANG THUC PHAM\n");
			System.out.println("0. Du Lieu Mac Dinh.");
			System.out.println("1. Nhap Mot Hang Thuc Pham.");
			System.out.println("2. Xuat Danh Sach Hang Thuc Pham.");
			System.out.println("3. Thoat.");
			System.out.println("Chon So: ");
			chon = sc.nextInt();
			if(chon < 0 || chon > 3) {
				System.out.println("Chọn sai!! Chọn lại");
			}else {
				switch (chon) {
				case 1:
					nhapMotHangHoa(dsHangHoa);
					break;
				case 2:
					xuatDanhSach(dsHangHoa.layDanhSach());
					break;
				case 3:
				
					break;
				default:
					System.out.println("Danh sách Hàng Hóa\n");
					xuatDanhSach(dsHangHoa.layDanhSach());
					break;
				}
			}

		}while(chon != 3);
		sc.close();
	}

	public static void nhapMotHangHoa(DanhSachHangThucPham dsHangHoa){
		Scanner sc = new Scanner(System.in);
		GregorianCalendar ngaySX = new GregorianCalendar();
		GregorianCalendar ngayHH = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Nhập mã hàng hóa: ");
		String maHang = null;
		do {
			maHang = sc.nextLine();
			if(isNullOrEmpltyOfID(maHang) == true) {
				System.out.println("Mã hàng hóa không được để rỗng! Nhập lại!");
				maHang = sc.nextLine();
			}
		}while(isNullOrEmpltyOfID(maHang) == true);

		System.out.println("Nhập tên hàng hóa: ");
		String tenHang;
		do {
			tenHang = sc.nextLine();
			if(isNullOrEmpltyOfID(tenHang) == true) {
				System.out.println("Tên hàng hóa không được để rỗng! Nhập lại!");
			}
		}while(isNullOrEmpltyOfID(tenHang) == true);
		
		System.out.println("Nhập đơn hàng: ");
		double donHang;
		do {
			donHang = sc.nextDouble();
			if(donHang <= 0) {
				System.out.println("Đơn giá phải lớn hơn 0! Nhập lại: ");
			}
		}while(donHang <= 0);
		sc.nextLine();//reset
		System.out.println("Nhập ngày sản xuất: ");
		String txtNgaySanXuat;
		//validate ngày sản xuất
		do {
			txtNgaySanXuat = sc.nextLine();
			try {
			
				ngaySX.setTime(sdf.parse(txtNgaySanXuat));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(isNullOrEmpltyOfID(txtNgaySanXuat) == true) {
				System.out.println("Ngày sản xuất không được để trống! Nhập lại!: ");
			}
		}while(isNullOrEmpltyOfID(txtNgaySanXuat) == true);
		//-end input ngày sản xuất
		System.out.println("Nhập hạn sử dụng: ");
		String txtNgayHetHan;
		//validate ngày hết hạn
		do {
			txtNgayHetHan = sc.nextLine();
			try {
				ngayHH.setTime(sdf.parse(txtNgayHetHan));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(isNullOrEmpltyOfID(txtNgayHetHan) == true) {
				System.out.println("Ngày hết hạn không được để rỗng! Nhập lại!!");
			}else if(ngayHH.getTime().getTime() <= ngaySX.getTime().getTime()) {
				System.out.println("Ngày hết hạn phải lớn hơn ngày sản xuất!! Nhập lại!!");
			}
			
		}while(isNullOrEmpltyOfID(txtNgayHetHan) == true || (ngayHH.getTime().getTime() <= ngaySX.getTime().getTime()));
		//- end input ngày hết hạn
		HangThucPham hangHoa = new HangThucPham(maHang, tenHang, donHang, ngaySX, ngayHH);
		dsHangHoa.addHangHoa(hangHoa);
		if(dsHangHoa.timHangHoa(maHang) != null) {//có trong danh sách
			System.out.println("Hàng hóa "+maHang+" đã tồn tại!!");
		}else {//success
			System.out.println("Thêm hàng hóa: " + maHang +" thành công!!!");
		}
		sc.close();
	}
	public static boolean isNullOrEmpltyOfID(String str) {
		boolean check = (str != null && !str.isEmpty()) ? false : true;
		return check;
	}
	public static void xuatDanhSach(HangThucPham[] hangHoa) {
		tieuDe();
		for(HangThucPham row : hangHoa) {
			if(row !=null) {
				System.out.println(row);	
			}

		}
	}
	public static void tieuDe() {
		System.out.println(String.format("%10s | %-20s | %20s | %-15s | %-15s | %-10s", "Mã","Tên Hàng","Đơn giá","Ngày sản xuất","Ngày hết hạn","Trạng thái"));
	}
}
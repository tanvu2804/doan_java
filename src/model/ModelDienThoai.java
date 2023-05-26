package model;

import java.util.Objects;

public class ModelDienThoai {
	private String maDienThoai;
	private String tenDienThoai;
	private int namSX;
	private double giaTien;

	public String getMaDienThoai() {
		return maDienThoai;
	}

	public void setMaDienThoai(String maDienThoai) {
		this.maDienThoai = maDienThoai;
	}

	public String getTenDienThoai() {
		return tenDienThoai;
	}

	public void setTenDienThoai(String tenDienThoai) {
		this.tenDienThoai = tenDienThoai;
	}

	public int getNamSX() {
		return namSX;
	}

	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}

	public ModelDienThoai(String maDienThoai, String tenDienThoai, int namSX, double giaTien) {
		this.maDienThoai = maDienThoai;
		this.tenDienThoai = tenDienThoai;
		this.namSX = namSX;
		this.giaTien = giaTien;
	}

	public ModelDienThoai() {

	}

	@Override
	public int hashCode() {
		return Objects.hash(giaTien, maDienThoai, namSX, tenDienThoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelDienThoai other = (ModelDienThoai) obj;
		return giaTien == other.giaTien && Objects.equals(maDienThoai, other.maDienThoai) && namSX == other.namSX
				&& Objects.equals(tenDienThoai, other.tenDienThoai);
	}

	@Override
	public String toString() {
		return "DIENTHOAI [maDienThoai=" + maDienThoai + ", tenDienThoai=" + tenDienThoai + ", namSX=" + namSX
				+ ", giaTien=" + giaTien + "]";
	}

}

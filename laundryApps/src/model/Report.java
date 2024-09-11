package model;

public class Report {
	String id_report, id_order,id_service, id_user;
	int data_pendapatan, data_pengeluran;
	public String getId_report() {
		return id_report;
	}
	public void setId_report(String id_report) {
		id_report = id_report;
	}
	public String getId_order() {
		return id_order;
	}
	public void setId_order(String id_order) {
		this.id_order = id_order;
	}
	public String getId_service() {
		return id_service;
	}
	public void setId_service(String id_service) {
		this.id_service = id_service;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public int getData_pendapatan() {
		return data_pendapatan;
	}
	public void setData_pendapatan(int data_pendapatan) {
		this.data_pendapatan = data_pendapatan;
	}
	public int getData_pengeluran() {
		return data_pengeluran;
	}
	public void setData_pengeluran(int data_pengeluran) {
		this.data_pengeluran = data_pengeluran;
	}

}

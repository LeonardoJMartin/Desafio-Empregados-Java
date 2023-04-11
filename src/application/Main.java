package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Nome do departamento: ");
		String departmentName = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Telefone: ");
		String phoneNumber = sc.next();
		
		Address address = new Address(email, phoneNumber);
		Department department = new Department(departmentName, payDay, address);
		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		for(int i =0; i<n; i++) {
			System.out.println("Dados do funcionário "+ (i+1) + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			String employeeName = sc.nextLine();
			System.out.print("Salário: ");
			double employeeSalary = sc.nextDouble();
			Employee employee = new  Employee(employeeName, employeeSalary);
			department.addEmployee(employee);
		}
		System.out.println();
		showReport(department);
		sc.close();
	}
	
	public static void showReport( Department department) {
		System.out.println("FOLHA DE PAGAMENTO:");
		System.out.println("Departamento Vendas = R$ "+ String.format("%.2f", department.payroll()));
		System.out.println("Pagamento realizado no dia " + department.getPayDay());
		System.out.println("Funcionários:");
		for(Employee x : department.getList()){
			System.out.println(x.getName());
		}
		System.out.println("Para dúvidas favor entrar em contato: "+ department.getAddress().getEmail());
	}

}

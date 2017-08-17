class Employee{
	private int id;
	private String empName;
	private double salary;
	public Employee(int id,String empName,double salary){
		this.id=id;
		this.empName=empName;
		this.salary=salary;
	}
	public double getSalary(){
		return this.salary;
	}
}
class Labour extends Employee{
	private double overtime;
	public Labour(int id,String empName,double salary,double overtime){
		super(id,empName,salary);
		this.overtime=overtime;
	}
	public double getSalary(){
		return this.overtime+super.getSalary();
	}
}
class Manager extends Employee{
	private double incentive;
	public Manager(int id,String empName,double salary,double incentive){
		super(id,empName,salary);
		this.incentive=incentive;
	}
	public double getSalary(){
		return this.incentive+super.getSalary();
	}
}
class EmployeeTest{
	public static double getTotalSalaryOfAllEmployee(Employee emp[]){
		double totalSalary=0.0;
		for(int i=0;i<emp.length;i++){
			totalSalary=totalSalary+emp[i].getSalary();
		}
		return totalSalary;
	}
	public static void main(String args[]){
		Employee []emp=new Employee[2];
		emp[0]=new Labour(1,"abc",3000,500);
		emp[1]=new Manager(11,"xyz",10000,1000);
		System.out.println("Total Salary = "+getTotalSalaryOfAllEmployee(emp));
	}
}
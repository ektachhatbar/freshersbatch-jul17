function EmployeeList1(empId,ename,empSalary,deptno){
	this.empId=empId;
	this.ename=ename;
	this.empSalary=empSalary;
	this.deptno=deptno;
}
var EmployeeList=(function(){
	var Employee=[];
	return{
		addId:function(emp){ Employee.push(emp);},
		getIds:function(){ return Employee;}
	}
})();
var EmpId=new EmployeeList1(111,"abc",50000,1234);
function testAccount(){
	EmployeeList.addId(EmpId);
	var Employee=EmployeeList.getIds();
	console.log(Employee);
}
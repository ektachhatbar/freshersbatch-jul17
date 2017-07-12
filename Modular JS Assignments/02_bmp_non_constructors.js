function Employee(eid,ename,esal){
	this.eid = eid;
	this.ename = ename;
	this.esal = esal;
}
function EmployeeList(ary){
	console.log(ary.length);
	return {
		arrSort : function() {
					
			ary.sort(function(a, b){return a.eid - b.eid});
		},
		display : function() {
			console.log(ary);
		}
	}
}
function test(){
	var emp = new Array();
		emp[0] = new Employee(39,"John",50590);
		emp[1] = new Employee(33,"Mike",50772);
		emp[2] = new Employee(2,"Mark",23456);
		emp[3] = new Employee(88,"Mary",12345);
		emp[4] = new Employee(12,"Benedict",78654);
	var empList = new EmployeeList(emp);
	empList.arrSort();
	empList.display();
}
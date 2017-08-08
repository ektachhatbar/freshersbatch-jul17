var circle = {
    print: function () { return console.log("Circle"); }
};
var employee = {
    print: function () { return console.log("Employee"); }
};
function printAll(circle, employee) {
    circle.print();
    employee.print();
}
printAll(circle, employee);

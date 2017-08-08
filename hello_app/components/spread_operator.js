export function testSpreadOperator(){
    function printCapitalNames(n1,n2,n3,n4,n5){
        console.log("Names in Capital : ");
        console.log(n1.toUpperCase());
        console.log(n2.toUpperCase());
        console.log(n3.toUpperCase());
        console.log(n4.toUpperCase());
        console.log(n5.toUpperCase());
  }
    let names2=["adam","blake","clark","dell","ellen"];
    printCapitalNames(...names2);
}
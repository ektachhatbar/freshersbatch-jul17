export function testPromises(){
    var sum=0;
    var p1=Promise.resolve(5);
    var p2=Promise.resolve(4);
    Promise.all([p1, p2]).then(function (promises) {
promises.forEach(function (no) { 
    sum=sum+no;
     }); console.log(sum);
});

}
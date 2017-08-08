export function testScoping(){
    var n1=1;
    if(n1<10){
        let n2=11;
    }
    console.log(n1);
    console.log(n2);
}
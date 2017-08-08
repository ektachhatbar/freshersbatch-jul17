export function testDefaultValues(){
    let num=(n1=1,n2=2)=>{
        console.log("Sum : ",n1+n2);
    }
    num();
    num(5,4);
}
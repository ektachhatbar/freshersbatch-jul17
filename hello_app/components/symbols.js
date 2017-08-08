export function testSymbols(){
    let prevno=Symbol();
    let currno=Symbol();
    class Fibonacci{
        constructor(prev,curr){
            this[prevno]=prev;
            this[currno]=curr;
        }
        next(){
            [this[currno],this[prevno]]=[this[currno]+this[prevno],this[currno]];
                        return {value:this[currno]};
        }
    }
    let ob=new Fibonacci(0,1);
    for(var i=0;i<=5;i++){
        console.log(ob.next());
    }
}
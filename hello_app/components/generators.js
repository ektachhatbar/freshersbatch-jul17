function* amstrong(){
    var i,n,temp,rem;
    var num1=0;
    var num2=1000;
    for(i=num1+1; i<num2; i++){
        temp = i;
        n = 0;

        while(temp != 0){
            rem = temp%10;
            n = n + rem*rem*rem;
            temp = parseInt(temp/10);
        }

        if(i == n){
            if(reset){
                num1=0;
                num2=1000;    
                i=1;
            }
            let reset = yield i;

        }
        try{
            if(i>=999){
                num1=0;
                num2=1000;    
                i=0;
                throw  0;
            }
        }catch(msg){
            console.log("Value greater than 1000");
        }
    }
}
export function testGenerators(){
    let gen=amstrong();
    console.log(gen.next());
    console.log(gen.next());
    console.log(gen.next());
    console.log(gen.next());
    console.log(gen.next(true));
    console.log(gen.next());
    console.log(gen.next());   
    console.log(gen.next());
    console.log(gen.next());  
    console.log(gen.next());  
    console.log(gen.next());  
    console.log(gen.next());  
    console.log(gen.next());  
    console.log(gen.next());  
    console.log(gen.next());  
}

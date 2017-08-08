var i,n,temp,rem;
var num1=0;
var num2=1000;
let amstrong = {
     
    [Symbol.iterator]()
     {
           return {
               next() {
                        for(i=num1+1; i<num2; i++)
                            {
                                temp = i;
                                n = 0;
                                while(temp != 0)
                                {
                                    rem = temp%10;
                                    n = n + rem*rem*rem;
                                    temp = parseInt(temp/10);
                                }
                                if(i == n)
                                {
   
                                console.log(i);
                                }
                            }
                 }
                }
             }
}
export function testIterator(){
let itr = amstrong[Symbol.iterator]();
console.log(itr.next());
}

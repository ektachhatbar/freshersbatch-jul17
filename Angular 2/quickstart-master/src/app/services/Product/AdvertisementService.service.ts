import { Injectable } from '@angular/core';
@Injectable() 
export class ProductService { 
        products :Array<any>=[];
        products1 :Array<any>=[];

    setAd(obj:any){
    this.products.push(obj);
    console.log(this.products);
   }
   getAll(){
       return this.products;
   }
   delete_Ad(id:number){
       for(let index of this.products){
    if(id===index.id){
      let newId=this.products.indexOf(index);
      this.products.splice(newId,1);
   }
   
}
}
getAdvById(obj:any){
this.products1.push(obj);
console.log("prod",this.products1);
}
}

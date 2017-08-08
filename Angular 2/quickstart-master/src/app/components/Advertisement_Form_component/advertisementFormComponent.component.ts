import { Component, EventEmitter } from '@angular/core';
import { ProductService } from '../../services/Product/AdvertisementService.service';
@Component({
  selector: 'advertisement-form',
  templateUrl: './AdvertisementForm.html',
 // outputs: ['childEvent']
})
export class advertisementForm  { 
  title = 'Advertisement Form';
  categories: Array<string>=['Furniture', 'Hardware', 'Mobile'];
  counter : number=0;
  defaultName:string="xyz";

/* advertisements:Array<any>=[];
  public childEvent = new EventEmitter<any>();
  addAdvertisement(nameRef:any,quantityRef:any,priceRef:any,categoryRef:any){
    //console.log("Name ",nameRef);
   // console.log("Category ",categoryRef);
    //this.advertisements.push({'name':nameRef,'quantity':quantityRef,'price':priceRef,'category':categoryRef});
    this.counter++;
     this.childEvent.emit({id:this.counter,name:nameRef, quantity:quantityRef,price:priceRef,category:categoryRef});
    }*/
              
    constructor(private productService: ProductService) { 
      //  console.log("Products = ", productService.getProducts());

    }
      addAdvertisement(nameRef:any,quantityRef:any,priceRef:any,categoryRef:any){
            this.counter++;
           let obj={id:this.counter,name:nameRef,quantity:quantityRef,price:priceRef,category:categoryRef};
            this.productService.setAd(obj);
      }
}
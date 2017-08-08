import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../../services/Product/AdvertisementService.service';


@Component({
  selector: 'my-app',
  template:`<h1>hello {{name}}</h1>`,
    providers: [ProductService]

})
export class Edit   implements OnInit{ 
 categories: Array<string> = ['Furniture', 'Hardware', 'Mobile'];
    id:number;
    name:string;
    quantity:number;
    price:number;
    product:any;
    constructor(private activatedRoute: ActivatedRoute,private productService: ProductService) {
        
    }
ngOnInit(){ 
          this.name = this.activatedRoute.snapshot.params['name']; 
          this.product=this.productService.getAll();
          this.name=this.product.name;
          console.log("INIT NAME ",this.name);
        } 
        
}
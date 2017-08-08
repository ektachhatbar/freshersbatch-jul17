import { Component} from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router'; 
import { ProductService } from "../../services/Product/AdvertisementService.service";


@Component({
  selector: 'advertisement-table',
  templateUrl: './AdvertisementTable.html',
  //inputs: ['appTextBox']

})


export class advertisementTable  { 
      public arr: Array<any>=[];

  constructor(private productService: ProductService,private router: Router,private activatedRoute: ActivatedRoute) {
this.arr=this.productService.getAll();   

}
//public appTextBox: Array<any>=[];
deleteAd(id:number){
 /* for(let index of this.appTextBox){
    if(id===index.id){
      let newId=this.appTextBox.indexOf(index);
      this.appTextBox.splice(newId,1);
    }
  }*/
  this.productService.delete_Ad(id);

}
editAd(id:number,name:any,quantity:any,price:any){
   let obj={id:id,name:name,quantity:quantity,price:price};
  this.productService.getAdvById(obj);
this.router.navigate(['/edit',id]);
}

}

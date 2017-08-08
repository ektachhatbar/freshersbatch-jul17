import { Component } from '@angular/core';
import { ProductService } from './services/Product/AdvertisementService.service';

@Component({
  selector: 'my-app',
  template:'<router-outlet></router-outlet>',
  providers: [ProductService]
})
export class AppComponent  { 
  childData:Object;
   objarr:Array<any>=[];
 retrieve(newadv:any)
   {
    // console.log(newadv);
     // this.childData=newadv;
      this.objarr.push(newadv);
     // console.log(this.objarr);
   }
}

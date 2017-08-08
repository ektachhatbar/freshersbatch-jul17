import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AdvertisementService } from '../../services/Advertisement/AdvertisementService.service';
import { LoginService } from '../../services/SignUp/login.service';

@Component({
  selector: 'my-app',
  templateUrl: `./MyAccount.html`,
  providers: [AdvertisementService,LoginService]

})
export class MyAccountComponent  { 
  myadvertisements: Array<any>=[];
  id: any;
  successfullReg: any;
  storeReg: any;
  logoutToken: any;
  categories: Array<any> = [];
  name: any; 
  authToken:any;
    constructor(private router: Router,advertisementService: AdvertisementService,private activatedRoute: ActivatedRoute,private loginService:LoginService) {
  advertisementService.getAllCategories().subscribe((response:any)=> { 
    response.data.itemList.forEach((item:any)=>{
      this.categories.push(item.name);
      console.log("Categories ",item.name);
    })
  }); 


}
ngOnInit() { 
  this.name = this.activatedRoute.snapshot.params['userName']; 
  this.authToken = this.activatedRoute.snapshot.params['authToken']; 
  console.log("username ",this.authToken);
} 
logout(){
  this.logoutToken=this.authToken;
  this.authToken=null;
  this.loginService.logoutUser(this.logoutToken).subscribe((response)=>{},(error)=>{});
  this.loginService.setToken(null);
  this.router.navigate(['']);
}

postAd(title1:any , name1:any , category1:any , description1:any):void{
  console.log("post ",this.authToken);
    this.storeReg ={title:title1 ,name:name1 ,category:category1,description:description1};
    this.myadvertisements.push({title:title1 ,name:name1 ,category:category1,description:description1});
    this.loginService.postAdvertisement(this.storeReg,this.authToken).subscribe((data:any)=> { 
      this.successfullReg=data;
      this.id =  this.successfullReg.data['id'];
      console.log('Received products: ', this.successfullReg);                   
      console.log("my ad ",this.myadvertisements);
      if(this.id==null){

      }else{
        alert("Post Successfully");
      }
    });
  }
  user(){
            console.log("aasa",this.authToken);
            this.router.navigate(['/myProfile',this.authToken]);
  }
}
